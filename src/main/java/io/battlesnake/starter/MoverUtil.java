package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverUtil {
	
	static Board board = MoverHead.board;
	
	public static boolean isValid(Point p) {
		if(p.getX() < 0) return false;
		if(p.getY() < 0) return false;
		if(p.getX() > board.getWidth()) return false;
		if(p.getY() > board.getHeight()) return false;
		
		for(Snake s: MoverHead.board.snakes) {
			if(s.isAt(p)) return false;
		}
		if(board.self.isAt(p)) return false;
		return true;
	}
	
	public static boolean isValid(int x, int y) {
		return isValid(new Point(x, y));
	}
	
	
	
}