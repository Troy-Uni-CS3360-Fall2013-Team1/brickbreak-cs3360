package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import com.example.brickbreak.R;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

//Canvas for us to draw on 

public class DrawableCanvas {
	Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
	Canvas c = new Canvas(b);
	private View mContext;
	
	Resources res = mContext.getResources();
	
	Drawable myImage = res.getDrawable(R.drawable.my_image);
	
	 LinearLayout mLinearLayout;

	  protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  // Create a LinearLayout in which to add the ImageView
	  mLinearLayout = new LinearLayout(this);

	  // Instantiate an ImageView and define its properties
	  ImageView i = new ImageView(this);
	  i.setImageResource(R.drawable.my_image);
	  i.setAdjustViewBounds(true); // set the ImageView bounds to match the Drawable's dimensions
	  i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,
	  LayoutParams.WRAP_CONTENT));

	  // Add the ImageView to the layout and set the layout as the content view
	  mLinearLayout.addView(i);
	  setContentView(mLinearLayout);
	  }
}
