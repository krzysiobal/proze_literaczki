package Listeners;

import java.util.EventListener;

public interface UserLeavesRoomListener extends EventListener {
	public void userLeaves(String username);
}