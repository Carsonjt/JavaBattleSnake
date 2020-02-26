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
		
		// RETURN LEAST DANGEROUS MOVE
		// IF MULTIPLE:
		//    -> MOVE CLOSEST TO MIDDLE
		//    IF MULTIPLE STILL:
		//      -> PICK RANDOM
		for (Map.Entry<String, Integer> entry : moveValues.entrySet()) {

			String direction = entry.getKey();
            Point dPoint = MoverUtil.getPoint(b, direction); 
			
			if(MoverUtil.isOnBorder(b, dPoint))
				moveValues.replace(direction, 1);
			if(MoverUtil.isOnCorner(b, dPoint))
				moveValues.replace(direction, 3);
		 }
		
		Random random = new Random();
		int index = random.nextInt(openMoves.size());
		System.out.println(moveValues);
		return openMoves.get(index);
	}
	
	public static ArrayList<String> calcPossibleMoves(Board b) {
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
		//RUN MANY CHECKS TO CALC DANGER OF EACH MOVE
	}
	
}