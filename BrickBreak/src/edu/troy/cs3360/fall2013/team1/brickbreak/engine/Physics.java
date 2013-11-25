package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

/**
 * This class handles the movement and collision of all objects.
 * 
 * @author Dexter Parks
 * @version 1.0
 * @since 2013-11-15
 */
public class Physics {

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
		ball.setXPosition(ball.getXPosition() + ball.getXVelocity());
		ball.setYPosition(ball.getYPosition() + ball.getYVelocity());

	}
	/**
	 * Checks to see if the ball is in bounds.
	 * <ul>
	 * <li>
	 * 1 = left
	 * </li>
	 * <li>
	 * 2 = top
	 * </li>
	 * <li>
	 * 5 = right
	 * </li>
	 * <li>
	 * 8 = bottom
	 * </li>
	 * <li>
	 * 9 = left/bottom
	 * </li>
	 * <li>
	 * 3 = left/top
	 * </li>
	 * <li>
	 * 7 = right/top
	 * </li>
	 * <li>
	 * 13 = right/bottom
	 * </li>
	 * </ul> 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param ball
	 * @param boundary
	 * @return side This integer corresponds to the side that was hit.
	 */
	private int checkBounds(AABB aabb, Rectangle box) {
		int side = 0;
		
		//Left side check
		if (aabb.getX() < box.getX() ) {
			side = 1;
		}
		//Top side check
		else if(aabb.getY() < box.getY()) {
			side += 2;
		}
		//Right side check
		else if(aabb.getX() > box.getX() + box.getWidth()) {
			side += 5;
		}
		//Bottom side check
		else if(aabb.getY() > box.getY() + box.getHeight()) {
			side += 8;
		}
		return side;
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