package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.PigGame;

public class PigGameTest1 {

	public static void main(String[] args) {
		
		PigGame pigGame = new PigGame();
		
		Scanner scanner = new Scanner(System.in);
		
		boolean exitStatus=winingStatus(0);
		System.out.println("Turn: "+pigGame.getTurn());
		
		while(!exitStatus) {
			exitStatus=play(pigGame,scanner);
		}
		pigGame.displayScore();
		System.out.println("You won! in "+pigGame.getTurn()+" turns");
		

	}

	private static boolean play(PigGame pigGame,Scanner scanner) {
		
		System.out.println("Do you want to Roll or hold? (r/h): ");
		char ch = scanner.next().charAt(0);
		
		int points=choiceDie(ch,pigGame);

		return winingStatus(points);
	}

	private static int choiceDie(char ch,PigGame pigGame) {
		
		int points=0;
		switch (ch) {
	    case 'r':
	        points = pigGame.rollDie();
	        break;
	    case 'h':
	        pigGame.holdDie();
	        break;
	    default:
	        System.out.println("Enter valid Input");
	        break;
	}
		return points;
		
	}

	private static boolean winingStatus(int points) {
			return points>20;
	}


}
