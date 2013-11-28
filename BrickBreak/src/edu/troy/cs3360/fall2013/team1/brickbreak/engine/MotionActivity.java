package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.app.Activity;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent; 
import android.view.GestureDetector;

public class MotionActivity extends Activity
{
	// Captures the X & Y movement of the fingure on the screen 
	// and tells what happened. 
	
	@Override 
	public boolean onTouchEvent(MotionEvent event)
	{
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
	            return super.onTouchEvent(event);

	}
	}

}
