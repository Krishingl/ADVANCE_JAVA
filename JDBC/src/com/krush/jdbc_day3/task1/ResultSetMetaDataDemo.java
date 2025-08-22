package com.krush.jdbc_day3.task1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataDemo {

	public static void main(String[] args)
	{
		  try {
			  
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			  
		  }catch(ClassNotFoundException e)
		  {
			  System.err.println("Class Not Found");
		  }
		  try {
		  Connection con;
		
			 con= DriverManager.getConnection(
					 "jdbc:oracle:thin:@localhost:1521:ORCL",
					 "KIDB",
					 "123"
					 );
			System.out.println("Connection Estamblished..!");
		
		  Statement stmt = con.createStatement();
		   
		  ResultSet rs = stmt.executeQuery("Select * from userdetails");
		  
		  ResultSetMetaData rsmd = rs.getMetaData();
		     
		  System.out.println(rsmd.getColumnCount());
		  System.out.println(rsmd.getColumnName(1));
		  System.out.println(rsmd.getColumnTypeName(1));
		  System.out.println(rsmd.getColumnDisplaySize(1));
		  System.out.println(rsmd.getPrecision(1));

		  
		  
		  DatabaseMetaData dbMeta = con.getMetaData();

          // Print metadata information
          System.out.println("\n=== Database Metadata Information ===");
          System.out.println("Database Product Name   : " + dbMeta.getDatabaseProductName());
          System.out.println("Database Product Version: " + dbMeta.getDatabaseProductVersion());
          System.out.println("Database Major Version  : " + dbMeta.getDatabaseMajorVersion());
          System.out.println("Database Minor Version  : " + dbMeta.getDatabaseMinorVersion());

          System.out.println("\n=== Driver Information ===");
          System.out.println("Driver Name             : " + dbMeta.getDriverName());
          System.out.println("Driver Version          : " + dbMeta.getDriverVersion());
          System.out.println("Driver Major Version    : " + dbMeta.getDriverMajorVersion());
          System.out.println("Driver Minor Version    : " + dbMeta.getDriverMinorVersion());

          System.out.println("\n=== Database Limits ===");
          System.out.println("Max Columns in a Table  : " + dbMeta.getMaxColumnsInTable());
          System.out.println("Max Tables in a Select  : " + dbMeta.getMaxTablesInSelect());
          System.out.println("Max Row Size            : " + dbMeta.getMaxRowSize());
          System.out.println("Max Statement Length    : " + dbMeta.getMaxStatementLength());

		 }catch(SQLException e) {
			System.out.println("|Statement Problem..!");
		 }
		 
		    
		 
		 
		  
		  
		  
		  
		  
		  
	}

}
