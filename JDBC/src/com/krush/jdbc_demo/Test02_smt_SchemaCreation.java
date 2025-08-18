package com.krush.jdbc_demo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02_smt_SchemaCreation {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			// 1.Loading Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.Establishing Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "123");
			System.out.println("Connection Created Succesfully");
			// 3. Creating Statement Object

			stmt = con.createStatement();
			// Executing Queries
			stmt.execute("ALTER SESSION SET \"_ORACLE_SCRIPT\"= true");
			stmt.execute("DROP USER KIDB");
			stmt.execute("CREATE USER KIDB IDENTIFIED BY 123");
			stmt.execute("GRANT DBA to KIDB");

			System.out.println("User is Created and DBA permission are Granted");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} finally {

			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}
}
