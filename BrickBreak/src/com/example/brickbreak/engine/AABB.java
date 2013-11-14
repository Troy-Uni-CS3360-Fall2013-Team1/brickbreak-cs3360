package com.example.brickbreak.engine;
/*
 * This Class defines a box surrounding an object that is aligned to the x and y axes.
 * Its x and y coordinates are aligned to the x and y axes of the current plane.
 */
public class AABB extends Rectangle {

	//-----Constructors
	AABB() {
		super();
	}
	
	//Creates a new AABB with the origin(x,y) the top left corner
	AABB(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	//-----Getters/Setters
	
}
