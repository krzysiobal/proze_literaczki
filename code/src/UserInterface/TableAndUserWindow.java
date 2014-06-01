package UserInterface;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
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

import Containers.Move;
import Containers.Room;
import Containers.Table;
import Containers.User;
import Listeners.GameWindowListener;
import Listeners.IncomingPrivateChatMessageListener;
import Listeners.UsersTablesRoomsListener;
import Models.TablesListTableModel;
import Models.UsersListTableModel;

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
	private TablesListTableModel tablesListModel;
	private UsersListTableModel usersListModel;
	private JMenuBar menuBar;
	private JScrollPane usersScrollPane;
	private JScrollPane tablesScrollPane;
	private StatusBar statusBar;

	HashMap<String, ChatWithUserWindow> chatWindows = new HashMap<String, ChatWithUserWindow>();
	HashMap<Integer, GameWindow> gameWindows = new HashMap<Integer, GameWindow>();

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
		roomsListCombo.disable();
		roomsListCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED
						&& roomsListCombo.isEnabled()) {
					appLogic.getConnection()
							.joinRoom(((String) arg0.getItem()));
				}
			}
		});

		usersScrollPane = new JScrollPane();
		usersListModel = new UsersListTableModel(appLogic.getGameRoomData()
				.getUsers());
		usersList = new JTable(usersListModel);
		usersScrollPane.getViewport().add(usersList);
		usersScrollPane.setPreferredSize(new Dimension(300, 300));

		tablesScrollPane = new JScrollPane();
		tablesUsersPanel = new JPanel();
		tablesListModel = new TablesListTableModel(appLogic.getGameRoomData()
				.getTables());
		tablesList = new JTable(tablesListModel);
		tablesScrollPane.getViewport().add(tablesList);
		tablesScrollPane.setPreferredSize(new Dimension(400, 300));

		mainPanel = new JPanel();
		listsPanel = new JPanel();

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
				GameWindow win = new GameWindow(appLogic, 0);
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
				JTable target = (JTable) arg0.getSource();
				int row = target.getSelectedRow();
				int tableNo = tablesListModel.getTable(row).getNumber();
				appLogic.getConnection().enterTable(tableNo);
			}
		});

		usersList.addMouseListener(new MouseListener() {

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
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable) e.getSource();
				int row = target.getSelectedRow();
				String userName = usersListModel.getUser(row).getUsername();

				if (!chatWindows.containsKey(userName))
					chatWindows.put(userName, new ChatWithUserWindow(appLogic,
							userName));

				chatWindows.get(userName).setVisible(true);
			}
		});

		appLogic.getConnection().addListener(
				new IncomingPrivateChatMessageListener() {
					@Override
					public void incomingPrivateChatMessage(String message,
							String from) {

						if (!chatWindows.containsKey(from))
							chatWindows.put(from, new ChatWithUserWindow(
									appLogic, from));

						chatWindows.get(from).addToChat(message);
						appLogic.getConnection()
								.acknowledgePrivateChatMessages(from);
						chatWindows.get(from).setVisible(true);
					}
				});

		appLogic.getConnection().addListener(new UsersTablesRoomsListener() {
			@Override
			public void usersInRoomList(List<User> users) {
				synchronized (this) {
					appLogic.getGameRoomData().getUsers().addUsers(users);
					usersListModel.fireTableDataChanged();
				}
			}

			@Override
			public void userUpdate(User user) {
				synchronized (this) {
					appLogic.getGameRoomData().getUsers().addUpdateUser(user);
					usersListModel.fireTableDataChanged();
				}
			}

			@Override
			public void userLeaves(String username) {
				synchronized (this) {
					appLogic.getGameRoomData().getUsers().deleteUser(username);
					usersListModel.fireTableDataChanged();
				}
			}

			@Override
			public void tablesInRoomList(List<Table> tables) {
				synchronized (this) {
					appLogic.getGameRoomData().getTables().addTables(tables);
					tablesListModel.fireTableDataChanged();
				}
			}

			@Override
			public void tableUpdate(Table table) {
				synchronized (this) {
					appLogic.getGameRoomData().getTables()
							.addUpdateTable(table);
					tablesListModel.fireTableDataChanged();
				}
			}

			@Override
			public void tableCloses(int number) {
				synchronized (this) {
					appLogic.getGameRoomData().getTables().deleteTable(number);
					tablesListModel.fireTableDataChanged();
				}
			}

			@Override
			public void roomsList(final List<Room> rooms,
					final int currentRoomIndex) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						appLogic.getGameRoomData().setRooms(rooms);
						appLogic.getGameRoomData().setCurrentRoomIndex(
								currentRoomIndex);

						roomsListCombo.disable();
						roomsListCombo.removeAllItems();

						for (Room r : rooms)
							roomsListCombo.addItem(r.getDetails());

						roomsListCombo.setSelectedIndex(currentRoomIndex);
						roomsListCombo.enable();
					}
				});
			}
		});

		appLogic.getConnection().addListener(new GameWindowListener() {
			@Override
			public void tableSettings(int tableNo, String operatorNickname) {
			}

			@Override
			public void openGameWindow(int tableNo) {
				if (!gameWindows.containsKey(tableNo))
					gameWindows.put(tableNo, new GameWindow(appLogic, tableNo));
				gameWindows.get(tableNo).setVisible(true);
			}

			@Override
			public void gameMoves(int tableNo, List<Move> moves) {
				gameWindows.get(tableNo).setMoves(moves);
			}
		});
	}

	/** Dodaje nowy stół do tabeli */
	public void addTablesItem(final Table t) {
		synchronized (this) {
			appLogic.getGameRoomData().getTables().addUpdateTable(t);
			tablesListModel.fireTableDataChanged();
		}
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