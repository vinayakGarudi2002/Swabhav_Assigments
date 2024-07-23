package com.aurionpro.exception;

public class CurrentAccountException extends AccountException {

	public CurrentAccountException(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return "Amount need to be: "+amount+" to avail OverDraft Facility";
		
	}
	public String getLeastLimitMessage() {
		return "Amount need to be atleast: "+amount;
	}
	
	public String getMaxLimitMessage() {
		return "Amount can  be atMax: "+amount;
	}

}
