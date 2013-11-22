package edu.troy.cs3360.fall2013.team1.brickbreak;


import com.example.brickbreak.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreFragment extends FragmentActivity {
	int currentscore;
	int currentlive;
	TextView scoreView;
	TextView livesView;
    

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score_fragment);
		
		 scoreView = (TextView)findViewById(R.id.textView3);
		 scoreView.setText("0000"); // also can call a function return the score 

		 livesView = (TextView)findViewById(R.id.textView5);
		 livesView.setText("3"); // also can call a function return the score 

		 Button btnMenu;
		 btnMenu=(Button)findViewById(R.id.button1);
		    
	      
	       
	       // Set OnClick Listener on SignUp button 
	        btnMenu.setOnClickListener(new View.OnClickListener() {
	               
	               public void onClick(View v) {
	                   // TODO Auto-generated method stub
	               }
	           });
	}
	
	//Sample Methods to update score 
		public void updateScore( int brickvalue) {
			currentscore =+ brickvalue;
			scoreView.setText(Integer.toString(currentscore));
		}

	//update lives
	public void updatelives( int live) {
		
	///	if (ball went out the x value)/////////////////////////////////////////////////////////////
		{
		currentlive = live;
		currentlive-= 1;
	    livesView.setText( Integer.toString(currentlive));
	}
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.score, menu);
		return true;
	}
	
}

