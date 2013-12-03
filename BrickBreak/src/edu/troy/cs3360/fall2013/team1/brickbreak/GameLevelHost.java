package edu.troy.cs3360.fall2013.team1.brickbreak;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.brickbreak.R;

public class GameLevelHost extends Activity implements EngineFragment.onScoreUpdateListener {

	ScoreFragment mScoreFragment;
	EngineFragment mEngineFragment;
	
	private static final String TAG = "edu.troy.cs3360.fall2013.team1.brickbreak.GameLevelHost";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "We made it to onCreate. Inflating Layout...");
		setContentView(R.layout.activity_game_level_host);
		Log.d(TAG, "Inflated Layout!");
		FragmentManager fm = getFragmentManager();
		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		
		mScoreFragment = new ScoreFragment();
		mEngineFragment = new EngineFragment();
		
		fragmentTransaction.add(R.id.score_fragment_container, mScoreFragment);
		fragmentTransaction.add(R.id.engine_fragment_container, mEngineFragment);
		fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_level_host, menu);
		return true;
	}

	@Override
	public void onScoreUpdate(int deltaScore) {
		//ScoreFragment scoreFragment = (ScoreFragment) getFragmentManager().findFragmentById(R.id.score_fragment);
		//scoreFragment.updateScore(deltaScore);
	}

	@Override
	public void onLivesUpdate(int deltaLives) {
		//ScoreFragment scoreFragment = (ScoreFragment) getFragmentManager().findFragmentById(R.id.score_fragment);
		//scoreFragment.updateLives(deltaLives);
		
	}

	/**
	 * @return the engineFragment
	 */
	public EngineFragment getEngineFragment() {
		return mEngineFragment;
	}

}
