package com.krush.jdbc_day6.banking_application.blc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AccountOperations {

	Connection con = DatabaseConnection.getConn();

	public boolean addAccountDetails(Account account) throws SQLException {

		PreparedStatement pStmt = con.prepareStatement("INSERT INTO accounts(?,?,?)");
		pStmt.setLong(1, account.getAccountNumber());
		pStmt.setString(2, account.getAccountHolderName());
		pStmt.setDouble(3, account.getAccountBalance());
		boolean execute = pStmt.execute();
        
		return execute;

	}

	public void viewAccountDetails() throws SQLException {

		Statement stmt = con.createStatement();

		ResultSet resultSet = stmt.getResultSet();

		while (resultSet.next()) {

			System.out.println("Account No is : " + resultSet.getString(1) + "\n Holder Name: " + resultSet.getString(2)
					+ "\n Balance : " + resultSet.getString(3));
			System.out.println("---------------------------------------------------------");

		}
             resultSet.close();
	}

	public void transactionOperation(Account account) throws SQLException {
		Scanner sc = new Scanner(System.in);
		con.setAutoCommit(false);

		System.out.print("Enter the amount to be deposit : ");

		double deposit = Double.parseDouble(sc.nextLine());
		System.out.println("Enter the account number: ");
		long acNo = Long.parseLong(sc.nextLine());

		PreparedStatement pstmtDeposit = con.prepareStatement("Update acount set balance= balace+? where  acc_no=?");
		pstmtDeposit.setLong(2, acNo);
		pstmtDeposit.setDouble(1, deposit);
		
		int exDeposit = pstmtDeposit.executeUpdate();
		   
		    
		  if(exDeposit>=1) {
			  System.out.println("Deposited Successfully!!");
			  System.out.println();
				PreparedStatement pstmtWithdraw = con.prepareStatement("Update acount set balance= balace-? where  acc_no=?");
				System.out.println("Enter the amount to be withdraw: ");
			 Double withdraw = Double.parseDouble(sc.nextLine());
				System.out.println("Enter the account number: ");
				 acNo = Long.parseLong(sc.nextLine());
				 pstmtWithdraw.setDouble(1,withdraw);
			      pstmtWithdraw.setLong(2,acNo);
			      
			   int exWithdraw = pstmtWithdraw .executeUpdate();
			      
			   if(exWithdraw>=1) {
				      System.out.println("Insufficient Balance!");
				   con.commit();
			   }else {
				   con.rollback();
			   }
			      
			     
			
			  sc.close();
			  
		  }
		  
		  
		  
		
		
		
	}

}
