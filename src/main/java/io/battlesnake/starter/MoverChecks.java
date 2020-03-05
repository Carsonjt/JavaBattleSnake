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

	static ArrayList<String> tiles = new ArrayList<String>();
	public static int adjacentSpace(Board b, Point p) {
		tiles.clear();
		adjacentSpaceHelper(p);
		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return 0;
		else	
			return ((b.self.bodyLoc.length / 2) - tiles.size()) * 2 + 5;
	}
	
	public static void adjacentSpaceHelper(Point p) {

		if(tiles.size() >= p.b.self.bodyLoc.length / 2)
			return;

		if((p.getLeft().isValid()) && !tiles.contains(p.getLeft().x + "|" + p.getLeft().y)) {
			tiles.add(p.getLeft().x + "|" + p.getLeft().y);
			adjacentSpaceHelper(p.getLeft());
		}
		if((p.getRight().isValid()) && !tiles.contains(p.getRight().x + "|" + p.getRight().y)) {
			tiles.add(p.getRight().x + "|" + p.getRight().y);
			adjacentSpaceHelper(p.getRight());
		}
		if((p.getUp().isValid()) && !tiles.contains(p.getUp().x + "|" + p.getUp().y)) {
			tiles.add(p.getUp().x + "|" + p.getUp().y);
			adjacentSpaceHelper(p.getUp());
		}
		if((p.getDown().isValid()) && !tiles.contains(p.getDown().x + "|" + p.getDown().y)) {
			tiles.add(p.getDown().x + "|" + p.getDown().y);
			adjacentSpaceHelper(p.getDown());
		}
		return;
	}
	
	
	
	static ArrayList<String> tiles2 = new ArrayList<String>();
	public static int possibleAdjacentSpace(Board b, Point p) {
		tiles2.clear();
		possibleAdjacentSpaceHelper(p);
		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return 0;
		else	
			return ((b.self.bodyLoc.length / 2) - tiles2.size()) * 2 + 3;
	}
	
	public static void possibleAdjacentSpaceHelper(Point p) {

		if(tiles2.size() >= p.b.self.bodyLoc.length / 2)
			return;
		boolean isNext = false;
		for(Point surrounding: p.getSurrounding()) {
			if((surrounding.isValid()) && !tiles2.contains(surrounding.x + "|" + surrounding.y)) {
				for(Snake s: p.b.snakes) {
					isNext = false;
					for(Point other1: s.head.getSurrounding()) {
						if(other1.equals(surrounding))
							isNext = true;
					}
				}
				if(!isNext) {
					tiles2.add(surrounding.x + "|" + surrounding.y);
					possibleAdjacentSpaceHelper(surrounding);
				}
			}
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
		return 0;
	}
	
	public static int avoidForcedHeadOnCollisions(Point p) {
		ArrayList<String> points = new ArrayList<String>();
		for(Snake snake: p.b.snakes) {
			if(snake.length >= p.b.self.length) {
				//SNAKE POSSIBLE MOVES
				for(Point snake1: snake.bodyLoc[0].getSurrounding()) {
					points.clear();
					// ADD SURROUNDING POSSIBLE MOVES
					for(Point snake2: snake1.getSurrounding()) {
						points.add(snake2.x + "|" + snake2.y);
					}
					System.out.println("SURROUNDING POINTS: " + points);
					
					boolean isInvalid = true;
					for(Point self: p.getSurrounding()) {
						if(self.isValid()) {
							if(!points.contains(self.x + "|" + self.y))
								// TODO: MAKE SURE THERE IS ROOM
								isInvalid = false;
						}
					}
					if(isInvalid)
						return -5;
				}
			}
		}
		return 0;
	}

	public static int nearbyFood(Point p) {
		//DIRECT CHECK
		for(Point food: p.b.foodLoc) {
			if(p.equals(food)) {
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
