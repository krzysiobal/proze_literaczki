package UserInterface;

import Containers.GameRoomData;
import Main.Connection;
import Utilities.ConfigFile;

/**
 * Logika aplikacji zawierajaca wszystkie dane o stanie gry, do ktorej maja
 * dostep wszystkie klasy interfejsu graficznego
 */
public class AppLogic {
	/** twoja nazwa użytkownika */
	private String username;

	/** twoje haslo */
	private String password;

	/** dane o stolach, uztywkonikach */
	private GameRoomData gameRoomData;

	/** polaczenie do serwera */
	private Connection connection;

	/** plik konfiguracyjny */
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

	/** zwraca twoja nazwe uzytkownika */
	public String getUsername() {
		return username;
	}

	/** ustawia twoja nazwe uzytkownika */
	public void setUsername(String username) {
		this.username = username;
	}

	/** zwraca twoje haslo */
	public String getPassword() {
		return password;
	}

	/** ustawia twoje haslo */
	public void setPassword(String password) {
		this.password = password;
	}
}
