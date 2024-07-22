package com.aurionpro.exception;

public class NegativeAmountException extends RuntimeException {
	
	private double amount;

	public NegativeAmountException(double amount) {
		super();
		this.amount = amount;
	}
	
	public String getMessage() {
		return "Invalid Input! , Negative amount entered ";
	}

}
