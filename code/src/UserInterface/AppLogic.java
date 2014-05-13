package UserInterface;

import Containers.Room;
import Main.Connection;
import Utilities.ConfigFile;

/** Logika aplikacji */
public class AppLogic {
	/** zmienna przechowywująca nazwę użytkownika */
	private String username;

	/** zmienna przechowywująca hasło użytkownika */
	private String password;

	private Room room;
	private Connection connection = new Connection();
	private ConfigFile configFile = new ConfigFile();

	/** Zwraca pokój, do którego użytkownik jest połączony */
	public Room getRoom() {
		return room;
	}

	/** Ustawia pokój, do którego użytkowink jest połączony */
	public void setRoom(Room room) {
		this.room = room;
	}

	/** zwraca konfigurację */
	public ConfigFile getConfigFile() {
		return configFile;
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
