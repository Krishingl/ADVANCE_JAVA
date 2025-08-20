package com.krush.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConn3 {

	
	public static void main(String[] args) {
		
		try {
		Driver d= new oracle.jdbc.driver.OracleDriver();  //Driver interface reference  only created. but Driver register   
		          DriverManager.registerDriver(d);
		Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydba9am","123");
		
		
		Statement st= con.createStatement();
		
		
//		st.execute("ALTER");
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
