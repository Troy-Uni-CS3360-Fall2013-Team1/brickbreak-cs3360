package edu.troy.cs3360.fall2013.team1.brickbreak.engine;
/*
 * This class is a simple point class bundling together an x and y coordinate
 */
public class Point {

	//-----Data members
	int mX;
	int mY;
	
	//-----Constructors
	Point() {
		int mX = 0;
		int mY = 0;
	}
	
	Point (int x, int y) {
		
		mX = x;
		mY = y;
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
}
