package Containers;

/**
 * klasa reprezentująca dane o graczach siedzących na stole podczas rozgrywki
 * (nicki, ilość punktów, pozostaly czas do zakończenia gry)
 */
public class ChairsOnTable {
	/** ile jest miejsc przy stole */
	int count = 2;

	/**
	 * numer gracza aktualnie wykonujacego ruch, -1 - nikt nie wykonuje ruchu
	 * (gra sie nie zaczela)
	 */
	int activePlayerIndex = -1;

	/** czy gra sie juz zaczela */
	boolean gameInProgress;

	/** czy dane miejsce jest wolne */
	boolean[] available = new boolean[count];

	/** nicki graczy */
	String[] playerNames = new String[count];

	/** pozostaly czas, w sekundach */
	int[] time = new int[count];

	/** ilosc pozostalych liter do konca gry */
	int[] lettersLeftCount = new int[count];

	/** ilosc punktow zdobytych przez graczy */
	int[] points = new int[count];

	/** konstruktor */
	public ChairsOnTable() {
		gameInProgress = false;
		for (int i = 0; i < count; ++i) {
			available[i] = true;
			playerNames[i] = "-";
			time[i] = 0;
			lettersLeftCount[i] = 0;
			points[i] = 0;
		}
	}

	/** zwraca ilosc miejsc przy stole */
	public int getCount() {
		return count;
	}

	/** ustawia ilosc miejsc przyu stole */
	public void setCount(int count) {
		this.count = count;
	}

	/** zwraca nicki graczy przy stole */
	public String[] getPlayerNames() {
		return playerNames;
	}

	/** ustawia nicki graczy przy stole */
	public void setPlayerNames(String[] playerNames) {
		this.playerNames = playerNames;
	}

	/** zwraca czas graczy przy stole */
	public int[] getTime() {
		return time;
	}

	/** ustawia czas graczy przy stole */
	public void setTime(int[] time) {
		this.time = time;
	}

	/** zwraca ile liter pozostalo graczom */
	public int[] getLettersLeftCount() {
		return lettersLeftCount;
	}

	/** ustawia ile liter pozostalo graczom */
	public void setLettersLeftCount(int[] lettersLeftCount) {
		this.lettersLeftCount = lettersLeftCount;
	}

	/** zwraca punkty graczy */
	public int[] getPoints() {
		return points;
	}

	/** ustawia punkty graczy */
	public void setPoints(int[] points) {
		this.points = points;
	}

	/** zwraca numer gracza wykonujacego ruch */
	public int getActivePlayerIndex() {
		return activePlayerIndex;
	}

	/** ustawia numer gracza wykonujacego ruch */
	public void setActivePlayerIndex(int activePlayerIndex) {
		this.activePlayerIndex = activePlayerIndex;
	}

	/** zwraca wolne miejsca przy stole */
	public boolean[] getAvailable() {
		return available;
	}

	/** ustawia wolne miejsca przy stole */
	public void setAvailable(boolean[] available) {
		this.available = available;
	}

	/** zwraca czy gra sie zaczela */
	public boolean isGameInProgress() {
		return gameInProgress;
	}

	/** ustawia czy gra sie zaczela */
	public void setGameInProgress(boolean gameInProgress) {
		this.gameInProgress = gameInProgress;
	}

}
