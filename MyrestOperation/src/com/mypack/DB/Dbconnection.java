package com.mypack.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection  {

	private static Dbconnection db;

	public Dbconnection() {
		super();
		// Auto-generated constructor stub
	}
	
	private static Dbconnection getInstance() {
		
		if(db==null) {
			db=new Dbconnection();
		}
		return db;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		 Connection con=null;  
         Class.forName("com.mysql.jdbc.Driver");  
         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");  
         return con;  
		
		
		
		
	}
	
}
