package Containers;

/** krzesla na sotle */
public class ChairsOnTable {
	int count = 2;
	/** czy mozna usiasc */
	int activePlayerIndex = -1;
	boolean gameInProgress;
	boolean[] available = new boolean[count];

	/** nicki graczy */
	String[] playerNames = new String[count];

	/** pozostaly czas, w sekundach */
	int[] time = new int[count];

	/** ilosc pozostalych liter do konca gry */
	int[] lettersLeftCount = new int[count];

	int[] points = new int[count];

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String[] getPlayerNames() {
		return playerNames;
	}

	public void setPlayerNames(String[] playerNames) {
		this.playerNames = playerNames;
	}

	public int[] getTime() {
		return time;
	}

	public void setTime(int[] time) {
		this.time = time;
	}

	public int[] getLettersLeftCount() {
		return lettersLeftCount;
	}

	public void setLettersLeftCount(int[] lettersLeftCount) {
		this.lettersLeftCount = lettersLeftCount;
	}

	public int[] getPoints() {
		return points;
	}

	public void setPoints(int[] points) {
		this.points = points;
	}

	public int getActivePlayerIndex() {
		return activePlayerIndex;
	}

	public void setActivePlayerIndex(int activePlayerIndex) {
		this.activePlayerIndex = activePlayerIndex;
	}

	public boolean[] getAvailable() {
		return available;
	}

	public void setAvailable(boolean[] available) {
		this.available = available;
	}

	public boolean isGameInProgress() {
		return gameInProgress;
	}

	public void setGameInProgress(boolean gameInProgress) {
		this.gameInProgress = gameInProgress;
	}

}
