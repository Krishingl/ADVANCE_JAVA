package com.krush.jdbc_day6.banking_application.blc;
import java.util.Scanner;
public class Account_Operation {
	
	public static void main(String[] args) {
		System.out.println("""
Press 1 → Perform deposit & withdraw operation (transactional).
Press 2 → Insert new account details.
Press 3 → View all account details.
Press 4 → Exit application.
				""");
		  Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter your choice: 1 :");
		int choice = Integer.parseInt(sc.nextLine());
	
		   switch(choice) {
		   case 1->
		   {   System.out.println("Enter the amount to be deposit: ");
		   
		          double dipositAmount = Double.parseDouble(sc.nextLine());
			       System.out.println("Enter the account number: ");
			       int accountNumber = Integer.parseInt(sc.nextLine());
			       
			       
			       
			   
		   }
		   
		   
		   case 2->
		   {
			   
		   }
		   case 3->{
			   
			   
		   }
           case 4->{
			   
			   
		   }
		   }
		   
	}

}
