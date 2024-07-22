package com.aurionpro.model;

import com.aurionpro.exception.InsufficientFundsException;
import com.aurionpro.exception.NegativeAmountException;

public class BankAccount {

    private long accountNumber;
    private double balance;
    private String name;
    
    

    public BankAccount(double balance, String name) {
		super();
		this.balance = balance;
		this.name = name;
	}

	public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public long accountNumberGenerator() {
        return (long) (Math.random() * 9000000000L) + 1000000000L;
    }

    
    public void deposit(double creditAmount) {
        if (creditAmount <= 0) {
            throw new NegativeAmountException(creditAmount);
        }
        balance += creditAmount;
        System.out.println("Amount credited: " + creditAmount);
    }

    
    public void withdraw(double amount) {
        if (amount <= 0) {
        	throw new NegativeAmountException(amount);
        }
        if (balance < amount) {
            throw new InsufficientFundsException(balance);
        }
        balance -= amount;
        System.out.println("Amount debited: " + amount);
    }

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", name=" + name + "]";
	}
}
