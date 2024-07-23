package com.aurionpro.exception;

public class SavingAccountException extends AccountException{

	public SavingAccountException(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return "Balance need to be atleast: " + amount+" to open Saving Account";
	}
	
	public String getInsufficientBalanceExceptionMessage() {
		return "Insufficient balance for the requested amount:  " + amount;
	}
	

}
