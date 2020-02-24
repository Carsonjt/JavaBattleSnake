package io.battlesnake.starter;

import java.awt.Point;

public class Snake{

	String id;
	String name;
	int health;
	Point[] bodyLocs;
	Point head;
	Point tail;
	Point neck;

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
		Point[] newBodyLocs = new Point[bodyLocs.length + 1];
		for(int i = 0; i < bodyLocs.length ; i++) {
			newBodyLocs[i] = bodyLocs[i];
		}
		newBodyLocs[newBodyLocs.length - 1] = p;
		this.bodyLocs = newBodyLocs;
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
}