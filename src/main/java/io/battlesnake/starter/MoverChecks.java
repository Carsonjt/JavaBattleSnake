package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;
import java.util.ArrayList;

public class MoverChecks {

	public static int isOnBorder(Board b, Point p) {
		if(p.getX() == 0) return 1;
		if(p.getY() == 0) return 1;
		if(p.getX() == b.getWidth()) return 1;
		if(p.getY() == b.getHeight()) return 1;
		return 0;
	}
	
	public static int isOnCorner(Board b, Point p) {
		if((p.getX() == 0) && (p.getY() == 0)) return 3;
		if((p.getX() == 0) && (p.getY() == b.getHeight())) return 3;
		if((p.getX() == b.getWidth()) && (p.getY() == 0)) return 3;
		if((p.getX() == b.getWidth()) && (p.getY() == b.getHeight())) return 3;
		return 0;
	}

	static ArrayList<Point> tiles = new ArrayList<Point>();
	
	public static int adjacentSpace(Board b, Point p) {
		tiles = new ArrayList<Point>();
		adjacentSpaceHelper(b, p);
		
		System.out.println(tiles);
		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return 0;
		else
			return ((b.self.bodyLoc.length / 2) - tiles.size()) * 2 + 3;
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
		
		for(Snake snake: b.snakes) {
			if(snake.bodyLoc.length >= b.self.bodyLoc.length) {
				if(snake.bodyLoc[0].equals(MoverUtil.getRight(b, p)))
					return 10;
				if(snake.bodyLoc[0].equals(MoverUtil.getDown(b, p)))
					return 10;
				if(snake.bodyLoc[0].equals(MoverUtil.getLeft(b, p)))
					return 10;
				if(snake.bodyLoc[0].equals(MoverUtil.getUp(b, p)))
					return 10;
			}
		}
		return 0;
	}

	public static int nearbyFood(Board b, Point p) {
		//DIRECT CHECK
		for(Point food: b.foodLoc) {
			if(p.equals(food))
				return -1;
		}
		Point left = MoverUtil.getLeft(b, p);
		Point right = MoverUtil.getRight(b, p);
		Point up = MoverUtil.getUp(b, p);
		Point down = MoverUtil.getDown(b, p);

		//RADIUS CHECK 1
		if(MoverUtil.isValid(b, left)) {
			for(Point food: b.foodLoc) {
				if(left.equals(food))
					return -1;
			}
//			return nearbyFood(b, left);
		}
			
		if(MoverUtil.isValid(b, right)) {
			for(Point food: b.foodLoc) {
				if(right.equals(food))
					return -1;
			}
//			return nearbyFood(b, right);
		}
			
		if(MoverUtil.isValid(b, up)) {
			for(Point food: b.foodLoc) {
				if(up.equals(food))
					return -1;
			}
//			return nearbyFood(b, up);
		}
	
		if(MoverUtil.isValid(b, down)) {
			for(Point food: b.foodLoc) {
				if(down.equals(food))
					return -1;
			}
//			return nearbyFood(b, down);
		}

		

		return 0;
	}

}
