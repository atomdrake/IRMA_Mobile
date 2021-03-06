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

	//Type being selected stored in a string.
	static String TypeSelected = " ";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_recipes_type_main);
		
		
		BreakfastButton = (Button) findViewById(R.id.Breakfast_Button);
		LunchButton = (Button) findViewById(R.id.Lunch_Button);
		DinnerButton = (Button) findViewById(R.id.Dinner_Button);
		DessertButton = (Button) findViewById(R.id.Dessert_Button);
		SnackButton = (Button) findViewById(R.id.Snack_Button);
		OtherButton = (Button) findViewById(R.id.Other_Button);		
		
		BreakfastButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Breakfast Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "Breakfast";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeTypeMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
		
			
			}
		});// End BreakfastButton Button
		
		
		LunchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Lunch Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "Lunch";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeTypeMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End LunchButton Button
		
		DinnerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Dinner Recipes...", Toast.LENGTH_LONG).show();		
			
			TypeSelected = "Dinner";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeTypeMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End DinnerButton Button
		
		DessertButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Dessert Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "Dessert";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeTypeMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End DessertButton Button
		
		SnackButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Snack Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "Snack";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeTypeMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End SnackButton Button
		
		OtherButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Other Recipes...", Toast.LENGTH_LONG).show();		
			
			TypeSelected = "Other";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeTypeMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
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
