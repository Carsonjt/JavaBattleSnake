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

		//if(b.self.bodyLoc[b.self.bodyLoc.length-1].equals(p)) return true;
		
		if(b.self.isAt(p)) return false;
		
		for(Snake s: b.snakes) {
			if(s.isAt(p)) return false;
		}
		
		return true;
	}
	
	public static boolean isValid(Board b, int x, int y) {
		return isValid(b, new Point(x, y));
	}
	
	public static Point getPoint(Board b, String s) {
		if(s.equals("left"))
			return new Point((int) b.self.bodyLoc[0].getX() - 1,(int) b.self.bodyLoc[0].getY());
		if(s.equals("right"))
			return new Point((int) b.self.bodyLoc[0].getX() + 1,(int) b.self.bodyLoc[0].getY());
		if(s.equals("up"))
			return new Point((int) b.self.bodyLoc[0].getX(), (int) b.self.bodyLoc[0].getY() - 1);
		//down
		return new Point((int) b.self.bodyLoc[0].getX(), (int) b.self.bodyLoc[0].getY() + 1);
	}
	
	public static boolean isTail(Board b, Point p) {
	
		for(Snake s: b.snakes) {
			if(s.bodyLoc[s.bodyLoc.length - 1].equals(p))
				return true;
		}
		return false;
	}
	
	public static Point getLeft(Board b, Point p) {
		return new Point((int) p.getX() - 1,(int) p.getY());
	}
	
	public static Point getRight(Board b, Point p) {
		return new Point((int) p.getX() + 1,(int) p.getY());
	}
	
	public static Point getUp(Board b, Point p) {
		return new Point((int) p.getX(), (int) p.getY() - 1);
	}
	
	public static Point getDown(Board b, Point p) {
		return new Point((int) p.getX(), (int) p.getY() + 1);
	}
	
	public static Point[] surroundingPoints(Board b, Point p) {
		Point[] points = new Point[4];
		points[0] = MoverUtil.getLeft(b, p);
		points[1] = MoverUtil.getRight(b, p);
		points[2] = MoverUtil.getUp(b, p);
		points[3] = MoverUtil.getDown(b, p);
		return points;
	}

	
}