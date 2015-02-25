package com.base.irma;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends MainActivity {


	Button AllRecipes;
	Button MyRecipes;
	Button MyPantry;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		
		AllRecipes = (Button) findViewById(R.id.AllRecipes);
		MyRecipes = (Button) findViewById(R.id.MyRecipes);
		MyPantry = (Button) findViewById(R.id.MyPantry);
		
		
		AllRecipes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MainMenu.this, "Access All Recipes...", Toast.LENGTH_LONG).show();		
			
			Intent i = new Intent(MainMenu.this, AllRecipeMainMenu.class);
			startActivity(i);
			
			}
		});// End AllRecipes Button
		
		
		MyRecipes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MainMenu.this, "Access the user's recipe menu", Toast.LENGTH_LONG).show();	
			
			Intent i = new Intent(MainMenu.this, MyRecipeMainMenu.class);
			startActivity(i);
			
			
			}
		});// End MyRecipes Button
		
		
		MyPantry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MainMenu.this, "Access the user's pantry menu", Toast.LENGTH_LONG).show();		
			
			Intent i = new Intent(MainMenu.this, PantryMainMenu.class);
			startActivity(i);
			
			}
		});// End MyPantry Button		
	} //End onCreate 
	

	
	
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
