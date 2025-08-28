package com.krush.jdbc_day5.student_data_operation_system.blc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataFunctionality {

	     final static private  Connection con=ConnectionProvider.getConn();
	
	
	public static  boolean addStudentToDataBase(Student s) {
		  
		  boolean isInserted=false;
		
		
		        String insertQuery="INSERT INTO STUDENT(name,id,address,adharno)  VALUES(?,STU_SEQ.nextVAL,?,?)";
		        	
		try {
			PreparedStatement PStmt = con.prepareStatement(insertQuery);
			PStmt.setString(1, s.name());
	        PStmt.setString(2, s.address());
			PStmt.setString(3, s.adharNo());
			
			int executeUpdate = PStmt.executeUpdate();
			
			if(executeUpdate!=0) {
				 isInserted=true;
			}
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return isInserted;
	}
	
	
	
	public static List<Student> displayStudentData() {
		
		String selectQuery= "Select * From Student";
		
		List<Student> listOfSudent=null;
		
		try {
			
			PreparedStatement PStmt = con.prepareStatement(selectQuery);
			 listOfSudent= new ArrayList<>();
			ResultSet rs=  PStmt.getResultSet();
			
			while(rs.next()) {
			   listOfSudent.add(new Student(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));   
				
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listOfSudent;
		
	}
	
	
	public static int updateStudentData(String name) 
	{
		
				System.out.println("Select the The Option which You want to Update :\n"
						+ "1. Address\n"
						+ "2. Addhar Number ");  
				
				System.out.println("Enter Your Choice : ");       
				Scanner sc= new  Scanner(System.in);
				int choice = sc.nextInt();  sc.nextLine();
				   
				   String updateQueryAddress = "UPDATE STUDENT SET address=? whrere name='"+name+"'";
				   String updateQueryAddharNumber= "UPDATE STUDENT SET adharNo=? whrere name='"+name+"'";
				   PreparedStatement pstmt=null;
				
				switch(choice) {
				case 1->{
					   System.out.println("Enter the Address : ");
					   String address=sc.nextLine();
					   
					      try {
						 pstmt= con.prepareStatement(updateQueryAddress);
							pstmt.setString(1, address);
							
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					      
			
				       }
				case 2->{
					  System.out.println("Enter the Address : ");
					   String addharNumber=sc.nextLine();
					   
					      try {
							 pstmt= con.prepareStatement(updateQueryAddharNumber);
							pstmt.setString(1, addharNumber);
							
						
							} catch (SQLException e) {
							
							e.printStackTrace();
						}
				}
			      default->{   System.err.println("InValid Option..!!");
					
				      System.exit(0);
			      }
				}
			
		   try {
			return  pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return 0;
		   
		
	}
	

	public static int deleteStudentData(int id) 
	{
		
				
				   
				   String deleteQuery = "Delete from student  where id='"+id+"'";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(deleteQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
	
		   try {
			return  pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		   
		
	}
	
	
	
	
	

}
