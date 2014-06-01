package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.Move;

public interface GameWindowListener extends EventListener {
	public void openGameWindow(int tableNo);

	public void tableSettings(int tableNo, String operatorNickname);

	public void gameMoves(int tableNo, List<Move> moves);
}
