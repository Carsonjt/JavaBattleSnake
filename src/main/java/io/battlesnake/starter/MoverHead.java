package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverHead {
	
	public static String calcMove(Board b) {
		
		if(b.snakes[0].bodyLoc[0].getY() == 10) {
			if(b.snakes[0].bodyLoc[0].getX() == 10)
				return "up";
			return "right";
		if(b.snakes[0].bodyLoc[0].getX() == 10) {
			if(b.snakes[0].bodyLoc[0].getY() == 0)
				return "left";
			return "up";
		if(b.snakes[0].bodyLoc[0].getY() == 0) {
			if(b.snakes[0].bodyLoc[0].getX() == 0)
				return "down";
			return "left";
		if(b.snakes[0].bodyLoc[0].getY() == 10) {
			if(b.snakes[0].bodyLoc[0].getX() == 0)
				return "right";
			return "down";
			
	}
	
}