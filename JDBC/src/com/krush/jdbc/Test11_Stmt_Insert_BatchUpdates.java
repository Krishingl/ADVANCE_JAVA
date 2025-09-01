package com.krush.jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class Test11_Stmt_Insert_BatchUpdates {

	public static void main(String[] args) {
		    
		       final String URL= "jdbc:oracle:thin:@localhost:1521:orcl";
		       final String USN= "KIDB";
		       final String PWD= "123";
		       
		       
		       try(Connection con= DriverManager.getConnection(URL,USN,PWD);
		    		   
		    	Statement stmt = con.createStatement();
		    	)
		       {
		    	   Scanner sc = new Scanner(System.in);
		    	   
		    	    String option = "N";
		    	    do {
		    	    	System.out.print("\nEnter the Course Name : ");
		    	    	String cName = sc.nextLine();
		    	    	System.out.print("Eneter the Course Fees : ");
		    	    	double cFee = sc.nextDouble(); sc.nextLine();
		    	    	
		    	    	String insertQuery="INSERT INTO course values(course_seq.nextVal,'"+cName+"','"+cFee+"')";
		    	    	stmt.addBatch(insertQuery);
		    	    	        
		    	    	    System.out.println("\nQuery Is Added to the Batch.");   
		    	    	    System.out.print("\n Do You Want To Continue (Y/N) : ");
		    	    	    
		    	    	    option = sc.next().toUpperCase();sc.nextLine();
		    	    	
		    	    }while (option.charAt(0)=='Y' );
		    	    
		    	    
		    	    
		    	    
		    	    int [] numberOfRows = stmt.executeBatch();
		    	    int numberOfRow=0;
		    	    for( int value:numberOfRows) {
		    	    	numberOfRow+=value;
		    	    }
		    	    
		    	    System.out.println(numberOfRow+" row inserted.");
		    	   
		    	   System.out.println("*************Thank You, vist Again*************");
		    	   
		    	   
		    	   
		       }catch(SQLException e) {
		    	   System.out.println(e);
		       }
		       
		        
		        
		        
		        

	}

}
