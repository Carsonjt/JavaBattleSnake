package io.battlesnake.starter;

import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import io.battlesnake.starter.Board;
import java.awt.Point;

public class JSONParser {
	
	public static Board makeBoard(JsonNode json) {
		Board board = new Board(json.at("/board/height").asInt() - 1, json.at("/board/width").asInt() - 1, json.at("/turn").asInt());
		
		json.at("/board/snakes").forEach(snake -> {
			Snake s = new Snake(snake.at("/id").asText(), snake.at("/name").asText(), snake.at("/health").asInt());
			
			snake.at("/body").forEach(body -> {
				Point p = new Point(body.at("/x").asInt(), body.at("/y").asInt());
				s.addBodyLoc(p);
			});
	
			if(json.at("you/id").asText().equals(s.id)) {
				board.self = s;
				System.out.println("ADDED SELF");
			} else {
				System.out.println("ADDED SNAKE");
				board.addSnake(s);
			}
		});
		return board;
		
	}	
}