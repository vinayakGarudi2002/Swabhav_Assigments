package com.aurionpro.model;

import com.aurionpro.exception.AccountException;
import com.aurionpro.exception.SavingAccountException;

public class SavingAcccount extends Account {
	
	private int minimumBalance;
	
	public SavingAcccount( String name, double balance, AccountType accountType) {
		super(name, balance, accountType);
		this.minimumBalance=5000;
		if(balance<minimumBalance)
			throw new SavingAccountException(minimumBalance);
	}


	public int getMinimumBalance() {
		return minimumBalance;
	}


	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}


	private double balance =getBalance();
	
	  public void credit(double amount) {
		  balance=getBalance();
	        if (amount <= 0) {
	        	throw new AccountException(amount);
	        }
	        balance += amount;
	        setBalance(balance);
	        System.out.println("Amount credited: " + amount);
	    }

	    
	    public void debit(double amount) {
	    	 balance=getBalance();
	        if (amount <= 0) {
	        	throw new AccountException(amount);
	        }
	        
	        if (balance < amount) {
	        	throw new SavingAccountException(amount);
	        }
	        balance -= amount;
//	        if(balance<minimumBalance)
//				throw new SavingAccountException(amount);
	        setBalance(balance);
	        System.out.println("Amount debited: " + amount);
	    }

}
