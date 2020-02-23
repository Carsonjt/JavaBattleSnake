
public class SnakeObj{

	String id;
	String name;
	int health;
	List<Point> bodyLocs;

	public SnakeObj(String id, String name, int health) {
		bodyLocs = new ArrayList<Point>();
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
	public ArrayList<Point> getBodyLocs() {
		return bodyLocs;
	}
	public void addBodyLoc(Point p) {
		bodyLocs.append(p);
	}
}