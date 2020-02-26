package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverUtil {
	
	public static boolean isValid(Board b, Point p) {
		if(p.getX() < 0) return false;
		if(p.getY() < 0) return false;
		if(p.getX() > b.getWidth()) return false;
		if(p.getY() > b.getHeight()) return false;
		if(b.self.isAt(p)) return false;
		
		for(Snake s: b.snakes) {
			if(s.isAt(p)) return false;
		}
		
		return true;
	}
	
	public static boolean isValid(Board b, int x, int y) {
		return isValid(b, new Point(x, y));
	}
	
	public static boolean isOnBorder(Board b, Point p) {
		if(p.getX() = 0) return true;
		if(p.getY() = 0) return true;
		if(p.getX() = b.getWidth()) return true;
		if(p.getY() = b.getHeight()) return true;
		return false;
	}
	
	public static boolean isOnCorner(Board b, Point p) {
		if(p.getX() = 0 && p.getY() == 0) return true;
		if(p.getX() = 0 && p.getY() == b.getHeight()) return true;
		if(p.getX() = b.getWidth() && p.getY() == 0) return true;
		if(p.getX() = b.getWidth() && p.getY() == b.getHeight()) return true;
	return false;
	}
	
	public Point getPoint(Board b, String s) {
		if(s.equals("left"))
			return new Point(b.self.getBodyLoc[0].getX() - 1, b.self.getBodyLoc[0].getY());
		if(s.equals("right"))
			return new Point(b.self.getBodyLoc[0].getX() + 1, b.self.getBodyLoc[0].getY());
		if(s.equals("up"))
			return new Point(b.self.getBodyLoc[0].getX(), b.self.getBodyLoc[0].getY() + 1);
		if(s.equals("down"))
			return new Point(b.self.getBodyLoc[0].getX(), b.self.getBodyLoc[0].getY() - 1);
	
}