package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverHead {
	
	public static String calcMove(Board b) {
		
		if(b.height == b.snakes[0].bodyLoc[0].getY())
			return "right";
		return "down";
			
	}
	
}