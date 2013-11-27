package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

//Canvas for us to draw on 

public class DrawableCanvas {
	Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
	Canvas c = new Canvas(b);
}
