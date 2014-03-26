package Main;
import java.sql.Connection;

import Containers.Room;

public class ApplicationLogic {
	private Room room;
	private Connection connection;
	
	public ApplicationLogic() {
		
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}