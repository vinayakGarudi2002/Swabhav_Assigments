package com.aurionpro.model;

import java.util.Scanner;

public class SecondLargestOfArray {

	public static void main(String[] args) {
		
		  Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter size of array: ");
			int size = scanner.nextInt();
			
			int array[] = new int[size];
			
			arrayInput(array,scanner);
			
			int result =secondLargestNumber(array);
			
			System.out.println("Second Largest Number of Array is: "+result);
			

	}
	
	  private static int secondLargestNumber(int[] array) {
		
		  if(array.length<2) {
			  return -1;
		  }
		  
		  int maxElement=array[0];
		  int secondLargestElement=Integer.MIN_VALUE;
		  
		  for(int number:array) {
			  if(number>maxElement) {
				  secondLargestElement=maxElement;
				  maxElement=number;
				  continue;
			  }
			  
			  if(number>secondLargestElement && number!=maxElement) {
				  secondLargestElement=number;
			  }
		  }
		  
		return secondLargestElement;
	}


	private static void arrayInput(int[] array, Scanner scanner) {
	    	System.out.println("Enter Values of Array: ");
			for(int i=0;i<array.length;i++) {
				System.out.println("Enter Element "+(i+1)+": ");
				array[i]=scanner.nextInt();
			}	
	}

	
	

}
