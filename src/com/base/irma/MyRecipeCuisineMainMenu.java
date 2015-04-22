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

public class MyRecipeCuisineMainMenu extends MainActivity {
	
	Button AmericanButton;
	Button MexicanButton;
	Button ItalianButton;
	Button FrenchButton;
	Button IndianButton;
	Button OtherButton;

	//Type being selected stored in a string.
	static String TypeSelected = " ";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_recipes_cuisine_main);
		
		
		AmericanButton = (Button) findViewById(R.id.American_Button);
		MexicanButton = (Button) findViewById(R.id.Mexican_Button);
		ItalianButton = (Button) findViewById(R.id.Italian_Button);
		FrenchButton = (Button) findViewById(R.id.French_Button);
		IndianButton = (Button) findViewById(R.id.Indian_Button);
		OtherButton = (Button) findViewById(R.id.Other_Cuisine_Button);		
		
		AmericanButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Breakfast Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "American";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeCuisineMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
		
			
			}
		});// End BreakfastButton Button
		
		
		MexicanButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Lunch Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "Mexican";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeCuisineMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End LunchButton Button
		
		ItalianButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Dinner Recipes...", Toast.LENGTH_LONG).show();		
			
			TypeSelected = "Italian";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeCuisineMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End DinnerButton Button
		
		FrenchButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Dessert Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "French";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeCuisineMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End DessertButton Button
		
		IndianButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Snack Recipes...", Toast.LENGTH_LONG).show();	
			
			TypeSelected = "Indian";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeCuisineMainMenu.this, MyTypeRecipeSelection.class);
			startActivity(i);
			
			}
		});// End SnackButton Button
		
		OtherButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(MyRecipeTypeMainMenu.this, "Display Other Recipes...", Toast.LENGTH_LONG).show();		
			
			TypeSelected = "Other";
			
			//Launch the MyTypeRecipeSelection activity
			Intent i = new Intent(MyRecipeCuisineMainMenu.this, MyTypeRecipeSelection.class);
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
