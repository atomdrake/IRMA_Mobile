package com.base.irma;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class RecipeDisplay extends MainActivity {
	
	Button NextButton;
	Button PreviousButton;
	Button CancelButton;
	EditText Recipe_Name_Field;
	EditText Ingredients_Field;
	EditText Directions_Field;
	EditText StepNumber_Field;
	
	//We need a variable to tack what step number we're at.
	int CurrentStepNumber = 1;
	
	//A variable to know the max number of steps in the recipe?
	int MaxStepsInRecipe = 1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display_recipe);

		
		//Assign all the fields and buttons we have
		NextButton = (Button) findViewById(R.id.Next_button);
		PreviousButton = (Button) findViewById(R.id.Previous_Button);
		CancelButton = (Button) findViewById(R.id.Cancel_button);
		Recipe_Name_Field = (EditText) findViewById(R.id.Recipe_Name_field);
		Ingredients_Field = (EditText) findViewById(R.id.Ingredients_Field);
		Directions_Field = (EditText) findViewById(R.id.Steps_Field);
		
		//If there is a next step go to it
		NextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
			
				//If there are more steps to display then display them
				if(CurrentStepNumber != MaxStepsInRecipe){
					
					GoToNextStep();
					
				}
				//otherwise let the user know they are on the last step
				else{
					
					Toast.makeText(RecipeDisplay.this, "This is the last step in the recipe!", Toast.LENGTH_LONG).show();					
				}
			
			}
		});// End NextButton Button
		
		
		//If there is a previous step go to it
		PreviousButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				//If there is a previous step to go to go back to it
				if(CurrentStepNumber > 1){
					
					GoToPreviousStep();
				}
				//otherwise let the user know this is the first or only step
				else{
					
					if(MaxStepsInRecipe == 1 ){
						
						Toast.makeText(RecipeDisplay.this, "This is the only step in the recipe!", Toast.LENGTH_LONG).show();
					}
					else{	
						
						Toast.makeText(RecipeDisplay.this, "This is the first step in the recipe!", Toast.LENGTH_LONG).show();
					}				
				}			
			}
		});// End PreviousButton Button
		
		
		//We cancel out of the recipe selection screen and go back to confirm screen
		CancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(RecipeDisplay.this, "Destroy this page and go back.", Toast.LENGTH_LONG).show();		
			
			finish();
			
			}
		});// End CancelButton Button
		
		
		//Fill the text fields with the information.
		populate_text_fields();
		
	}//End onCreate
	


	//Pull and / or display the data for the previous step
	//this will depend if we're already storing the steps locally or of we need to 
	//pull them from the database...
	private void GoToPreviousStep() {
		
		
		//Make sure to decrement the currentstepnumber
		CurrentStepNumber--;
		
	}



	//Pull and / or display the data for the next step
	//this will depend if we're already storing the steps locally or of we need to 
	//pull them from the database...
	private void GoToNextStep() {
		

		//Make sure to increment the currentstepnumber...
		CurrentStepNumber++;
	}
	

	//Travis this is called on create so we can use this oportunity to either
	//pull all the steps and store them locally or just pull the first steps for display
	//whichever you think is easier. But we do need to log the total number of 
	//steps at this time in MaxStepsInRecipe for sure...
	private void populate_text_fields() {

	
		//Recipe to use is stored in ConfirmRecipeSelection.selectedRecipe.
		
		
		//Example test data
		String RecipeName = "Chicken Fried Bacon";
		String Ingredients = "Bacon 1 Lb" + "\n" + "All purpose flour 3 cups" + "\n" + "Vegetable oil 4 cups" + "\n" + "Salt and Pepper";
		String Directions = "Heat oil to 375 degrees in a large skillet" ;//+ "\n" + "Coat the bacon with the flour" + "\n" + 
			//				"Fry the bacon in the oil untill crispy" + "\n" + "Sprinkle on salt and peper to taste" + "\n" + 
			//						"Enjoy";
		
		Recipe_Name_Field.setText(RecipeName);
		Ingredients_Field.setText(Ingredients);
		Directions_Field.setText(Directions);
		StepNumber_Field.setText("Step " + CurrentStepNumber);
		
		//Set the text fields to be uneditable by user.
		Recipe_Name_Field.setKeyListener(null);
		Ingredients_Field.setKeyListener(null);
		Directions_Field.setKeyListener(null);
		StepNumber_Field.setKeyListener(null);
		
		//Make sure to update MaxStepsInRecipe!
		MaxStepsInRecipe = 1;
		
		
	}
	


}
