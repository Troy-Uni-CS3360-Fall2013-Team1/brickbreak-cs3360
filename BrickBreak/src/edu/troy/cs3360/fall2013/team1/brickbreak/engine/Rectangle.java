package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

public class Rectangle {
	
	//-----Data Members
	int mX;
	int mY;
	int mWidth;
	int mHeight;
	
	//-----Constructors
	Rectangle() {
		int mX = 0;
		int mY = 0;
		int mWidth = 1;
		int mHeight = 1;
	}
	
	Rectangle(int x, int y, int width, int height) {
		int mX = x;
		int mY = y;
		int mWidth = width;
		int mHeight = height;
	}

	public int getmX() {
		return mX;
	}

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

	//-----Getters/Setters
	
}
