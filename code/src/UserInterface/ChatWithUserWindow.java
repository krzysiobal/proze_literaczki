package UserInterface;

//TODO - przeniesc rejestracje z wątku UI
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Main.Connection;

/**
 * Okno rozmowy prywatnej z użytkownikiem
 */
@SuppressWarnings("serial")
public class ChatWithUserWindow extends JFrame {
	/** nick osoby z ktorą prowadzimy prywatną rozmowę */
	String username;

	/** Logika aplikacji */
	private AppLogic appLogic;

	/** Pole tekstowe przechowywujące aktualną historie rozmowy */
	private JTextArea chatHistory;

	/** Pole przechowywujące tekst rozmowy, który chcemy wysłać do użytkownika */
	private JTextField chatMessageToSend;

	/** Głowny panel okna. */
	private JPanel mp;

	/** Konstruktor głównego okna logowania/rejestracji aplikacji. */
	public ChatWithUserWindow(AppLogic appLogic, String username) {
		this.appLogic = appLogic;

		this.username = username;

		mp = new JPanel();

		chatHistory = new JTextArea(15, 30);
		JScrollPane chatHistoryScrollPane = new JScrollPane(chatHistory);
		chatHistoryScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chatHistoryScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatHistory.setEditable(false);
		chatHistory.setWrapStyleWord(true);

		chatMessageToSend = new JTextField();

		mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
		mp.add(chatHistoryScrollPane);
		mp.add(chatMessageToSend);
		add(mp);
		pack();

		final Connection con = appLogic.getConnection();
		final String un = username;
		chatMessageToSend.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& chatMessageToSend.getText().length() > 0) {
					con.sendPrivateChatMessage(un, chatMessageToSend.getText());
					chatMessageToSend.setText("");
					e.consume();
				}
			}
		});
		chatMessageToSend.requestFocus();

		setTitle("Private chat with " + username);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setFocusable(true);
		setResizable(false);
	}

	/** dodaje do listy wyswietlanych wiadomosci podana wiadomosc */
	public void addToChat(String message) {
		chatHistory.setText(chatHistory.getText() + message + "\r\n");

		// scroll it to bottom
		chatHistory.setCaretPosition(chatHistory.getDocument().getLength());
	}
}