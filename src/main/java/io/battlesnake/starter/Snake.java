import java.awt.Point;

public class Snake{

	String id;
	String name;
	int health;
	Point[] bodyLocs;

	public Snake(String id, String name, int health) {
		this.id = id;
		this.name = name;
		this.health = health;
	}

	public String getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public Point[] getBodyLocs() {
		return bodyLocs;
	}
	public void addBodyLoc(Point p) {
		return;
	}
}