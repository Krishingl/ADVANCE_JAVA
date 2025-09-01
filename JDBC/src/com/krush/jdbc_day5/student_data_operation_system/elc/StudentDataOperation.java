package com.krush.jdbc_day5.student_data_operation_system.elc;

import java.util.List;
import java.util.Scanner;

import com.krush.jdbc_day5.student_data_operation_system.blc.Student;
import com.krush.jdbc_day5.student_data_operation_system.blc.StudentDataFunctionality;

public class StudentDataOperation {

	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		 boolean flag=true;
		 do{
		 System.out.println("""
		Displays options:

Press 1: Add Student
Press 2: Delete Student
Press 3: Update Student by Name
Press 4: Display All Students
Press 5: Exit
		 		""");
		 
		 System.out.println("Select the Option : ");
		 int choice = sc.nextInt(); sc.nextLine();
		 
		 switch(choice) {
		 case 1->{
			 System.out.println("Enter the Student Name: ");
			 String name =sc.nextLine();
			 System.out.println("Enter the Student id: ");
			 int id = Integer.parseInt(sc.nextLine());
			 
			 System.out.println("Enter the student address:");
			 String address =sc.nextLine();
			 System.out.println("Enter the student adharNo :");
			 String adharNo =sc.nextLine();
			 
		    boolean isInserted	= StudentDataFunctionality.addStudentToDataBase(new Student(name, id, address, adharNo));
			     if(isInserted) {
			    	 System.out.println("Data inserted Successfully");
			     }else {
			    	 System.err.println("Data not Inserted try Again..!!");
			     }
			 
		 }
		 case 2->{
			 
			 System.out.println("Enter the Student id for deleting the record : ");
			 int id = Integer.parseInt(sc.nextLine());
			 int count =StudentDataFunctionality.deleteStudentData(id);
			 if(count>0) {
				 System.out.println("record Deleted Successfully..");
			 }else {
				 System.err.println("No Record Found..!");
			 }
			 
		 }
		 
		 case 3->{
			 System.out.println("Enter the Student Name :");
			 
			 
			 int count =StudentDataFunctionality.updateStudentData(sc.nextLine());
			 
			 if(count>0) {
				 System.out.println("record Updated Successfully..");
			 }else {
				 System.err.println("No Record Found..!");
			 }
			 
		 }
 case 4->{
	 List<Student> displayStudentData = StudentDataFunctionality.displayStudentData(); 
	             
	 displayStudentData.forEach(System.out::println);
		 }
		 
 
 case 5->{
	            flag=false;
	 
 }
		 }
	}while(flag);
		
	}

}
