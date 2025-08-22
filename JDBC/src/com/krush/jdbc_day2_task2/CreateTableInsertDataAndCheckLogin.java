package com.krush.jdbc_day2_task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class  CreateTableInsertDataAndCheckLogin {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "KIDB", "123");
			System.out.println("sucess");
			Statement smt = con.createStatement();
		
			

			Scanner sc = new Scanner(System.in);
			
			Boolean flag=true;
			while(flag) {
			System.out.println("1. Create Table \n2.Insert Record\n3.Login\n4.Exit ");

			System.out.println("Insert Your Choice: ");

			int choice = Integer.parseInt(sc.nextLine());
            
			switch (choice) {
		
			case 1:
				try {
				System.out.println("U are going to create Table ");

				smt.execute(
						" Create table userDetails(userName varchar2(30),password varchar2(20),firstName varchar2(20),lastName Varchar2(20),mailId varchar2(50), phoneNumber varchar2(30))");
				}catch(SQLException e) {
					System.err.println("Table is alrady Created  Please Do other Operation.");
				}
				break;
			
			case 2:
				System.out.println();
				System.out.println("Enter UserName : ");
				String uName = sc.nextLine();
				System.out.println("Enter  PassWord : ");
				String pass = sc.nextLine();
				System.out.println("Enter  First Name : ");
				String fName = sc.nextLine();
				System.out.println("Enter  Last Name: ");
				String lName = sc.nextLine();
				System.out.println("Enter  Mail ID: ");
				String mailId = sc.nextLine();
				System.out.println("Enter  Phone: ");
			        long phone =Long.parseLong(sc.nextLine());
                  smt.execute("Insert into userDetails values('"+uName+"','"+pass+"','"+fName+"','"+lName+"','"+mailId+"','"+phone+"')");
				break;
			case 3:
				System.out.println("Enter UserName : ");
				uName = sc.nextLine();
				System.out.println("Enter  PassWord : ");
				pass = sc.nextLine();
				ResultSet rs2 = smt
						.executeQuery("Select * from userDetails  where userName='" + uName + "' AND password='" + pass + "'");
 
				if(rs2.next()) {
					System.out.println("Login Succesfull\n WellCome to user '" + rs2.getString(1) + "'");
					flag= false;
				}else {
					System.out.println("Invalid password..");
				}
				break;
			case 4: flag= false;
			   break;
			   default: System.err.println("Invalid Choice Please Select Valid Option..");

			}

			}

		} catch (Exception e) {
                     e.printStackTrace();
		}

	}

}
