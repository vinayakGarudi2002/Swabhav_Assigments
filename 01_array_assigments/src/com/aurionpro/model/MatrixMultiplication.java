package com.aurionpro.model;

import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		
		  Scanner scanner = new Scanner(System.in);
		  
		  System.out.println("Read first matrix:");
	        int[][] matrix1 = readMatrix(scanner);

	        System.out.println("Read second matrix:");
	        int[][] matrix2 = readMatrix(scanner);

	        if (matrix1[0].length != matrix2.length) {
	            System.out.println("Matrices cannot be multiplied");
	            return;
	        }

	        int[][] result = multiplyMatrix(matrix1, matrix2);

	        printMatrix(result);
       
		

	}
	
	 private static int[][] readMatrix(Scanner scanner) {
	      

	        System.out.println("Enter how many rows? ");
	        int row = scanner.nextInt();

	        System.out.println("Enter how many columns? ");
	        int column = scanner.nextInt();

	        int[][] matrix = new int[row][column];

	        System.out.println("Enter Matrix Elements:");

	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < column; j++) {
	                System.out.print("Element [" + i + "][" + j + "]: ");
	                matrix[i][j] = scanner.nextInt();
	            }
	        }

	        System.out.println("Matrix is:");

	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < column; j++) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println();
	        }

	        return matrix;
	    }

	    private static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
	    	 int row1 = matrix1.length;
	         int col1 = matrix1[0].length;
	         int col2 = matrix2[0].length;

	         int[][] result = new int[row1][col2];

	         for (int i = 0; i < row1; i++) {
	             for (int j = 0; j < col2; j++) {
	                 result[i][j] = rowColumnMultiplication(matrix1, matrix2, i, j);
	             }
	         }

	         return result;
	    }
	    
	    private static int rowColumnMultiplication(int[][] matrix1, int[][] matrix2, int i, int j) {
	    	

		        int result = 0;

		        for (int k = 0; k < matrix1[0].length; k++) {
		            
		                result =result+ matrix1[i][k]*matrix2[k][j];
		            
		        }
	    	
	    	return result;
	    }

	    private static void printMatrix(int[][] matrix) {
	        int row = matrix.length;
	        int column = matrix[0].length;

	        System.out.println("Addition of Matrix is:");

	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < column; j++) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }


}
