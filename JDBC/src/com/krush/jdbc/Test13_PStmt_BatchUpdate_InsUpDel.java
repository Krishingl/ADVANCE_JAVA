package com.krush.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Test13_PStmt_BatchUpdate_InsUpDel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		
		Properties props = new Properties();
		props.load(new FileReader("driverInfo.properties"));
		
		
		final String URL= props.getProperty("url");
		final String USN= props.getProperty("usn");
		final String PWD= props.getProperty("pwd");
		
		
		
		
		

	}

}
