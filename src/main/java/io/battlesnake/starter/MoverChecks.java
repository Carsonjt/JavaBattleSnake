package io.battlesnake.starter;

import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;
import java.util.ArrayList;

public class MoverChecks {

	public static int isOnBorder(Board b, Point p) {
		if(p.getX() == 0) return 1;
		if(p.getY() == 0) return 1;
		if(p.getX() == b.getWidth()) return 1;
		if(p.getY() == b.getHeight()) return 1;
		return 0;
	}
	
	public static int isOnCorner(Board b, Point p) {
		if((p.getX() == 0) && (p.getY() == 0)) return 3;
		if((p.getX() == 0) && (p.getY() == b.getHeight())) return 3;
		if((p.getX() == b.getWidth()) && (p.getY() == 0)) return 3;
		if((p.getX() == b.getWidth()) && (p.getY() == b.getHeight())) return 3;
		return 0;
	}

	static ArrayList<Point> tiles = new ArrayList<Point>();
	
	public static int adjacentSpace(Board b, Point p) {
		tiles = new ArrayList<Point>();
		adjacentSpaceHelper(b, p);
		
		System.out.println(tiles);
		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return 0;
		else
			return ((b.self.bodyLoc.length / 2) - tiles.size()) * 3;
	}
	
	public static void adjacentSpaceHelper(Board b, Point p) {

		if(tiles.size() >= b.self.bodyLoc.length / 2)
			return;

		Point left = MoverUtil.getLeft(b, p);
		Point right = MoverUtil.getRight(b, p);
		Point up = MoverUtil.getUp(b, p);
		Point down = MoverUtil.getDown(b, p);
			
		//if(MoverUtil.isValid(b, left) && !tiles.contains(left)) {
		//	tiles.add(left);
		//	adjacentSpace(b, left);
		//}
		//if(MoverUtil.isValid(b, right) && !tiles.contains(right)) {
		//	tiles.add(right);
		//	adjacentSpace(b, right);
		//}
		if(MoverUtil.isValid(b, up) && !tiles.contains(up)) {
			tiles.add(up);
			adjacentSpace(b, up);
		}
		if(MoverUtil.isValid(b, down) && !tiles.contains(down)) {
			tiles.add(down);
			adjacentSpace(b, down);
		}
		return;
	}

}
