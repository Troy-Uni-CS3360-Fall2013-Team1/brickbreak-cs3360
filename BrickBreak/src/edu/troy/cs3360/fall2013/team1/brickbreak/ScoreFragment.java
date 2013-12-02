package edu.troy.cs3360.fall2013.team1.brickbreak;


import com.example.brickbreak.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public  class ScoreFragment extends Fragment {

	int mScore=0000;
	int mLives = 3;
	TextView scoreView;
	TextView livesView;
	Button menuButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.activity_score_fragment, container, false);
    	
    	scoreView = (TextView) getView().findViewById(R.id.textViewScore);
    	scoreView.setText(mScore); // also can call a function return the score 
        
    	livesView = (TextView) getView().findViewById(R.id.textViewLives);
    	livesView.setText(mLives); // also can call a function return the score 
    	
    	// the buttons for what will the menu hold
    	menuButton=(Button) getView().findViewById(R.id.buttonMenu);
    	      
    	// Set OnClick Listener on SignUp button 
    	menuButton.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) {
	    	}
    	});
        
    	return view;
	}
    

	
	//Sample Methods to update score 
	public void updateScore( int brickvalue)
	 {
		mScore += brickvalue;
		scoreView.setText(Integer.toString(mScore));
	 }

	//update lives
	public void updatelives(int live)
	{
		mLives+=live;
	    livesView.setText( Integer.toString(mLives));
     }
}

