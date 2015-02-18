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


/*
 public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
if(Connection.Connect() == false) {
JOptionPane.showMessageDialog(null, "Error connecting to the database.");
}
else
try {
Login_Screen window = new Login_Screen();
window.frmKds.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
} 
  
 
 */

public class MainActivity extends ActionBarActivity {
	
		//if(Connection.Connect() == false)
		//{
			//System.out.println("Failed Connection");
		//	Toast.makeText(MainActivity.this, "Error connecting", Toast.LENGTH_LONG).show();
			
	//	}
		
		
	

	//Create some objects to use in here
	EditText UserName;
	EditText Password;
	Button LoginButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Link the text fields we have to the objects we're creating for them
		UserName = (EditText) findViewById(R.id.user_name_field);
		Password = (EditText) findViewById(R.id.password_field);
		LoginButton = (Button) findViewById(R.id.login_button);
		
		LoginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			Toast.makeText(MainActivity.this, "Logging in...", Toast.LENGTH_LONG).show();
			//Connect to server with user name and password here
			
			connectToServer();
			
			//goes into the next page
			Intent i = new Intent(MainActivity.this, MainMenu.class);
			startActivity(i);
			
			}


		});
		
		
	}

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
	
	private void connectToServer() {
		
		
		if(Connection.Connect() == false)
			{
				//System.out.println("Failed Connection");
				Toast.makeText(MainActivity.this, "Error connecting", Toast.LENGTH_LONG).show();
				Toast.makeText(MainActivity.this, Connection.message, Toast.LENGTH_LONG).show();
				
			}
		else
		{
			Toast.makeText(MainActivity.this, "Connection Successful", Toast.LENGTH_LONG).show();			
		}
		// TODO Auto-generated method stub
		
	}
	
}
