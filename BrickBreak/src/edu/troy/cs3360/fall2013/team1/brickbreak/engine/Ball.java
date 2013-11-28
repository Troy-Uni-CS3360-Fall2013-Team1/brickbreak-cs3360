package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.graphics.Canvas;
// This is to draw the shape and the position of the 
// ball. X and Y will be changed to the input of the physics class. 
// height and width will change depending on what we need

public class Ball {
	
	float mXPosition;
	float mYPosition;
	
	float mXVelocity;
	float mYVelocity;
	
	AABB mAABB;
	/**
	 * Default constructor. Sets Origion (top left corner) to (0,0) with a size of 25x25.
	 * @author Dexter Parks
	 * @version 1.0
	 * @since 11:39:36 PM
	 */
	Ball() {
		mXPosition = 0;
		mYPosition = 0;
		mXVelocity = 0;
		mYVelocity = 0;
		mAABB = new AABB(0, 0, 25, 25);
		
	}
	
	Ball(float x, float y, float xVelocity, float yVelocity, int width, int height) {
		mXPosition = x;
		mYPosition = y;
		mXVelocity = xVelocity;
		mYVelocity = yVelocity;
		mAABB = new AABB(x, y, width, height);
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
	public void setyVelocity(float yVelocity) {
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
	
	

	
    void drawCircle(float cx, float cy, float radius)
    {
    }
    protected void onDraw(Canvas canvas)
    {
    	
    }
}


