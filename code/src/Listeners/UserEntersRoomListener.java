package Listeners;

import java.util.EventListener;

public interface UserEntersRoomListener extends EventListener {
	public void userEnters(String username, int rankingPosition,
			String nationality);
}