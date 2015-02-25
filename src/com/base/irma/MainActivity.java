package com.base.irma;
//http://www.tutorialspoint.com/android/android_php_mysql.htm
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.StrictMode;


public class MainActivity extends ActionBarActivity {
	
	

	//Create some objects to use in here
	EditText UserName;
	EditText Password;
	Button LoginButton;
	String user;
	String pw;
	
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
			//String res = Login.doInBackground("test");
			user = UserName.getText().toString();
			pw = Password.getText().toString();
			Login(user,pw);
			try {
				
					Thread.sleep(500);
								
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			Toast.makeText(MainActivity.this, "Error = " + Login.err, Toast.LENGTH_LONG).show();
			Toast.makeText(MainActivity.this, "Boolean = " + Login.result, Toast.LENGTH_LONG).show();			
			if(Login.result == true)
			{
			//goes into the next page
			Intent i = new Intent(MainActivity.this, MainMenu.class);
			startActivity(i);
			}
			
			}


		});
		
		
	}
	
	public void Login(String user, String pw)
	{
		
		new Login(this).execute(user,pw);
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
}
	
	