package com.krush.jdbc_demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Test03_Stmt_TableCreation {

	public static void main(String[] args) {
		try {
			// 1. Loading DB driver

			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("Driver is loaded");
			// 2. Establishing connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "KIDB", "123");
			System.out.println("Connection is created");
			// 3. Creating Statement object
			Statement stmt = con.createStatement();
			System.out.println("Statement is created");
			     //Drop already created tables 
    stmt.execute("Drop table course CASCADE CONSTRAINTS ");
	stmt.execute("Drop  table student CASCADE CONSTRAINTS");
			
			// 4. Executing Table creation queries
			
			String courseTableQuery = " CREATE TABLE course( course_id NUMBER(4) PRIMARY KEY, course_name VARCHAR(20) NOT NULL UNIQUE ,course_fee NUMBER(7,2))";

			String studentTableQuery =  "CREATE TABLE student (" +
				    " sid NUMBER(4) PRIMARY KEY, " +
				    " sname VARCHAR2(50) NOT NULL UNIQUE, " +
				    " course_id NUMBER(4) REFERENCES course(course_id), " +
				    " fee NUMBER(7,2))";
			stmt.execute(courseTableQuery);

			System.out.println("Course table is created");
			stmt.execute(studentTableQuery);
			System.out.println("Student table is created");
			

            // 5. Insert sample data
            stmt.execute("INSERT INTO course VALUES (101, 'Java', 15000.00)");
            stmt.execute("INSERT INTO course VALUES (102, 'Python', 12000.00)");
            System.out.println("Sample courses inserted");

            stmt.execute("INSERT INTO student VALUES (1, 'Krushna', 101, 15000.00)");
            stmt.execute("INSERT INTO student VALUES (2, 'Amit', 102, 12000.00)");
            System.out.println("Sample students inserted");
         
          //6.Retrieving Or reading the Data from DataBase
               
            ResultSet rs= stmt.executeQuery("SELECT * FROM STUDENT");
               
            while(rs.next())
            {

                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                int courseId = rs.getInt("course_id");
                double fee = rs.getDouble("fee");

                System.out.println(sid + " | " + sname + " | " + courseId + " | " + fee);
            	
            }
            
            ResultSet rss = stmt.executeQuery("SELECT * FROM student");

            System.out.printf("%-5s %-15s %-10s %-10s%n", "SID", "SNAME", "COURSE_ID", "FEE");
            System.out.println("------------------------------------------------------");

            while (rss.next()) {
                System.out.printf("%-5d %-15s %-10d %-10.2f%n",
                        rss.getInt("sid"),
                        rss.getString("sname"),
                        rss.getInt("course_id"),
                        rss.getDouble("fee"));
            }
			    
			//7.closing connection
			stmt.close();
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

}
