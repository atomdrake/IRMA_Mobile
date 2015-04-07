package com.base.irma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MyTypeRecipeSelection_DB  extends AsyncTask<String,Void,String>{

	public static boolean result = false;
	public static String jsonResponse = "";

   public MyTypeRecipeSelection_DB(Context context) {      
   }


   protected  String doInBackground(String... arg0) {   
	   
	   try{
           String username = (String)arg0[0];
           String type = (String)arg0[1];		   
           String link = "http://54.69.205.117/includes/mobile_type_selection.php?username=" + username + "&type=" + type;         
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
          jsonResponse = sb.toString();
           
           
     }catch(Exception e){
    	 result = false;    	    	 
     }
	
	return null;
  }


	
}


