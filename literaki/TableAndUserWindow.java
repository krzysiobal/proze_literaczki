package UserInterface;

import java.awt.Dimension;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Main.ApplicationLogic;

public class TableAndUserWindow extends JFrame {
	private ApplicationLogic appLogic;
	private JPanel mainPanel;
	private JPanel listsPanel;
	private JList tablesList;
	private JList usersList;
	private JMenuBar menuBar;
	private JScrollPane usersScrollPane;
	private JScrollPane tablesScrollPane;
	private StatusBar statusBar;
	
	public TableAndUserWindow() {
		initUI();
		setTitle("Literaki - Tables & Users");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
	}
	
	public final void initUI() {
		mainPanel = new JPanel();
		listsPanel = new JPanel();
		tablesList = new JList();
		usersList = new JList();
		usersScrollPane = new JScrollPane();
		tablesScrollPane = new JScrollPane();
		menuBar = new JMenuBar();
		statusBar = new StatusBar();
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		
		tablesScrollPane.getViewport().add(tablesList);
		//tablesScrollPane.setPreferredSize(new Dimension(400, 300));
		usersScrollPane.getViewport().add(usersList);
		usersScrollPane.setPreferredSize(new Dimension(200, tablesScrollPane.getHeight()));
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(tablesScrollPane);
		mainPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		mainPanel.add(usersScrollPane);
		
		getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
		setJMenuBar(menuBar);
		add(mainPanel);
		pack();
	}
}

class StatusBar extends JLabel {
	public StatusBar() {
		super();
		setMessage("Ready");
	}
	
	public void setMessage(String message) {
		setText(message);
	}
}