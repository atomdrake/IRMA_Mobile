package com.base.irma;



import com.dm.zbar.android.scanner.ZBarConstants;
import com.dm.zbar.android.scanner.ZBarScannerActivity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
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
	Button ScanButton;
	
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
	
	private static final int ZBAR_SCANNER_REQUEST = 0;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantry_add_scanner);
		
		AddButton = (Button) findViewById(R.id.AddButton);
		CancelButton = (Button) findViewById(R.id.CancelButton);
		ScanButton = (Button) findViewById(R.id.button1);	
		item_Name_Field = (EditText) findViewById(R.id.Name_field);
		calorie_field = (EditText) findViewById(R.id.Calorie_field);
		carb_field = (EditText) findViewById(R.id.Carb_field);
		fat_field = (EditText) findViewById(R.id.Fat_field);
		protein_field = (EditText) findViewById(R.id.Protein_field);
		barcode_field = (EditText) findViewById(R.id.Barcode_field);
		aisle_field = (EditText) findViewById(R.id.Aisle_field);
		quantity_field = (EditText) findViewById(R.id.Quantity_field);
		alcohol_field = (EditText) findViewById(R.id.Alcohol_field);
		
		
		//Once we have data from the scanner we can ungrey this button and allow the item to be added
		AddButton.setEnabled(false);
		
		AddButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			//Toast.makeText(PantryAddScanner.this, "Adding item to personal pantry", Toast.LENGTH_LONG).show();	
			//

			

			}
		});// End AddButton Button
		
		
		CancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryAddScanner.this, "Destroy this page and go back.", Toast.LENGTH_LONG).show();		
			
			finish();
			
			}
		});// End CancelButton Button
		
		
		//Activate the scanner to pull in the data 
		ScanButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Check for the camera first
				if ( isCameraAvailable() ) {
					
					//Need to get this to return results and push a new activity with the bar code, currently just scans 
					Intent intent = new Intent(PantryAddScanner.this, ZBarScannerActivity.class);
					startActivityForResult(intent, ZBAR_SCANNER_REQUEST);
					
				}
				else {
					
		           Toast.makeText(PantryAddScanner.this, "Rear Facing Camera Unavailable", Toast.LENGTH_SHORT).show();
		        }				
				
			}
		});
		
		
	}//End onCreate
	
	//Method to check for the re-facing camera
    public boolean isCameraAvailable() {
        PackageManager pm = getPackageManager();
        return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }	
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {    
        if (resultCode == RESULT_OK) 
        {
            // Scan result is available by making a call to data.getStringExtra(ZBarConstants.SCAN_RESULT)
            // Type of the scan result is available by making a call to data.getStringExtra(ZBarConstants.SCAN_RESULT_TYPE)
            Toast.makeText(this, "Scan Result = " + data.getStringExtra(ZBarConstants.SCAN_RESULT), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Scan Result Type = " + data.getIntExtra(ZBarConstants.SCAN_RESULT_TYPE, 0), Toast.LENGTH_SHORT).show();
            // The value of type indicates one of the symbols listed in Advanced Options below.
            testBarcode(data);
            
        } else if(resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Scan Canceled", Toast.LENGTH_SHORT).show();
        }
    }// end onActivityResult
    

    //Test the scanned barcode against the database to see if we can populate the rest of the fields
	private void testBarcode(Intent data) {

		//unlock the Add button
		AddButton.setEnabled(true);
		
		//Put the barcode data into the text field
		barcode_field.setText(data.getStringExtra(ZBarConstants.SCAN_RESULT));
		
		/*
		if(narcode is in database)
		{
			populate the other fields 			
		}
		*/
		
	}

}
