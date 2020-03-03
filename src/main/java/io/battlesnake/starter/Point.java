package io.battlesnake.starter;

import io.battlesnake.starter.PointInterface;

public class Point implements PointInterface {
	int x;
	int y;
	Board b;
	
	public Point(Board b, int x, int y) {
		this.b = b;
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean equals(Point p) {
		return ((x == p.x) && (y == p.y));
	}
	
	public boolean isValid() {
		if(x < 0) return false;
		if(y < 0) return false;
		if(x > b.width) return false;
		if(y > b.height) return false;

		Point p = new Point(b, x, y);
		if(b.self.isAt(p)) return false;
		
		for(Snake s: b.snakes) {
			if(s.isAt(p)) return false;
		}
		return true;
	}
	
	public boolean isOnBorder() {
		if(x == 0) return true;
		if(y == 0) return true;
		if(x == b.width) return true;
		if(y == b.height) return true;
		
		return false;
	}
	
	public boolean isOnCorner() {
		if((x == 0) && (y == 0)) return true;
		if((x == 0) && (y == b.height)) return true;
		if((x == b.width) && (y == 0)) return true;
		if((x == b.width) && (y == b.height)) return true;
		return false;
	}
	
	public Point getLeft() {
		return new Point(b, x-1, y);
	}
	public Point getRight() {
		return new Point(b, x+1, y);
	}
	public Point getUp() {
		return new Point(b, x, y-1);
	}
	public Point getDown() {
		return new Point(b, x, y+1);
	}
	
	public Point[] getSurrounding() {
		Point[] points = new Point[4];
		Point p = new Point(b, x, y);
		points[0] = p.getLeft();
		points[1] = p.getRight();
		points[2] = p.getUp();
		points[3] = p.getDown();
		return points;
	}
}
