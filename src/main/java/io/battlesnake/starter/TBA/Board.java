import java.awt.Point;

public class Board {
	
	int height;
	int width;
	List<Point> foodLocs;
	List<SnakeObj> snakes;
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		foodLoc = new ArrayList<Point>();
		snakes = new ArrayList<SnakeObj>();
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public ArrayList<Point> getFoodLocs() {
		return foodLocs;
	}
	public ArrayList<SnakeObj> getSnakes() {
		return snakes;
	}
	public void addFoodLoc(Point p) {
		foodLocs.append(p);
	}
	public void addSnake(SnakeObj s) {
		snakes.append(s);
	}
}