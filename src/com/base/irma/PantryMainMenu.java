package com.base.irma;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PantryMainMenu extends MainActivity {
	
	Button AddNewButton;
	Button MySuppliesButton;
	EditText SearchText;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantry_main_menu);
		
		
		AddNewButton = (Button) findViewById(R.id.Time_Button);
		MySuppliesButton = (Button) findViewById(R.id.Region_Button);
		
		//Not implemented, will probably end up using some kind of on focus listener and 
		//running a sql query on things as they are entering unless we
		//want to just add in a search button
		SearchText =  (EditText) findViewById(R.id.SearchTextField);
		
		
		AddNewButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryMainMenu.this, "Going to add new menu...", Toast.LENGTH_LONG).show();	
			
			Intent i = new Intent(PantryMainMenu.this, PantryAddMenu.class);
			startActivity(i);
			
			}
		});// End AddNewButton Button
		
		
		MySuppliesButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryMainMenu.this, "View this user's exsisiting supplies...", Toast.LENGTH_LONG).show();		
			
			}
		});// End MySuppliesButton Button
		
		
		
		
		
	}//End onCreate
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


}
