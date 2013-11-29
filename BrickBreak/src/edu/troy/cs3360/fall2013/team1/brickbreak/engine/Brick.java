package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.graphics.Canvas;
import java.util.UUID;	

/**
 * This class defines a brick object. It extends a AABB and adds a BrickValue, color, and region id.
 * 
 * @author Dexter Parks
 * @author Justin Williams
 * @since 11-25-13
 * @version 1.0
 */
public class Brick extends AABB {
	
	//-----Data Members
	int mBrickValue;
	Colors mColor;
	int mRegionNodeID;
	UUID mBrickID;
	
	
	
	//-----Constructors
	/**
	 * Default constructor. Creates a Brick at (0,0) with a width/height of 1.
	 * Sets the brick to have a base value of 100.
	 * Sets the color to be grey.
	 * @author Dexter Parks
	 * @version 1.0
	 */
	public Brick() {
		super();
		mBrickValue = 100;
		mColor = Colors.Grey;
	}
	
	/**
	 * Constructor with arguments for setting position and dimensions.
	 * @param X coordinate of the top left corner.
	 * @param Y coordinate of the top left corner.
	 * @param Width from the top left corner.
	 * @param Height from the top left corner.
	 */
	public Brick(float x, float y, float width, float height) {
		super(x, y, width, height);
		mBrickValue = 100;
		mColor = Colors.Grey;
		mBrickID = UUID.randomUUID();
	}

	//-----Graphics Functions
	
	/**
	 * Creates the Canvas for us to draw on 
	 * @author Justin Williams
	 * @version 1.0
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 */
	void drawRect(float left, float top, float right, float bottom)
	{
		
	}
	/**
	 * 
	 * @author Justin Williams
	 * @version 1.0
	 * @param canvas
	 */
	protected void onDraw(Canvas canvas)
	{
		
	}
	

	//-----Getters/Setters
	/**
	 * @return the brickValue
	 */
	public int getBrickValue() {
		return mBrickValue;
	}

	/**
	 * @param brickValue the brickValue to set
	 * @return 
	 */
	public Brick setBrickValue(int brickValue) {
		mBrickValue = brickValue;
		return this;
	}

	/**
	 * @return the color
	 */
	public Colors getColor() {
		return mColor;
	}

	/**
	 * @param color the color to set
	 * @return 
	 */
	public Brick setColor(Colors color) {
		mColor = color;
		return this;
	}

	/**
	 * @return the regionNodeID
	 */
	public int getRegionNodeID() {
		return mRegionNodeID;
	}

	/**
	 * @param regionNodeID the regionNodeID to set
	 */
	public void setRegionNodeID(int regionNodeID) {
		mRegionNodeID = regionNodeID;
	}
}
