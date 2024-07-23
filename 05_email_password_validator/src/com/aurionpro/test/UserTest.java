package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.exception.EmailNotValidException;
import com.aurionpro.exception.PasswordNotValidException;
import com.aurionpro.model.User;

public class UserTest {

	
	    public static void main(String[] args) {
	    	
	    	
	    	Scanner scanner = new Scanner(System.in);
	       
	    	User user = null;
	    	
	    	boolean status = false;
	    	
	    	System.out.println("|------Login-------|");
	    	
	    	while(!status) {
	    		
	    		 user=createUser(scanner);	  
	    		 if(user!=null)
	    			 status=true;
	    		 
	    		 System.out.println("");
	    		
	    		
	    	}
	    	
	    	System.out.println(user);

	    	System.out.println("User Succesfully Created");
	    	
	    }
	    
	    
	    
	    public static User createUser(Scanner scanner) {
	    	User user=null;
	    	
	    	System.out.println("Enter your Email: ");
    		String email = scanner.nextLine();
    		
    		System.out.println("Enter your password: ");
    		String password = scanner.nextLine();
    		
    		 try {
    			 user = new User(email,password);
    			
    		 }catch(EmailNotValidException e) {
    			 System.out.println(e.getMessage());
    		 }catch(PasswordNotValidException e) {
    			 System.out.println(e.getMessage());
    		 }catch(Exception e) {
    			 System.out.println(e.getMessage());
    		 }
	    	
			return user;
	    	
	    }

	   
	


}
