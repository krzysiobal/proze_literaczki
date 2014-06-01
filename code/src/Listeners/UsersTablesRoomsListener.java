package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.Room;
import Containers.Table;
import Containers.User;

public interface UsersTablesRoomsListener extends EventListener {
	void roomsList(List<Room> rooms, int currentRoomIndex);

	void tablesInRoomList(List<Table> tables);

	public void tableUpdate(Table table);

	public void tableCloses(int number);

	void usersInRoomList(List<User> users);

	public void userUpdate(User user);

	public void userLeaves(String username);

}
