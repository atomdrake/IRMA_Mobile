package com.base.irma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class AddIngredient  extends AsyncTask<String,Void,String>{

	public static boolean result = false;
	public static String insertResult = "";

   public AddIngredient(Context context) {      
   }


   protected  String doInBackground(String... arg0){   
	   
	   try{
           String username = MainActivity.Username;           		
           String ingredient = (String)arg0[0];
           String groceryaisle = (String)arg0[1];
           int quantity = Integer.parseInt((String)arg0[2]);
           int alcohol = Integer.parseInt((String)arg0[3]);
           int calorie = Integer.parseInt((String)arg0[4]);
           int carb = Integer.parseInt((String)arg0[5]);  
           int fat = Integer.parseInt((String)arg0[6]);
           int protein = Integer.parseInt((String)arg0[7]);
           String link = "http://54.69.205.117/includes/mobile_process_ingredient.php?username="+username+"&ingredient="+ingredient+"&groceryisle="+groceryaisle+"&quantity="+quantity+"&alcohol="+alcohol+"&calorie="+calorie+"&carbohydrate="+carb+"&fat="+fat+"&protein="+protein;          
           new URL(link);
           Log.i(username, "my informational message");
           HttpClient client = new DefaultHttpClient();
           HttpGet request = new HttpGet();
           request.setURI(new URI(link));
           HttpResponse response = client.execute(request);
           BufferedReader in = new BufferedReader
          (new InputStreamReader(response.getEntity().getContent()));
          StringBuffer sb = new StringBuffer("");
          String line="";
          while ((line = in.readLine()) != null) {
            sb.append(line);
            break;
           }
          Log.i(sb.toString(), "SB to String");
           if(sb.toString().equals("Success"))
           {      
           in.close();
           result = true;
           insertResult = ingredient + " has successfully been inserted";
           return "true";
           }
           else
           {
        	result = false;
        	return "false";        	   
           }
           
     }catch(Exception e){
    	 result = false;    	    	 
     }
	
	return null;
  }


	
}


