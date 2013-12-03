package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Fragment;
import android.content.res.Resources;

import com.example.brickbreak.R;

import edu.troy.cs3360.fall2013.team1.brickbreak.EngineFragment;

public class Engine {

	//-----Constants
	private static final int LOSE_LIFE = -1;
	private static final int GAIN_LIFE = 1;
	
	//-----Data Members
	List<Brick> mBrickList;
	RegionMap<Brick> mRegionMap;
	InputStream mInputStream;
	Physics mPhysicsEngine;
	Ball mBall;
	Paddle mPaddle;
	Rectangle mGameWindow;
	EngineFragment mEngineFragment;
	
	/**
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 * @since 10:11:09 PM
	 * @param engineFragment
	 * @param Accpets a reference to the resources in the activity
	 * @param Accepts a rectangle representing the bounds of the view
	 */
	public Engine(Fragment engineFragment, Resources res, Rectangle bounds, Paddle paddle) {
		mGameWindow = bounds;
		LevelBrickReadParser parser = new LevelBrickReadParser();
		mInputStream = res.openRawResource(R.raw.level_1);
		mEngineFragment = (EngineFragment) engineFragment;
		try {
			mBrickList = parser.parse(mInputStream);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (mInputStream != null) {
			mRegionMap = new RegionMap<Brick>(0,mGameWindow);
			fillRegionMap(mBrickList);
		}
		
		mPhysicsEngine = new Physics();
		mBall = new Ball();
		mPaddle = paddle;
	}

	private void fillRegionMap(List<Brick> brickList) {
		Iterator<Brick> mIt = brickList.iterator();
		while(mIt.hasNext()) {
			mRegionMap.insert((Rectangle) mIt.next());
		}
		
	}
	/**
	 * Primary method to simulate the next step in the game
	 * 
	 * @author Dexter Parks
	 * @version 1.0
	 */
	public void runUpdate() {
		updatePosition();
		collisionDetection();
	}

	private void updatePosition() {
		mPhysicsEngine.moveBall(mBall);
	}

	private void collisionDetection() {
		if (mPhysicsEngine.checkBounds(mBall, mGameWindow)) {
			updateLife(LOSE_LIFE);
		}
		mPhysicsEngine.checkBallPaddleCollision(mBall, mPaddle);
		if (mPhysicsEngine.checkBounds(mBall, mGameWindow)) {
			updateLife(LOSE_LIFE);
		}
		List<Brick> bricksInArea = new ArrayList<Brick>();
		mPhysicsEngine.checkBrickBallCollision(mBall, mRegionMap.retrieve(bricksInArea, mBall));
		
		if(mPhysicsEngine.isBrickBroken()) {
			findBrokenBricks(bricksInArea);
		}
		if (mPhysicsEngine.checkBounds(mBall, mGameWindow)) {
			updateLife(LOSE_LIFE);
		}
	}

	private void findBrokenBricks(List<Brick> bricksInArea) {
		Iterator<Brick> mBricksInAreaIt = bricksInArea.iterator();
		
		while(mBricksInAreaIt.hasNext()) {
			Brick currentBrick = mBricksInAreaIt.next();
			Iterator<Brick> mBrickListIt = mBrickList.iterator();
			while(mBrickListIt.hasNext()) {
				Brick temp = mBrickListIt.next();
				if(temp.getBrickID().equals(currentBrick.getBrickID())) {
					updateScore(temp);
					mRegionMap.delete(temp);
					mBrickListIt.remove();		
				}
			}
		}
	}

	private void updateScore(Brick brick) {
		mEngineFragment.updateScore(brick.getBrickValue());
	}

	private void updateLife(int deltaLives) {
		mEngineFragment.updateLives(deltaLives);
		
	}

	/**
	 * @return the brickList
	 */
	public List<Brick> getBrickList() {
		return mBrickList;
	}

	/**
	 * @param brickList the brickList to set
	 */
	public void setBrickList(List<Brick> brickList) {
		mBrickList = brickList;
	}

	/**
	 * @return the ball
	 */
	public Ball getBall() {
		return mBall;
	}

	/**
	 * @param the ball to set
	 */
	public void setBall(Ball ball) {
		mBall = ball;
	}

	/**
	 * @return the paddle
	 */
	public Paddle getPaddle() {
		return mPaddle;
	}

	/**
	 * @param the paddle to set
	 */
	public void setPaddle(Paddle paddle) {
		mPaddle = paddle;
	}
}
