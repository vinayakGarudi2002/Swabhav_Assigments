package com.aurionpro.model;

import java.util.Scanner;

public class SortedSquareProblem {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter size of array: ");
		int size = scanner.nextInt();
		
		int array[] = new int[size];
		
	    getArrayInputSortedOrder(array,size,scanner);
		
		squareSortedArray(array);
		
		System.out.println("Sqared Sorted Array: ");
		
		diaplayArray(array);


	}

	
    private static void diaplayArray(int[] array) {
	
    	for(int i=0;i<array.length;i++) {
			System.out.println("Element "+(i+1)+": "+array[i]);
			
		}
    	
	}


	private static void getArrayInputSortedOrder(int[] array, int size,Scanner scanner) {
    	System.out.println("Enter Values of Array in Sorted Order: ");
		for(int i=0;i<size;i++) {
			System.out.println("Enter Element "+(i+1)+": ");
			array[i]=scanner.nextInt();
		}
		
	}


	public static void squareSortedArray(int[] arr) {
		
		 //squaring every element of array
    	for(int i=0;i<arr.length;i++) {
    		arr[i]=arr[i]*arr[i];
    	}
    	
    	//intilizing array to store final sorted array
    	int array[]=new int[arr.length];
    	
    	int left=0;
    	
    	// dividing array in two parts descending and ascending
    	
    	//it check if descending array exists 
    	if(arr.length>1 && arr[0]>arr[1]) {
    		while(left<arr.length-1) {
    			if(arr[left]>=arr[left+1]) {
    				left++;
    			}else {
    				break;
    			}
    		}
    	}
    	
    	// right is starting counter of ascending order (second array)
    	int right=left;
    	
    	//left is starting counter of descending order ( first array)
    	left=left-1;
    	
    	int k=0;
    	
    	// logic of merging two sorted array 
    	while(right<arr.length && left>=0) {
    		
    		if(arr[left]<arr[right]) {
    			array[k]=arr[left];
    			left--;
    		}else if(arr[left]>arr[right]) {
    			array[k]=arr[right];
    			right++;
    		}else {
    			array[k]=arr[left];
    			left--;
    			right++;
    		}
    		
    		k++;
    	}
    	
    	while(right<arr.length) {
    		array[k]=arr[right];
			right++;
			k++;
    	}
    	
    	while(left>=0) {
    		array[k]=arr[left];
			left--;
			k++;
    	}
    	
    	
    	//copying result to back original array;
    	for(int i=0;i<arr.length;i++) {
    		arr[i]=array[i];
    	}
		
		
	}


}
