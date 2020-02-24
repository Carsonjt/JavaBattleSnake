package io.battlesnake.starter;

import java.awt.Point;

public class Board {
	
	int turn;
	int height;
	int width;
	Point[] foodLocs;
	Snake[] snakes;

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
		return;
	}
	public void addSnake(Snake s) {
		return;
	}
}