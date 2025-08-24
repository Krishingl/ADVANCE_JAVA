package com.krush.jdbc_day4;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
public class Test10_PStmt_Insert_DynamicValues_AutomaticLoadingDriver_TryWithRes {
    public static void main(String[] args) {

;
try {
	//1. creating empty properties objects
	Properties props = new Properties();
	
	//2. loading properties from properties file into props object
	props.load(new FileReader("driverInfo.properties"));
	
	//3. reading properties from props object and storing local variables
	String url		= props.getProperty("url");
	String usn		= props.getProperty("usn");
	String pwd		= props.getProperty("pwd");

	String insertQuery = 
			"""
			INSERT INTO course(course_id, course_name, course_fee) 
			VALUES(course_seq.nextval, ?, ?)
			""";		
	//JDBC objects creation with 'try-with-resouces'
	try(
			Connection con = DriverManager.getConnection(url, usn, pwd);
			PreparedStatement pstmt = con.prepareStatement(insertQuery);//<--
	){
		Scanner scn = new Scanner(System.in);
		
		String option = "N";
		do {
			System.out.print("\nEnter course name: ");
			String courseName = scn.nextLine();

			System.out.print("Enter course fee : ");
			double courseFee = scn.nextDouble(); 
			
			//-->setting values to pstmt
			
			pstmt.setString(1, courseName);
			pstmt.setDouble(2, courseFee);
			
			//-->executing pstmt query
			
			int numberOfRows = pstmt.executeUpdate();
			System.out.println("\n "+ numberOfRows + " row inserted");
		
			System.out.print("\nDo you want to continue(Y/N)?: ");
			option = scn.next(); scn.nextLine();
			
		}while(option.equalsIgnoreCase("Y"));
		
		System.out.println("\n******* Thank you, Visit again *******");

	}//try-with-resource close
	catch (SQLException e) {
		e.printStackTrace();
	}
}catch(IOException e) {
	e.printStackTrace();
}
    		} //main close
    	}//class close

