package com.krush.jdbc_day7.insertQueryProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchStudentUsingProcedure {


    public static void main(String[] args) {
        // Database Credentials
        final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
        final String USN = "KIDB2";   // your DB username
        final String PWD = "123";    // your DB password

        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded...");

            // Get Connection
            Connection con = DriverManager.getConnection(URL, USN, PWD);
            System.out.println("Connection Established...");

            // Prepare CallableStatement for procedure with OUT parameter
            CallableStatement cst = con.prepareCall("{call GetStudentDetails(?, ?)}");

            // Input from user
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            // Set IN parameter
            cst.setInt(1, id);

            // Register OUT parameter (cursor)
            cst.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);

            // Execute
            cst.execute();

            // Get ResultSet from OUT parameter
            ResultSet rs = (ResultSet) cst.getObject(2);

            // Display Data
            if (rs.next()) {
                System.out.println("===== Student Details =====");
                System.out.println("ID        : " + rs.getInt("stuId"));
                System.out.println("Name      : " + rs.getString("stuName"));
                System.out.println("Roll No   : " + rs.getInt("stuRollNo"));
                System.out.println("Address   : " + rs.getString("stuAddress"));
                System.out.println("Mail ID   : " + rs.getString("stuMailId"));
                System.out.println("Phone No  : " + rs.getString("stuPhoneNumber"));
            } else {
                System.out.println("No student found with ID: " + id);
            }

            // Close resources
            rs.close();
            cst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

}
