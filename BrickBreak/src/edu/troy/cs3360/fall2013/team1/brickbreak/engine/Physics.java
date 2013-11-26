package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.util.ArrayDeque;

/**
 * This class handles the movement and collision of all objects.
 * 
 * @author Dexter Parks
 * @version 1.0
 * @since 2013-11-15
 */
public class Physics {

	//-----Flags
	boolean mBallOutOfBounds;		//True if ball fell through the bottom of the map
	boolean mBrickBroken;			//True if brick broken
	
	//-----Data Members
	ArrayDeque<Brick> mBrokenBricks;	//List of bricks broken during this cycle
	
	
	//-----Constructors 
	
	/**
	 * Default Constructor.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 */
	public Physics() {
		mBallOutOfBounds = false;
		mBrickBroken = false;
		mBrokenBricks = new ArrayDeque<Brick>();
	}
	
	
	//-----Movement Functions
	
	/**
	 * This class accepts a paddle object and a the change in position.
	 * @author Dexter Parks
	 * @version 1.0
	 * @param paddle
	 * @param dx Change in x position.
	 */
	public void movePaddle(Paddle paddle, float dx) {
		paddle.setX(paddle.getX() + dx);
	}
	
	
	/**
	 * Moves the ball based on its current velocity.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @return void Void
	 */
	public void moveBall(Ball ball) {
		ball.setX(ball.getX() + ball.getXVelocity());
		ball.setY(ball.getY() + ball.getYVelocity());

	}
	
	
	//-----Bounds Checking Functions
	
	/**
	 * Checks to see if the ball is in bounds. If out of bounds, calculates the delta out of bounds
	 * and moves the ball back inside bounds based on the delta.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param ball
	 * @param boundary
	 * @return side This integer corresponds to the side that was hit.
	 */
	private boolean checkBounds(Ball ball, Rectangle box) {
		//Left side check
		if (ball.getX() < box.getX() ) {
			ball.setX(box.getX() - ball.getX());
			ball.setXVelocity(ball.getXVelocity() * -1);
		}
		//Top side check
		else if(ball.getY() < box.getY()) {
			ball.setY(box.getY() - ball.getY());
			ball.setYVelocity(ball.getYVelocity() * -1);
		}
		//Right side check
		else if(ball.getX() > box.getX() + box.getWidth()) {
			ball.setX(box.getX() * 2 - ball.getX());
		}
		//Bottom side check
		else if(ball.getY() > box.getY() + box.getHeight()) {
			mBallOutOfBounds = true;
		}
		return mBallOutOfBounds;
	}
	
	
	/**
	 * Finds the direction that the ball was moving in (with respect to the x dimension).
	 * Offsets the ball based off of position inside collision.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param Ball object to be manipulated
	 * @param The left edge of the object
	 * @param The right edge of the object
	 */
	private void reflectX(Ball ball, float firstEdge, float secondEdge) {
		if (ball.getXVelocity() > 0) {
			ball.setX(firstEdge * 2 - (ball.getX() + ball.getWidth()));
		} else {
			ball.setX(secondEdge * 2 - ball.getX());
		}
	}
	
	
	/**
	 * Finds the direction that the ball was moving in (with respect to the y dimension).
	 * Offsets the ball based off of position inside collision.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param Ball object to be manipulated
	 * @param The left edge of the object
	 * @param The right edge of the object
	 */
	private void reflectY(Ball ball, float firstEdge, float secondEdge) {
		if (ball.getYVelocity() > 0) {
			ball.setY(firstEdge * 2 - (ball.getY() + ball.getWidth()));
		} else {
			ball.setY(secondEdge * 2 - (ball.getY() + ball.getHeight()));
		}
	}
	
	
	/**
	 * Checks to see if the ball is colliding with deque of bricks.
	 * If a brick is broken, it is added to mBrokenBricks and the BrickBroken flag is set.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param The ball that could collide with bricks
	 * @param The list of possible bricks that could collide with the ball
	 */
	void checkBrickBallCollision(Ball ball, ArrayDeque<Brick> brickList) {
		
		
		float mBallLeftEdge = ball.getX();
		float mBallRightEdge = ball.getX() + ball.getWidth();
		float mBallTopEdge = ball.getY();
		float mBallBottomEdge = ball.getY() + ball.getHeight();
		
		while (!brickList.isEmpty()) {
			Brick brick = brickList.pop();
			
			float mBrickLeftEdge = brick.getX();
			float mBrickRightEdge = brick.getX() + brick.getWidth();
			float mBrickTopEdge = brick.getY();
			float mBrickBottomEdge = brick.getY() + brick.getHeight();
			
			//Check X edges
			if (mBallRightEdge > mBrickLeftEdge && mBallRightEdge < mBrickRightEdge) {
				reflectX(ball, mBrickLeftEdge, mBrickRightEdge);
				mBrokenBricks.push(brick);
				mBrickBroken = true;
			} else if(mBallLeftEdge > mBrickLeftEdge && mBallLeftEdge < mBrickRightEdge) {
				reflectX(ball, mBrickLeftEdge, mBrickRightEdge);
				mBrokenBricks.push(brick);
				mBrickBroken = true;
			}
			
			//Check Y edges
			if (mBallBottomEdge > mBrickTopEdge && mBallBottomEdge < mBrickBottomEdge) {
				reflectY(ball, mBrickTopEdge, mBrickBottomEdge);
				mBrokenBricks.push(brick);
				mBrickBroken = true;
			} else if (mBallTopEdge > mBrickTopEdge && mBallTopEdge < mBrickBottomEdge) {
				reflectY(ball, mBrickTopEdge, mBrickBottomEdge);
				mBrokenBricks.push(brick);
				mBrickBroken = true;
			}
		}
		
		
	}
	
	
	/**
	 * Checks to see if the two objects collided.
	 * @param box1
	 * @param box2
	 * @return boolean True if the objects collided
	 */
	public boolean collision(AABB box1, AABB box2) {
		boolean isCollision = false;
		return isCollision;
	}
	

	//-----Getters/Setters
	
	/**
	 * @return the ballOutOfBounds
	 */
	public boolean isBallOutOfBounds() {
		return mBallOutOfBounds;
	}

	/**
	 * @param ballOutOfBounds the ballOutOfBounds to set
	 */
	public void setBallOutOfBounds(boolean ballOutOfBounds) {
		mBallOutOfBounds = ballOutOfBounds;
	}

	/**
	 * @return the brickBroken
	 */
	public boolean isBrickBroken() {
		return mBrickBroken;
	}

	/**
	 * @param brickBroken the brickBroken to set
	 */
	public void setBrickBroken(boolean brickBroken) {
		mBrickBroken = brickBroken;
	}

	/**
	 * @return the brokenBricks
	 */
	public ArrayDeque<Brick> getBrokenBricks() {
		return mBrokenBricks;
	}

	/**
	 * @param brokenBricks the brokenBricks to set
	 */
	public void setBrokenBricks(ArrayDeque<Brick> brokenBricks) {
		mBrokenBricks = brokenBricks;
	}
	
	
}