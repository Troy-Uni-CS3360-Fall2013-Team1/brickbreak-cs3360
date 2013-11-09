package com.example.brickbreak.engine;

import java.util.ArrayList;
import java.util.List;

public class RegionMap {

	private final int MAX_OBJECTS = 10;
	private final int MAX_LEVELS = 5;
	
	private int mLevel;
	private List mObjects;
	private AABB mBounds;
	private RegionMap[] mNodes;
	
	
	
	RegionMap(int level, AABB bounds) {
		mLevel = level;
		mBounds = bounds;
		mObjects = new ArrayList();
		mNodes = new RegionMap[4];
		
		
	}
	
	//Clears the tree of all nodes/objects
	public void clear() {
		
	}
	
	//Once a node reaches the maximum allowed children, it then splits the region into a 4 sub-regions
	private void split() {
		
	}
	
	//Inserts a new object into the map
	public void insert(AABB aabb) {
		
	}
}
