package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Klasa wyświetaląca okno ze stołu z trwającą grą */
@SuppressWarnings("serial")
public class GameWindow extends JFrame {
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
	private JButton minButton;

	/** Przycisk zamykający okno */
	private JButton exitButton;

	/** Pole zawierające nazwę pierwszego gracza. */
	private UserField firstPlayerField;

	/** Pole zawierające nazwę drugiego gracza. */
	private UserField secondPlayerField;

	/** Pole zawierające punkty pierwszego gracza. */
	private UserField firstPlayerPoints;

	/** Pole zawierające punkty drugiego gracza. */
	private UserField secondPlayerPoints;

	/** Zmienna przechowywująca polski alfabet. Z niej będa losowane literki. */
	private String alphabet = "AĄBCĆDEĘFGHIJKLMNŃOPQRSŚTUVWXYŹŻ";

	/** Zmienna przechowywująca nazwe pliku konfiguracyjnego. */
	private String fileName = "e:\\Pulpit\\proze-literaczki\\repo\\code\\config.txt";

	/**
	 * Zmienna, do której zczytywane są kolory pól na planszy z pliku
	 * konfiguracyjnego.
	 */
	private String[][] net = new String[15][15];
	/*
	 * {"r","w","b","w","w","g","w","r","w","g","w","w","b","w","r"},
	 * {"w","w","w","w","g","w","r","w","r","w","g","w","w","w","w"},
	 * {"b","w","w","g","w","b","w","y","w","b","w","g","w","w","b"},
	 * {"w","w","g","w","b","w","y","w","y","w","b","w","g","w","w"},
	 * {"w","g","w","b","w","y","w","w","w","y","w","b","w","g","w"},
	 * {"g","w","b","w","y","w","w","b","w","w","y","w","b","w","g"},
	 * {"w","r","w","y","w","w","b","w","b","w","w","y","w","r","w"},
	 * {"r","w","y","w","w","b","w","w","w","b","w","w","y","w","r"},
	 * {"w","r","w","y","w","w","b","w","b","w","w","y","w","r","w"},
	 * {"g","w","b","w","y","w","w","b","w","w","y","w","b","w","g"},
	 * {"w","g","w","b","w","y","w","w","w","y","w","b","w","g","w"},
	 * {"w","w","g","w","b","w","y","w","y","w","b","w","g","w","w"},
	 * {"b","w","w","g","w","b","w","y","w","b","w","g","w","w","b"},
	 * {"w","w","w","w","g","w","r","w","r","w","g","w","w","w","w"},
	 * {"r","w","b","w","w","g","w","r","w","g","w","w","b","w","r"},
	 */

	/** Tablica 2D przechowywująca współrzędne pól z podwojoną ilością punktów */
	private int[][] fields2x = { { 0, 2 }, { 0, 12 }, { 2, 0 }, { 2, 14 },
			{ 12, 0 }, { 12, 14 }, { 14, 2 }, { 14, 12 } };

	/** Tablica 2D przechowywująca współrzędne pól z potrojoną ilością punktów */
	private int[][] fields3x = { { 2, 5 }, { 2, 9 }, { 3, 4 }, { 3, 10 },
			{ 4, 3 }, { 4, 11 }, { 5, 2 }, { 5, 12 }, { 9, 2 }, { 12, 9 },
			{ 9, 12 }, { 10, 3 }, { 10, 11 }, { 11, 4 }, { 11, 10 }, { 12, 5 },
			{ 12, 9 } };

	/** Konstruktor okna, wczytuje plik konfiguracyjny */
	public GameWindow() {
		loadConfig(fileName);
		init();
		setTitle("Literaki");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		minButton = new JButton("Minimize");
		exitButton = new JButton("Exit");
		tableNumber = new JLabel("table #314");
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridLayout(15, 15));

		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.add(infoPanelOne);
		infoPanel.add(infoPanelTwo);
		infoPanel.add(infoPanelLetters);

		infoPanelOne.add(tableNumber);
		infoPanelOne.add(minButton);
		infoPanelOne.add(exitButton);

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

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	/**
	 * Wypełnia plansze polami o odpowiednim kolorze na podstawie wartości
	 * przechowywanej w zmiennej net
	 */
	public void loadFields() {
		String points = "";
		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				String col = net[i][j];
				if (check2x(i, j) == true)
					points = "2x";
				else if (check3x(i, j) == true)
					points = "3x";
				switch (col) {
				case "w":
					fieldsPanel.add(new Field(Color.WHITE, points));
					break;
				case "g":
					fieldsPanel
							.add(new Field(new Color(0, 255, 0, 95), points));
					break;
				case "r":
					fieldsPanel
							.add(new Field(new Color(255, 0, 0, 95), points));
					break;
				case "b":
					fieldsPanel
							.add(new Field(new Color(0, 0, 255, 95), points));
					break;
				case "y":
					fieldsPanel.add(new Field(new Color(255, 255, 0, 95),
							points));
					break;
				}
				points = "";
			}
	}

	/** sprawdza czy pole powinno mieć podwójną punktację */
	private boolean check2x(int i, int j) {
		for (int n = 0; n < 8; n++)
			if ((i == fields2x[n][0] && j == fields2x[n][1])
					|| (i == fields2x[n][0] && j == fields2x[n][1]))
				return true;
		return false;
	}

	/** sprawdza czy pole powinno mieć potrójną punktację */
	private boolean check3x(int i, int j) {
		for (int n = 0; n < 15; n++)
			if ((i == fields3x[n][0] && j == fields3x[n][1])
					|| (i == fields3x[n][0] && j == fields3x[n][1]))
				return true;
		return false;
	}

	/** Zwraca pseudolosową litere alfabetu */
	private char getRandomLetter() {
		int randomNum = (int) (Math.random() * 32);
		return alphabet.charAt(randomNum);
	}

	/** Wczytuje plik konfiguracyjny o podanej nazwie, wypełnia zmienną net */
	private void loadConfig(String fileName) {
		Vector<String> lines = new Vector<String>();
		String line;
		try {
			InputStream is = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null)
				lines.add(line);
			br.close();
			initNet(lines);
		} catch (IOException e) {

		}
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
