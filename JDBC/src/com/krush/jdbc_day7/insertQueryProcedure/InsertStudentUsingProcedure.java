package com.krush.jdbc_day7.insertQueryProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class InsertStudentUsingProcedure {

    public static void main(String[] args) {
        // Database Credentials
        final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String USN = "KIDB2";   // your username
        final String PWD = "123";    // your password

        Scanner sc = new Scanner(System.in);

        try {
            // Load Oracle Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded...");

            // Establish Connection
            Connection con = DriverManager.getConnection(URL, USN, PWD);
            System.out.println("Connection Established...");

            // Prepare CallableStatement for procedure
            CallableStatement cst = con.prepareCall("call InsertStudentDetails(?,?,?,?,?,?,?,?,?)");

            // Taking input from user
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();

            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();

            System.out.print("Enter House No: ");
            String hno = sc.nextLine();

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            System.out.print("Enter Pincode: ");
            int pincode = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Mail ID: ");
            String mid = sc.nextLine();

            System.out.print("Enter Phone No: ");
            String phno = sc.nextLine();

            // Set parameters
            cst.setInt(1, id);
            cst.setInt(2, roll);
            cst.setString(3, name);
            cst.setString(4, branch);
            cst.setString(5, hno);
            cst.setString(6, city);
            cst.setInt(7, pincode);
            cst.setString(8, mid);
            cst.setString(9, phno);

            // Execute Procedure
            cst.execute();
            System.out.println("{Student Details Inserted Successfully!}");

            // Close
            cst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
