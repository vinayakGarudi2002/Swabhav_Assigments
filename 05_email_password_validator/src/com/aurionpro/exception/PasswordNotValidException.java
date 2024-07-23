package com.aurionpro.exception;

public class PasswordNotValidException extends RuntimeException {
	
	public String getMessage() {
		return"Password not Valid";
	}

}
