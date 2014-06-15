package UserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Containers.ChairsOnTable;
import Containers.Move;
import Containers.MoveTile;
import Main.Connection;
import Utilities.Colors;

/** Klasa wyświetaląca okno ze stołu z trwającą grą */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	AppLogic appLogic;

	/** miejsca na stole */
	ChairsOnTable chairsOnTable = new ChairsOnTable();

	/** litery ktore dostales */
	GameLetter[] gameLetters = new GameLetter[7];

	/** Główny panel okna z planszą gry */
	private JPanel mainPanel;

	/** Panel, na którym znajduje się plansza do gry */
	private JPanel fieldsPanel;

	/** tekst od innych graczy na stole **/
	JTextArea chatHistory;

	JLabel playersImage;
	UserPanelInfo player1info, player2info;

	/** Zmienna przechowywująca polski alfabet. Z niej będa losowane literki. */
	private String[] letters;
	private int[] lettersCount;
	private int[] lettersPoints;

	/** Zmienna określająca kolory pól na planszy */
	private String[][] net = new String[15][15];
	private int[][] muls = new int[15][15];

	/** panele przechowujące pola planszy **/
	Field[][] fields = new Field[15][15];

	/** panele przechowujące pola z literami gracza **/
	Field[] fieldsYourLetters = new Field[7];

	/** panele przechowujące pola z literami na wymianę **/
	Field[] fieldsLettersToChange = new Field[7];

	int tableNo;

	/** Konstruktor okna, wczytuje plik konfiguracyjny */
	public GameWindow(AppLogic appLogic, int tableNo) {
		this.appLogic = appLogic;
		this.tableNo = tableNo;

		loadConfig();
		init();

		setTitle(String.format("Literaki - table #%d", tableNo));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setFocusable(true);
	}

	/** Funkcja inicjująca interfejs */
	public void init() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridLayout(17, 15));

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

		JPanel chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

		chatHistory = new JTextArea(10, 20);
		JScrollPane chatHistoryScrollPane = new JScrollPane(chatHistory);
		chatHistoryScrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chatHistoryScrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		chatHistory.setEditable(false);
		chatHistory.setWrapStyleWord(true);
		final JTextField chatMessageToSend = new JTextField();

		chatPanel.setLayout(new BorderLayout());
		chatPanel.add(chatHistoryScrollPane);
		chatPanel.add(chatMessageToSend, BorderLayout.SOUTH);

		chatMessageToSend.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				final Connection con = appLogic.getConnection();
				if (e.getKeyCode() == KeyEvent.VK_ENTER
						&& chatMessageToSend.getText().length() > 0) {
					con.sendMessageAtTable(tableNo, chatMessageToSend.getText());
					chatMessageToSend.setText("");
					e.consume();
				}
			}
		});
		chatMessageToSend.requestFocus();

		try {
			playersImage = new JLabel((Icon) (new ImageIcon(
					ImageIO.read(new File("images/players.png")))));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		player1info = new UserPanelInfo(this, chairsOnTable, 0);
		player2info = new UserPanelInfo(this, chairsOnTable, 1);
		bottomPanel.add(player1info);
		bottomPanel.add(playersImage);
		bottomPanel.add(player2info);
		player1info.update();
		player2info.update();

		bottomPanel.add(chatPanel);

		mainPanel.add(fieldsPanel);
		mainPanel.add(bottomPanel);

		add(mainPanel);

		loadFields();
		pack();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				appLogic.getConnection().leavetable(tableNo);
			}
		});

		chatMessageToSend.requestFocus();

		gameLetters[0] = new GameLetter();
		gameLetters[0].setLetter(2);
		displayYourLetters();
		updateWindow();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (chairsOnTable.isGameInProgress()) {
						chairsOnTable.getTime()[chairsOnTable
								.getActivePlayerIndex()]--;
					}

					updateWindow();
					try {
						Thread.sleep(1000);
					} catch (Exception ex) {

					}
				}
			}
		}).start();
	}

	/**
	 * Wczytuje plik konfiguracyjny o podanej nazwie, wypełnia zmienną net
	 */
	private void loadConfig() {
		letters = appLogic.getConfigFile().getValue("Letters", "letters")
				.split(",");
		lettersCount = new int[letters.length];
		lettersPoints = new int[letters.length];

		for (int i = 0; i < letters.length; ++i) {
			lettersCount[i] = Integer.parseInt(appLogic.getConfigFile()
					.getValue("Letters", "letters_count").split(",")[i]);
			lettersPoints[i] = Integer.parseInt(appLogic.getConfigFile()
					.getValue("Letters", "letters_points").split(",")[i]);
		}

		Vector<String> lines = new Vector<String>();

		for (int i = 1; i <= 15; i++)
			lines.add(appLogic.getConfigFile().getValue("Boards",
					"colours_line" + new Integer(i).toString()));

		initNet(lines);

		for (int i = 1; i <= 15; i++)
			for (int j = 1; j <= 15; j++)
				muls[i - 1][j - 1] = Integer.parseInt(appLogic
						.getConfigFile()
						.getValue("Boards",
								"bonuses_line" + new Integer(i).toString())
						.substring(j - 1, j));

	}

	/**
	 * Wypełnia plansze polami o odpowiednim kolorze na podstawie wartości
	 * przechowywanej w zmiennej net
	 */
	public void loadFields() {
		String fieldLabel;
		Color fieldBackColor;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				String col = net[i][j];
				if (muls[i][j] == 2)
					fieldLabel = "2x";
				else if (muls[i][j] == 3)
					fieldLabel = "3x";
				else
					fieldLabel = "";

				if (col.equals("w"))
					fieldBackColor = Colors.fieldWhite;
				else if (col.equals("g"))
					fieldBackColor = Colors.fieldGreen;
				else if (col.equals("r"))
					fieldBackColor = Colors.fieldRed;
				else if (col.equals("b"))
					fieldBackColor = Colors.fieldBlue;
				else if (col.equals("y"))
					fieldBackColor = Colors.fieldYellow;
				else
					fieldBackColor = Color.WHITE;

				final Field f = new Field(fieldBackColor, fieldLabel);
				fields[i][j] = f;
				f.setBorder(new LineBorder(new Color(192, 192, 192), 1));

				// reagowanie na klikniecie pola, na razie nie dziala
				f.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
					}

					@Override
					public void mouseClicked(MouseEvent arg0) {
						int i = getRandomLetterIndex();
						f.setText(letters[i]);
						f.setForeground(Color.BLACK);
						f.setBackground(Colors
								.getLetterTileColor(lettersPoints[i]));
						f.setBorder(new LineBorder(Colors
								.getLetterTileBorderColor(lettersPoints[i]), 2));

					}
				});
				fieldsPanel.add(f);
			}

		// pasek odstepu
		for (int j = 0; j < 15; j++) {
			fieldsPanel.add(new Field(new Color(0, 0, 0, 0), ""));
		}

		// litery gracza
		for (int j = 0; j < 7; j++) {
			final Field f = new Field(Color.WHITE, "");
			f.setBorder(new LineBorder(new Color(192, 192, 192), 1));
			fieldsPanel.add(f);
			fieldsYourLetters[j] = f;
		}

		fieldsPanel.add(new Field(new Color(0, 0, 0, 0), ""));

		// miejsca na wymiane
		for (int j = 0; j < 7; j++) {
			final Field f = new Field(new Color(0, 0, 0, 90), "");
			f.setBorder(new LineBorder(new Color(192, 192, 192), 1));
			fieldsPanel.add(f);
			fieldsLettersToChange[j] = f;
		}
	}

	/** Zwraca pseudolosową litere alfabetu */
	private int getRandomLetterIndex() {
		Random r = new Random();
		return r.nextInt(letters.length);
	}

	/** Wypełnia tablice net */
	private void initNet(Vector<String> lines) {
		int i = 0;
		for (String l : lines) {
			for (int j = 0; j < 15; j++)
				net[i][j] = String.valueOf(l.charAt(j));
			++i;
		}
	}

	private void addMoveinternal(Move m) {
		for (MoveTile mt : m.getTiles()) {
			boolean onBlank = mt.getLetter() >= 64;
			int l = mt.getLetter() % 64 - 2;
			if (l < 0 || l >= letters.length)
				continue;

			Field f = fields[mt.getY()][mt.getX()];
			f.setText(letters[l % 64]);
			f.setForeground(Color.BLACK);
			f.setBackground(Colors.getLetterTileColor(lettersPoints[onBlank ? 0
					: l]));
			f.setBorder(new LineBorder(Colors
					.getLetterTileBorderColor(lettersPoints[onBlank ? 0 : l]),
					2));
		}
	}

	public void addMove(final Move move) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				addMoveinternal(move);
			}
		});
	}

	public void setMoves(final List<Move> moves) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				for (Move m : moves) {
					addMoveinternal(m);
				}
			}
		});
	}

	public void addToChat(String message) {
		chatHistory.setText(chatHistory.getText() + message + "\r\n");

		// scroll it to bottom
		chatHistory.setCaretPosition(chatHistory.getDocument().getLength());
	}

	void displayYourLetters() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 7; ++j) {
					final Field f = fieldsYourLetters[j];
					if (gameLetters[j] == null) {
						f.setBackground(Color.WHITE);
						f.setText("");
						f.setBorder(new LineBorder(new Color(192, 192, 192), 1));
					} else {
						f.setBackground(Colors
								.getLetterTileColor(lettersPoints[gameLetters[j]
										.getLetter()]));

						f.setText(letters[gameLetters[j].getLetter()]);

						f.setBorder(new LineBorder(
								Colors.getLetterTileBorderColor(lettersPoints[gameLetters[j]
										.getLetter()]), 2));
						f.setLayout(new FlowLayout());
						// f.setComponentZOrder(f, 2);

						f.addMouseMotionListener(new MouseMotionListener() {

							@Override
							public void mouseMoved(MouseEvent e) {
							}

							@Override
							public void mouseDragged(MouseEvent e) {
								f.setBounds(e.getX(), e.getY(), f.getWidth(), f.getHeight());
								f.setLocation(new Point(getMousePosition().x - 20,getMousePosition().y + -10));
							}
						});
					}
				}
				repaint();
			}
		});
	}

	public void updateWindow() {
		String p1 = "", p2 = "";
		if (appLogic.getGameRoomData().getTables().getTable(tableNo) != null
				&& appLogic.getGameRoomData().getTables().getTable(tableNo)
						.getUsersAtTable() != null) {
			p1 = appLogic.getGameRoomData().getTables().getTable(tableNo)
					.getUsersAtTable()[0];
			p2 = appLogic.getGameRoomData().getTables().getTable(tableNo)
					.getUsersAtTable()[1];
		}
		chairsOnTable.getPlayerNames()[0] = p1;
		chairsOnTable.getPlayerNames()[1] = p2;

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				player1info.update();
				player2info.update();
			}
		});
	}
}

class GameLetter {
	int letter;

	public int getLetter() {
		return letter;
	}

	public void setLetter(int letter) {
		this.letter = letter;
	}
}

@SuppressWarnings("serial")
class UserPanelInfo extends JPanel {
	GameWindow gw;
	ChairsOnTable chairsOnTable;
	int index;
	UserPanelInfoField nameField, pointsField, timeField, lettersLeftField;

	public UserPanelInfo(GameWindow gw, ChairsOnTable chairsOnTable, int index) {
		super();
		this.gw = gw;
		this.chairsOnTable = chairsOnTable;
		this.index = index;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		nameField = new UserPanelInfoField();
		pointsField = new UserPanelInfoField();
		timeField = new UserPanelInfoField();
		lettersLeftField = new UserPanelInfoField();

		nameField.setFieldProperties(18);
		pointsField.setFieldProperties(13);
		timeField.setFieldProperties(13);
		lettersLeftField.setFieldProperties(13);

		add(nameField);
		add(pointsField);
		add(timeField);
		add(lettersLeftField);
	}

	public void update() {
		if (chairsOnTable.getActivePlayerIndex() == index)
			setBorder(new LineBorder(new Color(192, 192, 192), 2));
		else
			setBorder(null);

		if (chairsOnTable.getPlayerNames()[index].equals("")) {
			// wolne miejsce
			nameField.setText("<usiądź>");
			nameField.setClickable(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gw.appLogic.getConnection().takePlaceAtTable(gw.tableNo,
							index);
				}
			});
		} else {
			nameField.setText(chairsOnTable.getPlayerNames()[index]);
			nameField.setNonClickable();
		}

		pointsField.setText(String.format("Punkty: %d",
				chairsOnTable.getPoints()[index]));

		timeField.setText(String.format("Czas: %2d:%02d",
				chairsOnTable.getTime()[index] / 60,
				chairsOnTable.getTime()[index] % 60));

		lettersLeftField.setText(String.format("Litery: %d\n",
				chairsOnTable.getLettersLeftCount()[index]));

	}
}

/** Klasa reprezentująca pole z nazwą użytkownika oraz punktami */
@SuppressWarnings("serial")
class UserPanelInfoField extends JButton {
	ActionListener al;

	/**
	 * Ustawia właściwości przycisku reprezentującego pole z nazwą użytkownika
	 * oraz punktami
	 */
	public void setFieldProperties(int fontsize) {
		setPreferredSize(new Dimension(140, 0));
		setFont(new Font("Droid Sans Mono", Font.BOLD, fontsize));
		setBorder(null);
		setBackground(UIManager.getColor("Panel.background"));
		setEnabled(false);
	}

	public void setClickable(ActionListener al) {
		this.al = al;
		addActionListener(al);
		setEnabled(true);
	}

	public void setNonClickable() {
		removeActionListener(al);
		setEnabled(false);
	}
}
