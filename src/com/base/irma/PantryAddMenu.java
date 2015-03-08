package com.base.irma;

import com.dm.zbar.android.scanner.ZBarScannerActivity;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PantryAddMenu extends MainActivity {
	
	protected static final int ZBAR_SCANNER_REQUEST = 0;
	Button ScanButton;
	Button ManualEntryButton;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantry_add_main);
		
		ScanButton = (Button) findViewById(R.id.AddButton);
		ManualEntryButton = (Button) findViewById(R.id.CancelButton);
		
		
		ScanButton.setOnClickListener(new View.OnClickListener() {
		
			
			@Override
			public void onClick(View v) {				
		
				
				//Need to get this to return results and push a new activity with the bar code, currently just scans 
				Intent intent = new Intent(PantryAddMenu.this, ZBarScannerActivity.class);
				startActivityForResult(intent, ZBAR_SCANNER_REQUEST);
			
			}
		});// End ScanButton Button		
		
		
		
		ManualEntryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(PantryAddMenu.this, "Go to the manual entry page...", Toast.LENGTH_LONG).show();	
			
			Intent i = new Intent(PantryAddMenu.this, PantryAddManual.class);
			startActivity(i);
			
			
			}
		});// End ManualEntryButton Button
		
		
		
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
