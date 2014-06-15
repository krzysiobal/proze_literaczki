package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.ChairsOnTable;
import Containers.Move;

public interface GameWindowListener extends EventListener {
	public void openGameWindow(int tableNo);

	public void tableSettings(int tableNo, String operatorNickname);

	public void gameMoves(int tableNo, List<Move> moves);

	public void messageAtTable(int tableNo, String message);

	public void gameStats1(int tableNo, ChairsOnTable chairsOnTable);

	public void gameMove(int tableNo, Move move);
}
