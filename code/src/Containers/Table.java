package Containers;

import java.util.Properties;

/** Przechowuje informacje o jednym ze stołów */
public class Table {
	private int number;
	private Properties tableProperties;
	private String gameTime;
	private boolean isRanked;
	private TableAvailability tableAvailability;
	private String[] usersAtTable;

	/** Dla jakich użytkowników stół jest dostępny */
	enum TableAvailability {
		/** dla każdego */
		PUBLIC,
		/** od rankingu 1200 */
		R1200,
		/** od rankingu 1350 */
		R1350,
		/** od rankingu 1500 */
		R1500,
		/** od rankingu 1650 */
		R1650,
		/** od rankingu 1800 */
		R1800,
		/** od rankingu 1950 */
		R1950,
		/** od rankingu 2100 */
		R2100,
		/** tylko dla zaproszonych */
		PRIVATE
	};

	/** konstruktor klasy */
	public Table() {
	}

	/** zwraca numer stołu */
	public int getNumber() {
		return number;
	}

	/** ustawia numer stołu */
	public void setNumber(int number) {
		this.number = number;
	}

	/** zwraca ustawienia stołu */
	public Properties getTableProperties() {
		return tableProperties;
	}

	/** ustawia ustawienia stołu */
	public void setTableProperties(Properties tableProperties) {
		this.tableProperties = tableProperties;
	}

	/** zwraca czas, jaki trwa gra przy tym stole */
	public String getGameTime() {
		return gameTime;
	}

	/** ustawia czas, jaki trwa gra przy tym stole */
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	/** zwraca informacje, czy gra przy stole jest rankingowa */
	public boolean isRanked() {
		return isRanked;
	}

	/** ustawia, czy gra przy stole jest rankingowa */
	public void setRanked(boolean isRanked) {
		this.isRanked = isRanked;
	}

	/** zwraca dostępnośc stołu dla graczy */
	public TableAvailability getTableAvailability() {
		return tableAvailability;
	}

	/** ustawia dostępność stołu dla graczy */
	public void setTableAvailability(TableAvailability tableAvailability) {
		this.tableAvailability = tableAvailability;
	}

	/** zwraca listę użytkowników siedzących przy stole */
	public String[] getUsersAtTable() {
		return usersAtTable;
	}

	/** ustawial listę użytkowników siedzących przy stole */
	public void setUsersAtTable(String[] usersAtTable) {
		this.usersAtTable = usersAtTable;
	}
}