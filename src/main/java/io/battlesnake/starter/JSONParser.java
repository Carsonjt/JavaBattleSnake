package io.battlesnake.starter;

import com.fasterxml.jackson.databind.JsonNode;
import io.battlesnake.starter.Board;

public class JSONParser {
	
	public static Board makeBoard(JsonNode json) {
		Board board = new Board(json.at("/board/height").asInt(), json.at("/board/width").asInt(), json.at("/turn").asInt());
		
		// ADD FOOD LOCS
		// ADD SNAKES
		
		return board;
		
	}	
}