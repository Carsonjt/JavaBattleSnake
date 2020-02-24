package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverHead {
	
	public static String calcMove(Board b) {
		
			/*if(b.getTurn() % 4 == 0)
				return "right";
			else if(b.getTurn() % 4 == 1)
				return "up";
			else if(b.getTurn() % 4 == 2)
				return "left";
			else
				return "down";*/
			
			//if(b.height == b.self.head.getY())
			//	return "right";
			
			return "right";
			
	}
	
}