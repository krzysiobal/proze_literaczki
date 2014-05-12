package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Okno wyświetlane tuż po uruchomieniu aplikacji (z polem na nazwę użytkownika
 * i hasło)
 */
@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

	/** Logika aplikacji */
	private AppLogic appLogic;

	/** Pole tekstowe przechowywujące nazwę użytkownika. */
	private JTextField usernameTextField;

	/** Pole przechowywujące hasło użytkownika. */
	private JPasswordField passwordTextField;

	/** Pole przechowywujące potwierdzenie hasła użytkownika. */
	private JPasswordField repeatPasswordTextField;

	/** Głowny panel okna. */
	private MainPanel mp;

	/** Panel, w którym umiejscowione pola tekstowe oraz ich oznaczenia. */
	private JPanel textPanel;

	/** Panel, w którym umiejscowione są przyciski zarządzające oknem. */
	private JPanel buttonPanel;

	/** Oznakowanie pola przechowywującego nazwę użytkownika. */
	private JLabel usernameLabel;

	/** Oznakowanie pola przechowywującego hasło użytkownika. */
	private JLabel passwordLabel;

	/** Oznakowanie pola przechowywującego potwierdzenie hasła użytkownika. */
	private JLabel repeatPasswordLabel;

	/** Przycisk logowania/rejestracji. */
	private JButton btnLogin;

	/** Przycisk wyjścia z aplikacji. */
	private JButton btnExit;

	/**
	 * Przełącznik zmieniający wygląd okna pomiędzy widokami
	 * logowanie/rejestracja.
	 */
	private JCheckBox checkBox;

	/** Konstruktor głównego okna logowania/rejestracji aplikacji. */
	public LoginWindow(AppLogic appLogic) {
		this.appLogic = appLogic;
		mp = new MainPanel();
		mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
		mp.add(Box.createRigidArea(new Dimension(0, 7)));
		mp.add(textPanel);
		mp.add(Box.createRigidArea(new Dimension(0, 7)));
		mp.add(buttonPanel);
		mp.add(Box.createRigidArea(new Dimension(0, 7)));
		add(mp);

		setTitle("Literaki - Logging in / Registration");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		setResizable(false);
	}

	/** Główny panel aplikacji. */
	class MainPanel extends JPanel {
		/**
		 * Konstruktor głównego panelu aplikacji, inicjuje wszystkie kontrolki
		 * oraz ustawia listenery.
		 */
		public MainPanel() {
			textPanel = new JPanel();
			buttonPanel = new JPanel();
			usernameTextField = new JTextField();
			usernameTextField.setText(appLogic.getConfigFile().getValue(
					"UserData", "Name"));
			passwordTextField = new JPasswordField();
			passwordTextField.setText(appLogic.getConfigFile().getValue(
					"UserData", "Password"));
			repeatPasswordTextField = new JPasswordField();
			btnLogin = new JButton("Log in");
			btnExit = new JButton("Exit");
			usernameLabel = new JLabel("Username: ");
			passwordLabel = new JLabel("Password: ");
			repeatPasswordLabel = new JLabel("Repeat password: ");
			checkBox = new JCheckBox();
			checkBox.setText("Registration");
			setupListeners();
		}

		/**
		 * Funkcja dodająca zdarzenia do przycisków btnExit, btnLogin oraz
		 * kontrolki checkBox.
		 */
		public void setupListeners() {
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

						} else {
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
						textPanel.add(repeatPasswordLabel, 4);
						textPanel.add(repeatPasswordTextField, 5);
						btnLogin.setText("Register");
						textPanel.updateUI();
						pack();

					} else {
						textPanel.remove(repeatPasswordLabel);
						textPanel.remove(repeatPasswordTextField);
						btnLogin.setText("Log in");
						textPanel.updateUI();
						pack();
					}
				}
			});
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			GridLayout gridLayout = new GridLayout(3, 2);
			gridLayout.setVgap(5);
			gridLayout.setHgap(-30);
			textPanel.setLayout(gridLayout);
			textPanel.add(usernameLabel, 0);
			textPanel.add(usernameTextField, 1);
			textPanel.add(passwordLabel, 2);
			textPanel.add(passwordTextField, 3);

			buttonPanel.add(btnLogin);
			buttonPanel.add(btnExit);
			buttonPanel.add(checkBox);

			pack();
		}

		/** Wyświetla okno z informacją dla użytkownika. */
		private void showMessageDialog(String dialogMessage) {
			JOptionPane.showMessageDialog(this, dialogMessage);
		}

		/** Funkcja uruchamiająca okno z tabelami stołów oraz użytkowników. */
		public void showTablesAndUsers() {
			dispose();
			TableAndUserWindow tableAndUserWindow = new TableAndUserWindow(
					appLogic);
			tableAndUserWindow.setVisible(true);
			tableAndUserWindow.setAutoRequestFocus(true);
		}

		/**
		 * sprawdza po kliknięciu na przycisk btnLogin, czy użytkownik wypełnił
		 * wszystkie pola. Jeśli nie, to koloruje oznakowania na czerwono.
		 */
		@SuppressWarnings("deprecation")
		public boolean checkLogRegFormState() {
			boolean result = true;
			if (usernameTextField.getText().equals("")) {
				usernameLabel.setForeground(Color.RED);
				result = false;
			} else
				usernameLabel.setForeground(Color.BLACK);

			if (passwordTextField.getText().equals("")) {
				passwordLabel.setForeground(Color.RED);
				result = false;
			} else
				passwordLabel.setForeground(Color.BLACK);

			if (checkBox.isSelected())
				if (repeatPasswordTextField.getText().equals("")) {
					repeatPasswordLabel.setForeground(Color.RED);
					result = false;
				} else
					repeatPasswordLabel.setForeground(Color.BLACK);
			return result;
		}
	}
}