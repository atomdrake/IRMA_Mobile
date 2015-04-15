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

public class ConfirmRecipeSelection extends MainActivity {
	
	Button MakeButton;
	Button CancelButton;
	EditText Recipe_Name_Field;
	EditText Ingredients_Field;
	EditText Directions_Field;
	
	//Store the recipe we select so we can pull it for display on the next screen
	static int SelectedRecipeIDNumber;	
	static String selectedRecipe = "";
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm_recipe);

		
		MakeButton = (Button) findViewById(R.id.Make_Button);
		CancelButton = (Button) findViewById(R.id.CancelButton);
		Recipe_Name_Field = (EditText) findViewById(R.id.Recipe_Name_field);
		Ingredients_Field = (EditText) findViewById(R.id.Ingredients_Field);
		Directions_Field = (EditText) findViewById(R.id.Steps_Field);
		
		
		ConfirmRecipeSelection_DB(MainActivity.Username);
		try {				
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}	

		//Fill the text fields with the information.
		populate_text_fields();
		
		MakeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(ConfirmRecipeSelection.this, "Go to step by step directions", Toast.LENGTH_LONG).show();	
			
			Intent i = new Intent(ConfirmRecipeSelection.this, RecipeDisplay.class);
			startActivity(i);	


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
	
	public void ConfirmRecipeSelection_DB(String user)
	{
		
		new ConfirmRecipeSelection_DB(this).execute(user);
	}

	//Travis this method will populate the text fields as necessary.
	//Remember the recipe ID is being stored in SelectedRecipeIDNumber
	private void populate_text_fields() {
		// TODO Auto-generated method stub
	    Log.i("my main message", "WTF?");
		JSONArray newArray;
		String masterDirections = "";
		String masterIngredients = "";
		
		//We'll need to generalize this line to allow us to pull the selectedRecipe ID from whatever activity sent us here
		//For example if we got here from select recipe by time or by cuisine
		String RecipeName = MyTypeRecipeSelection.selectedRecipe;
		try {
			newArray = new JSONArray(ConfirmRecipeSelection_DB.jsonResponse);
			for (int i = 0; i < newArray.length(); i++) {
        	    JSONObject jsonobject = newArray.getJSONObject(i);        	    
        	    try
        	    {
	        	    String Quantity = jsonobject.getString("Quantity");	        	
	        	    String UOM = jsonobject.getString("UOM");
	        	    String Ingredient = jsonobject.getString("Item");
	        	    //Log.i("my RecipeName", RecipeName);
	        	    masterIngredients = masterIngredients + Quantity + " " + UOM + " " + Ingredient + "\n";
        	    }
        	    catch (JSONException e){}
        	    
        	    try{
        	    	String directions = jsonobject.getString("Contents");
            	    masterDirections = masterDirections + directions + "\n"; 	
        	    }
        	    catch (JSONException e){}
        	   
        	    Log.i("my message", masterIngredients);

        	}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
		
		//Something like if(recipe ID exsists in My TypeRecipeSelection then use it, else check the other places it could be
		
		//Example test data
		//String RecipeName = "Chicken Fried Bacon";
		//String Ingredients = "Bacon 1 Lb" + "\n" + "All purpose flour 3 cups" + "\n" + "Vegetable oil 4 cups" + "\n" + "Salt and Pepper";
		//String Directions = "Heat oil to 375 degrees in a large skillet" + "\n" + "Coat the bacon with the flour" + "\n" + 
		//					"Fry the bacon in the oil untill crispy" + "\n" + "Sprinkle on salt and peper to taste" + "\n" + 
		//							"Enjoy";
				
		
		selectedRecipe = MyTypeRecipeSelection.selectedRecipe;
		
		
		Recipe_Name_Field.setText(RecipeName);
		Ingredients_Field.setText(masterIngredients);
		Directions_Field.setText(masterDirections);
		
		//Set the text fields to be uneditable by user.
		Recipe_Name_Field.setKeyListener(null);
		Ingredients_Field.setKeyListener(null);
		Directions_Field.setKeyListener(null);
		
		
	}
	


}
