package Containers;

import java.util.LinkedList;
import java.util.List;

/** klasa reprezentująca ruch w grze */
public class Move {
	/** opis ruchu, np: +12 -> +12 pkt, (W) -> wymiana */
	String description;

	/** lista wylozonych kafaelkow skladajacych sie na ruch */
	List<MoveTile> tiles = new LinkedList<MoveTile>();

	/** zwraca opis ruchu */
	public String getDescription() {
		return description;
	}

	/** ustawia opis ruchu */
	public void setDescription(String description) {
		this.description = description;
	}

	/** zwraca liste wylozonych kafaelkow skladajacych sie na ruch */
	public List<MoveTile> getTiles() {
		return tiles;
	}

	/** ustawia liste wylozonych kafaelkow skladajacych sie na ruch */
	public void setTiles(List<MoveTile> tiles) {
		this.tiles = tiles;
	}

}
