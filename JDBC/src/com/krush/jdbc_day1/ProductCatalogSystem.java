package com.krush.jdbc_day1;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class ProductCatalogSystem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  System.out.println("Class Loaded Succesfully");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "KIDB", "123");
		  System.out.println("Connection created.");
		  
		  Statement stmt = con.createStatement();
		  System.out.println("Statement created.");
		  
		  stmt.execute("DROP  TABLE ORDERS CASCADE CONSTRAINTS" );
		  stmt.execute("DROP  TABLE PRODUCTS CASCADE CONSTRAINTS" );
		  stmt.execute("DROP  TABLE CUSTOMERS  CASCADE CONSTRAINTS" );
//		
	//  stmt.execute("DROP    SEQUENCE product_seq " );
	//	  stmt.execute("DROP  SEQUENCE   customer_seq" );
//  	  stmt.execute("DROP  SEQUENCE order_seq" );
	  
		  
		 String productTableQuery = """
		 		
		 		        CREATE table products(
		 		        product_id NUMBER(4) PRIMARY KEY,
		 		        product_name VARCHAR2(100) NOT NULL,
		 		        price NUMBER(10,2) CHECK (price>=0),
		 		        STOCK NUMBER(7)  DEFAULT 0 CHECK(STOCK>=0)
		 		        )
		 		        
		 		
		 		""";
		 String customersTableQuery = """
			 		
	 		        CREATE table CUSTOMERS(
	 		        customer_id NUMBER(4) PRIMARY KEY,
	 		        name VARCHAR2(20) NOT NULL,
	 		        email VARCHAR2(20) UNIQUE,
	 		         phone  NUMBER(15)
	 		          )
	 		        
	 		""";
		 
		 String ordersTableQuery = """
			 		
	 		        CREATE table ORDERS(
	 		        order_id NUMBER(4) PRIMARY KEY,
	 		        customer_id NUMBER(4)  REFERENCES CUSTOMERS(customer_id) ,
	 		        order_date DATE  DEFAULT SYSDATE,
	 		        total_amount Number(12,2) DEFAULT 0
	 		        )
	 		        
	 		""";
		
		 String productSeq="CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1";
		 String  customerSeq="CREATE SEQUENCE customer_seq START WITH 100 INCREMENT BY 1";
		 String  orderSeq="CREATE SEQUENCE order_seq START WITH 1000 INCREMENT BY 1";
		 
		 
		 
		 stmt.execute(productTableQuery);
		 System.out.println("Product Table Created Succesfully");
		 
		 stmt.execute(customersTableQuery);
		 System.out.println("Customer Table Created Succesfully");
			
		 stmt.execute(ordersTableQuery);
		 System.out.println("Order Table Created Succesfully");
			
		 
		
		
		 stmt.execute(customerSeq);
		 System.out.println("cutomer sequence created Created Succesfully");
		 stmt.execute(productSeq);
		 System.out.println("product sequence created Created Succesfully");
		 
		 stmt.execute(orderSeq);

		 System.out.println("order sequence created Created Succesfully");
		 
		 
		 
	}

}
