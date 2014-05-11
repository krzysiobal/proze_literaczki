package UserInterface;

import javax.swing.SwingUtilities;

/** Główna klasa aplikacji */
public class LiterakiClient {
	/** zmienna przechowywująca nazwę użytkownika */
	private String username;

	/** zmienna przechowywująca hasło użytkownika */
	private String password;

	/** główna pętla aplikacji */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainWindow mw = new MainWindow();
				mw.setVisible(true);
				mw.setAutoRequestFocus(true);

				// TableAndUserWindow t = new TableAndUserWindow();
				// t.setVisible(true);
				// t.setAutoRequestFocus(true);
			}
		});
	}
}