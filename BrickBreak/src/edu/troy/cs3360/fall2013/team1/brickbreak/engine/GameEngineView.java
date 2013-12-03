package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameEngineView extends SurfaceView implements SurfaceHolder.Callback
{
    //used to keep track of time between updates and amount of time to sleep for
    long lastUpdate = 0;
    long sleepTime=0;
    //Game engine
    Engine gEngine;

    //objects which house info about the screen
    SurfaceHolder surfaceHolder;
    Context context;
 
    //our Thread class which houses the game loop
    private PaintThread thread;
 
    //Motion Tracking Data
    @SuppressLint("InlinedApi")
	private int mActivePointerId = MotionEvent.INVALID_POINTER_ID;
    private float mLastTouchX;
	private float mLastTouchY;
    
	//Game Window Bounds
	Rectangle mBounds;
	
	//Reference to Hosting Fragment
	//Fragment mEngineFragment;
	
	//Paddle
	Paddle mPaddle = new Paddle();
	
    //initialization code
    void InitView(){
      //initialize our screen holder
      SurfaceHolder holder = getHolder();
      holder.addCallback(this);

      //initialize our game engine
      gEngine = new Engine(context, mPaddle);
        
      //initialize our Thread class. A call will be made to start it later
      thread = new PaintThread(holder, context, new Handler(), gEngine);
      setFocusable(true);
   }
 
   //class constructors
    public GameEngineView(Context contextS, AttributeSet attrs, Fragment fragment, Rectangle Bounds){
        super(contextS, attrs);
        context=contextS;
        InitView();
    }
    
    public GameEngineView(Context contextS, AttributeSet attrs, int defStyle){
       super(contextS, attrs, defStyle);
       context=contextS;
       InitView();
   }
   public GameEngineView(Context contextS, AttributeSet attrs){
       super(contextS, attrs);
       context=contextS;
       InitView();
   }
   
   @SuppressLint("InlinedApi")
   @Override
   public boolean onTouchEvent(MotionEvent ev) {
       // Let the ScaleGestureDetector inspect all events.
       //mScaleDetector.onTouchEvent(ev);
                
       final int action = MotionEventCompat.getActionMasked(ev); 
           
       switch (action) { 
       case MotionEvent.ACTION_DOWN: {
           final int pointerIndex = MotionEventCompat.getActionIndex(ev); 
           final float x = MotionEventCompat.getX(ev, pointerIndex); 
           final float y = MotionEventCompat.getY(ev, pointerIndex); 
               
           // Remember where we started (for dragging)
           mLastTouchX = x;
           mLastTouchY = y;
           // Save the ID of this pointer (for dragging)
           mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
           break;
       }
               
       case MotionEvent.ACTION_MOVE: {
           // Find the index of the active pointer and fetch its position
           final int pointerIndex = 
                   MotionEventCompat.findPointerIndex(ev, mActivePointerId);  
               
           final float x = MotionEventCompat.getX(ev, pointerIndex);
           final float y = MotionEventCompat.getY(ev, pointerIndex);
               
           // Calculate the distance moved
           final float dx = x - mLastTouchX;
           final float dy = y - mLastTouchY;

           mPaddle.movePaddle(dx);
           
           invalidate();

           // Remember this touch position for the next move event
           mLastTouchX = x;
           mLastTouchY = y;

           break;
       }
               
       case MotionEvent.ACTION_UP: {
           mActivePointerId = MotionEvent.INVALID_POINTER_ID;
           break;
       }
               
       case MotionEvent.ACTION_CANCEL: {
           mActivePointerId = MotionEvent.INVALID_POINTER_ID;
           break;
       }
           
       case MotionEvent.ACTION_POINTER_UP: {
               
           final int pointerIndex = MotionEventCompat.getActionIndex(ev); 
           final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex); 

           if (pointerId == mActivePointerId) {
               // This was our active pointer going up. Choose a new
               // active pointer and adjust accordingly.
               final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
               mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex); 
               mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex); 
               mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
           }
           break;
       }
       }       
       return true;
   }
   
   //these methods are overridden from the SurfaceView super class. They are automatically called 
  // when a SurfaceView is created, resumed or suspended.
   @Override 
   public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {}

   @Override 
   public void surfaceDestroyed(SurfaceHolder arg0) {
       boolean retry = true;
       //code to end gameloop
       thread.state=PaintThread.PAUSED;
       while (retry) {
           try {
               //code to kill Thread
               thread.join();
               retry = false;
           } catch (InterruptedException e) {
           }
       }

   }

   @Override 
   public void surfaceCreated(SurfaceHolder arg0) {
       if(thread.state==PaintThread.PAUSED){
           //When game is opened again in the Android OS
           thread = new PaintThread(getHolder(), context, new Handler(), gEngine);
           thread.start();
       }else{
           //creating the game Thread for the first time
           thread.start();
       }
   }
   
}