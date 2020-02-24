package io.battlesnake.starter;

import java.awt.Point;

public class Board {
	
	int turn;
	int height;
	int width;
	Point[] foodLocs;
	Snake[] snakes;
	Snake self;

	public Board(int height, int width, int turn) {
		this.height = height;
		this.width = width;
		this.turn = turn;
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
	public Point[] getFoodLocs() {
		return foodLocs;
	}
	public Snake[] getSnakes() {
		return snakes;
	}
	public void addFoodLoc(Point p) {
		Point[] newFoodLocs = new Point[foodLocs.length + 1];
		for(int i = 0; i < foodLocs.length ; i++) {
			newFoodLocs[i] = foodLocs[i];
		}
		newFoodLocs[newFoodLocs.length - 1] = p;
		this.foodLocs = newFoodLocs;
		return;
	}
	public void addSnake(Snake s) {
	/*	if(snakes.length == 0) {
			snakes = new Snake[1];
			snakes[0] = s;
		} else {
			Snake[] newSnakes = new Snake[snakes.length + 1];
			for(int i = 0; i < snakes.length ; i++) {
				newSnakes[i] = snakes[i];
			}
			newSnakes[newSnakes.length - 1] = s;
			this.snakes = newSnakes;
		}*/
		return;
	}
	public void setSelf(Snake self) {
		this.self = self;
	}
}