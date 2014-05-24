package UserInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Containers.User;
import Listeners.UsersAtTableListListener;

/** Klasa wyświetlająca okno z listą stołów i użytkowników */
@SuppressWarnings("serial")
public class TableAndUserWindow extends JFrame {
	private AppLogic appLogic;
	private JPanel mainPanel;
	private JPanel listsPanel;
	private JTable tablesList;
	private JTable usersList;
	private DefaultTableModel tablesListModel;
	private DefaultTableModel usersListModel;
	private JMenuBar menuBar;
	private JScrollPane usersScrollPane;
	private JScrollPane tablesScrollPane;
	private StatusBar statusBar;

	/** Konstruktor klasy TableAndUserWindow */
	public TableAndUserWindow(AppLogic appLogic) {
		this.appLogic = appLogic;
		init();
		setTitle("Literaki - Tables & Users");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/** Inicjuję klasę TableAndUserWindow **/
	public void init() {
		mainPanel = new JPanel();
		listsPanel = new JPanel();
		tablesListModel = new DefaultTableModel(new Object[] { "Number",
				"Time", "1st player", "2nd player" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		usersListModel = new DefaultTableModel(new Object[] { "Username",
				"Rank", "Playing" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tablesList = new JTable(tablesListModel);
		usersList = new JTable(usersListModel);
		usersScrollPane = new JScrollPane();
		tablesScrollPane = new JScrollPane();
		menuBar = new JMenuBar();
		statusBar = new StatusBar();
		JMenu menuGame = new JMenu("Game");
		JMenu menuHelp = new JMenu("Help");
		JMenuItem createTableItem = new JMenuItem("Create new table");
		JMenuItem settingsItem = new JMenuItem("Settings...");
		JMenuItem exitGameItem = new JMenuItem("Exit game");
		menuGame.add(createTableItem);
		menuGame.add(settingsItem);
		menuGame.addSeparator();
		menuGame.add(exitGameItem);
		menuBar.add(menuGame);
		menuBar.add(menuHelp);
		tablesScrollPane.getViewport().add(tablesList);
		tablesScrollPane.setPreferredSize(new Dimension(400, 300));
		usersScrollPane.getViewport().add(usersList);
		usersScrollPane.setPreferredSize(new Dimension(220, tablesScrollPane
				.getHeight()));

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(tablesScrollPane);
		mainPanel.add(usersScrollPane);

		// addTablesItem(512, 12, "John", "Mark");
		// addTablesItem(31, 5, "Steven", "asd");

		getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
		setJMenuBar(menuBar);

		mainPanel.add(tablesScrollPane);
		mainPanel.add(usersScrollPane);
		add(mainPanel);
		pack();

		exitGameItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		createTableItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameWindow win = new GameWindow(appLogic);
				win.setVisible(true);
			}
		});

		appLogic.getConnection().addUsersAtTableListListener(
				new UsersAtTableListListener() {

					@Override
					public void usersAtTableList(List<User> users) {

						System.out.println("przyszło");

						for (User u : users)
							addUsersItem(u);

					}
				});
	}

	/** Dodaje nowy stół do tabeli */
	public void addTablesItem(int tableNumber, int time, String firstPlayer,
			String secondPlayer) {
		tablesListModel.addRow(new Object[] { "#" + tableNumber, time + " min",
				firstPlayer, secondPlayer });
	}

	public void addUsersItem(User u) {
		usersListModel.addRow(new Object[] { u.getUsername(),
				u.getRankingPosition(), u.getTableAt() });
	}
}

/** Klasa wyświetlająca pasek statusu */
@SuppressWarnings("serial")
class StatusBar extends JLabel {
	public StatusBar() {
		super();
		setMessage("Ready");
	}

	/** Ustawia tekst w polu statusu */
	public void setMessage(String message) {
		setText(message);
	}
}