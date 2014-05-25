package Listeners;

import java.util.EventListener;

public interface UserLeaveRoomListener extends EventListener {
	public void userLeave(String username);
}