package edu.troy.cs3360.fall2013.team1.brickbreak;


import com.example.brickbreak.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreFragment extends FragmentActivity
{
	int mCurrentScore;
	int mScore=0000;
	int mLives = 3;
	int mCurrentLive;
	TextView scoreView;
	TextView livesView;
	public  class brickbreak extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_fragment);
		}
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                             Bundle savedInstanceState) {
	        // Inflate the layout for this fragment
	    	setContentView(R.layout.activity_score_fragment);
	    	scoreView = (TextView)findViewById(R.id.textView3);
	    	scoreView.setText(mScore); // also can call a function return the score 
	        
	    	livesView = (TextView)findViewById(R.id.textView5);
	    	livesView.setText(mLives); // also can call a function return the score 

	    	Button btnMenu;
	    	btnMenu=(Button)findViewById(R.id.button1);
	    	btnMenu=(Button)findViewById(R.id.button2);
	    	btnMenu=(Button)findViewById(R.id.button3);
	    		    
	    	      
	    	// Set OnClick Listener on SignUp button 
	    	btnMenu.setOnClickListener(new View.OnClickListener()
	    	{
	         
	    	public void onClick(View v) 
	         {
	    	  // TODO Auto-generated method stub
	    	 }
	    	 });
	        return inflater.inflate(R.layout.activity_score_fragment, container, false);
	    }
	}
    

	
	//Sample Methods to update score 
	public void updateScore( int brickvalue)
	 {
		mCurrentScore += brickvalue;
		scoreView.setText(Integer.toString(mCurrentScore));
	 }

	//update lives
	public void updatelives(int live)
	{
		mCurrentLive+=live;
	    livesView.setText( Integer.toString(mCurrentLive));
     }

}

