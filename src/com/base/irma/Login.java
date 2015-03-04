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

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Login  extends AsyncTask<String,Void,String>{

	public static boolean result = false;

   public Login(Context context) {      
   }


   protected  String doInBackground(String... arg0) {   
	   
	   try{
           String username = (String)arg0[0];
           String password = (String)arg0[1];		   
           String link = "http://54.69.205.117/includes/mobile_login.php?username=" + username + "&password=" + password;           
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
           if(sb.toString().equals(username))
           {           
         
           in.close();
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


