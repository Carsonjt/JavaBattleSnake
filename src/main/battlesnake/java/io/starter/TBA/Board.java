
public class Board {
	
	int height;
	int width;
	List<Point> foodLocs;
	List<Snake> snakes;
	
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		foodLoc = new ArrayList<Point>();
		snakes = new ArrayList<Snake>();
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
	public ArrayList<Snake> getSnakes() {
		return snakes;
	}
	public void addFoodLoc(Point p) {
		foodLocs.append(p);
	}
	public void addSnake(Snake s) {
		snakes.append(s);
	}
}