package io.battlesnake.starter;

import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import io.battlesnake.starter.Board;
import java.awt.Point;

public class JSONParser {
	
	public static Board makeBoard(JsonNode json) {
		Board board = new Board(json.at("/board/height").asInt(), json.at("/board/width").asInt(), json.at("/turn").asInt());
		System.out.println("BEFORE");
		
		json.at("/board/snakes").forEach(snake -> {
			Snake s = new Snake(snake.at("/id").asText(), snake.at("/name").asText(), snake.at("/health").asInt());
			System.out.println("ADDED SNAKE: " + s.name);
			
			snake.at("/body").forEach(body -> {
				Point p = new Point(body.at("/x").asInt(), body.at("/y").asInt());
				s.addBodyLoc(p);
				System.out.println("ADDED BODY: " + p.getX() + " " + p.getY());
			});
	
			board.addSnake(s);
			System.out.println("AFTER");
		});
		System.out.println("END");
		return board;
		
	}	
}