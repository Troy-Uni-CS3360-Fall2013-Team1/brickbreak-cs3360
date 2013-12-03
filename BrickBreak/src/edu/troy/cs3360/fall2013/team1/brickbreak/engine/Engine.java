package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;

import com.example.brickbreak.R;

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
	
	
	public Engine(Resources res, Rectangle bounds) {
		mGameWindow = bounds;
		LevelBrickReadParser parser = new LevelBrickReadParser();
		mInputStream = res.openRawResource(R.raw.level_1);
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
		mPaddle = new Paddle();
	}

	private void fillRegionMap(List<Brick> brickList) {
		Iterator<Brick> mIt = brickList.iterator();
		while(mIt.hasNext()) {
			mRegionMap.insert((Rectangle) mIt.next());
		}
		
	}
	
	public void runUpdate() {
		updatePosition();
		collisionDetection();
	}

	private void updatePosition() {
		mPhysicsEngine.moveBall(mBall);
		mPhysicsEngine.movePaddle(mPaddle, 0);
		//TODO Implement touch handling - Event Listener?
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
		// TODO Auto-generated method stub
		
	}

	private void updateLife(int loseLife) {
		// TODO Auto-generated method stub
		
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
	 * @param ball the ball to set
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
	 * @param paddle the paddle to set
	 */
	public void setPaddle(Paddle paddle) {
		mPaddle = paddle;
	}
}
