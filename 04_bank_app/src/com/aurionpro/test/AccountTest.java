package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.AccountException;
import com.aurionpro.exception.CurrentAccountException;
import com.aurionpro.exception.SavingAccountException;
import com.aurionpro.model.Account;
import com.aurionpro.model.AccountType;
import com.aurionpro.model.CurrentAccount;
import com.aurionpro.model.SavingAcccount;


public class AccountTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to my Bank");
		
		System.out.println("Enter how many accounts you like to open: ");
		int totalNumberAccount=scanner.nextInt();
		Account[] bankAccounts = new Account[totalNumberAccount]; 
		
		createListOfAccount(bankAccounts,scanner);
		
		boolean exitStatus=false;
		
		displayAllAccounts(bankAccounts);
		
		while(!exitStatus) {
			
			//taking index to select object from array
			System.out.println("Enter Account number to perform transaction or -1 to exit: ");
			int accountIndex=scanner.nextInt();
			
			if(accountIndex==-1) {
				exitStatus=true;
				break;
			}
			
			if(accountIndex>bankAccounts.length || accountIndex<1) {
				System.out.println("Enter Valid Account Number");
			}else {
				
				performTransaction(bankAccounts,accountIndex);
			}
		}
		
		System.out.println("Application closed succesfully! ");

	}
	
	
public static Account createAccount(Scanner scanner) {
	
	     scanner.nextLine();

	
         System.out.print("Enter 's' for chosing saving account and 'c' for current account: ");
         char ch = scanner.next().charAt(0);
         
         
         
         AccountType accountType;
         
         switch (ch) {
 		case 'c':
 			accountType = AccountType.CURRENT;
 			break;
         case 's':
        	 accountType = AccountType.SAVING;
 			break;

 		default:
 			System.err.println("In Valid Input");
 			return null;
 		}
         
       
         Account account=createAccount(accountType,scanner);
         
        
         
         return account;
         
	}


private static Account createAccount(AccountType accountType,Scanner scanner) {
	

		 System.out.println("Enter the following details to create your account in our bank:");
	     System.out.print("Name: ");
	     String name = scanner.next();
	    
	     System.out.print("Initial Balance: ");
	     double balance = scanner.nextDouble();

     
    


	if(accountType==AccountType.CURRENT) {
		return createCurrentAccount(name,balance);
	}
	
	return createSavingAccount(name,balance);
}


private static Account createSavingAccount(String name, double balance) {
	Account account=null;
	try{
		 account = new SavingAcccount(name,balance, AccountType.SAVING);
		 account.setAccountNumber(account.accountNumberGenerator());
	}catch(SavingAccountException e) {
		System.err.println(e.getMessage());
	}

	return account;
}


private static Account createCurrentAccount(String name, double balance) {
	
	Account account = new CurrentAccount(name,balance, AccountType.CURRENT);
	account.setAccountNumber(account.accountNumberGenerator());
	
	return account;
}


private static void createListOfAccount(Account[] bankAccounts,Scanner scanner) {
	int accountsCreated=0;
	//using while loop as we don.t know how many iteration will happen 
	while(accountsCreated<bankAccounts.length) {
		System.out.println("Creating Account No.: "+(accountsCreated+1));
		Account account=createAccount(scanner);
		
		if(account==null)
			continue;
		
		bankAccounts[accountsCreated]=account;
		displayAccountDetails(bankAccounts[accountsCreated]);
		System.out.println("");
		
		accountsCreated++;
	}
	  
}


 private static void displayAccountDetails(Account account) {
	        System.out.println("Account Details:");
	        System.out.println("Account Number: " + account.getAccountNumber());
	        System.out.println("Name: " + account.getName());
	        System.out.println("Account Type: " + account.getAccountType());
	        System.out.println("Balance: " + account.getBalance());
	    }
 
 
 private static void displayAllAccounts(Account[] bankAccounts) {
	  
	  System.out.println("Total Accounts Created: ");
		System.out.println("");
		for(int i=0;i<bankAccounts.length;i++) {
			System.out.println("Account No.: "+(i+1));
			displayAccountDetails(bankAccounts[i]);
			System.out.println("");
		}
	  
 }
 
 
 private static void performTransaction(Account[] bankAccounts,int accountIndex) {
	  
	  Scanner scanner = new Scanner(System.in);
	  
	  boolean quitStatus=false;
		
		displayAccountDetails(bankAccounts[accountIndex-1]);
		
		 while (!quitStatus) {
	            System.out.println("Choose an option:");
	            System.out.println("1. View Balance");
	            System.out.println("2. Credit Amount");
	            System.out.println("3. Debit Amount");
	            System.out.println("4. Exit");

	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1:
	                    System.out.println("Balance: " + bankAccounts[accountIndex-1].getBalance());
	                    break;
	                case 2:
	                    System.out.print("Enter amount to credit: ");
	                    double creditAmount = scanner.nextDouble();
	                    try {
	                    	bankAccounts[accountIndex-1].credit(creditAmount);
	                    }
	                    catch(CurrentAccountException e) {
	                    	System.out.println(e.getMessage());
	                    }catch(SavingAccountException e) {
	                    	System.out.println(e.getMessage());
	                    }catch(AccountException e) {
	                    	System.out.println(e.getMessage());
	                    }catch(Exception e) {
	                    	System.out.println(e.getMessage());
	                    }
	                    break;
	                case 3:
	                    System.out.print("Enter amount to debit: ");
	                    double debitAmount = scanner.nextDouble();
	                    
	                    try{
	                    	bankAccounts[accountIndex-1].debit(debitAmount);
	                    }catch(CurrentAccountException e) {
	                    	System.out.println(e.getMessage());
	                    }catch(SavingAccountException e) {
	                    	System.out.println(e.getInsufficientBalanceExceptionMessage());
	                    }catch(AccountException e) {
	                    	System.out.println(e.getMessage());
	                    }catch(Exception e) {
	                    	System.out.println(e.getMessage());
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


}
