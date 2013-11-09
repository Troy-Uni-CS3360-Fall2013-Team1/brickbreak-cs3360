package com.example.brickbreak.engine;
/*
 * This Class defines a box surrounding an object. Its x and y coordinates are aligned to the x and y axes of the current plane.
 */
public class AABB {

	private int mX;
	private int mY;
	
	private int mWidth;
	private int mHeight;
	
	//-----Constructors
	AABB() {
		
	}
	
	//Creates a new AABB with the origin(x,y) the top left corner
	AABB(int x, int y, int width, int height) {
		mX = x;
		mY = y;
		mWidth = width;
		mHeight = height;
	}

	//-----Getters/Setters
	public int getX() {
		return mX;
	}

	public void setX(int x) {
		mX = x;
	}

	public int getY() {
		return mY;
	}

	public void setY(int y) {
		mY = y;
	}

	public int getWidth() {
		return mWidth;
	}

	public void setWidth(int width) {
		mWidth = width;
	}

	public int getHeight() {
		return mHeight;
	}

	public void setHeight(int height) {
		mHeight = height;
	}
}
