package io.battlesnake.starter;

import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import io.battlesnake.starter.Board;
import java.awt.Point;

public class JSONParser {
	
	public static Board makeBoard(JsonNode json) {
		Board board = new Board(json.at("/board/height").asInt(), json.at("/board/width").asInt(), json.at("/turn").asInt());
		
		
		
		Iterator<String> snakes = json.at("/board/snakes").fieldNames();
		while(snakes.hasNext()) {
			JsonNode snake = json.get(snakes.next());
			Snake s = new Snake(snake.at("/id").asText(), snake.at("/name").asText(), snake.at("/health").asInt());
			board.addSnake(s);
			
			Iterator<String> bodies = snake.at("/body").fieldNames();
			while(bodies.hasNext()) {
				JsonNode body = snake.get(bodies.next());
				s.addBodyLoc(new Point(body.at("/x").asInt(), body.at("/y").asInt()));
			}
		}
		return board;
		
	}	
}