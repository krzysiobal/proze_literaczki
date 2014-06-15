package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.Room;
import Containers.Table;
import Containers.User;

/** interfejs listenera do powiadomiania o zdarzeniach zachodzacych w pokoju */
public interface UsersTablesRoomsListener extends EventListener {
	/** przyszla lista pokoi */
	void roomsList(List<Room> rooms, int currentRoomIndex);

	/** przyszla lista stolow */
	void tablesInRoomList(List<Table> tables);

	/** dane o stole sie zmienily */
	public void tableUpdate(Table table);

	/** stol zamknieto */
	public void tableCloses(int number);

	/** przyszla lista uzytkownikow */
	void usersInRoomList(List<User> users);

	/** dane o uzytkowniku sie zmienily */
	public void userUpdate(User user);

	/** uzytkownik wyszedl z pokoju */
	public void userLeaves(String username);

}
