package com.krush.jdbc_demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Test01_Connection{
	
	public static void main(String[] args) {
		   
		
		
		try {
			
			//1.Loading  the Oracle Driver into JVM
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Create the Connection to DataBase   //jdbc:oracle:thin:@//<host>:<port>/<service_name>

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mydb9am","123");
			
			System.out.println("Connection Established");
			//Printing the Connection Object Class Name
			System.out.println(con);//oracle.jdbc.driver.T4CConnection@275710fc  [fQN +@+ hashCode()]
			//Closing Connection
			con.close();
	
		
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
	
		
	}

}
