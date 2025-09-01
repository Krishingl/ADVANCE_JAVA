package com.krush.jdbc_day6.banking_application.blc;

//This class will represent the account entity.
public class Account {
   private 	long accountNumber;// Unique account number

	private String accountHolderName;// Name of account holder
	private double accountBalance;// Current Balance

	public Account(long accountNumber, String accountHolderName, double accountBalance) {
        this.accountBalance=accountBalance;
		this.accountHolderName=accountHolderName;
		this.accountNumber=accountNumber;
		
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + "]";
	}

	
	

}
