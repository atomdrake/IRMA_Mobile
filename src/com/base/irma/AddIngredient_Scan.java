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

public class AddIngredient_Scan  extends AsyncTask<String,Void,String>{

	public static boolean result = false;	

   public AddIngredient_Scan(Context context) {      
   }


   protected  String doInBackground(String... arg0){   
	   
	   try{
           String username = MainActivity.Username;           		
           String barcode = (String)arg0[0];           
           String link = "http://54.69.205.117/includes/mobile_process_ingredient_scan.php?username="+username+"&barcode="+barcode;          
           new URL(link);
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
           if(sb.toString().equals("Private-Found"))
           {      
           in.close();
           result = true;           
           return "true";
           }
           else if(sb.toString().equals("Public-Found"))
           {
        	    result = true;        	   
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


