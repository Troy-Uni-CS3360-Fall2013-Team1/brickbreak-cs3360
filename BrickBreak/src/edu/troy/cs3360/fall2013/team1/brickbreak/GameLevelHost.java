package edu.troy.cs3360.fall2013.team1.brickbreak;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.brickbreak.R;

public class GameLevelHost extends Activity implements EngineFragment.onScoreUpdateListener {

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

	@Override
	public void onScoreUpdate(int deltaScore) {
		ScoreFragment scoreFragment = (ScoreFragment) getFragmentManager().findFragmentById(R.id.score_fragment);
		scoreFragment.updateScore(deltaScore);
	}

	@Override
	public void onLivesUpdate(int deltaLives) {
		ScoreFragment scoreFragment = (ScoreFragment) getFragmentManager().findFragmentById(R.id.score_fragment);
		scoreFragment.updateLives(deltaLives);
		
	}

}
