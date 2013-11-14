package com.example.brickbreak.engine;

import java.util.ArrayList;
import java.util.List;

public class RegionMap {

	private final int MAX_OBJECTS = 10;
	private final int MAX_LEVELS = 5;
	
	private int mLevel;
	private List mObjects;
	private Rectangle mBounds;
	private RegionMap[] mNodes;
	
	
	
	RegionMap(int level, Rectangle bounds) {
		mLevel = level;
		mBounds = bounds;
		mObjects = new ArrayList();
		mNodes = new RegionMap[4];
		
		
	}
	
	//Clears the tree of all nodes/objects
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
	
	//Inserts a new object into the map
	public void insert(Brick brick) {
		
	}
}
