package edu.troy.cs3360.fall2013.team1.brickbreak;

import com.example.brickbreak.R;
import com.example.brickbreak.R.layout;
import com.example.brickbreak.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GameLevelHost extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_level_host);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_level_host, menu);
		return true;
	}

}
