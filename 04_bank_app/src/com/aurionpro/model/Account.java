package com.aurionpro.model;

public class Account {
	
	private long accountNumber;
	private String name;
	private double balance;
	private AccountType accountType; 
	
	public Account( String name, double balance,AccountType accountType) {
		this.name = name;
		this.balance = balance;
		this.accountType=accountType;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	 public long accountNumberGenerator() {
	        return (long) (Math.random() * 9000000000L) + 1000000000L;
	    }
	public void credit(double creditAmount) {
		// TODO Auto-generated method stub
		System.out.println("Account");
		
	}
	public void debit(double debitAmount) {
		// TODO Auto-generated method stub
		System.out.println("Account");
	}

}
