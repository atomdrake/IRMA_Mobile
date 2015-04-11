package com.base.irma;


import java.util.ArrayList;
import java.util.List;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MyTypeRecipeSelection extends MainActivity {
	

	//What type of recipes should be pulled from the database.
	String TypeToQuery = MyRecipeTypeMainMenu.TypeSelected;   //TypeSelected in the previous menu
	
	//Store the recipe we select so we can pull it for display on the next screen
	static int SelectedRecipeIDNumber;	
	
	//The listView we'll associate with the recipe ListView on the page
	ListView RecipeList;
	
	//Storage for the list of recipe names and the list of recipe IDs these should be 1 to 1
	ArrayList<String> recipeNameList;
	ArrayList<Integer> recipeIDList;
	
	//test data to populate the list with
	String [] items =  { "Recipe 1","Recipe 2","Recipe 3","Recipe 4","Recipe 5","Recipe 6" };
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_type_recipe_selection);
		

		RecipeList = (ListView) findViewById(R.id.MyTypeListView);
		
		Toast.makeText(getApplicationContext(), "Type Selected to display here : "+TypeToQuery,   Toast.LENGTH_LONG).show();
		
		//******* Create an arrayList of recipes and then adapt it for use for, and set it in the RecipeList ListView ********
		recipeNameList = new ArrayList<String>();
		recipeIDList = new ArrayList<Integer>();		
	
		
		MyTypeRecipeSelection_DB(MainActivity.Username,TypeToQuery);
		try {				
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}	
		
		// Populate the list with the appropriate type from the database
		populateRecipeNameList();
		
		// Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, recipeNameList);

        //Set the adapted array as the contents of the RecipeList
        RecipeList.setAdapter(arrayAdapter); 
        
        //*******  End List construction block *******
        
        
        RecipeList.setOnItemClickListener(new OnItemClickListener(){        	
        	
                 // argument position gives the index of item which is clicked
        		@Override
                public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
                {

        				//We need to know which item was selected
                        String selectedRecipe=recipeNameList.get(position);

                        
                        //Get the corresponding ID and set it in the static for use in DisplayRecipeActivity
                        SelectedRecipeIDNumber = recipeIDList.get(position);
  
                        
    					//This is test code we can get rid of later
                      Toast.makeText(getApplicationContext(), "Recipe Name/ID Selected : "+selectedRecipe  + " / " + SelectedRecipeIDNumber,   Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "Recipe Name/ID Selected : "+selectedRecipe ,   Toast.LENGTH_LONG).show();
                        
                        //Launch DisplayRecipeActivity
            			Intent i = new Intent(MyTypeRecipeSelection.this, ConfirmRecipeSelection.class);
            			startActivity(i);
                        
                        
                     }


        });// End onClickListener for RecipeList 	

    
		
	}//End onCreate
	

	public void MyTypeRecipeSelection_DB(String user, String type)
	{
		
		new MyTypeRecipeSelection_DB(this).execute(user,type);
	}
	
	
	
	//populate the list with some recipes, this will probably use TypeToQuery
	//Travis will hook in the backend here
	private void populateRecipeNameList() {
	
		
		JSONArray jsonarray;
		try {
			jsonarray = new JSONArray(MyTypeRecipeSelection_DB.jsonResponse);
			for (int i = 0; i < jsonarray.length(); i++) {
        	    JSONObject jsonobject = jsonarray.getJSONObject(i);
        	    Integer ID = Integer.parseInt(jsonobject.getString("RecipeID"));
        	    String RecipeName = jsonobject.getString("RecipeName");
        	    //String CookTime = jsonobject.getString("CookTime");
        	    //String MealType = jsonobject.getString("MealType");
        		recipeNameList.add(RecipeName);
        		recipeIDList.add(ID);
        	    //Log.i("my message", ID);
        	    Log.i("my message", RecipeName);
        	    //Log.i("my message", CookTime);
        	    //Log.i("my message", MealType);
        	}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
		
		/*
		//Test recipes, remove after SQL logic is in place.
		recipeNameList.add("Cheezy Bacon Curls");
		recipeIDList.add(101);

		
		recipeNameList.add("Chicken fried Bacon");
		recipeIDList.add(102);
		
		recipeNameList.add("Deepfried Bacon");
		recipeIDList.add(103);
		
		recipeNameList.add("Bacon Moose");
		recipeIDList.add(104);
		
		recipeNameList.add("Bacon tartar");
		recipeIDList.add(105);
		
		recipeNameList.add("Bacon on Bacon Sandwich");
		recipeIDList.add(106);
		
		recipeNameList.add("Bacon Weave");
		recipeIDList.add(107);
		
		recipeNameList.add("Chunks Of Bacon");
		recipeIDList.add(108);
		
		recipeNameList.add("Some other Bacon Recipe");
		recipeIDList.add(109);
		
		recipeNameList.add("Something Something Bacon");
		recipeIDList.add(110);
		
		recipeNameList.add("Something Something Bacon Darkside");
		recipeIDList.add(111);
		
		*/
		
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
