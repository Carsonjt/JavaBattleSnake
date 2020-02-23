import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Board {
	
	int height;
	int width;
	Point[] foodLocs;
	SnakeObj[] snakes;
	
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
	public SnakeObj[] getSnakes() {
		return snakes;
	}
	public void addFoodLoc(Point p) {
		return;
	}
	public void addSnake(SnakeObj s) {
		return;
	}
}