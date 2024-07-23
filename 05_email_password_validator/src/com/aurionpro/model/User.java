package com.aurionpro.model;

import com.aurionpro.exception.EmailNotValidException;
import com.aurionpro.exception.PasswordNotValidException;

public class User {
	
	private String email;
	private String password;
	
	public User(String email, String password) {
		if(!emailValidator(email))
			throw new EmailNotValidException();
		this.email = email;
		
		if(!validatePassword(password))
			throw new PasswordNotValidException();
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(!emailValidator(email))
			throw new EmailNotValidException();
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(!validatePassword(password))
			throw new PasswordNotValidException();
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	private static boolean emailValidator(String email) {
	
		String validContent = "1234567890@.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!#$%&'*+-/=?^_`{|}~";
		
		if(email.contains(" ")) {
			return false;
			
		}
		
		int index_a=email.indexOf('@');
		if(index_a==0 || index_a==-1 || email.indexOf('@',(index_a+1))!=-1){
			return false;
		}
		
		int dotIndex=email.lastIndexOf('.');
		
		if(dotIndex==-1 || dotIndex==email.length()-1 || dotIndex==index_a+1) {
			return false;
		}
		
		for(char ch: email.toCharArray()) {
			if(validContent.indexOf(ch)==-1) {
				return false;
			}
		}
		
		String domainString=email.substring(dotIndex+1);
		
		if(domainString.length()<2) {
			return false;
		}
		
		
		return true;
		
	}
	
	
	public static boolean validatePassword(String password) {
		
		if(password.contains(" ")) {
			return false;
		}
		
		if(password.length()<8) {
			return false;
		}
		
		String character="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean charFlag=false;
		
		String digit="1234567890";
		boolean digitFlag=false;
		
		String specialCharacters = "!@#$%^&*()-_+=<>?{}[]|/.,:;\"'\\";

		boolean specialCharFlag=false;
		
		for(char ch:password.toCharArray()) {
			if(!charFlag) {
				if(character.indexOf(ch)!=-1) {
					charFlag=true;
				}
			}
			
			if(!digitFlag) {
				if(digit.indexOf(ch)!=-1) {
					digitFlag=true;
				}
			}
			
			if(!specialCharFlag) {
				if(specialCharacters.indexOf(ch)!=-1) {
					specialCharFlag=true;
				}
			}
			
			if((charFlag&&digitFlag)&&specialCharFlag) {
				return true;
			}
			
			
		}
		
		return false;
	}
	
	

	
	
}
