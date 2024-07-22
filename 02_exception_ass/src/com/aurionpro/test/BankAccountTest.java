package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.InsufficientFundsException;
import com.aurionpro.exception.NegativeAmountException;
import com.aurionpro.model.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to My Bank");
		
		BankAccount account=createBankAccount(scanner);
		
		performTransaction(account, scanner);
		

	}

	private static BankAccount createBankAccount(Scanner scanner) {
		
		 System.out.println("Enter the following details to create your account in our bank:");
         System.out.print("Name: ");
         String name = scanner.nextLine();
         System.out.print("Initial Balance: ");
         double balance = scanner.nextInt();

         BankAccount account = new BankAccount(balance,name);
         account.setAccountNumber(account.accountNumberGenerator());  // some process would be haping in real scenario before asigning account number
         
         System.out.println("Account created successfully!");
		return account;
	}
	
  private static void performTransaction(BankAccount bankAccount, Scanner scanner) {
		  
		  boolean quitStatus=false;
			
			displayAccountDetails(bankAccount);
			
			 while (!quitStatus) {
		            System.out.println("Choose an option:");
		            System.out.println("1. View Balance");
		            System.out.println("2. Credit Amount");
		            System.out.println("3. Debit Amount");
		            System.out.println("4. Exit");

		            int choice = scanner.nextInt();
		            switch (choice) {
		                case 1:
		                    System.out.println("Balance: " + bankAccount.getBalance());
		                    break;
		                case 2:
		                    System.out.print("Enter amount to credit: ");
		                    double creditAmount = scanner.nextDouble();
		                    try {
		                    	bankAccount.deposit(creditAmount);
		                    }catch(NegativeAmountException e) {
		                    	System.err.println(e.getMessage());
		                    	
		                    }catch(Exception e) {
		                    	System.err.println(e.getMessage());
		                    }
		                    
		                    break;
		                case 3:
		                    System.out.print("Enter amount to debit: ");
		                    double debitAmount = scanner.nextDouble();
		                    try {
		                    	bankAccount.withdraw(debitAmount);
		                    }catch(NegativeAmountException e) {
		                    	System.err.println(e.getMessage());
		                    }catch(InsufficientFundsException e) {
		                    	System.err.println(e.getMessage());
		                    }
		                    catch(Exception e) {
		                    	System.err.println(e.getMessage());
		                    }
		                    
		                    break;
		                case 4:
		                	quitStatus = true;
		                    System.out.println("Thank you for banking with us!");
		                    break;
		                default:
		                    System.out.println("Invalid option, please try again.");
		                    break;
		            }
		        }	
	  }

                   private static void displayAccountDetails(BankAccount account) {
                	   
               	        System.out.println("Account Details:");
               	        System.out.println("Account Number: " + account.getAccountNumber());
               	        System.out.println("Name: " + account.getName());
               	        System.out.println("Balance: " + account.getBalance());
         }
	
	
	
	

}
