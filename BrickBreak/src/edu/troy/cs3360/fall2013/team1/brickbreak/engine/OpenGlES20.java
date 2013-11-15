package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

// mainly the graffics engine 


public class OpenGlES20 extends Activity
{
	private GLSurfaceView mGLView;
	
	@Override
	public void onCreate (Bundle savedInstanceState)
	{
		super.onCreate ( savedInstanceState);
		
		// Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLView = new MyGLSurfaceView(this);
        setContentView(mGLView);

	}

}
