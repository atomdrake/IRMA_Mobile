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

public class PantryAddManual extends MainActivity {
	
	Button AddButton;
	Button CancelButton;
	String Item_Name = "";
	int calorie_count = 0;
	int carb_count = 0;
	int fat_count = 0;	
	int protein_count = 0;
	int barcode = 0;
	EditText Item_Name_Field;
	EditText calorie_field;
	EditText carb_field;
	EditText fat_field;
	EditText protein_field;
	EditText barcode_field;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantry_add_manual);
		
		AddButton = (Button) findViewById(R.id.AddButton);
		CancelButton = (Button) findViewById(R.id.CancelButton);
		Item_Name_Field = (EditText) findViewById(R.id.name_field);
		calorie_field = (EditText) findViewById(R.id.calorie_field);
		carb_field = (EditText) findViewById(R.id.Carb_field);
		fat_field = (EditText) findViewById(R.id.Fat_field);
		protein_field = (EditText) findViewById(R.id.Protein_field);
		barcode_field = (EditText) findViewById(R.id.Barcode_field);
		
		
		//Once we have data added in we can enable this button
		//AddButton.setEnabled(false);
		
		AddButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(PantryAddManual.this, "Adding item to personal pantry", Toast.LENGTH_LONG).show();	
				
			//Gather the various info from the fields and save them to strings and ints.	
			gather_strings();	
			
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
		// TODO Auto-generated method stub
		
	}
	
	
	//assign the data to the proper field
	private void gather_strings() {
		
		Item_Name = Item_Name_Field.getText().toString();
		calorie_count = Integer.parseInt(calorie_field.getText().toString());
		carb_count = Integer.parseInt(carb_field.getText().toString());
		fat_count = Integer.parseInt(fat_field.getText().toString());	
		protein_count = Integer.parseInt(protein_field.getText().toString());
		barcode = Integer.parseInt(barcode_field.getText().toString());
		
		//Test the input
		//Toast.makeText(PantryAddManual.this, "Entered: " + Item_Name + ", " + calorie_count + ", "
		//		+ carb_count + ", " + fat_count + ", " + protein_count + ", " + barcode , Toast.LENGTH_LONG).show();
		
		
	}

}
