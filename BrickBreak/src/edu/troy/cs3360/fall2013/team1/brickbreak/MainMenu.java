package edu.troy.cs3360.fall2013.team1.brickbreak;

import com.example.brickbreak.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}*/
	public void onPopupBtClick(View view)
	{
		PopupMenu menu = new PopupMenu (this,view);
		menu.getMenuInflater().inflate(R.menu.main_menu, menu.getMenu());
		menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
		{
			public boolean onMenuItemClick(MenuItem item) 
			{
				Toast toast = Toast.makeText(MainMenu.this,
						item.getTitle()+"was pressed",
						Toast.LENGTH_SHORT);
				toast.show();
				return true;
			}
    });
		menu.show();
	}
}
