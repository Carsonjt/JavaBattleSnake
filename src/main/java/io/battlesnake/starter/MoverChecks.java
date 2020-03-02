package io.battlesnake.starter;

import io.battlesnake.starter.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;
import java.util.ArrayList;

public class MoverChecks {

	public static int avoidBorder(Point p) {
		if(p.isOnBorder())
			return 1;
		return 0;
	}

	public static int isOnCorner(Point p) {
		if(p.isOnCorner())
			return 3;
		return 0;
	}

	static ArrayList<Point> tiles = new ArrayList<Point>();
	public static int adjacentSpace(Point p) {
		tiles = new ArrayList<Point>();
		adjacentSpaceHelper(p);
		
		if(tiles.size() >= p.b.self.bodyLoc.length / 2)
			return 0;
		else	
			return ((p.b.self.bodyLoc.length / 2) - tiles.size()) * 2 + 5;
	}
	
	public static void adjacentSpaceHelper(Point p) {

		if(tiles.size() >= p.b.self.bodyLoc.length / 2)
			return;

		if((p.getLeft().isValid()) && !tiles.contains(p.getLeft())) {
			tiles.add(p.getLeft());
			adjacentSpaceHelper(p.getLeft());
		}
		if((p.getRight().isValid()) && !tiles.contains(p.getRight())) {
			tiles.add(p.getRight());
			adjacentSpaceHelper(p.getRight());
		}
		if((p.getUp().isValid()) && !tiles.contains(p.getUp())) {
			tiles.add(p.getUp());
			adjacentSpaceHelper(p.getUp());
		}
		if((p.getDown().isValid()) && !tiles.contains(p.getDown())) {
			tiles.add(p.getDown());
			adjacentSpaceHelper(p.getDown());
		}
		return;
	}

	public static int avoidHeadOnCollision(Point p) {
		//CHECK DIRECT COLLISIONS
		for(Snake snake: p.b.snakes) {
			if(snake.bodyLoc.length >= p.b.self.bodyLoc.length) {
				for(Point surrounding: p.getSurrounding()) {
					if(snake.bodyLoc[0].equals(surrounding))
						return 10;
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

	public static int nearbyFood(Point p) {
		//DIRECT CHECK
		for(Point food: p.b.foodLoc) {
			if(p.equals(food)) {
				//if(avoidBorder(b, food) == 3)
				//	return 0;
				return -2;
			}
		}
		if(p.b.self.health < 15) {
			for(Point surrounding: p.getSurrounding()) {
			
				if(surrounding.isValid()) {
					for(Point food: p.b.foodLoc) {
						if(surrounding.equals(food)) {
							return -2;
						}
					}
				}
			}	
		}
		return 0;
	}
	

}
