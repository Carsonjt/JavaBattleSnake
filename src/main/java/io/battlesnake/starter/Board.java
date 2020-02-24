package io.battlesnake.starter;

import java.awt.Point;

public class Board {
	
	int turn;
	int height;
	int width;
	Point[] foodLoc;
	Snake[] snakes;
	Snake self;

	public Board(int height, int width, int turn) {
		this.height = height;
		this.width = width;
		this.turn = turn;
		snakes = new Snake[0];
		foodLoc = new Point[0];
	}
	public int getTurn() {
		return turn;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public Point[] getFoodLoc() {
		return foodLoc;
	}
	public Snake[] getSnakes() {
		return snakes;
	}
	public void addFoodLoc(Point p) {
		Point[] newFoodLoc = new Point[foodLoc.length + 1];
		if(newFoodLoc.length == 1)
			newFoodLoc[0] = p;
		else {
			for(int i = 0; i < foodLoc.length ; i++) {
				newFoodLoc[i] = foodLoc[i];
			}
			newFoodLoc[newFoodLoc.length - 1] = p;
		}
		this.foodLoc = newFoodLoc;
		return;
	}
	public void addSnake(Snake s) {
		Snake[] newSnakes = new Snake[snakes.length + 1];
		if(newSnakes.length == 1)
			newSnakes[0] = s;
		else {
			for(int i = 0; i < snakes.length ; i++) {
				newSnakes[i] = snakes[i];
			}
			newSnakes[newSnakes.length - 1] = s;
		}
		this.snakes = newSnakes;
		return;
	}
	public void setSelf(Snake self) {
		this.self = self;
	}
}