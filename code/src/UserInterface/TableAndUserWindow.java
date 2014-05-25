package UserInterface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Containers.Room;
import Containers.Table;
import Containers.User;
import Listeners.RoomListListener;
import Listeners.TablesInRoomListListener;
import Listeners.UsersInRoomListListener;

/** Klasa wyświetlająca okno z listą stołów i użytkowników */
@SuppressWarnings("serial")
public class TableAndUserWindow extends JFrame {
	private AppLogic appLogic;
	private JComboBox roomsListCombo;
	private JPanel mainPanel;
	private JPanel tablesUsersPanel;
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
		roomsListCombo = new JComboBox<Room>();
		tablesUsersPanel = new JPanel();
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
		// TODO - sortowanie listy użytkowników (po nickach) i stołów (po
		// numerach)
		//
		// TableRowSorter<DefaultTableModel> usersListSorter = new
		// TableRowSorter<DefaultTableModel>(
		// usersListModel);
		// usersListSorter.setSortsOnUpdates(true);
		// usersList.setRowSorter(usersListSorter);

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

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(roomsListCombo);
		mainPanel.add(tablesUsersPanel);

		tablesUsersPanel.setLayout(new BoxLayout(tablesUsersPanel,
				BoxLayout.X_AXIS));

		tablesUsersPanel.add(tablesScrollPane);
		tablesUsersPanel.add(usersScrollPane);

		getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
		setJMenuBar(menuBar);

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
				win.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				win.setVisible(true);
			}
		});

		tablesList.addMouseListener(new MouseListener() {

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
				GameWindow win = new GameWindow(appLogic);
				win.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				win.setVisible(true);
			}
		});

		appLogic.getConnection().addListener(new UsersInRoomListListener() {
			@Override
			public void usersInRoomList(List<User> users) {
				appLogic.getGameRoomData().setUsers(users);
				for (User u : users)
					addUsersItem(u);

			}
		});

		appLogic.getConnection().addListener(new TablesInRoomListListener() {
			@Override
			public void tablesInRoomList(List<Table> tables) {
				appLogic.getGameRoomData().setTables(tables);
				for (Table t : tables)
					addTablesItem(t);

			}
		});

		appLogic.getConnection().addListener(new RoomListListener() {
			@Override
			public void roomsList(List<Room> rooms, int currentRoomIndex) {
				appLogic.getGameRoomData().setRooms(rooms);
				appLogic.getGameRoomData()
						.setCurrentRoomIndex(currentRoomIndex);
				roomsListCombo.removeAllItems();

				for (Room r : rooms)
					roomsListCombo.addItem(r.getDetails());

				roomsListCombo.setSelectedIndex(currentRoomIndex);

				roomsListCombo.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent arg0) {
						if (arg0.getStateChange() == ItemEvent.SELECTED) {
							appLogic.getConnection().joinRoom(
									((String) arg0.getItem()));
						}
					}
				});
			}
		});

	}

	/** Dodaje nowy stół do tabeli */
	public void addTablesItem(Table t) {
		String firstPlayer = "";
		String secondPlayer = "";
		if (t.getUsersAtTable() != null) {
			if (t.getUsersAtTable().length >= 1)
				firstPlayer = t.getUsersAtTable()[0];
			if (t.getUsersAtTable().length >= 2)
				secondPlayer = t.getUsersAtTable()[1];
		}

		tablesListModel.addRow(new Object[] { "#" + t.getNumber(),
				t.getGameTime() + " min", firstPlayer, secondPlayer });
	}

	public void addUsersItem(User u) {
		usersListModel.addRow(new Object[] { u.getUsername(),
				u.getRankingPosition(),
				u.getTableAt() == 0 ? "-" : u.getTableAt() });
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