package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Containers.Packet;
import Containers.Table;
import Containers.User;
import Exceptions.ConnectionFailException;
import Exceptions.LoginFailExceptionConnectionProblem;
import Exceptions.LoginFailExceptionInvalidCredentials;
import Exceptions.RegisterUsernameExceptionConnectionProblem;
import Exceptions.RegisterUsernameExceptionUserAlreadyExists;
import Listeners.LoggedSuccessfullyListener;
import Listeners.TablesInRoomListListener;
import Listeners.UserEnterRoomListener;
import Listeners.UserLeaveRoomListener;
import Listeners.UsersInRoomListListener;
import UserInterface.AppLogic;

/** Klasa odpowiedzialna za połączenie z serwerem */
public class Connection {
	AppLogic appLogic;
	Socket clientSocket;
	DataOutputStream outToServer;
	DataInputStream inFromServer;

	String ksession;

	List<UsersInRoomListListener> usersInRoomListListeners = new LinkedList<UsersInRoomListListener>();
	List<LoggedSuccessfullyListener> loggedSuccefullyListeners = new LinkedList<LoggedSuccessfullyListener>();
	List<TablesInRoomListListener> tablesInRoomListListeners = new LinkedList<TablesInRoomListListener>();

	public Connection(AppLogic appLogic) {
		this.appLogic = appLogic;
	}

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

	private void interpretPacket(Packet packet) {

		if (packet.getNumbers().length > 0) {
			int packetId = packet.getNumbers()[0];

			switch (packetId) {
			case 01: // ping request
				sendPacket(new int[] {}, new String[] {});
				break;

			case 18:
				for (LoggedSuccessfullyListener l : loggedSuccefullyListeners)
					l.loggedSuccesfully();
				break;

			case 27: { // receiving list of users in room
				List<User> users = new LinkedList<User>();

				for (int i = 0; i < packet.getStrings().length; i++) {
					String username = packet.getStrings()[i];
					int rankingPosition = packet.getNumbers()[3 + (3 * i) + 2];
					int tableNo = packet.getNumbers()[3 + (3 * i) + 1];
					int nationality = packet.getNumbers()[3 + (3 * i) + 0];
					User u = new User(username, rankingPosition, tableNo, null);
					users.add(u);
				}

				for (UsersInRoomListListener l : usersInRoomListListeners)
					l.usersInRoomList(users);
				break;
			}

			case 71: { // receiving list of tables in room
				// PAKIET: numbers = 335, strings = 249
				// 71, 4, 3, 814, 0, 1, 1, 885,
				// 7m, irenara111, medyka41, 15m, , , 10m,
				List<Table> tables = new LinkedList<Table>();
				int num_mul = packet.getNumbers()[1];
				int str_mul = packet.getNumbers()[2];
				for (int i = 0; i * str_mul < packet.getStrings().length; i += 1) {
					Table t = new Table();
					String stime = packet.getStrings()[i * str_mul + 0];
					try {
						t.setGameTime(Integer.parseInt(stime.substring(0,
								stime.length() - 1)));
					} catch (Exception ex) {
						t.setGameTime(0);
					}
					t.setUsersAtTable(new String[] {
							packet.getStrings()[i * str_mul + 1],
							packet.getStrings()[i * str_mul + 2] });
					t.setNumber(packet.getNumbers()[3 + i * num_mul + 0]);
					tables.add(t);
				}

				for (TablesInRoomListListener l : tablesInRoomListListeners)
					l.tablesInRoomList(tables);
				break;
			}
			default:
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
						interpretPacket(packet);
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

	/** Ustawia listener wywoływany w momencie gdy użytkownik opuszcza pokój */
	public void setOnUserLeaveListener(UserLeaveRoomListener userLeaveListner) {

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

	private int receiveInt32() throws IOException {
		byte[] array = new byte[4];
		inFromServer.readFully(array, 0, array.length);
		return ((array[0] & 0xFF) << 24) | ((array[1] & 0xFF) << 16)
				| ((array[2] & 0xFF) << 8) | ((array[3] & 0xFF) << 0);
	}

	private int receiveInt16() throws IOException {
		byte[] array = new byte[2];
		inFromServer.readFully(array, 0, array.length);
		return ((array[0] & 0xFF) << 8) | (array[1] & 0xFF);
	}

	/** wysyla podana tablice numbers i strings zgodnie ze specyfikacja pakietu */
	private void sendPacket(int[] numbers, String[] strings) {
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
			ex.printStackTrace();
		}
	}

	private Packet receivePacket() {
		try {
			int numbers[];
			String[] strings;

			int len = receiveInt32();
			// System.out.println("LEN=" + len);

			int numbersCount = receiveInt16();
			int stringsCount = receiveInt16();

			// System.out.println("NC=" + numbersCount + ", SC = " +
			// stringsCount);
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
			System.out.println(p.toString());
			return p;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new Packet();
	}

	/**
	 * Ustawia listener wywoływany w momencie gdy użytkownik przychodzi do
	 * pokoju
	 */
	public void setOnUserEnterRoomListener(
			UserEnterRoomListener userEnterRoomListner) {

	}

	public void addUsersInRoomListListener(UsersInRoomListListener l) {
		usersInRoomListListeners.add(l);
	}

	public void addLoggedSuccessfullyListener(LoggedSuccessfullyListener l) {
		loggedSuccefullyListeners.add(l);
	}

	public void addTablesInRommListListener(TablesInRoomListListener l) {
		tablesInRoomListListeners.add(l);
	}
}