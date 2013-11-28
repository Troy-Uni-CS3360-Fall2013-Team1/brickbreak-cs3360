package edu.troy.cs3360.fall2013.team1.brickbreak.engine;


import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;



public class MotionActivity extends Activity implements
GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

private static final String DEBUG_TAG = "Gestures";
private GestureDetector mDetector; 

// Called when the activity is first created. 
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_list_item);
// Instantiate the gesture detector with the
// application context and an implementation of
// GestureDetector.OnGestureListener
mDetector = new GestureDetector(this,this);
// Set the gesture detector as the double tap
// listener.
mDetector.setOnDoubleTapListener(this);
}

@Override 
public boolean onTouchEvent(MotionEvent event){ 
this.mDetector.onTouchEvent(event);
int action = MotionEventCompat.getActionMasked(event);

switch(action) {
    case (MotionEvent.ACTION_DOWN) :
        Log.d(DEBUG_TAG,"Action was DOWN");
        return true;
    case (MotionEvent.ACTION_MOVE) :
        Log.d(DEBUG_TAG,"Action was MOVE");
        return true;
    case (MotionEvent.ACTION_UP) :
        Log.d(DEBUG_TAG,"Action was UP");
        return true;
    case (MotionEvent.ACTION_CANCEL) :
        Log.d(DEBUG_TAG,"Action was CANCEL");
        return true;
    case (MotionEvent.ACTION_OUTSIDE) :
        Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                "of current screen element");
        return true;      
    default : 
    	// Be sure to call the superclass implementation
        return super.onTouchEvent(event);
}
}      


@Override
public boolean onDown(MotionEvent event) { 
Log.d(DEBUG_TAG,"onDown: " + event.toString()); 
return true;
}

@Override
public boolean onFling(MotionEvent event1, MotionEvent event2, 
    float velocityX, float velocityY) {
Log.d(DEBUG_TAG, "onFling: " + event1.toString()+event2.toString());
return true;
}

@Override
public void onLongPress(MotionEvent event) {
Log.d(DEBUG_TAG, "onLongPress: " + event.toString()); 
}

@Override
public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
    float distanceY) {
Log.d(DEBUG_TAG, "onScroll: " + e1.toString()+e2.toString());
return true;
}

@Override
public void onShowPress(MotionEvent event) {
Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
}

@Override
public boolean onSingleTapUp(MotionEvent event) {
Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
return true;
}

@Override
public boolean onDoubleTap(MotionEvent event) {
Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
return true;
}

@Override
public boolean onDoubleTapEvent(MotionEvent event) {
Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
return true;
}

@Override
public boolean onSingleTapConfirmed(MotionEvent event) {
Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
return true;
}
	
	}
