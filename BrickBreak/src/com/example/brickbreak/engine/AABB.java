package com.example.brickbreak.engine;
/*
 * This Class defines a box surrounding an object. Its x and y coordinates are aligned to the x and y axes of the current plane.
 */
public class AABB {

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	//-----Constructors
	AABB() {
		
	}
	
	//Creates a new AABB with the origin(x,y) the top left corner
	AABB(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	//-----Getters/Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
