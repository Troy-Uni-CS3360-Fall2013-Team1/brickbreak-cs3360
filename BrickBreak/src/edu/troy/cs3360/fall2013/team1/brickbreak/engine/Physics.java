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
	 * Checks to see if the two objects collided.
	 * @param box1
	 * @param box2
	 * @return boolean True if the objects collided
	 */
	public boolean collision(AABB box1, AABB box2) {
		boolean isCollision = false;
		return isCollision;
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
	 * 0 = left
	 * </li>
	 * <li>
	 * 1 = top
	 * </li>
	 * <li>
	 * 2 = right
	 * </li>
	 * <li>
	 * 3 = bottom
	 * </li>
	 * <li>
	 * 4 = left/bottom
	 * </li>
	 * <li>
	 * 5 = left/top
	 * </li>
	 * <li>
	 * 6 = right/top
	 * </li>
	 * <li>
	 * 7 = right/bottom
	 * </li>
	 * </ul> 
	 * @author Dexter Parks
	 * @version 1.0
	 * @param ball
	 * @param boundary
	 * @return side This integer corresponds to the side that was hit.
	 */
	private int checkBounds(AABB ball, Rectangle boundary) {
		int side;
		return side;
		
	}
	
	/**
	 * This class accepts a paddle object and a the change in position.
	 * @author Dexter Parks
	 * @version 1.0
	 * @param paddle
	 * @param dx Change in x position.
	 */
	public void movePaddle(Paddle paddle, int dx) {
				
	}
}