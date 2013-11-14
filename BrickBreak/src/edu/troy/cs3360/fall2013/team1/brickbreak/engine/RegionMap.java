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
 * @author Justin Williams
 * @author Sarah
 * @version 1.0
 * @since 2013-11-14
 */

package edu.troy.cs3360.fall2013.team1.brickbreak.engine;/*

 * They are number 0, 1, 2, 3 counter clockwise.
 * A list of objects can be obtained via the INSERTNAMEOFFUNCTIONTORETRIEVEOBJECTS for any given space
 */
import java.util.ArrayList;
import java.util.List;

public class RegionMap {

	//This determines the maximum number of objects inside any region
	private final int MAX_OBJECTS = 10;
	//This determines the maximum number of sub-regions
	private final int MAX_LEVELS = 5;
	
	private int mLevel;
	private List mObjects;
	private Rectangle mBounds;
	private RegionMap[] mNodes;
	
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
		mBounds = bounds;
		mObjects = new ArrayList();
		mNodes = new RegionMap[4];
		
		
	}
	
	//Purges the tree of all nodes/objects
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
	
	//Once a node reaches the maximum allowed children, it then splits the region into a 4 sub-regions
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
		int mSubWidth = mBounds.getWidth() / 2;
		int mSubHeight = mBounds.getHeight() / 2;
		int mX = mBounds.getX();
		int mY = mBounds.getY();
		
		mNodes[0] = new RegionMap(mLevel+1, new Rectangle(mX + mSubWidth, mY, mSubWidth, mSubHeight));
		mNodes[1] = new RegionMap(mLevel+1, new Rectangle(mX, mY, mSubWidth, mSubHeight));
		mNodes[2] = new RegionMap(mLevel+1, new Rectangle(mX, mY + mSubHeight, mSubWidth, mSubHeight));
		mNodes[3] = new RegionMap(mLevel+1, new Rectangle(mX + mSubWidth, mY + mSubHeight, mSubWidth, mSubHeight));
		
	}
	
	/**
	 * Determines where the object lives. -1 means that the object belongs
	 * to its parent node and not the child.
	 * 
	 * @author Dexter Parks
	 * 
	 * @param rectangle This is the object to locate in the RegionMap
	 * @return
	 */
	private int getIndex(Rectangle rectangle) {
		int index = -1;
		//Finds the vertical midpoint
		double mVerticalMidpoint = mBounds.getmX() + (mBounds.getWidth() / 2);
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
	 * @param brick This is the object to be inserted into the map
	 */
	public void insert(Brick brick) {
		//TODO Implement insert
		//Return int corresponding to a region key?
	}
	
	/**
	 * This function removes an object from the map
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param brick
	 */
	public void delete(Brick brick) {
		//TODO Implement delete
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
	public List retrieve(List returnObjects, Rectangle  rectangle) {
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
	//TODO Investigate hash table for constant time access to any brick
}
