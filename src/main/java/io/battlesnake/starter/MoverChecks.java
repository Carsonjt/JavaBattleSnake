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

	public static int avoidCorner(Point p) {
		if(p.isOnCorner())
			return 3;
		return 0;
	}

	static ArrayList<String> tiles = new ArrayList<String>();
	static boolean willOpen;
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
	
/*	public static int isTrap(Board b, Point p) {
		tiles.clear();
		willOpen = true;
		isTrapHelper(p);
		if(willOpen)
			return 2;
		
		if(tiles.size() >= b.self.bodyLoc.length)
			return 0;
		else	
			return ((b.self.bodyLoc.length) - tiles.size()) + 5;
	}
	
	public static void isTrapHelper(Point p) {

		if(tiles.size() >= p.b.self.bodyLoc.length)
			return;
		
		for(Point surrounding: p.getSurrounding()) {
			if(!tiles.contains(surrounding.x + "|" + surrounding.y) {
				if(surrounding.isValid()) {
					tiles.add(surrounding.x + "|" + surrounding.y);
					possibleTrapsHelper(surrounding);
				} else {
					//IF IS A SNAKE, IF DISTANCE FROM IS GREATER THAN DISTANCE FROM TAIL (SNAKE LENGTH - INDEX)
					if(!surrounding.isInMap())
						continue;
					
					Snake snake = MoverUtil.getSnakeOn(surrounding);
					
					
					if(MoverUtil.distanceBetween(b.p, p.b.self.head, surrounding) > DISTANCE FROM TAIL (SNAKE LENGTH - INDEX) {
						tiles.add(surrounding.x + "|" + surrounding.y);
						possibleTrapsHelper(surrounding);
					}
				}
			}
		}
		return;
	}*/

	static ArrayList<String> tiles2 = new ArrayList<String>();
	public static int possibleTraps(Board b, Point p) {
		tiles2.clear();
		possibleTrapsHelper(p);
		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return 0;
		else	
			return ((b.self.bodyLoc.length / 2) - tiles2.size()) * 2 + 3;
	}
	
	public static void possibleTrapsHelper(Point p) {

		if(tiles2.size() >= p.b.self.bodyLoc.length / 2)
			return;
		boolean isNext = false;
		for(Point surrounding: p.getSurrounding()) {
			if((surrounding.isValid()) && !tiles2.contains(surrounding.x + "|" + surrounding.y)) {
				for(Snake s: p.b.snakes) {
					for(Point other1: s.head.getSurrounding()) {
						if(other1.equals(p))
							isNext = true;
					}
				}
				if(!isNext) {
					tiles2.add(surrounding.x + "|" + surrounding.y);
					possibleTrapsHelper(surrounding);
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
					//System.out.println("SURROUNDING POINTS: " + points);
					
					boolean isInvalid = true;
					for(Point self: p.getSurrounding()) {
						if(self.isValid()) {
							if(!points.contains(self.x + "|" + self.y))
								// TODO: MAKE SURE THERE IS ROOM
								isInvalid = false;
						}
					}
					if(isInvalid)
						return 5;
				}
			}
		}
		return 0;
	}

	public static int nearbyFood(Point p) {
		//RAD 1
		for(Point food: p.b.foodLoc) {
			if(p.equals(food)) {
				for(Point aroundFood: food.getSurrounding()) {
					for(Snake snakes: p.b.snakes) {
						if(snakes.head.equals(aroundFood))
							return 1;
					}
				}
				
				if(p.b.self.length <= 8 && p.b.self.health < 30) {
						return -2;
				else if(p.isOnBorder())
					return 0;
				}
			}
		}
		
		//RAD 2
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
		//RAD 3
		if(p.b.self.health < 8) {
			for(Point surrounding1: p.getSurrounding()) {
				if(surrounding1.isValid()) {
					for(Point surrounding2: surrounding1.getSurrounding()) {		
						if(surrounding2.isValid()) {
							for(Point food: p.b.foodLoc) {
								if(surrounding2.equals(food)) {
									return -2;
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}
	static ArrayList<String> tiles3 = new ArrayList<String>();
	public static int nonBorderSpace(Board b, Point p) {
		tiles3.clear();
		nonBorderSpaceHelper(p);
		System.out.println(tiles3);
		if(tiles3.size() >= b.self.bodyLoc.length / 2) {
			return 0;
		} else {
			return ((b.self.bodyLoc.length - tiles3.size()) / 4);
		}
	}
	
	public static void nonBorderSpaceHelper(Point p) {

		if(tiles3.size() >= p.b.self.bodyLoc.length / 2)
			return;

		if((p.getLeft().isValid()) && !tiles3.contains(p.getLeft().x + "|" + p.getLeft().y) && !p.getLeft().isOnBorder()) {
			tiles3.add(p.getLeft().x + "|" + p.getLeft().y);
			nonBorderSpaceHelper(p.getLeft());
		}
		if((p.getRight().isValid()) && !tiles3.contains(p.getRight().x + "|" + p.getRight().y) && !p.getRight().isOnBorder()) {
			tiles3.add(p.getRight().x + "|" + p.getRight().y);
			nonBorderSpaceHelper(p.getRight());
		}
		if((p.getUp().isValid()) && !tiles3.contains(p.getUp().x + "|" + p.getUp().y) && !p.getUp().isOnBorder()) {
			tiles3.add(p.getUp().x + "|" + p.getUp().y);
			nonBorderSpaceHelper(p.getUp());
		}
		if((p.getDown().isValid()) && !tiles3.contains(p.getDown().x + "|" + p.getDown().y) && !p.getDown().isOnBorder()) {
			tiles3.add(p.getDown().x + "|" + p.getDown().y);
			nonBorderSpaceHelper(p.getDown());
		}
		return;
	}
	//TODO
	public static int canBorderKill(Board b) {
		if(b.snakes.length <= 4) {
			for(Snake snake: b.snakes) {
				String direction = "none";
				if(snake.head.isOnBorder()) {
					
					if(snake.head.x == 0 || snake.head.x == b.width) {
					
					}
				}
			}	
		}
		return 0;
	}

}
