package Containers;

import java.util.LinkedList;
import java.util.List;

/** Klasa przechowująca informacje o stole */
public class GameRoomData {
	List<Room> rooms = new LinkedList<Room>();
	int currentRoomIndex;

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	List<Table> tables = new LinkedList<Table>();
	List<User> users = new LinkedList<User>();

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getCurrentRoomIndex() {
		return currentRoomIndex;
	}

	public void setCurrentRoomIndex(int currentRoomIndex) {
		this.currentRoomIndex = currentRoomIndex;
	}

}