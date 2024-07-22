package com.aurionpro.exception;

public class InsufficientFundsException extends RuntimeException {
	
	double amount;

	public InsufficientFundsException(double amount) {
		super();
		this.amount = amount;
	}
	
	public String getMessage() {
		return "Insufficient Fund "+", Available balance: "+amount;
	}

}
