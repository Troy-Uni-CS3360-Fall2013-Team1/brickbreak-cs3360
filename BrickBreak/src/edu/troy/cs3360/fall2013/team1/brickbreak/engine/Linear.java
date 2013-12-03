package edu.troy.cs3360.fall2013.team1.brickbreak.engine;

import android.os.Bundle;
import android.widget.LinearLayout;

public class Linear {
	 LinearLayout mLinearLayout;

	  protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  // Create a LinearLayout in which to add the ImageView
	  mLinearLayout = new LinearLayout(Red.png);

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
