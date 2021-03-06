package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.brickbreak.R;

import edu.troy.cs3360.fall2013.team1.brickbreak.EngineFragment;
import edu.troy.cs3360.fall2013.team1.brickbreak.GameLevelHost;

public class Engine {

	//-----Constants
	private static final int LOSE_LIFE = -1;
	private static final int GAIN_LIFE = 1;
	private static final float BALL_INIT_X = 0;
	private static final float BALL_INIT_Y = 0;
	private static final float BALL_INIT_X_VELOCITY = 0;
	private static final float BALL_INIT_Y_VELOCITY = 0;
	private static final float PADDLE_INIT_X = 0;
	private static final float PADDLE_INIT_Y = 0;
	
	//-----Data Members
	List<Brick> mBrickList;
	RegionMap<Brick> mRegionMap;
	InputStream mInputStream;
	Physics mPhysicsEngine;
	Ball mBall;
	Paddle mPaddle;
	Rectangle mGameWindow;
	EngineFragment mEngineFragment;
	private boolean mBallOutOfBounds;
	
	/**
	 * 
	 * @author Dexter Parks
	 * @version 1.1
	 * @since 12-2-13
	 * @param engineFragment reference to the fragment
	 * @param res a reference to the resources in the activity
	 * @param Rectangle a rectangle representing the bounds of the view
	 * @param Paddle a reference to the paddle
	 */
	public Engine(Context context, Paddle paddle) {
		Resources res = context.getResources();
		mEngineFragment = ((GameLevelHost) context).getEngineFragment();
		mGameWindow = mEngineFragment.getBounds();
		LevelBrickReadParser parser = new LevelBrickReadParser();
		mInputStream = res.openRawResource(R.raw.level_1);
		try {
			mBrickList = parser.parse(mInputStream, context);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (mBrickList != null && mGameWindow != null) {
			mRegionMap = new RegionMap<Brick>(0,mGameWindow);
			fillRegionMap(mBrickList);
		}
		mBallOutOfBounds = false;
		mPhysicsEngine = new Physics();
		mBall = new Ball();
		mPaddle = paddle;
		
		reset();
	}

	public void reset() {
		mBall.setX(BALL_INIT_X);
		mBall.setY(BALL_INIT_Y);
		mBall.setXVelocity(BALL_INIT_X_VELOCITY);
		mBall.setYVelocity(BALL_INIT_Y_VELOCITY);
		
		mPaddle.setX(PADDLE_INIT_X);
		mPaddle.setY(PADDLE_INIT_Y);
		
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
		checkValidData();
		updatePosition();
		collisionDetection();
	}

	private void checkValidData() {
		if (mGameWindow == null || mRegionMap == null) {
			mGameWindow = mEngineFragment.getBounds();
			mRegionMap = new RegionMap<Brick>(0,mGameWindow);
		}
		
	}

	private void updatePosition() {
		mPhysicsEngine.moveBall(mBall);
	}

	private void collisionDetection() {
		Log.d("edu.troy.cs3360.fall2013.team1.brickbreak.engine.Engine", mGameWindow.toString());
		if (mPhysicsEngine.checkBounds(mBall, mGameWindow)) {
			updateLife(LOSE_LIFE);
			mBallOutOfBounds  = true;
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
 * This method draws the bricks/ball/paddle onto the given canvas. The canvas should come from the surface holder.
 * @author Dexter Parks
 * @author Justin Williams
 * @param setting the drawable image up for DrawableCanvas.
 */
	public void Draw(Canvas c) {
		
		Iterator<Brick> mBrickListIt = mBrickList.iterator();
		while(mBrickListIt.hasNext()) {
			Brick brick = mBrickListIt.next();
			ImageView mBrickImageView = new ImageView(mEngineFragment.getActivity());
			RelativeLayout.LayoutParams mBrickImageViewLayoutParameters = (RelativeLayout.LayoutParams)mBrickImageView.getLayoutParams();
			mBrickImageView.setImageResource(brick.getBrickResId());
			mBrickImageView.setAdjustViewBounds(true);
			//mBrickImageViewLayoutParameters.leftMargin = (int)(Math.floor(brick.getX()));
			//mBrickImageViewLayoutParameters.topMargin = (int)(Math.floor(brick.getY()));
			mBrickImageView.setLayoutParams(mBrickImageViewLayoutParameters);
			mBrickImageView.draw(c);
			
		}
	}
}
