package edu.troy.cs3360.fall2013.team1.brickbreak.engine;



import android.graphics.Canvas;
// This is to draw the shape and the position of the 
// ball. X and Y will be changed to the input of the physics class. 
// height and width will change depending on what we need


public class Ball extends AABB{
	
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
    
    void drawCircle(float cx, float cy, float radius) {
    }
    
    protected void onDraw(Canvas canvas) {
    	
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
