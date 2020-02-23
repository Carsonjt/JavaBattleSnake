import java.awt.Point;
import java.io.

public class Board {
	
	int height;
	int width;
	Point[] foodLocs;
	Snake[] snakes;
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public Point[] getFoodLocs() {
		return foodLocs;
	}
	public Snake[] getSnakes() {
		return snakes;
	}
	public void addFoodLoc(Point p) {
		return;
	}
	public void addSnake(Snake s) {
		return;
	}
}