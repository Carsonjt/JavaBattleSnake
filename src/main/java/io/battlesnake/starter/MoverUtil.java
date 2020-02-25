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
	
	
	
}