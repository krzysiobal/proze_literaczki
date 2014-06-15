package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

import Containers.ChairsOnTable;
import Containers.Move;
import Containers.MoveTile;
import Containers.Packet;
import Containers.Room;
import Containers.Table;
import Containers.User;
import Exceptions.ConnectionFailException;
import Exceptions.LoginFailExceptionConnectionProblem;
import Exceptions.LoginFailExceptionInvalidCredentials;
import Exceptions.RegisterUsernameExceptionConnectionProblem;
import Exceptions.RegisterUsernameExceptionUserAlreadyExists;
import Listeners.GameWindowListener;
import Listeners.IncomingPrivateChatMessageListener;
import Listeners.LoggedSuccessfullyListener;
import Listeners.UsersTablesRoomsListener;
import UserInterface.AppLogic;

/** Klasa odpowiedzialna za połączenie z serwerem */
public class Connection {
	/** czy wyswietlac informacje o nieznanych pakietach */
	boolean debug = false;

	/**
	 * czy wyswietlac informacje o wszystkich pakietach odbieranych i wysylanych
	 */
	boolean showAllPackets = false;

	/** logika aplikacji */
	AppLogic appLogic;

	/** gniazdo polaczenia z serwerem */
	Socket clientSocket;

	/** strumien wyjscia do serwera */
	DataOutputStream outToServer;

	/** strumien wejscia od serwera */
	DataInputStream inFromServer;

	/** identyfikator sesji po zalogowainu/rejestracji */
	String ksession;

	/** wszyscy zarejestrowani sluchacze */
	List<EventListener> listeners = new CopyOnWriteArrayList<EventListener>();

	/** konstruktor */
	public Connection(AppLogic appLogic) {
		this.appLogic = appLogic;
	}

	/** rejestruje uzytkownika o podanym nicku i hasle */
	public void registerUsername(String username, String password)
			throws RegisterUsernameExceptionConnectionProblem,
			RegisterUsernameExceptionUserAlreadyExists {
		try {
			String url = "http://www.kurnik.pl/rejestracja.phtml?t=bb&l=1";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header
			con.setRequestMethod("POST");

			con.setRequestProperty("Host", "www.kurnik.pl");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0");
			con.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			con.setRequestProperty("Accept-Language", "pl,en-us;q=0.7,en;q=0.3");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			con.setRequestProperty("Referer",
					"http://www.kurnik.pl/rejestracja.phtml?t=bb");
			con.setRequestProperty("Connection", "keep-alive");

			String urlParameters = "id=" + username + "&pw1=" + password
					+ "&email=";

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();

			Map<String, List<String>> responseHeader = con.getHeaderFields();
			for (String key : responseHeader.keySet())
				if (key != null && key.equals("Set-Cookie")) {
					String cookie = "";
					for (String s : responseHeader.get(key))
						cookie = cookie + s;
					String[] cookies = cookie.split("; ");
					for (String s : cookies)
						if (s.startsWith("ksession=")) {
							ksession = s.substring(9);
							return;
						}
				}

		} catch (Exception ex) {
			throw new RegisterUsernameExceptionConnectionProblem();
		} finally {
		}
		throw new RegisterUsernameExceptionUserAlreadyExists();
	}

	/** loguje sie na uzytkownika o podanym nicku i hasle */
	public void login(String username, String password)
			throws LoginFailExceptionInvalidCredentials,
			LoginFailExceptionConnectionProblem {
		try {
			String url = "http://www.kurnik.pl/literaki/?l=1";
			HttpURLConnection.setFollowRedirects(false);
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add request header
			con.setRequestMethod("POST");

			con.setRequestProperty("Host", "www.kurnik.pl");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0");
			con.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			con.setRequestProperty("Accept-Language", "pl,en-us;q=0.7,en;q=0.3");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			con.setRequestProperty("Referer", "http://www.kurnik.pl/literaki/");
			con.setRequestProperty("Connection", "keep-alive");

			String urlParameters = "cc=0&id=" + username + "&pw=" + password;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			Map<String, List<String>> responseHeader = con.getHeaderFields();

			for (String key : responseHeader.keySet()) {
				if (key != null && key.equals("Set-Cookie")) {

					String cookie = "";
					for (String s : responseHeader.get(key))
						cookie = cookie + s;

					String[] cookies = cookie.split("; ");
					for (String s : cookies)
						if (s.startsWith("ksession=")) {
							ksession = s.substring(9);
							return;
						}
				}
			}

		} catch (Exception ex) {
			throw new LoginFailExceptionConnectionProblem();
		} finally {
		}
		throw new LoginFailExceptionInvalidCredentials();
	}

	/** wykonuje odpowiednie dzialania po przyjsciu danego pakietu */
	private void interpretPacket(Packet packet) {
		if (showAllPackets) {
			System.out.println("ODBIERAM " + packet.toString());
		}

		if (packet.getNumbers().length > 0) {
			int packetId = packet.getNumbers()[0];

			switch (packetId) {
			case 0x01: // ping request
				sendPacket(new int[] {}, new String[] {});
				break;

			case 0x15: {// incoming private chat message
				for (EventListener l : listeners)
					if (l instanceof IncomingPrivateChatMessageListener)
						((IncomingPrivateChatMessageListener) l)
								.incomingPrivateChatMessage(
										packet.getStrings()[0],
										packet.getStrings()[1]);
				break;
			}

			case 0x12: // entered room
				for (EventListener l : listeners)
					if (l instanceof LoggedSuccessfullyListener)
						((LoggedSuccessfullyListener) l).loggedSuccesfully();
				break;

			case 0x19: {// user update
				String username = packet.getStrings()[0];
				int rank = packet.getNumbers().length != 4 ? 0 : packet
						.getNumbers()[3];
				int tableAt = packet.getNumbers()[2];
				int nationality = packet.getNumbers()[1];

				User user = new User(username, rank, tableAt, "?");

				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).userUpdate(user);
				break;
			}

			case 0x18: {// user leaves room
				String username = packet.getStrings()[0];
				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).userLeaves(username);
				break;
			}

			case 0x1b: { // receiving list of users in room
				List<User> users = new LinkedList<User>();
				int intsperuser = packet.getNumbers()[1];

				for (int i = 0; i < packet.getStrings().length; i++) {
					String username = packet.getStrings()[i];

					int rankingPosition = intsperuser != 3 ? 0 : packet
							.getNumbers()[3 + (intsperuser * i) + 2];
					int tableNo = packet.getNumbers()[3 + (intsperuser * i) + 1];
					int nationality = packet.getNumbers()[3 + (intsperuser * i) + 0];

					User u = new User(username, rankingPosition, tableNo, null);
					users.add(u);
				}

				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).usersInRoomList(users);
				break;
			}

			case 0x20: { // receiving list of rooms
				// PAKIET: numbers = 2, strings = 1
				// 32, 6,
				// #100... bocianowo (pełny)
				// #200... boleszyn (pełny)
				// #300... burszewo (pełny)
				// #400... chojnik (pełny)
				// #500... domkowo (pełny)
				// #600... drogosze (pełny)
				// #700... gieduty (177)
				List<Room> rooms = new LinkedList<Room>();
				for (String s : packet.getStrings()[0].split("\n")) {
					int number = Integer
							.parseInt(s.substring(1, s.indexOf(".")));
					String name = s.substring(s.indexOf(" "),
							s.indexOf("(") - 1);
					Room r = new Room();
					r.setName(name);
					r.setNumber(number);
					r.setDetails(s);
					rooms.add(r);
				}
				int currentRoomIndex = packet.getNumbers()[1];

				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).roomsList(rooms,
								currentRoomIndex);
				break;

			}

			case 0x46: { // table on list update
				String stime = packet.getStrings()[0];
				String user1 = packet.getStrings()[1];
				String user2 = packet.getStrings()[2];
				int tableNo = packet.getNumbers()[1];

				Table t = new Table();
				t.setGameTime(stime);
				t.setUsersAtTable(new String[] { user1, user2 });
				t.setNumber(tableNo);

				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).tableUpdate(t);
				break;
			}

			case 0x47: { // receiving list of tables in room
				// PAKIET: numbers = 335, strings = 249
				// 71, 4, 3, 814, 0, 1, 1, 885,
				// 7m, irenara111, medyka41, 15m, , , 10m,
				List<Table> tables = new LinkedList<Table>();
				int num_mul = packet.getNumbers()[1];
				int str_mul = packet.getNumbers()[2];
				for (int i = 0; i * str_mul < packet.getStrings().length; i += 1) {
					Table t = new Table();
					String stime = packet.getStrings()[i * str_mul + 0];
					t.setGameTime(stime);
					t.setUsersAtTable(new String[] {
							packet.getStrings()[i * str_mul + 1],
							packet.getStrings()[i * str_mul + 2] });
					t.setNumber(packet.getNumbers()[3 + i * num_mul + 0]);
					tables.add(t);
				}

				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).tablesInRoomList(tables);
				break;
			}

			case 0x48: { // delete table from list
				int tableNo = packet.getNumbers()[1];
				for (EventListener l : listeners)
					if (l instanceof UsersTablesRoomsListener)
						((UsersTablesRoomsListener) l).tableCloses(tableNo);
				break;
			}

			case 0x49: {
				int tableNo = packet.getNumbers()[1];

				for (EventListener l : listeners)
					if (l instanceof GameWindowListener)
						((GameWindowListener) l).openGameWindow(tableNo);
				break;
			}

			case 0x51: { // message at table;
				int tableNo = packet.getNumbers()[1];
				String message = packet.getStrings()[0];
				for (EventListener l : listeners)
					if (l instanceof GameWindowListener)
						((GameWindowListener) l).messageAtTable(tableNo,
								message);
				break;
			}

			// punkty graczy po wejsciu na stol
			// 0x005a, 0x0065, 0x0007, 0x0001, 0x0008, 0x0001, 0x060f, 0xffff,
			// 0x0005, 0x017a, 0x0003, 0x0001, 0x0002, 0x0003, 0x0128, 0x01c2,
			// 0x0001, 0x0086, 0x0136, 0x0001,

			case 0x5a: {
				if (packet.getNumbers()[2] == 7) {
					int tableNo = packet.getNumbers()[1];
					ChairsOnTable ch = new ChairsOnTable();
					ch.setGameInProgress(packet.getNumbers()[3] != 0xFFFF);
					ch.setActivePlayerIndex(packet.getNumbers()[3]);

					ch.setPoints(new int[] { packet.getNumbers()[14],
							packet.getNumbers()[17] });
					ch.setTime(new int[] { packet.getNumbers()[15],
							packet.getNumbers()[18] });

					for (EventListener l : listeners)
						if (l instanceof GameWindowListener)
							((GameWindowListener) l).gameStats1(tableNo, ch);
				}
				break;
			}

			case 0x5b: {
				int tableNo = packet.getNumbers()[1];
				List<Move> moves = new LinkedList<Move>();

				int in = 2;
				int is = 0;
				while (in < packet.getNumbers().length
						&& is < packet.getStrings().length) {
					Move m = new Move();
					m.setDescription(packet.getStrings()[is]);
					while (packet.getNumbers()[in] != 0) {
						MoveTile mt = new MoveTile();
						int x = packet.getNumbers()[in] / 128 % 16;
						int y = packet.getNumbers()[in] / 2048 % 16;
						int l = packet.getNumbers()[in] % 128;
						mt.setX(x);
						mt.setY(y);
						mt.setLetter(l);
						m.getTiles().add(mt);
						in++;
					}

					moves.add(m);
					is++;
					in++;
				}

				for (EventListener l : listeners)
					if (l instanceof GameWindowListener)
						((GameWindowListener) l).gameMoves(tableNo, moves);
				break;
			}

			case 0x5c: { // ruch
				if (packet.getStrings().length != 0)
					break;
				// ruch migajacy z prosbka o akceptacje
				// System.out.println(packet);
				int tableNo = packet.getNumbers()[1];

				int in = 2;
				// int is = 0;
				Move m = new Move();
				while (in < packet.getNumbers().length) {
					MoveTile mt = new MoveTile();
					int x = packet.getNumbers()[in] / 128 % 16;
					int y = packet.getNumbers()[in] / 2048 % 16;
					int l = packet.getNumbers()[in] % 128;
					mt.setX(x);
					mt.setY(y);
					mt.setLetter(l);
					m.getTiles().add(mt);
					in++;
				}

				for (EventListener l : listeners)
					if (l instanceof GameWindowListener)
						((GameWindowListener) l).gameMove(tableNo, m);
				break;
			}

			case 0xffff:
				if (packet.getStrings().length > 0) {
					JOptionPane.showMessageDialog(null, packet.getStrings()[0]);
				}
				try {
					clientSocket.close();
				} catch (Exception ex) {
				}
				break;

			default:
				if (debug)
					System.out.println(packet.toString());
				// JOptionPane.showMessageDialog(null, "pakiet inny");
			}
		}
	}

	/** Łączy się z serwerem za pomocą podanych danych uwierzytelniających */
	public void connect(String roomName) throws ConnectionFailException {
		try {
			clientSocket = new Socket(appLogic.getConfigFile().getValue(
					"Server",

					"Host"), Integer.parseInt(appLogic.getConfigFile()
					.getValue("Server", "Port")));
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new DataInputStream(clientSocket.getInputStream());

			sendPacket(new int[] { 0x4276 },
					new String[] { ksession.substring(0, 16),
							new String(new byte[] { 0x70, 0x6c }),
							new String(new byte[] { 0x6a }), new String(""),
							new String("") });

			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						Packet packet = receivePacket();
						if (packet != null)
							interpretPacket(packet);
						else
							break;
					}
				}
			}).start();

		} catch (IOException ex) {
			throw new ConnectionFailException();
		}
	}

	/** Kończy połączenie z serwerem */
	public void disconnect() throws ConnectionFailException {
		try {
			clientSocket.close();
		} catch (IOException ex) {
			throw new ConnectionFailException();
		}
	}

	/** wysyla do serwera liczbe 32 bitowa zgodnie z protokołem */
	private void sendInt32(int i) throws IOException {
		outToServer.write(new byte[] { (byte) ((i >> 24) & 0xFF),
				(byte) ((i >> 16) & 0xFF), (byte) ((i >> 8) & 0xFF),
				(byte) ((i >> 0) & 0xFF) });
	}

	/** wysyła do serwera liczbe 16 bitowązgodnie z protokołem */
	private void sendInt16(int i) throws IOException {
		outToServer.write(new byte[] { (byte) ((i >> 8) & 0xFF),
				(byte) ((i >> 0) & 0xFF) });
	}

	/** odbiera od serwera liczbe 32 bitowa */
	private int receiveInt32() throws IOException {
		byte[] array = new byte[4];
		inFromServer.readFully(array, 0, array.length);
		return ((array[0] & 0xFF) << 24) | ((array[1] & 0xFF) << 16)
				| ((array[2] & 0xFF) << 8) | ((array[3] & 0xFF) << 0);
	}

	/** odbiera od serwera liczbe 16 bitowa */
	private int receiveInt16() throws IOException {
		byte[] array = new byte[2];
		inFromServer.readFully(array, 0, array.length);
		return ((array[0] & 0xFF) << 8) | (array[1] & 0xFF);
	}

	/** wysyla podana tablice numbers i strings zgodnie ze specyfikacja pakietu */
	private void sendPacket(int[] numbers, String[] strings) {
		if (showAllPackets) {
			Packet p = new Packet();
			p.setNumbers(numbers);
			p.setStrings(strings);
			System.out.println("WYSYŁAM " + p.toString());
		}

		try {
			int len = 0;
			len += 4 + 4;
			len += numbers.length * 2;

			for (String s : strings) {
				byte[] array = s.getBytes("UTF8");
				len += 2 + array.length + 1;
			}

			sendInt32(len);
			sendInt16(numbers.length);
			sendInt16(strings.length);

			for (int n : numbers)
				sendInt16(n);

			for (String s : strings) {
				byte[] array = s.getBytes("UTF8");

				sendInt16(array.length);
				outToServer.write(array);
				outToServer.write(new byte[] { 0 });
			}
		} catch (Exception ex) {
		}
	}

	/** odbiera pakiet od serwera */
	private Packet receivePacket() {
		try {
			int numbers[];
			String[] strings;

			int len = receiveInt32();

			int numbersCount = receiveInt16();
			int stringsCount = receiveInt16();

			numbers = new int[numbersCount];
			strings = new String[stringsCount];

			for (int i = 0; i < numbersCount; i++)
				numbers[i] = receiveInt16();

			for (int i = 0; i < stringsCount; i++) {
				int stringLen = receiveInt16();
				byte[] chars = new byte[stringLen];
				inFromServer.readFully(chars, 0, stringLen);
				inFromServer.read();

				strings[i] = new String(chars, "UTF-8");
			}

			Packet p = new Packet();
			p.setNumbers(numbers);
			p.setStrings(strings);
			return p;
		} catch (Exception ex) {
		}
		return null;
	}

	/** dolacza do stolu o podanej pelnej nazwie */
	public void joinRoom(String roomName) {
		sendPacket(new int[] { 0x14 }, new String[] { "/join " + roomName });
	}

	/** wysyla prywatna wiadomosc do danego uzytkownika */
	public void sendPrivateChatMessage(String toUser, String message) {
		sendPacket(new int[] { 0x15 }, new String[] { toUser, message });
	}

	/** potwierdza odebranie prywatnej wiadomosci od danego uzytkownika */
	public void acknowledgePrivateChatMessages(String toUser) {
		sendPacket(new int[] { 0x19, 0x11 }, new String[] { toUser });
	}

	/** wchodzi na stol o podanym numerze */
	public void enterTable(int tableNumber) {
		sendPacket(new int[] { 0x0048, tableNumber }, new String[] {});
	}

	/** opuszcza stol o podanym numerze */
	public void leavetable(int tableNumber) {
		sendPacket(new int[] { 0x0049, tableNumber }, new String[] {});
	}

	/** wysyla wiadomosc na stole o podanym numerze */
	public void sendMessageAtTable(int tableNo, String message) {
		sendPacket(new int[] { 0x51, tableNo }, new String[] { message });
	}

	/** zajmuje miejsce na stole */
	public void takePlaceAtTable(int tableNo, int placeNo) {
		// sendPacket(new int[] { 0x54, tableNo, placeNo }, new String[] {}); -
		// wstanie ze stolu
		sendPacket(new int[] { 0x53, tableNo, placeNo }, new String[] {});
	}

	/** dodaje sluchacza */
	public void addListener(EventListener l) {
		listeners.add(l);
	}

}