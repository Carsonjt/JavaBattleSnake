package io.battlesnake.starter;

import java.awt.Point;

public class Snake{

	String id;
	String name;
	int health;
	Point[] bodyLoc;
	Point head;
	Point tail;
	Point neck;

	public Snake(String id, String name, int health) {
		this.id = id;
		this.name = name;
		this.health = health;
		bodyLoc = new Point[0];
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
		if(newBodyLoc.length == 1)
			newBodyLoc[0] = p;
		else {
			for(int i = 0; i < bodyLoc.length ; i++) {
				newBodyLoc[i] = bodyLoc[i];
			}
			newBodyLoc[newBodyLoc.length] = p;
		}
		this.bodyLoc = newBodyLoc;
		return;
	}
	public void setHead(Point head) {
		this.head = head;
	}
	public void setTail(Point tail) {
		this.tail = tail;
	}
	public void setNeck(Point neck) {
		this.neck = neck;
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
			System.out.println("NEW POINT");
			System.out.println("BOD 1/2/3" + bodyLoc[0] + bodyLoc[1] + bodyLoc[2]);
		for(int i = 0; i < bodyLoc.length; i++) {
			System.out.println("BODY: " + bodyLoc[i]);
			if(bodyLoc[i].equals(p)) {
				return true;
			}
		}
		return false;
	}
}