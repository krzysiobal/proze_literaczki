package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.User;

public interface UsersInRoomListListener extends EventListener {
	void usersInRoomList(List<User> users);
}
