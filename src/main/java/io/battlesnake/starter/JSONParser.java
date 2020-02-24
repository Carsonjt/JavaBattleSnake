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
			s.setHead(s.bodyLocs[0]);
			s.setNeck(s.bodyLocs[1]);
			s.setTail(s.bodyLocs[s.bodyLocs.length - 1]);
		}
		
		
		/*JsonNode selfSnake = json.get("/you");
		Snake self = new Snake(selfSnake.at("/id").asText(), selfSnake.at("/name").asText(), selfSnake.at("/health").asInt());
		board.setSelf(self);
		Iterator<String> bodies = selfSnake.at("/body").fieldNames();
		while(bodies.hasNext()) {
			JsonNode body = selfSnake.get(bodies.next());
			self.addBodyLoc(new Point(body.at("/x").asInt(), body.at("/y").asInt()));
		}
		self.setHead(self.bodyLocs[0]);
		self.setNeck(self.bodyLocs[1]);
		self.setTail(self.bodyLocs[self.bodyLocs.length - 1]);
		*/
		return board;
		
	}	
}