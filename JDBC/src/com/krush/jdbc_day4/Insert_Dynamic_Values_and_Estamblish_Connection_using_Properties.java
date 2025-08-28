package com.krush.jdbc_day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import java.io.FileInputStream;

public class Insert_Dynamic_Values_and_Estamblish_Connection_using_Properties {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		try {

			Properties prop = new Properties();

			prop.load(new FileInputStream("driverInfo.properties"));

			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String usn = prop.getProperty("usn");
			String pwd = prop.getProperty("pwd");

			Class.forName(driver);

			con = DriverManager.getConnection(url, usn, pwd);
			System.out.println("Connection Sucessfull.!!");
			stmt = con.createStatement();

			Scanner sc = new Scanner(System.in);

			String option = "N";
			do {
				/*
				 * //Reading The table Name Dynamically
				 * System.out.println("Enter Table Name : "); String tName = sc.nextLine();
				 * 
				 * String readTable = "Select * from '" + tName + "'";
				 * 
				 * ResultSet rs = stmt.executeQuery(readTable); ResultSetMetaData rsmd=
				 * rs.getMetaData();
				 */
				System.out.print("Enter the Course Id : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter the  Course Name : ");

				String cName = sc.nextLine();
				System.out.print("Enter the Course Fee : ");
				Double fee = sc.nextDouble();
				sc.nextLine();
				
				
			String insertQuery = "INSERT INTO course( COURSE_ID ,COURSE_NAME, COURSE_FEE) VALUES() ";	
				
				
				
				

			} while (option.equalsIgnoreCase("Y"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
