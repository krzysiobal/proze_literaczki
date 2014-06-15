package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.ChairsOnTable;
import Containers.Move;

/** interfejs listenera do powiadomiania o zdarzeniach podczs gry */
public interface GameWindowListener extends EventListener {
	/** otworz okno z nowy stolem */
	public void openGameWindow(int tableNo);

	/** przyszly dane o ustawieniach stolu */
	public void tableSettings(int tableNo, String operatorNickname);

	/** przyszla lista ruchow po wejsciu na stol */
	public void gameMoves(int tableNo, List<Move> moves);

	/** przyszla wiadomosc na stole */
	public void messageAtTable(int tableNo, String message);

	/** przyszly statystyki uzytkownikow na stole */
	public void gameStats1(int tableNo, ChairsOnTable chairsOnTable);

	/** przyszedl kolejny ruch od uzytkownika */
	public void gameMove(int tableNo, Move move);
}
