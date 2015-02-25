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
	public static boolean complete = false;
	public static boolean loginsuccess;
	public static String err;
   private Context context;  
   //
   public Login(Context context) {
      this.context = context;      
   }


protected void onPreExecute(){

   }
 
   protected  String doInBackground(String... arg0) {    
	   Log.i("You bitch", "i hate you");
	   try{
           String username = (String)arg0[0];
           String password = (String)arg0[1];		   
           String link = "http://54.69.205.117/includes/mobile_login.php?username=" + username + "&password=" + password;           
           URL url = new URL(link);
           HttpClient client = new DefaultHttpClient();
           HttpGet request = new HttpGet();
           request.setURI(new URI(link));
           HttpResponse response = client.execute(request);
           BufferedReader in = new BufferedReader
          (new InputStreamReader(response.getEntity().getContent()));
         // System.out.println("###" + response.getEntity().getContent());
          StringBuffer sb = new StringBuffer("");
          String line="";
          while ((line = in.readLine()) != null) {
            sb.append(line);
            break;
           }
           if(sb.toString().equals(username))
           {
           //Log.i("MyActivity", "MyClass.getView() — get item number " + position);
           Log.i("YOUUUUUU", sb.toString());
           err = "Good";
           in.close();
           result = true;
           return "true";
           }
           else
           {
        	   Log.i("YOUUUUUU", "SUCK");
        	result = false;
        	return "false";
        	   
           }
           
           
           //return sb.toString();
           
     }catch(Exception e){
        err = "Exception: " + e.getMessage();        
    	 result = false;
    	    	 
     }
	//return null;
	   complete = true;
	return null;
  }
   
   @Override
   protected void onPostExecute(String result2){
	   
	   Success(result);

   }
   
public static void Success(boolean result)
{
	//Log.i("You bitch", "i love you");
	if(result == true)
	{
		//return true;
		Log.i("You bitch", "i really love you");
		loginsuccess = true;
	}
	else
	{
		//return false;
		Log.i("You bitch", "go die");
		loginsuccess = false;
		
	}
	
}


}