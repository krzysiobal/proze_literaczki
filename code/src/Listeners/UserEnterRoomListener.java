package Listeners;

import java.util.EventListener;

public interface UserEnterRoomListener extends EventListener {
	public void userEnter(String username, int rankingPosition,
			String nationality);
}