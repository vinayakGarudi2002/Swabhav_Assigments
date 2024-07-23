package com.aurionpro.model;

public class PigGame {
	
	private int turn;
	private int points; // goal(20)
	
	public PigGame() {
		turn=1;
		points=0;
	}
	
	public PigGame(int turn, int points) {
		this.turn = turn;
		this.points = points;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	
	public int rollDie()
	{
		int die=1 + (int)(Math.random() * 6);
		System.out.println("Die "+die);
		return updatePoints(die);
		
	}
	
	public void holdDie() {
		displayScore();
		updateTurn();
	}
	
	
	public int updatePoints(int die) {
		
		if(die==1) {
			points=0;
			displayScore();
			updateTurn();
			return points;
		}
		
		points+=die;
		return points;
	}
	
	public void displayScore() {
		
		System.out.println("Score for turn "+turn);
		System.out.println("Total Score: "+points);
		
	}
	
	private void updateTurn() {
		turn++;
		System.out.println("Turn: "+turn);
	}
	
	
	

}
