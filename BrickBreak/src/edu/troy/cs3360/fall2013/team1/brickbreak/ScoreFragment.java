package edu.troy.cs3360.fall2013.team1.brickbreak;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.brickbreak.R;

public  class ScoreFragment extends Fragment {

	int mScore;
	int mLives;
	TextView scoreView;
	TextView livesView;
	ImageButton overflowButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.activity_score_fragment, container, false);
    	
    	mScore = 0000;
    	mLives = 3;
    	
    	scoreView = (TextView) view.findViewById(R.id.current_score_text_view);
    	scoreView.setText(Integer.toString(mScore)); // also can call a function return the score 
        
    	livesView = (TextView) view.findViewById(R.id.current_lives_text_view);
    	livesView.setText(Integer.toString(mLives)); // also can call a function return the score 
    	
    	// the buttons for what will the menu hold
    	overflowButton=(ImageButton) view.findViewById(R.id.overflow_button);
    	      
    	// Set OnClick Listener on SignUp button 
    	overflowButton.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) {
	    	}
    	});
        
    	return view;
	}
    

	
	//Sample Methods to update score 
	public void updateScore(int brickvalue)
	 {
		mScore += brickvalue;
		scoreView.setText(Integer.toString(mScore));
	 }

	//update lives
	public void updateLives(int live)
	{
		mLives+=live;
	    livesView.setText(Integer.toString(mLives));
     }
}

