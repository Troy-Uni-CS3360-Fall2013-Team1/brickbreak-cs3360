package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.util.Deque;
import java.util.Vector;

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
	Vector<Brick> mBrokenBricks;	//List of bricks broken during this cycle
	
	/**
	 * Default Constructor.
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 */
	public Physics() {
		
	}
	
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
	
	void checkBrickBallCollision(Ball ball, float firstEdge, float secondEdge) {
		if (ball.getYVelocity() > 0) {
			ball.setY(firstEdge * 2 - (ball.getY() + ball.getWidth()));
		} else {
			ball.setY(secondEdge * 2 - (ball.getY() + ball.getHeight()));
		}
	}
	
	private void reflectX(Ball ball, float firstEdge, float secondEdge) {
		if (ball.getXVelocity() > 0) {
			ball.setX(firstEdge * 2 - (ball.getX() + ball.getWidth()));
		} else {
			ball.setX(secondEdge * 2 - ball.getX());
		}
	}
	
	private void reflectY(Ball ball) {
		
	}
	
	void checkBrickBallCollision(Ball ball, Deque<Brick> brickList) {
		
		Brick brick = brickList.pop();
		
		float mBallLeftEdge = ball.getX();
		float mBallRightEdge = ball.getX() + ball.getWidth();
		float mBallTopEdge = ball.getY();
		float mBallBottomEdge = ball.getY() + ball.getHeight();
		
		float mBrickLeftEdge = brick.getX();
		float mBrickRightEdge = brick.getX() + brick.getWidth();
		float mBrickTopEdge = brick.getY();
		float mBrickBottomEdge = brick.getY() + brick.getHeight();
		
		//Check X edges
		if (mBallRightEdge > mBrickLeftEdge && mBallRightEdge < mBrickRightEdge) {
			reflectX(ball, mBrickLeftEdge, mBrickRightEdge);
		} else if(mBallLeftEdge > mBrickLeftEdge && mBallLeftEdge < mBrickRightEdge) {
			reflectX();
		}
		
		//Check Y edges
		if (mBallBottomEdge > mBrickTopEdge && mBallBottomEdge < mBrickBottomEdge) {
			reflectY();
		} else if (mBallTopEdge > mBrickTopEdge && mBallTopEdge < mBrickBottomEdge) {
			reflectY();
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
	
	
}