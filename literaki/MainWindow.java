package UserInterface;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
		setTitle("Literaki - Logging in / Registration");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setResizable(false);
	}
	
	/*
	 *  Sets up layout of the login / registraion frame
	 */
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
		checkBox.setText("Registration");
		
		//layouty
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		//textPanel.setLayout();
		//buttonPanel.setLayout();
		
		//dodawanie do panelu
		GridLayout gridLayout = new GridLayout(3, 2);
		gridLayout.setVgap(10);
		textPanel.setLayout(gridLayout);
		textPanel.add(usernameLabel);
		textPanel.add(usernameTextField);
		textPanel.add(passwordLabel);
		textPanel.add(passwordTextField);
		
		buttonPanel.add(btnLogin);
		buttonPanel.add(btnExit);
		buttonPanel.add(checkBox);
	
		mainPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		mainPanel.add(textPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 7)));
		mainPanel.add(buttonPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 7)));

		add(mainPanel);
		pack();
		
		//eventy
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkLogRegFormState()) {
					if (checkBox.isSelected()) {
						showMessageDialog("Registration successful.");
						showTablesAndUsers();
						
					}
					else {
						showMessageDialog("Logged in successfully.");
						showTablesAndUsers();
					}
				}
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
		
		mainPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mainPanel.requestFocus();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				mainPanel.requestFocus();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				mainPanel.requestFocus();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				mainPanel.requestFocus();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.requestFocus();
			}
			
		});
		
		mainPanel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
	}
	
	public boolean checkLogRegFormState() {
		boolean result = true;
		if (usernameTextField.getText().equals("")) {
			usernameLabel.setForeground(Color.RED);
			result = false;
		}
		else
			usernameLabel.setForeground(Color.BLACK);
		
		if (passwordTextField.getText().equals("")) {
			passwordLabel.setForeground(Color.RED);
			result = false;
		}
		else
			passwordLabel.setForeground(Color.BLACK);
		
		if (checkBox.isSelected())
			if (repeatPasswordTextField.getText().equals("")) {
				repeatPasswordLabel.setForeground(Color.RED);
				result = false;
			}
			else
				repeatPasswordLabel.setForeground(Color.BLACK);
		return result;
	}
	
	private void showMessageDialog(String dialogMessage) {
		JOptionPane.showMessageDialog(mainPanel, dialogMessage);
	}
	
	public void showTablesAndUsers() {
		TableAndUserWindow tableAndUserWindow = new TableAndUserWindow();
		tableAndUserWindow.setVisible(true);
		tableAndUserWindow.setAutoRequestFocus(true);
	}
}