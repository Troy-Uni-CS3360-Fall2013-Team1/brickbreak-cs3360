package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

public class Ball extends AABB {

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

	/**
	 * @return the aABB
	 */
	public AABB getAABB() {
		return mAABB;
	}

	/**
	 * @param aABB the aABB to set
	 */
	public void setAABB(AABB aABB) {
		mAABB = aABB;
	}
}
