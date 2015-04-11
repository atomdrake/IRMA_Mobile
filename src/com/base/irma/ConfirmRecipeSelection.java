package com.base.irma;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmRecipeSelection extends MainActivity {
	
	Button MakeButton;
	Button CancelButton;
	EditText Recipe_Name_Field;
	EditText Ingredients_Field;
	EditText Directions_Field;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm_recipe);
		
		MakeButton = (Button) findViewById(R.id.Make_Button);
		CancelButton = (Button) findViewById(R.id.CancelButton);
		Recipe_Name_Field = (EditText) findViewById(R.id.Recipe_Name_field);
		Ingredients_Field = (EditText) findViewById(R.id.Ingredients_Field);
		Directions_Field = (EditText) findViewById(R.id.Steps_Field);

		//Fill the text fields with the information.
		populate_text_fields();
		
		MakeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(ConfirmRecipeSelection.this, "Go to step by step directions", Toast.LENGTH_LONG).show();	
				


			}
		});// End MakeButton Button
		
		
		CancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(ConfirmRecipeSelection.this, "Destroy this page and go back.", Toast.LENGTH_LONG).show();		
			
			finish();
			
			}
		});// End CancelButton Button
		
	}//End onCreate

	//Travis this method will populate the text fields as necessary.
	//Remember the recipe ID is being stored in SelectedRecipeIDNumber
	private void populate_text_fields() {
		// TODO Auto-generated method stub
		
		
		//Something like if(recipe ID exsists in My TypeRecipeSelection then use it, else check the other places it could be
		
		//Example test data
		String RecipeName = "Chicken Fried Bacon";
		String Ingredients = "Bacon 1 Lb" + "\n" + "All purpose flour 3 cups" + "\n" + "Vegetable oil 4 cups" + "\n" + "Salt and Pepper";
		String Directions = "Heat oil to 375 degrees in a large skillet" + "\n" + "Coat the bacon with the flour" + "\n" + 
								"Fry the bacon in the oil untill crispy" + "\n" + "Sprinkle on salt and peper to taste" + "\n" + 
									"Enjoy";
				
		
		Recipe_Name_Field.setText(RecipeName);
		Ingredients_Field.setText(Ingredients);
		Directions_Field.setText(Directions);
		
		
	}
	


}
