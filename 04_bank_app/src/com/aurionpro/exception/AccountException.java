package com.aurionpro.exception;

public class AccountException extends RuntimeException {
	
	protected double amount;

	public AccountException(double amount) {
		this.amount = amount;
	}
	
	public String getMessage(){
		return "Enter Valid amount";
	}
	
	

}
