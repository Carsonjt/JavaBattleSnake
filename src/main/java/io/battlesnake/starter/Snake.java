package io.battlesnake.starter;

import io.battlesnake.starter.Point;

public class Snake{

	String id;
	String name;
	int health;
	int length;
	Point[] bodyLoc;
	Point head;
	Point tail;
	Point neck;

	public Snake(String id, String name, int health) {
		this.id = id;
		this.name = name;
		this.health = health;
		bodyLoc = new Point[0];
		length = 0;
		
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
	public Point[] getBodyLoc() {
		return bodyLoc;
	}
	public void addBodyLoc(Point p) {
		Point[] newBodyLoc = new Point[bodyLoc.length + 1];
		for(int i = 0; i < bodyLoc.length ; i++) {
			newBodyLoc[i] = bodyLoc[i];
		}
		newBodyLoc[newBodyLoc.length - 1] = p;
		this.bodyLoc = newBodyLoc;
		this.length++;
		
		if(length == 1)
			this.head = p;
		if(length == 2)
			this.neck = p;
		this.tail = p;
		
		return;
	}
	public Point getHead() {
		return head;
	}
	public Point getNeck() {
		return neck;
	}
	public Point getTail() {
		return tail;
	}
	public boolean isAt(Point p) {
			for(int i = 0; i < bodyLoc.length; i++) {
				if(bodyLoc[i].equals(p)) {
					return true;
				}
			}
		return false;
	}
}