package Containers;

import java.util.LinkedList;
import java.util.List;

/**
 * klasa reprezentująca ruch w grze
 */

public class Move {
	String description;
	List<MoveTile> tiles = new LinkedList<MoveTile>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MoveTile> getTiles() {
		return tiles;
	}

	public void setTiles(List<MoveTile> tiles) {
		this.tiles = tiles;
	}

}
