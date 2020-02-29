package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;
import java.util.ArrayList;

public class MoverChecks {

	public static int isOnBorder(Board b, Point p) {
		if(p.getX() == 0) return 3;
		if(p.getY() == 0) return 3;
		if(p.getX() == b.getWidth()) return 3;
		if(p.getY() == b.getHeight()) return 3;
		return 0;
	}

	public static int isNextToBorder(Board b, Point p) {
		if(p.getX() == 1) return 1;
		if(p.getY() == 1) return 1;
		if(p.getX() == b.getWidth() - 1) return 1;
		if(p.getY() == b.getHeight() - 1) return 1;
		return 0;
	}

	public static int isOnCorner(Board b, Point p) {
		if((p.getX() == 0) && (p.getY() == 0)) return 4;
		if((p.getX() == 0) && (p.getY() == b.getHeight())) return 4;
		if((p.getX() == b.getWidth()) && (p.getY() == 0)) return 4;
		if((p.getX() == b.getWidth()) && (p.getY() == b.getHeight())) return 4;
		return 0;
	}

	static ArrayList<Point> tiles = new ArrayList<Point>();
	
	public static int adjacentSpace(Board b, Point p) {
		tiles = new ArrayList<Point>();
		adjacentSpaceHelper(b, p);
		
		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return 0;
		else	
			return ((b.self.bodyLoc.length / 2) - tiles.size()) * 2 + 5;
	}
	
	public static void adjacentSpaceHelper(Board b, Point p) {

		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return;

		Point left = MoverUtil.getLeft(b, p);
		Point right = MoverUtil.getRight(b, p);
		Point up = MoverUtil.getUp(b, p);
		Point down = MoverUtil.getDown(b, p);
			
		if(MoverUtil.isValid(b, left) && !tiles.contains(left)) {
			tiles.add(left);
			adjacentSpaceHelper(b, left);
		}
		if(MoverUtil.isValid(b, right) && !tiles.contains(right)) {
			tiles.add(right);
			adjacentSpaceHelper(b, right);
		}
		if(MoverUtil.isValid(b, up) && !tiles.contains(up)) {
			tiles.add(up);
			adjacentSpaceHelper(b, up);
		}
		if(MoverUtil.isValid(b, down) && !tiles.contains(down)) {
			tiles.add(down);
			adjacentSpaceHelper(b, down);
		}
		return;
	}

	public static int avoidHeadOnCollision(Board b, Point p) {
		//CHECK DIRECT COLLISIONS
		for(Snake snake: b.snakes) {
			if(snake.bodyLoc.length >= b.self.bodyLoc.length) {
				for(Point surrounding: MoverUtil.surroundingPoints(b, p)) {
					if(snake.bodyLoc[0].equals(surrounding))
						return 20;
				}
			}
		}
		//CHECK FUTURE FORCED COLLISIONS
	/*	ArrayList<Point> otherMoves = new ArrayList<Point>();

		boolean isSafe = true;
		for(Snake snake: b.snakes) {
			for(Point other1: MoverUtil.surroundingPoints(b, snake.bodyLoc[0])) {
				if(MoverUtil.isValid(b, other1)) {
					otherMoves.clear();
					for(Point other2: MoverUtil.surroundingPoints(b, other1)) {
						if(MoverUtil.isValid(b, other2))
							otherMoves.add(other2);
					}
					
					//DOESNT HAVE SPACE OR FORCED HEAD ON (CONTAINS OTHERMOVES)
					boolean hasSafeMove = false;
					for(Point self: MoverUtil.surroundingPoints(b, p)) {
						if(MoverUtil.isValid(b, self)) {
							if(!otherMoves.contains(self)) // ADD CHECK IF HAS ENOUGH SPACE TOO
								hasSafeMove = true;
						}
					}
					
					if(!hasSafeMove) {
						isSafe = false;
					}
				}
			}
			
			
		}
		if(!isSafe)
			return 5;
	*/	
		return 0;
	}

	public static int nearbyFood(Board b, Point p) {
		//DIRECT CHECK
		for(Point food: b.foodLoc) {
			if(p.equals(food))
				return -2;
		}
		for(Point surrounding: MoverUtil.surroundingPoints(b, p)) {
			
			if(MoverUtil.isValid(b, surrounding)) {
				for(Point food: b.foodLoc) {
					if(surrounding.equals(food)) {
							return -2;
					}
				}
			}
		}
		return 0;
	}
	

}
