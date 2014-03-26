package UserInterface;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jws.Oneway;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;

import Main.ApplicationLogic;

public class MainWindow extends JFrame {
	private ApplicationLogic appLogic;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JPasswordField repeatPasswordTextField;
	private JCheckBox registration;
	private JPanel mainPanel;
	private JPanel textPanel;
	private JPanel buttonPanel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel repeatPasswordLabel;
	private JButton btnLogin;
	private JButton btnExit;
	private JCheckBox checkBox;
	
	public MainWindow() {
		initUI();
		setTitle("Literaki - Logging in");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public final void initUI() {
		//inizjalizacja
		mainPanel = new JPanel();
		textPanel = new JPanel();
		buttonPanel = new JPanel();
		usernameTextField = new JTextField();
		passwordTextField = new JPasswordField();
		repeatPasswordTextField = new JPasswordField();
		btnLogin = new JButton("Log in");
		btnExit = new JButton("Exit");
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		repeatPasswordLabel = new JLabel("Repeat password: ");
		checkBox = new JCheckBox();
		checkBox.setText("Registration: ");
		
		//layouty
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		//textPanel.setLayout();
		//buttonPanel.setLayout();
		
		//dodawanie do panelu
		GridLayout gridLayout = new GridLayout(3, 2);
		gridLayout.setHgap(0);
		gridLayout.setVgap(5);
		textPanel.setLayout(gridLayout);
		textPanel.add(usernameLabel);
		textPanel.add(usernameTextField);
		textPanel.add(passwordLabel);
		textPanel.add(passwordTextField);
		
		buttonPanel.add(btnLogin);
		buttonPanel.add(btnExit);
		buttonPanel.add(checkBox);
		
		mainPanel.add(textPanel);
		mainPanel.add(buttonPanel);

		add(mainPanel);
		pack();
		
		//eventy
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		checkBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					textPanel.add(repeatPasswordLabel);
					textPanel.add(repeatPasswordTextField);
					btnLogin.setText("Register");
					textPanel.updateUI();
					pack();
				}
				else {
					textPanel.remove(repeatPasswordLabel);
					textPanel.remove(repeatPasswordTextField);
					btnLogin.setText("Log in");
					textPanel.updateUI();
				}
			}
		});
	}
}