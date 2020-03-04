package io.battlesnake.starter;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import io.battlesnake.starter.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;
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
		
		Point left = b.self.head.getLeft();
		if(left.isValid())
			moves.add("left");

		Point right = b.self.head.getRight();
		if(right.isValid())
			moves.add("right");
		
		Point up = b.self.head.getUp();
		if(up.isValid())
			moves.add("up");
		
		Point down = b.self.head.getDown();
		if(down.isValid())
			moves.add("down");
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
			
			//CONTAINS FOOD (POSITIVE CHECK)
			//System.out.println("FOOD: " + direction + " " + MoverChecks.nearbyFood(dPoint));
			moveValues.replace(direction, moveValues.get(direction) + MoverChecks.nearbyFood(dPoint));
			//IS BORDER SQUARE
			//System.out.println("BORDER: " + direction + " " + MoverChecks.avoidBorder(dPoint));
			moveValues.replace(direction, moveValues.get(direction) + MoverChecks.avoidBorder(dPoint));
			//IS NEXT TO BORDER SQUARE
			//IS CORNER SQUARE
			//System.out.println("CORNER: " + direction + " " + MoverChecks.isOnCorner(dPoint));
			moveValues.replace(direction, moveValues.get(direction) + MoverChecks.isOnCorner(dPoint));
			//HAS ENOUGH SPACE
			moveValues.replace(direction, moveValues.get(direction) + MoverChecks.adjacentSpace(b, dPoint));
			//HEAD ON COLLISIONS
			//System.out.println("HEAD ON COLLISION: " + direction + " " + MoverChecks.avoidHeadOnCollision(dPoint));

			moveValues.replace(direction, moveValues.get(direction) + MoverChecks.avoidHeadOnCollision(dPoint));
			
			//FORCED HEAD ON COLLISION
			System.out.println("AVOID FORCE HEAD ON: " + direction + " " + MoverChecks.avoidForcedHeadOnCollisions(dPoint));
			moveValues.replace(direction, moveValues.get(direction) + MoverChecks.avoidForcedHeadOnCollisions(dPoint));
		 }
	}
	
}