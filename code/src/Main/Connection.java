package Main;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import Exceptions.ConnectionFailException;
import Exceptions.RegisterUsernameExceptionConnectionProblem;
import Exceptions.RegisterUsernameExceptionUserAlreadyExists;
import Listeners.UserEnterRoomListener;
import Listeners.UserLeaveRoomListener;

/** Klasa odpowiedzialna za połączenie z serwerem */
public class Connection {
	String ksession;

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

			// for (String key : header.keySet())
			// System.out.println(key + ": " + header.get(key));
			// System.out.println();

			// BufferedReader in = new BufferedReader(new InputStreamReader(
			// con.getInputStream()));
			// String inputLine;
			// StringBuffer response = new StringBuffer();
			//
			// while ((inputLine = in.readLine()) != null) {
			// response.append(inputLine);
			// }
			// in.close();
			//
			// // print result
			// System.out.println(responseCode + "\n" + response.toString());
		} catch (Exception ex) {
			throw new RegisterUsernameExceptionConnectionProblem();
		} finally {
		}
		throw new RegisterUsernameExceptionUserAlreadyExists();
	}

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