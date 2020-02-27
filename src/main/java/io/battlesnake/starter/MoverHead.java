package io.battlesnake.starter;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverHead {
	static HashMap<String, Integer> moveValues;
	
	
	public static String calcMove(Board b) {
		//FIND POSSIBLE MOVES (NO INSTA DEATH)
		ArrayList<String> openMoves = calcPossibleMoves(b);
		
		//IF NO POSSIBLE MOVES, ACCEPT DEFEAT :(
		if(openMoves.size() == 0)
			return "up";
		
		//PUT POSSIBLE MOVES INTO DANGER VALUE HASH MAP
		moveValues = new HashMap<String, Integer>();
		for(int i = 0; i < openMoves.size(); i++) {
			moveValues.put(openMoves.get(i), 0);
		}
		
		// CALC DANGER VALUES OF EACH POSSIBLE MOVE
		calcDangerValues(b);
		
		// FIND LEAST DANGEROUS MOVE
		int smallest = 999;
		String returnDirection = "default";
		for (Map.Entry<String, Integer> entry : moveValues.entrySet()) {
			// IF SMALLER UPDATE SMALLEST
			if(entry.getValue() < smallest) {
				smallest = entry.getValue();
				returnDirection = entry.getKey();
			}
			// IF EQUAL PICK RANDOM ONE
			if(entry.getValue() == smallest) {
				Random random = new Random();
				int rand = random.nextInt(2);
				if(rand == 0) {
					smallest = entry.getValue();
					returnDirection = entry.getKey();
				}
			}
		}
		// RETURN LEAST DANGEROUS
		System.out.println(moveValues);
		return returnDirection;
	}
	
	public static ArrayList<String> calcPossibleMoves(Board b) {
		// REMOVE SPACES THAT WILL DIRECTLY KILL IT (HAS A SNAKE/IS BORDER)
		ArrayList<String> moves = new ArrayList<String>();
		
		Point left = new Point((int) b.self.bodyLoc[0].getX() - 1, (int) b.self.bodyLoc[0].getY());
		if(MoverUtil.isValid(b, left)) moves.add("left");

		Point right = new Point((int) b.self.bodyLoc[0].getX() + 1, (int) b.self.bodyLoc[0].getY());
		if(MoverUtil.isValid(b, right)) moves.add("right");
		
		Point up = new Point((int) b.self.bodyLoc[0].getX(), (int) b.self.bodyLoc[0].getY() - 1);
		if(MoverUtil.isValid(b, up)) moves.add("up");
		
		Point down = new Point((int) b.self.bodyLoc[0].getX(), (int) b.self.bodyLoc[0].getY() + 1);
		if(MoverUtil.isValid(b, down)) moves.add("down");
		
		return moves;
	}
	
	public static void calcDangerValues(Board b) {
		// LOOP FOR EACH AVAILABLE MOVE
		for (Map.Entry<String, Integer> entry : moveValues.entrySet()) {
			String direction = entry.getKey();
            Point dPoint = MoverUtil.getPoint(b, direction); 
			//
			// ADD ALL DANGER CHECKS HERE
			//
			
			//IS BORDER SQUARE
			if(MoverUtil.isOnBorder(b, dPoint))
				moveValues.add(direction, moveValues.get(direction) + 1);
			//IS CORNER SQUARE
			if(MoverUtil.isOnCorner(b, dPoint))
				moveValues.add(direction, moveValues.get(direction) + 3);
			//HAS ENOUGH SPACE
			moveValues.replace
			
		 }
	}
	
}