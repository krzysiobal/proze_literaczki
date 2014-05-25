package UserInterface;

import Containers.GameRoomData;
import Main.Connection;
import Utilities.ConfigFile;

/** Logika aplikacji */
public class AppLogic {
	/** zmienna przechowywująca nazwę użytkownika */
	private String username;

	/** zmienna przechowywująca hasło użytkownika */
	private String password;

	private GameRoomData gameRoomData;
	private Connection connection;
	private ConfigFile configFile;

	/** konstruktor klasy */
	public AppLogic() {
		connection = new Connection(this);
		configFile = new ConfigFile();
		gameRoomData = new GameRoomData();
	}

	/** Zwraca pokój, do którego użytkownik jest połączony */
	public GameRoomData getGameRoomData() {
		return gameRoomData;
	}

	/** Ustawia pokój, do którego użytkowink jest połączony */
	public void setGameRoomData(GameRoomData gameRoomData) {
		this.gameRoomData = gameRoomData;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
