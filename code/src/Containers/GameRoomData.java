package Containers;

import java.util.LinkedList;
import java.util.List;

/**
 * Klasa przechowująca informacje o pokoju, w którym jesteś - dane o wszystkich
 * stołach, użytkownikach oraz innych pokojach, na które możesz wejść
 */
public class GameRoomData {
	/** lista pokoi */
	List<Room> rooms = new LinkedList<Room>();

	/** indeks pokoju z powyzszej listy w ktorym aktualnie przebywasz */
	int currentRoomIndex;

	/** lista stolow */
	Tables tables = new Tables();

	/** lista uzytkownikow */
	Users users = new Users();

	/** zwraca liste pokoi */
	public List<Room> getRooms() {
		return rooms;
	}

	/** ustawia liste pokoi */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	/** zwraca liste stolow */
	public Tables getTables() {
		return tables;
	}

	/** zwraca liste uzytkownikow */
	public Users getUsers() {
		return users;
	}

	/** ustawia liste uzytkownikow */
	public void setUsers(Users users) {
		this.users = users;
	}

	/** zwraca indeks pokoju w ktorym jestes */
	public int getCurrentRoomIndex() {
		return currentRoomIndex;
	}

	/** ustawia indeks pokoju w ktorym jestes */
	public void setCurrentRoomIndex(int currentRoomIndex) {
		this.currentRoomIndex = currentRoomIndex;
	}

}