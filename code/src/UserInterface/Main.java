package UserInterface;

import javax.swing.SwingUtilities;

import Exceptions.ConfigFileParseException;

/** Główna klasa aplikacji, zawierająca logikę */
public class Main {

	/** główna pętla aplikacji */
	public static void main(String[] args) {
		final AppLogic appLogic = new AppLogic();
		try {
			appLogic.getConfigFile().parse(
					"e:\\Pulpit\\proze-literaczki\\repo\\code\\settings.ini");

		} catch (ConfigFileParseException ex) {
			System.out.println(ex.getMessage());
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				LoginWindow mw = new LoginWindow(appLogic);
				mw.setVisible(true);
				mw.setAutoRequestFocus(true);
			}
		});
	}
}