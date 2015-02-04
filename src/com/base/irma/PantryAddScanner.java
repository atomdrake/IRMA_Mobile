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

public class PantryAddScanner extends MainActivity {
	
	Button AddButton;
	Button CancelButton;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantry_add_scanner);
		
		AddButton = (Button) findViewById(R.id.AddButton);
		CancelButton = (Button) findViewById(R.id.CancelButton);
		
		
		
		//Once we have data from the scanner we can ungrey this button and allow the item to be added
		AddButton.setEnabled(false);
		
		AddButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryAddScanner.this, "Adding item to personal pantry", Toast.LENGTH_LONG).show();	
			

			

			}
		});// End AddButton Button
		
		
		CancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryAddScanner.this, "Destroy this page and go back.", Toast.LENGTH_LONG).show();		
			
			finish();
			
			}
		});// End CancelButton Button
		
	}//End onCreate

}
