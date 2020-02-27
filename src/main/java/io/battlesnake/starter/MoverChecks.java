
import java.awt.Point;
import io.battlesnake.starter.Snake;
import io.battlesnake.starter.Board;

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
	
	public static int adjacentSpace(Board b, String s) {
		return adjacentSpace(b, getPoint(b, s));
	}
	
	public static int adjacentSpace(Board b, Point p) {
		
	}



}
