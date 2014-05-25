package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.Room;

public interface RoomListListener extends EventListener {
	void roomsList(List<Room> rooms, int currentRoomIndex);
}
