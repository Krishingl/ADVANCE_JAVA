package com.krush.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCConnectionDemo {
	
	public static void main(String[] args)
	{
		      
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb9am","123");
			System.out.println("sucess");
			Statement smt = con.prepareStatement("create table demo1(id number);");
			ResultSet rs= smt.executeQuery("select * from emp");
			ResultSetMetaData rsmd= rs.getMetaData();
		      System.out.println(rs);

		   // con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	
	}

}
