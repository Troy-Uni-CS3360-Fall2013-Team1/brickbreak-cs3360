package edu.troy.cs3360.fall2013.team1.brickbreak.engine;
/**
 * This class is a simple point class that bundles an x and y coordinate
 *
 * @author Dexter Parks
 * @version 1.0
 * @since 2013-11-14
 */
public class Point {

	//-----Data members
	int mX;
	int mY;
	
	//-----Constructors
	/**
	 * Default constructor.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 */
	Point() {
		int mX = 0;
		int mY = 0;
	}
	
	/**
	 * Constructor accepting to integers corresponding to the x and y coordinates
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	Point (int x, int y) {
		
		mX = x;
		mY = y;
	}
	
	//-----Getters/Setters
	/**
	 * Gets the x coordinate
	 * @return int x coordinate
	 */
	public int getX() {
		return mX;
	}

	/**
	 * Sets the x coordinate
	 * @param x value to set
	 */
	public void setX(int x) {
		mX = x;
	}

	/**
	 * Gets the y coordinate
	 * @return int y coordinate
	 */
	public int getY() {
		return mY;
	}

	/**
	 * Sets the y coordinate
	 * @param y value to set
	 */
	public void setY(int y) {
		mY = y;
	}
}
