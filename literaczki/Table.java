package Containers;

import java.util.Properties;

public class Table {
	private int number;
	private Properties tableProperties;
	private int gameTime;
	private boolean isRanked;
	private TableAvailability tableAvailability;
	private User[] usersAtTable;
	enum TableAvailability { PUBLIC, R1200, R1350, R1500, R1650, R1800, R1950, R2100, PRIVATE };
	
	public Table() {
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Properties getTableProperties() {
		return tableProperties;
	}

	public void setTableProperties(Properties tableProperties) {
		this.tableProperties = tableProperties;
	}

	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}

	public boolean isRanked() {
		return isRanked;
	}

	public void setRanked(boolean isRanked) {
		this.isRanked = isRanked;
	}

	public TableAvailability getTableAvailability() {
		return tableAvailability;
	}

	public void setTableAvailability(TableAvailability tableAvailability) {
		this.tableAvailability = tableAvailability;
	}

	public User[] getUsersAtTable() {
		return usersAtTable;
	}

	public void setUsersAtTable(User[] usersAtTable) {
		this.usersAtTable = usersAtTable;
	}
}