package io.battlesnake.starter;

import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import io.battlesnake.starter.Board;
import java.awt.Point;

public class JSONParser {
	
	public static Board makeBoard(JsonNode json) {
		Board board = new Board(json.at("/board/height").asInt(), json.at("/board/width").asInt(), json.at("/turn").asInt());
	
	
		JsonNode snakesNode = json.at("/board/snakes")
		Iterator<String> snakes = snakesNode.fieldNames();
		System.out.println("0");
		while(snakes.hasNext()) {
			JsonNode snake = json.get(snakes.next());
			System.out.println("1");
			board.addSnake(new Snake(snake.at("/id").asText(), snake.at("/name").asText(), snake.at("/health").asInt()));
			System.out.println("2");
	
		}
		System.out.println("3");
		//for(Snake sss: board.snakes) {
		//	System.out.println(sss.name);
		//}
		
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