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
	String[] DirectionsForStep;
	String[] IngredientsInStep;
	
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
		StepNumber_Field = (EditText) findViewById(R.id.StepNumber);
		
		RecipeDisplay_DB(MainActivity.Username);
		try {				
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}	
		
		
	
		//If there is a next step go to it
		NextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

				
			
				//If there are more steps to display then display them
				if(CurrentStepNumber != MaxStepsInRecipe ){
					
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
	
	public void RecipeDisplay_DB(String user)
	{
		
		new RecipeDisplay_DB(this).execute(user);
	}




	//Pull and / or display the data for the previous step
	//this will depend if we're already storing the steps locally or of we need to 
	//pull them from the database...
	private void GoToPreviousStep() {
		
		
		Ingredients_Field.setText(IngredientsInStep[CurrentStepNumber-2]);  	
		Directions_Field.setText(DirectionsForStep[CurrentStepNumber-2]);

		
		//Make sure to decrement the currentstepnumber
		CurrentStepNumber--;
		
		//Update step number
		String Steps = "Step: " + CurrentStepNumber;
		StepNumber_Field.setText(Steps);
		
	}



	//Pull and / or display the data for the next step
	//this will depend if we're already storing the steps locally or of we need to 
	//pull them from the database...
	private void GoToNextStep() {
		

		Ingredients_Field.setText(IngredientsInStep[CurrentStepNumber]);  	
		Directions_Field.setText(DirectionsForStep[CurrentStepNumber]);		
		
		
		//Make sure to increment the currentstepnumber...		
		CurrentStepNumber++;		
		
		//update step number
		String Steps = "Step: " + CurrentStepNumber;
		StepNumber_Field.setText(Steps);
	}
	

	//Travis this is called on create so we can use this oportunity to either
	//pull all the steps and store them locally or just pull the first steps for display
	//whichever you think is easier. But we do need to log the total number of 
	//steps at this time in MaxStepsInRecipe for sure...
	private void populate_text_fields() {

		JSONArray newArray;
		//Recipe to use is stored in ConfirmRecipeSelection.selectedRecipe.
		
		
		//Example test data
		String RecipeName = ConfirmRecipeSelection.selectedRecipe;
		
		
		//String Ingredients1 = "vegetable oil 5 C";
		//String Ingredients2 = "Bacon 1 lb" + "\n" + "all-purpose flour 3 C";
		//String Ingredients3 = "Bacon 1 lb" + "\n" + "vegetable oil 5 C" ;
		//String Ingredients4 = "Bacon 1 lb" + "\n" + "salt 1 tb" + "\n" + "ground black pepper 1 tb";
		
		
		
		try {
			newArray = new JSONArray(RecipeDisplay_DB.jsonResponse);
			MaxStepsInRecipe = newArray.length();
			DirectionsForStep = new String[MaxStepsInRecipe];  
			//IngredientsInStep = new String[MaxStepsInRecipe];	
			
			for (int i = 0; i < newArray.length(); i++) 
			{
				String contents = "";
        	    JSONObject jsonobject = newArray.getJSONObject(i);        	    
        	    try
        	    {
	        	   	        	
	        	    contents = jsonobject.getString("Contents");       
	        	    DirectionsForStep[i] = contents;
        	    }    catch (JSONException e){}

        	}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			newArray = new JSONArray(RecipeDisplay_DB.jsonResponse2);	
			IngredientsInStep = new String[MaxStepsInRecipe];	
			
			for (int i = 0; i < newArray.length(); i++) 
			{
				int DirNum = 0;
				String Item = "";
        	    JSONObject jsonobject = newArray.getJSONObject(i);        	    
        	    try
        	    {
	        	   	        	
	        	    DirNum = Integer.parseInt(jsonobject.getString("DirectionNumber"));
	        	    Item = jsonobject.getString("Item");
	        	    
        	    }    catch (JSONException e){}
        	    if(IngredientsInStep[DirNum] != null)
        	    {
        	    	IngredientsInStep[DirNum] = Item;
        	    }
        	    else
        	    {
        	    	IngredientsInStep[DirNum] += "\n " + Item;
        	    }
        	}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
		//String Directions1 = "Heat vegetable oil in a large skillet on medium-high heat." ;
		//String Directions2 = "Coat the Bacon with the all-purpose flour." ;
		//String Directions3 = "Fry the Bacon in the vegetable oil until golden brown." ;
		//String Directions4 = "Allow Bacon to cool and sprinkle with salt and ground black pepper to taste." ;		
		
		
		//Set the step string up
		String Steps = "Step: " + CurrentStepNumber;
		
		//Make sure to update MaxStepsInRecipe!
		
		
		//Declare the size of our string arrays
	
		
		//Populate with example test data
		
		//DirectionsForStep[0] = Directions1;
		//IngredientsInStep[0] = Ingredients1;
		
		//DirectionsForStep[1] = Directions2;
		//IngredientsInStep[1] = Ingredients2;
		
		//DirectionsForStep[2] = Directions3;
	//	IngredientsInStep[2] = Ingredients3;
		
		//DirectionsForStep[3] = Directions4;
	//	IngredientsInStep[3] = Ingredients4;
		
		
		//Set the text in the fields
		Recipe_Name_Field.setText(RecipeName);				//Won't Change
		Ingredients_Field.setText(IngredientsInStep[CurrentStepNumber]);  	//Will be IngredientsInStep[CurrentStepNumber-1]
		Directions_Field.setText(DirectionsForStep[CurrentStepNumber-1]);   	//Will be DirectionsForStep[CurrentStepNumber-1]
		StepNumber_Field.setText(Steps);					//Populated above
		
		//Set the text fields to be uneditable by user.
		Recipe_Name_Field.setKeyListener(null);
		Ingredients_Field.setKeyListener(null);
		Directions_Field.setKeyListener(null);
		StepNumber_Field.setKeyListener(null);
		
	
		
	}
	


}
