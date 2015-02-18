package com.base.irma;
import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.Driver;
import com.mysql.*;
public class Connection {
public static String username;
public static String password;
public static String url;
public static Statement stmt;
public static String pw;
public static String name;
public static String url2;
public static java.sql.Connection con;
public static String message;
private static void ReadFile(){
try{
FileInputStream fstream = new FileInputStream("ConnectionInfo.txt");
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
username = br.readLine(); //First line is username
password = br.readLine(); //Second line is password
url = br.readLine(); //Third line is connection url
in.close(); //Close the buffer (Writes to the file)
String[] split = username.split(": ");
name = split[1];
split = password.split(": ");
pw = split[1];
split = url.split(" ");
//url2 = split[1];
url2 = "jdbc:mysql://54.69.205.117:3306/ira";
}catch (Exception e)
{
System.err.println("Error: " + e.getMessage());
message = "Error: " + e.getMessage();
}
}
/**
* The Connect() method is used to create the connection with the SQL server.
*
*/	
public static boolean Connect(){
//CreateFile();
ReadFile();
try {
Class.forName("com.mysql.jdbc.Driver");
}
catch (ClassNotFoundException e)
{
System.out.println(e.getMessage());
message = "Error2: " + e.getMessage();
return false;
}
try {
con = DriverManager.getConnection("jdbc:mysql://54.69.205.117:3306/ira","GLT","rockchalk"); //creates a connection with the server
}
catch (SQLException e)
{
System.out.println(e.getMessage());
message = "Error3: " + e.getMessage();
return false;
}
return true;
}
}