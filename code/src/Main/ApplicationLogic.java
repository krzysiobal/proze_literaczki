package Main;

import java.sql.Connection;

import Containers.Room;

/** Główna logikaa aplikacji */
public class ApplicationLogic {
	private Room room;
	private Connection connection;

	/** Konstruktor klasy */
	public ApplicationLogic() {

	}

	/** Zwraca pokój, do którego użytkownik jest połączony */
	public Room getRoom() {
		return room;
	}

	/** Ustawia pokój, do którego użytkowink jest połączony */
	public void setRoom(Room room) {
		this.room = room;
	}

	/** Zwraca połączenie z serwerem */
	public Connection getConnection() {
		return connection;
	}

	/** Ustawia połączenie z serwerem */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}