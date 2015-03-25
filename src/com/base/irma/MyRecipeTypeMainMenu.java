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

public class MyRecipeTypeMainMenu extends MainActivity {
	
	Button BreakfastButton;
	Button LunchButton;
	Button DinnerButton;
	Button DessertButton;
	Button SnackButton;
	Button OtherButton;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_recipes_type_main);
		
		
		BreakfastButton = (Button) findViewById(R.id.Breakfast_Button);
		LunchButton = (Button) findViewById(R.id.Lunch_Button);
		DinnerButton = (Button) findViewById(R.id.Dinner_Button);
		DessertButton = (Button) findViewById(R.id.Dessert_Button);
		SnackButton = (Button) findViewById(R.id.Snack_Button);
		OtherButton = (Button) findViewById(R.id.Other_Button);
		
		
		//Not implemented, will probably end up using some kind of on focus listener and 
		//running a sql query on things as they are entering unless we
		//want to just add in a search button
	
		
		
		BreakfastButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MyRecipeTypeMainMenu.this, "Display Breakfast Recipes...", Toast.LENGTH_LONG).show();	
		
			
			}
		});// End BreakfastButton Button
		
		
		LunchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MyRecipeTypeMainMenu.this, "Display Lunch Recipes...", Toast.LENGTH_LONG).show();		
			
			}
		});// End LunchButton Button
		
		DinnerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MyRecipeTypeMainMenu.this, "Display Dinner Recipes...", Toast.LENGTH_LONG).show();		
			
			}
		});// End DinnerButton Button
		
		DessertButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MyRecipeTypeMainMenu.this, "Display Dessert Recipes...", Toast.LENGTH_LONG).show();		
			
			}
		});// End DessertButton Button
		
		SnackButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MyRecipeTypeMainMenu.this, "Display Snack Recipes...", Toast.LENGTH_LONG).show();		
			
			}
		});// End SnackButton Button
		
		OtherButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MyRecipeTypeMainMenu.this, "Display Other Recipes...", Toast.LENGTH_LONG).show();		
			
			}
		});// End OtherButton Button
		
		
		
		
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
