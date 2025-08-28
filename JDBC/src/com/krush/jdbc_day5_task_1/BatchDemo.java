package com.krush.jdbc_day5_task_1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchDemo {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			FileReader fis=new FileReader("C:\\Users\\HP\\Downloads\\MOCK_DATA (3).csv");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kidb2", "123");
			
			
			
			PreparedStatement ps = con.prepareStatement("insert into student values(stu_seq.nextVal,?,?,?)");
			Scanner sc=new Scanner(fis);
			long startTime = System.currentTimeMillis();
	        sc.nextLine();//skip fist line that is name of column
	        
	        while(sc.hasNext())//if next line data are present then it return true
	        {
	        	String[] split = sc.nextLine().split(",");
	        	
	        	for(int i=0;i<split.length;i++)
	        	{
	        	ps.setString(i+1, split[i]);	
	        	}
	        	ps.addBatch();
	        }
	        ps.executeBatch();
	        System.out.println("success");
	        long endTime = System.currentTimeMillis();
	        System.out.println("Execution Time:"+(endTime-startTime));
		}
	        catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}


