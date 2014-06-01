package Containers;

import java.util.LinkedList;
import java.util.List;

/** Klasa przechowująca informacje o stole */
public class GameRoomData {
	List<Room> rooms = new LinkedList<Room>();
	int currentRoomIndex;
	Tables tables = new Tables();
	Users users = new Users();

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Tables getTables() {
		return tables;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getCurrentRoomIndex() {
		return currentRoomIndex;
	}

	public void setCurrentRoomIndex(int currentRoomIndex) {
		this.currentRoomIndex = currentRoomIndex;
	}

}