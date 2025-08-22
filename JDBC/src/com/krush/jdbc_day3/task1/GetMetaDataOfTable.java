package com.krush.jdbc_day3.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetMetaDataOfTable {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "KIDB", "123");
		System.out.println(" Connection sucess");
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Table Name : ");
		String tName = sc.nextLine();
		System.out.println("\r");
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("Select * from " + tName + "");

			ResultSetMetaData rsmd = rs.getMetaData();

			
		tableDesc(rsmd);
		
		System.out.println( "------------------------------ Records-------------------------------");
		System.out.println("--------------------------------------------------------\n");
			getRecords(rsmd, rs);
			rs.close();
		} catch (SQLException e) {
			System.out.println("Sorry this table not available.");
		}

		sc.close();
		stmt.close();
		con.close();

	}

	private static void tableDesc(ResultSetMetaData rsmd) {
		System.out.println("----------Table Column Description-------");
		try {
			System.out.println("Total Columns : " + rsmd.getColumnCount());

			System.out.println("------------------------------");
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println("Column Name : " + rsmd.getColumnName(i));
				System.out.println("Column Type : " + rsmd.getColumnType(i));
				System.out.println("Column Size : " + rsmd.getPrecision(i));
				System.out.println("Column Nullable : " + (rsmd.isNullable(i) == 1 ? "Yes" : "No"));

				System.out.println("------------------------------");
			}
		} catch (SQLException e) {
			System.err.println("Columns Not Found!!!");
		}

	}

	private static void getRecords(ResultSetMetaData rsmd,ResultSet rs) 
	{
	    	
		
	    		try {
	    			 if(rs.next())
	    			  {
	    			
	    			//Columns Names 
	    			int countLines=0;
					for(int i=1 ;i<=rsmd.getColumnCount();i++)
					{      int precision=rsmd.getPrecision(i); 
					         
					System.out.print(rsmd.getColumnName(i)+"");
					         
					        int space=(precision+(rsmd.getColumnName(i).toCharArray()).length);
						while(space>0) {
							System.out.print(" ");
						   space-=2;
					}
						
						countLines+=precision;
					}
					//lines
				
					System.out.println();
					   for(int j=1;j<=countLines;j++) {
					System.out.print("-");
					   }
					   System.out.println();
					   
					  //Table Records Or rows
					   
					do {
					for(int i=1;i<=rsmd.getColumnCount();i++) {
						System.out.print(rs.getString(i)+"\t\t   ");
					
						
					}
					System.out.println();
						
					}while(rs.next());
					   
	    			  }else
		    		{
		    			System.out.println("No data found..!");
		    		}   
	    			     
					   
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    		}
	    
}

