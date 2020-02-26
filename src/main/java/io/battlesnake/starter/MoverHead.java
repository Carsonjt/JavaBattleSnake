package io.battlesnake.starter;

import java.util.Random;
import java.util.ArrayList;
import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

public class MoverHead {

	public static String calcMove(Board b) {
		ArrayList<String> openMoves = calcPossibleMoves(b);
		
		HashMap<String, Integer> moveValues = new HashMap<String, Integer>();
		for(int i = 0; i < openMoves.size(); i++) {
			moveValues.put(openMoves.get(i), 0);
		}
		
		Random random = new Random();
		int index = random.nextInt(openMoves.size());
		System.out.println(moveValues);
		return openMoves.get(index);
	}
	
	public static ArrayList<String> calcPossibleMoves(Board b) {
		ArrayList<String> moves = new ArrayList<String>();
		Point left = new Point((int) b.self.bodyLoc[0].getX() - 1, (int) b.self.bodyLoc[0].getY());
		if(MoverUtil.isValid(b, left))
			moves.add("left");
		
		//RIGHT
		Point right = new Point((int) b.self.bodyLoc[0].getX() + 1, (int) b.self.bodyLoc[0].getY());
		if(MoverUtil.isValid(b, right))
			moves.add("right");
		
		//UP
		Point up = new Point((int) b.self.bodyLoc[0].getX(), (int) b.self.bodyLoc[0].getY() - 1);
		if(MoverUtil.isValid(b, up))
			moves.add("up");
		
		//DOWN
		Point down = new Point((int) b.self.bodyLoc[0].getX(), (int) b.self.bodyLoc[0].getY() + 1);
		if(MoverUtil.isValid(b, down))
			moves.add("down");
		
		return moves;
		
		
	}
	
	
}