package io.battlesnake.starter;

public interface PointInterface {

	int getX();
	int getY();
	boolean equals(Point p);
	boolean isValid();
	boolean isOnBorder();
	boolean isOnCorner();
	Point getUp();
	Point getDown();
	Point getLeft();
	Point getRight();
	Point[] getSurrounding();
 
}
