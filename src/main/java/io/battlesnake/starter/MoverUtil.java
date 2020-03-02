package io.battlesnake.starter;

import java.lang.Math;
import io.battlesnake.starter.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverUtil {
	
	public static Point getPoint(Board b, String s) {
		Point p = new Point(b, (int) b.self.bodyLoc[0].x, (int) b.self.bodyLoc[0].y);
		if(s.equals("left"))
			return p.getLeft();
		if(s.equals("right"))
			return p.getRight();
		if(s.equals("up"))
			return p.getUp();
		//down
			return p.getDown();
	}
	
	public static boolean isTail(Board b, Point p) {
	
		for(Snake s: b.snakes) {
			if(s.bodyLoc[s.bodyLoc.length - 1].equals(p))
				return true;
		}
		return false;
	}

	public static int distanceBetween(Board b, Point p1, Point p2) {
		int xDist = Math.abs(p1.x - p2.x);
		int yDist = Math.abs(p1.y - p2.y);
		return xDist + yDist;
	}
	
}