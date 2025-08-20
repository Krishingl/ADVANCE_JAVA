package com.krush.jdbc_day2_task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetails_Insert_Using_ScannerClass {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.Establishing Connection
	 Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123");
		System.out.println("Connection Created Succesfully");
		// 3. Creating Statement Object

		Statement stmt = con.createStatement();
		// Executing Queries
		
	}

}
