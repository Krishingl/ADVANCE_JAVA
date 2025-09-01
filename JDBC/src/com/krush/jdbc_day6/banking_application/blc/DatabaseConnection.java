package com.krush.jdbc_day6.banking_application.blc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	  
	      
	
	
	
	private static Connection con ;
	
	
	  private DatabaseConnection() {
		  
	  }
	

	
	public static Connection getConn() {
		  try {
				 if(con==null||con.isClosed())
				 {
					 
				
						con = DriverManager.getConnection(
							    "jdbc:oracle:thin:@localhost:1521:orcl", "KIDB2", "123");
				 }else {
					 System.err.println("Already Connection Object is Created.");
				 }
				
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }

		return con;

	}
	

	
	
	

}
