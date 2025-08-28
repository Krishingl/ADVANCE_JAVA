package com.krush.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test12_PStmt_Insert_BatchUpdates
{
   public static void main(String[] args)
   {
		   
	       final String URL= "jdbc:oracle:thin:@localhost:1521:orcl";
	       final String USN= "KIDB";
	       final String PWD= "123";
	       
	       
	   final String insertQuery="""
	      		INSERT INTO course values(course_seq.nextVal,?,?)
	      		""";
	       try(Connection con= DriverManager.getConnection(URL,USN,PWD);
	    	PreparedStatement pStmt =  con.prepareStatement(insertQuery)
	    		   )
	       {
	    	   Scanner sc = new Scanner(System.in);
	    	   String option ="Y";
	    	   do {
	    		   System.out.print("\nEnter the Course Name : ");
	    	    	String cName = sc.nextLine();
	    	    	System.out.print("Eneter the Course Fees : ");
	    	    	double cFee = sc.nextDouble(); sc.nextLine();
	    	    	
	    	    	
	    	    	pStmt.setString(1,cName);
	    	    	pStmt.setDouble(2, cFee);
	    	    	
	    	    	pStmt.addBatch();
	    	        
    	    	    System.out.println("\nQuery Is Added to the Batch.");   
    	    	    System.out.print("\n Do You Want To Continue (Y/N) : ");
    	    	    
    	    	    option = sc.next().toUpperCase();sc.nextLine();
    	    	
	    		      
	    	   }while(option.equals("Y"));
	    	   
	    	   int [] numberOfRows = pStmt.executeBatch();
	    	    int numberOfRow=0;
	    	    for( int value:numberOfRows) {
	    	    	numberOfRow+=value;
	    	    }
	    	    
	    	    System.out.println(numberOfRow+" row inserted.");
	    	   
	    	   System.out.println("*************Thank You, vist Again*************");
	    	   
	    	   
	    	   
	    	   
	       }catch(SQLException e) {
	    	  e.printStackTrace();
	       }
	    		   
	       

	}

}
