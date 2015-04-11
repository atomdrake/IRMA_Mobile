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

public class PantryAddManual extends MainActivity {
	
	Button AddButton;
	Button CancelButton;
	String Item_Name = "";
	String GroceryAisle = ""; //Need to add.
	String quantity = "1"; //Need to add.
	String alcohol = "0"; //Need to add.
	String calorie_count = "0";
	String carb_count = "0";
	String fat_count = "0";	
	String protein_count = "0";
	String barcode = "0";
	EditText item_Name_Field;
	EditText calorie_field;
	EditText carb_field;
	EditText fat_field;
	EditText protein_field;
	EditText barcode_field;
	EditText aisle_field;
	EditText quantity_field;
	EditText alcohol_field;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantry_add_manual);
		
		AddButton = (Button) findViewById(R.id.Make_Button);
		CancelButton = (Button) findViewById(R.id.CancelButton);
		item_Name_Field = (EditText) findViewById(R.id.Recipe_Name_field);
		calorie_field = (EditText) findViewById(R.id.Calorie_field);
		carb_field = (EditText) findViewById(R.id.Carb_field);
		fat_field = (EditText) findViewById(R.id.Fat_field);
		protein_field = (EditText) findViewById(R.id.Protein_field);
		barcode_field = (EditText) findViewById(R.id.Barcode_field);
		aisle_field = (EditText) findViewById(R.id.Aisle_field);
		quantity_field = (EditText) findViewById(R.id.Quantity_field);
		alcohol_field = (EditText) findViewById(R.id.Alcohol_field);
		
		//Once we have data added in we can enable this button
		//AddButton.setEnabled(false);
		
		AddButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(PantryAddManual.this, "Adding item to personal pantry", Toast.LENGTH_LONG).show();	
				
			//Gather the various info from the fields and save them to strings and ints.	
			gather_strings();	
			
			Log.i("myApp", "After grabbing strings");
			
			//Push the gathered info to the database (good luck Travis)
			push_to_database();

			}
		});// End AddButton Button
		
		
		CancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryAddManual.this, "Destroy this page and go back.", Toast.LENGTH_LONG).show();		
			
			finish();
			
			}
		});// End CancelButton Button
		
	}//End onCreate
	

	private void push_to_database() {
		Log.i("myApp", "push to database");
		// TODO Auto-generated method stub
		AddIngredient(Item_Name, GroceryAisle, quantity, alcohol, calorie_count, carb_count, fat_count, protein_count);
		try {				
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}						
		if(AddIngredient.result == true)
		{
			//goes into the next page
			//Intent i = new Intent(MainActivity.this, MainMenu.class);
			//startActivity(i);
			Toast.makeText(PantryAddManual.this, AddIngredient.insertResult, Toast.LENGTH_LONG).show();
		}
		else
		{
			Toast.makeText(PantryAddManual.this, AddIngredient.insertResult, Toast.LENGTH_LONG).show();
			
		}
	}
	
	public void AddIngredient(String Item_Name,String GroceryAisle,String quantity,String alcohol,String calorie_count,String carb_count,String fat_count,String protein_count)
	{
		Log.i("myApp", "add ingredient method");
		new AddIngredient(this).execute(Item_Name, GroceryAisle, quantity, alcohol, calorie_count, carb_count, fat_count, protein_count);
	}
	
	
	//assign the data to the proper field
	private void gather_strings() {
		
		Item_Name = item_Name_Field.getText().toString();
		calorie_count = calorie_field.getText().toString();
		carb_count = carb_field.getText().toString();
		fat_count = fat_field.getText().toString();	
		protein_count = protein_field.getText().toString();
		barcode = barcode_field.getText().toString();
		GroceryAisle = aisle_field.getText().toString();
		quantity = quantity_field.getText().toString();
		alcohol = alcohol_field.getText().toString(); 
		
		//Test the input
		//Toast.makeText(PantryAddManual.this, "Entered: " + Item_Name + ", " + calorie_count + ", "
		//		+ carb_count + ", " + fat_count + ", " + protein_count + ", " + barcode , Toast.LENGTH_LONG).show();
		
		
	}

}
