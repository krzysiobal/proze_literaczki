package UserInterface;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Exceptions.ConfigFileParseException;

/** Główna klasa aplikacji, zawierająca logikę */
public class Main {

	/** główna pętla aplikacji */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final AppLogic appLogic = new AppLogic();
				try {
					appLogic.getConfigFile().parse("settings.ini");
					LoginWindow mw = new LoginWindow(appLogic);
					mw.setVisible(true);
					mw.setAutoRequestFocus(true);

				} catch (ConfigFileParseException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});
	}
}