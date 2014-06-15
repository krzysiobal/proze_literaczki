package Containers;

/**
 * klasa pamięająca planszę do gry
 */
public class GameBoard {
	/** tablica pol w kolejnosci yx */
	char[] board_yx = new char[15 * 15];

	/** tablica pol w kolejnosci xy */
	char[] board_xy = new char[15 * 15];

	/** konstruktor */
	public GameBoard() {
		for (int i = 0; i < board_yx.length; ++i) {
			board_yx[i] = 0;
			board_xy[i] = 0;
		}
	}
}
