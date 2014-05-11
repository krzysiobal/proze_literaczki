package Main;

import Exceptions.ConnectionFailException;
import Listeners.UserEnterRoomListener;
import Listeners.UserLeaveRoomListener;

/** Klasa odpowiedzialna za połączenie z serwerem */
public class Connection {
	/** Łączy się z serwerem za pomocą podanych danych uwierzytelniających */
	public void connect(String username, String password, String roomName)
			throws ConnectionFailException {
	}

	/** Kończy połączenie z serwerem */
	public void disconnect() {

	}

	/** Ustawia listener wywoływany w momencie gdy użytkownik opuszcza pokój */
	public void setOnUserLeaveListener(UserLeaveRoomListener userLeaveListner) {

	}

	/**
	 * Ustawia listener wywoływany w momencie gdy użytkownik przychodzi do
	 * pokoju
	 */
	public void setOnUserEnterRoomListener(
			UserEnterRoomListener userEnterRoomListner) {

	}
}