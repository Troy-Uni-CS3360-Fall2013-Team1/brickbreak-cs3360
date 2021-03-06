package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * This class organizes objects in a 2D space.
 * <p>
 * Objects are organized in a tree structure with four
 * children. Each children represents a region from 0-3
 * going counterclockwise from the top right region.
 * <p>
 * Objects of type rectangle are inserted into the tree.
 * If any one node holds more than MAX_OBJECTS, then the
 * node is split into another tree.
 * 
 * @author Dexter Parks
 * @version 1.0
 * @since 2013-11-14
 */
public class RegionMap<T> {

	//-----Data Members
	
	//This determines the maximum number of objects inside any region
	private final int MAX_OBJECTS = 10;
	//This determines the maximum number of sub-regions
	private final int MAX_LEVELS = 5;
	//HashMap containing links to each container for the bricks
	private static HashMap map = new HashMap();
	//NodeLevelID
	private static int mNextNodeID;		//Next available ID for any Node
	private int mCurrentNodeID;			//Current Node's ID
	private int mLevel;					//Depth of the Node in the tree
	private List<T> mObjects;			//Bricks objects inside the current region
	private Rectangle mBounds;			//Area representing the current region
	private RegionMap<T>[] mNodes;		//Current node's children
	
	
	//-----Class Constructors
	
	/**
	 * Class Constructor used to create a new region split in 4
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param level Corresponds to the current depth of the tree
	 * @param bounds Rectangle object that defines a region for the tree
	 */
	RegionMap(int level, Rectangle bounds) {
		mLevel = level;
		mCurrentNodeID = mNextNodeID++;
		mBounds = bounds;
		mObjects = new ArrayList();
		mNodes = new RegionMap[4];
		map.put(mCurrentNodeID, this);
		
	}
	
	//-----Tree Functions
	/**
	 * Clears all nodes in the tree.
	 * 
	 * @return void
	 */
	public void clear() {
		mObjects.clear();
		for (int i = 0; i < mObjects.size(); i++) {
			if (mNodes[i] != null) {
				mNodes[i].clear();
				mNodes[i] = null;
			}
		}
	}
	
	
	/**
	 * Splits a region into 4 sub regions.
	 * If a region holds more than MAX_OBJECTS and is not at the maximum
	 * depth, then a new region is created.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @return void
	 */
	private void split() {
		float mSubWidth = mBounds.getWidth() / 2;
		float mSubHeight = mBounds.getHeight() / 2;
		float mX = mBounds.getX();
		float mY = mBounds.getY();
		
		mNodes[0] = new RegionMap<T>(mLevel+1, new Rectangle(mX + mSubWidth, mY, mSubWidth, mSubHeight));
		mNodes[1] = new RegionMap<T>(mLevel+1, new Rectangle(mX, mY, mSubWidth, mSubHeight));
		mNodes[2] = new RegionMap<T>(mLevel+1, new Rectangle(mX, mY + mSubHeight, mSubWidth, mSubHeight));
		mNodes[3] = new RegionMap<T>(mLevel+1, new Rectangle(mX + mSubWidth, mY + mSubHeight, mSubWidth, mSubHeight));
	}
	
	/**
	 * Determines where the object lives. -1 means that the object belongs
	 * to its parent node and not the child.
	 * 
	 * @author Dexter Parks
	 * 
	 * @param rectangle This is the object to locate in the RegionMap
	 * @return Returns the index of the region that the rectangle belongs to.
	 */
	private int getIndex(Rectangle rectangle) {
		int index = -1;
		//Finds the vertical midpoint
		double mVerticalMidpoint = mBounds.getX() + (mBounds.getWidth() / 2);
		//Finds the horizontal midpoint
		double mHorizontalMidpoint = mBounds.getY() + (mBounds.getHeight() / 2);
		//Checks to see if the object is entirely in the top two quadrants
		boolean mTopQuadrant = (rectangle.getY() < mHorizontalMidpoint && rectangle.getY() + rectangle.getHeight() < mHorizontalMidpoint);
		//Checks to see if the object is entirely in the bottom two quadrants
		boolean mBottomQuadrant = (rectangle.getY() > mHorizontalMidpoint);
		
		//Checks to see if the object is entirely in the left quadrant
		if(rectangle.getX() < mVerticalMidpoint && rectangle.getX() + rectangle.getWidth() < mVerticalMidpoint) {
			if (mTopQuadrant) {
				index = 1;
			}
			else if (mBottomQuadrant) {
				index = 2;
			}
		}
		//Checks to see if the object is entirely in the right quadrant
		else if(rectangle.getX() > mVerticalMidpoint) {
			if (mTopQuadrant) {
				index = 0;
			}
			else if (mBottomQuadrant) {
				index = 3;
			}
		}
		return index;
	}
	
	/**
	 * This function inserts a new object into the map.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param rectangle This is the object to be inserted into the map
	 * @return
	 */
	public void insert(Rectangle rectangle) {

		if (mNodes[0] !=null) {
			int index = getIndex(rectangle);
			
			if (index != -1) {
				mNodes[index].insert(rectangle);
				return;
			}
		}
		
		mObjects.add((T) rectangle);
		((Brick) rectangle).setRegionNodeID(mCurrentNodeID);
		
		if (mObjects.size() > MAX_OBJECTS && mLevel < MAX_LEVELS) {
			if (mNodes[0] == null) {
				split();
			}
			
			int i = 0;
			while (i < mObjects.size()) {
				int index = getIndex((Rectangle) mObjects.get(i));
				if (index != -1) {
					mNodes[index].insert((Rectangle) mObjects.remove(i));
				}
				else {
					i++;
				}
			}
		}
	}
	
	/**
	 * This function removes an object from the map
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param brick
	 */
	public void delete(Brick brick) {
		RegionMap<T> node = (RegionMap<T>) map.get(brick.getRegionNodeID());
		Iterator<T> it = node.mObjects.iterator();
		if ((((Brick) it.next()).getRegionNodeID()) == brick.getRegionNodeID()) {
			it.remove();
		}
	}
	
	/**
	 * Returns a given list of objects that are in the given brick's region
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param returnObjects This is the list of objects that are in the same space as the given object
	 * @param rectangle This is the object to check which objects are in its region
	 * @return returnObjects This is the list of objects that are in the same space as the given object
	 */
	public List<T> retrieve(List<T> returnObjects, Rectangle  rectangle) {
		int index = getIndex(rectangle);
		
		//Recursive, goes through each child until it reaches the last child or the object does not fit perfectly
		//in any region partitioned by the children
		if (index !=-1 && mNodes[0] != null) {
			mNodes[index].retrieve(returnObjects, rectangle);
		}
		//Adds all the objects belonging to the found region to the list to be returned
		returnObjects.addAll(mObjects);
		
		return returnObjects;
	}
}
