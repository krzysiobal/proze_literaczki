package Containers;

/**
 * klasa pamięająca planszę do gry
 */
public class GameBoard {

	char[] board_yx = new char[15 * 15];
	char[] board_xy = new char[15 * 15];

	public GameBoard() {
		for (int i = 0; i < board_yx.length; ++i) {
			board_yx[i] = 0;
			board_xy[i] = 0;
		}
	}
}
