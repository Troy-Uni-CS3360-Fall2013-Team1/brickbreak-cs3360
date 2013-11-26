package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

public class Ball extends AABB {
	
	float mXPosition;
	float mYPosition;
	
	float mXVelocity;
	float mYVelocity;
	
	/**
	 * Default constructor. Sets Origin (top left corner) to (0,0) with a size of 25x25.
	 * @author Dexter Parks
	 * @version 1.0
	 * @since 11:39:36 PM
	 */
	Ball() {
		super();
		mXVelocity = 1;
		mYVelocity = 1;
	}
	
	Ball(float x, float y, float xVelocity, float yVelocity, int width, int height) {
		super(x, y, width, height);
		mXVelocity = xVelocity;
		mYVelocity = yVelocity;
	}

	/**
	 * @return the xPosition
	 */
	public float getXPosition() {
		return mXPosition;
	}

	/**
	 * @param xPosition the xPosition to set
	 */
	public void setXPosition(float xPosition) {
		mXPosition = xPosition;
	}

	/**
	 * @return the yPosition
	 */
	public float getYPosition() {
		return mYPosition;
	}

	/**
	 * @param yPosition the yPosition to set
	 */
	public void setYPosition(float yPosition) {
		mYPosition = yPosition;
	}

	/**
	 * @return the xVelocity
	 */
	public float getXVelocity() {
		return mXVelocity;
	}

	/**
	 * @param xVelocity the xVelocity to set
	 */
	public void setXVelocity(float xVelocity) {
		mXVelocity = xVelocity;
	}

	/**
	 * @return the yVelocity
	 */
	public float getYVelocity() {
		return mYVelocity;
	}

	/**
	 * @param yVelocity the yVelocity to set
	 */
	public void setYVelocity(float yVelocity) {
		this.mYVelocity = yVelocity;
	}
}
