package UserInterface;

import javax.swing.SwingUtilities;

public class LiterakiClient {
	private String username;
	private String password;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MainWindow mw = new MainWindow();
				mw.setVisible(true);
			}
		});
	}
}