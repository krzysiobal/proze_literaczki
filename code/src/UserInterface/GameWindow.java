package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Containers.Move;
import Containers.MoveTile;
import Utilities.Colors;

/** Klasa wyświetaląca okno ze stołu z trwającą grą */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	AppLogic appLogic;

	/** Główny panel okna z planszą gry */
	private JPanel mainPanel;

	/** Panel, na którym znajduje się plansza do gry */
	private JPanel fieldsPanel;

	/** Panel bazowy dla infoPanelOne, infoPanelTwo, infoPanelLetters */
	private JPanel infoPanel;

	/**
	 * Panel, na którym znajdują się przyciski wyjścia, minimalizowania okna
	 * oraz numer stołu
	 */
	private JPanel infoPanelOne;

	/** Panel, na którym znajdują się nazwy graczy oraz ich punkty */
	private JPanel infoPanelTwo;

	/** Panel, na którym znajdują się wylosowane literki */
	private JPanel infoPanelLetters;

	/** Kontrolka wyświetlająca numer stołu */
	private JLabel tableNumber;

	/** Przycisk minimalizacji okna. */
	// private JButton minButton;

	/** Przycisk zamykający okno */
	// private JButton exitButton;

	/** Pole zawierające nazwę pierwszego gracza. */
	private UserField firstPlayerField;

	/** Pole zawierające nazwę drugiego gracza. */
	private UserField secondPlayerField;

	/** Pole zawierające punkty pierwszego gracza. */
	private UserField firstPlayerPoints;

	/** Pole zawierające punkty drugiego gracza. */
	private UserField secondPlayerPoints;

	/** Zmienna przechowywująca polski alfabet. Z niej będa losowane literki. */
	private String[] letters;
	private int[] lettersCount;
	private int[] lettersPoints;

	/** Zmienna określająca kolory pól na planszy */
	private String[][] net = new String[15][15];
	private int[][] muls = new int[15][15];
	Field[][] fields = new Field[15][15];

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
		infoPanel = new JPanel();
		infoPanelOne = new JPanel();
		infoPanelTwo = new JPanel();
		infoPanelLetters = new JPanel();
		firstPlayerField = new UserField("jjozwiak");
		secondPlayerField = new UserField("kbalazyk");
		firstPlayerPoints = new UserField("43");
		secondPlayerPoints = new UserField("78");

		// minButton = new JButton("Minimize");
		// exitButton = new JButton("Exit");
		tableNumber = new JLabel(String.format("table #%d", tableNo));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridLayout(15, 15));

		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.add(infoPanelOne);
		infoPanel.add(infoPanelTwo);
		infoPanel.add(infoPanelLetters);

		infoPanelOne.add(tableNumber);
		// infoPanelOne.add(minButton);
		// infoPanelOne.add(exitButton);

		infoPanelTwo.add(firstPlayerPoints);
		infoPanelTwo.add(firstPlayerField);
		infoPanelTwo.add(secondPlayerField);
		infoPanelTwo.add(secondPlayerPoints);

		infoPanelLetters.setLayout(new GridLayout(1, 7));
		infoPanelLetters.add(new Letter(new Color(255, 0, 0), "Z"));
		infoPanelLetters.add(new Letter(new Color(0, 0, 255), "A"));
		infoPanelLetters.add(new Letter(new Color(255, 255, 255), "Ć"));
		infoPanelLetters.add(new Letter(new Color(255, 0, 0), "S"));
		infoPanelLetters.add(new Letter(new Color(255, 255, 0), "A"));
		infoPanelLetters.add(new Letter(new Color(0, 255, 0), "W"));
		infoPanelLetters.add(new Letter(new Color(0, 0, 255), "P"));

		loadFields();
		mainPanel.add(fieldsPanel);
		mainPanel.add(infoPanel);
		add(mainPanel);
		pack();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				appLogic.getConnection().leavetable(tableNo);
			}
		});

		// exitButton.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// GameWindow.this.dispose();
		// }
		// });
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
		String fieldLabelColor;
		Color fieldBackColor;
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				String col = net[i][j];
				if (muls[i][j] == 2)
					fieldLabelColor = "2x";
				else if (muls[i][j] == 3)
					fieldLabelColor = "3x";
				else
					fieldLabelColor = "";

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

				final Field f = new Field(fieldBackColor, fieldLabelColor);
				fields[i][j] = f;
				f.setBorder(new LineBorder(new Color(192, 192, 192), 1));

				// reagowanie na klikniecie pola, na razie nie dziala
				f.addMouseListener(new MouseListener() {

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mousePressed(MouseEvent arg0) {

					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub

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

	public void setMoves(final List<Move> moves) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				for (Move m : moves) {
					for (MoveTile mt : m.getTiles()) {
						boolean onBlank = mt.getLetter() >= 64;
						int l = mt.getLetter() % 64 - 2;
						if (l < 0 || l >= letters.length)
							continue;

						Field f = fields[mt.getY()][mt.getX()];
						f.setText(letters[l % 64]);
						f.setForeground(Color.BLACK);
						f.setBackground(Colors
								.getLetterTileColor(lettersPoints[onBlank ? 0
										: l]));
						f.setBorder(new LineBorder(
								Colors.getLetterTileBorderColor(lettersPoints[onBlank ? 0
										: l]), 2));
					}
				}
			}
		});

	}
}

/** Klasa reprezentująca pole z nazwą użytkownika oraz punktami */
@SuppressWarnings("serial")
class UserField extends JButton {
	/** Konstuktor pola */
	public UserField(String username) {
		super(username);
		setFieldProperties();
	}

	/**
	 * Ustawia właściwości przycisku reprezentującego pole z nazwą użytkownika
	 * oraz punktami
	 */
	public void setFieldProperties() {
		setPreferredSize(new Dimension(120, 60));
		setFont(new Font("Droid Sans Mono", Font.BOLD, 18));
		setBorder(null);
		setEnabled(false);
	}
}
