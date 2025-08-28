package com.krush.jdbc_day5.student_data_operation_system.blc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection con ;
	
	
	  private ConnectionProvider() {
		  
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
