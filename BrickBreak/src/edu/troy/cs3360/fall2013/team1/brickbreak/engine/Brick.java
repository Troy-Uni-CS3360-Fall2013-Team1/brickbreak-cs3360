package edu.troy.cs3360.fall2013.team1.brickbreak.engine;


import java.util.UUID;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.example.brickbreak.R;


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
	Resources mRes;

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
	 * @author Dexter Parks
	 * @version 1.0
	 * @param canvas
	 */
	protected void onDraw(Canvas canvas) {
		
	}
	
	protected Drawable getResColor(Colors color) {
		Drawable res;
		if (color == Colors.Blue) {
			res = mRes.getDrawable(R.drawable.blue);
		} else if (color == Colors.Cyan) {
			res = mRes.getDrawable(R.drawable.cyan);
		} else if (color == Colors.Light_Blue) {
			res = mRes.getDrawable(R.drawable.light_blue);
		} else if (color == Colors.Lime) {
			res = mRes.getDrawable(R.drawable.lime);
		} else if (color == Colors.Orange) {
			res = mRes.getDrawable(R.drawable.orange);
		} else if (color == Colors.Purple) {
			res = mRes.getDrawable(R.drawable.purple);
		} else if (color == Colors.Red) {
			res = mRes.getDrawable(R.drawable.red);
		} else if (color == Colors.Yellow) {
			res = mRes.getDrawable(R.drawable.yellow);
		} else {
			res = mRes.getDrawable(R.drawable.grey);
		}
		
		return res;
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
	
	/**
	 * @return the brickID
	 */
	public UUID getBrickID() {
		return mBrickID;
	}

	/**
	 * @param brickID the brickID to set
	 */
	public void setBrickID(UUID brickID) {
		mBrickID = brickID;
	}

	public Resources getRes() {
		return mRes;
	}

	public Brick setRes(Resources res) {
		mRes = res;
		return this;
	}
}
