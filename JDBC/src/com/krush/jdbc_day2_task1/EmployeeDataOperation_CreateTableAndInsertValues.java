package com.krush.jdbc_day2_task1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDataOperation_CreateTableAndInsertValues {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  System.out.println("Class Loaded Succesfully");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "KIDB", "123");
		  System.out.println("Connection created.");
		  
		   Statement stmt = con.createStatement();
		   //  stmt.execute("drop table employee");
		     try(con;stmt) {
		    	 stmt.execute("""
		      		     CREATE TABLE employee( 
		      		     emp_id  NUMBER(8) PRIMARY KEY,
		      		     emp_name VARCHAR2(20) NOT NULL,
		      		     emp_age   NUMBER(3)  NOT NULL CHECK(emp_age>0 AND emp_age <=100),
		      		     emp_salary NUMBER(7,2) DEFAULT 0)
		      		                 
		      		""");
 
			      stmt.executeUpdate("Insert into employee values(1	,'Naresh',	22,	23432.6)");
			      stmt.executeUpdate("Insert into employee values(2	,'Suresh',	23,	32222.5)");
			      stmt.executeUpdate("Insert into employee values(3	,'Jain',	32,	43332.6)");
			      stmt.executeUpdate("Insert into employee values(4	,'David',	27,15009.2)");
			      stmt.executeUpdate("Insert into employee values(5	,'Anthony',	34,32322.5)");
				  
		    	 
		     }
		     catch(Exception e) {
		    	 System.err.println("Table is already created");
		    	 
		     }
		     Scanner sc = new Scanner(System.in);
		     
		     while(true) {
		    	 System.out.println("""
		    	 		
	Select Option:  
		    	 		 
		 1.Insert
		 2.Update
		 3.Read
		 4.Exit
		    	 		   
""");
		    	 System.out.print("Enter Your  Option : ");
		    	        int choice= Integer.parseInt(sc.nextLine());
		    	        switch(choice) {
		    	        case 1->{
                                 System.out.print("How Many record you want to insert: "); 
                                 ArrayList<Employee> listOfEmployee = new ArrayList<>();
                                int noof= Integer.parseInt(sc.nextLine());
                                 for(int i=1; i<=noof;i++) {
                                	 
                                         System.out.println("Enter the Employee Id : ");
                                         int id= Integer.parseInt(sc.nextLine());

                                         System.out.println("Enter the Employee Name : ");
                                         String name = sc.nextLine();
                                         
                                         System.out.print("Enter the Employee Age : ");
                                         int age= Integer.parseInt(sc.nextLine());
                                         System.out.print("Enter the Employee  Salary : ");
                                         double salary= Double.parseDouble(sc.nextLine());
                                         
                                         
                                         Employee emp= new Employee(id, name, age, salary);
                                         listOfEmployee.add(emp);
                                         
                                	
                                 }
                                 insertRecord(listOfEmployee, stmt);
                                 
		    	        }
		    	        case 2->
		    	        {
		    	        
		    	        	
		    	        }
		    	        case 3->
		    	        {
		    	    		ResultSet rs = stmt.executeQuery("Select * from employee");

		    				ArrayList<Employee> listOfEmployees = new ArrayList<>();

		    				while (rs.next()) {
		    					listOfEmployees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
		    				}

		    				ListIterator<Employee> listItr = listOfEmployees.listIterator();

		    				while (listItr.hasNext()) {
		    					Employee emp = listItr.next();
		    					int age = emp.age();
		    					if (age > 0) {
		    						System.out.println(emp);
		    					}
		    				}
		                     
		    	        }
		    	        case 4-> 
		    	        {
		    	        	 System.exit(0);
		    	        }
		    	        default-> System.err.println("Invalid Option select Valid please..");
		    	        
		    	        
		    	        }
		    	 
		     }
		     
		  
	
	}
	 private static void insertRecord(ArrayList<Employee> listOFEmployee,Statement stmt) 
	 {
		
		                  
		          try {
		        	  for(Employee emp: listOFEmployee) {
				stmt.executeUpdate("INSERT INTO employee values("+emp.id()+",'"+emp.name()+"',"+emp.age()+","+emp.salary()+")");
				 
		        	  }
		        	  
					
				}
		          catch(SQLException e)
		          {
				
					System.err.println("insertRecord");
					
				}
		
    	 
     }
     

}
