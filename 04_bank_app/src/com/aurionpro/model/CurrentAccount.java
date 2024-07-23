package com.aurionpro.model;

import com.aurionpro.exception.AccountException;
import com.aurionpro.exception.CurrentAccountException;

public class CurrentAccount extends Account {
	
	public CurrentAccount( String name, double balance, int minimumOverDraftLimit,
			int maximumOverDraftLimit, double overDraftAmountSanctined, int interest, int tenureMonths, AccountType accountType) {
		super(name, balance, accountType);
		this.minimumOverDraftLimit = minimumOverDraftLimit;
		this.maximumOverDraftLimit = maximumOverDraftLimit;
		this.overDraftAmountSanctined = overDraftAmountSanctined;
		this.interest = interest;
		this.tenureMonths = tenureMonths;
		
	}
	
	public CurrentAccount( String name, double balance, AccountType accountType) {
		super( name, balance, accountType);
		this.minimumOverDraftLimit = 25000;
		this.maximumOverDraftLimit = 1250000;
		this.overDraftAmountSanctined = 0;
		this.interest = 3;
		this.tenureMonths = 12;
	}

	private int minimumOverDraftLimit;
	private int maximumOverDraftLimit;
	private double overDraftAmountSanctined;
	private int interest;
	private int tenureMonths;
	
	public int getMinimumOverDraftLimit() {
		return minimumOverDraftLimit;
	}

	public void setMinimumOverDraftLimit(int minimumOverDraftLimit) {
		this.minimumOverDraftLimit = minimumOverDraftLimit;
	}

	public int getMaximumOverDraftLimit() {
		return maximumOverDraftLimit;
	}

	public void setMaximumOverDraftLimit(int maximumOverDraftLimit) {
		this.maximumOverDraftLimit = maximumOverDraftLimit;
	}

	public double getOverDraftAmountSanctined() {
		return overDraftAmountSanctined;
	}

	public void setOverDraftAmountSanctined(double overDraftAmountSanctined) {
		this.overDraftAmountSanctined = overDraftAmountSanctined;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getTenureMonths() {
		return tenureMonths;
	}

	public void setTenureMonths(int tenureMonths) {
		this.tenureMonths = tenureMonths;
	}

	private double balance =getBalance();
	
	
	
	
	  public void credit(double amount) {
		    
	        if (amount <= 0) {
	        	throw new AccountException(amount);
	            //return;
	        }
	        if(overDraftAmountSanctined!=0) {
	        	amount=overDraftDebit(amount);
	        }
	        balance=getBalance();// problem
	        balance += amount;
	        setBalance(balance);
	        System.out.println("Amount credited: " + amount);
	    }

	    
	    private double overDraftDebit(double amount) {
	    	
	    	if(amount>overDraftAmountSanctined) {
	    		amount=amount-overDraftAmountSanctined;
	    		overDraftAmountSanctined=0;
	    		System.out.println("Latest Over Draft Amount: "+overDraftAmountSanctined);
	    		return amount;
	    	}
	    	overDraftAmountSanctined=overDraftAmountSanctined-amount;
	    	System.out.println("Latest Over Draft Amount: "+overDraftAmountSanctined);	
		    return 0;
	}

		public void debit(double amount) {
			balance=getBalance();
	        if (amount <= 0) {
	        	throw new AccountException(amount);
	            //return;
	        }
	        if (balance > amount) {
	        	balance -= amount;
	        	setBalance(balance);
	        	System.out.println("Amount debited: " + amount);
	            return;
	        }
	        
	        overDraftTransaction(balance,amount);
	        
	    }
	    
	    public void overDraftTransaction(double balance,double amount) {
	    
	    	double OverDraftAmount=amount-balance;
	    	
	    	if(overDraftAmountSanctined>0) {
	    		OverDraftAmount+=overDraftAmountSanctined;
	    	}
	    	
	    	if(OverDraftAmount<minimumOverDraftLimit) {
	    		throw new CurrentAccountException(((minimumOverDraftLimit-OverDraftAmount)+amount));
	    		
	    	}else if(OverDraftAmount>maximumOverDraftLimit) {
	    		throw new CurrentAccountException(amount-(OverDraftAmount-maximumOverDraftLimit));
	    		
	    	}
	    	overDraftAmountSanctined=OverDraftAmount;
	    	setBalance(0);
	    	
	    	System.out.println("Amount witdrawn by availing overDraft facility: "+OverDraftAmount);
	    	System.out.println("Net withdrawn amount: "+amount);
	    	
	    }
	    
	    public void overDraftDetail() {
	    	if(overDraftAmountSanctined!=0) {
	    	System.out.println("Over Draft Amount Sanctined: "+overDraftAmountSanctined+"Rs");
	    	System.out.println("Intresrt per Month: "+interest+"%");
	    	System.out.println("Repayable Tenure: "+tenureMonths);
	    	return;
	    }
	    	
	    	
	    	System.out.println("OverDraft is Not avail by your Account");
	    	
	   
	    }
	    
	    

}
