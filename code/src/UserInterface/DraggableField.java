package UserInterface;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** literka z mozliwoscia prezciagania */
@SuppressWarnings("serial")
public class DraggableField extends Field implements MouseListener,
		MouseMotionListener {
	JFrame frame;
	JPanel panel;
	Point offset = new Point();
	boolean dragging = false;
	Point origLoc, newLoc = null;
	JLabel label;

	/** konstruktor */
	public DraggableField(Color color, String text, JFrame frame, JPanel panel) {
		super(color, text);
		this.frame = frame;
		this.panel = panel;
		origLoc = getLocation();
		newLoc = getLocation();
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		origLoc = getLocation();
		newLoc = getLocation();
		offset.x = e.getLocationOnScreen().x - getLocationOnScreen().x;
		offset.y = e.getLocationOnScreen().y - getLocationOnScreen().y;

		// panel.remove(this);
		dragging = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int steps = (int) (Math.sqrt((newLoc.x - origLoc.x)
						* (newLoc.x - origLoc.x) + (newLoc.y - origLoc.y)
						* (newLoc.y - origLoc.y)) / 4);
				if (steps == 0)
					steps = 1;
				for (int i = steps; i >= 0; --i) {
					int x = origLoc.x + ((newLoc.x - origLoc.x) * i / steps)
							+ (int) (20 * Math.sin(2 * Math.PI * i / steps));
					int y = origLoc.y + ((newLoc.y - origLoc.y) * i / steps)
							+ (int) (20 * Math.sin(2 * Math.PI * i / steps));

					setLocation(new Point(x, y));
					try {
						Thread.sleep(20);
					} catch (Exception ex) {

					}
				}

			}
		}).start();
		dragging = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragging) {
			newLoc = getLocation();
			newLoc.x += e.getX() - offset.x;
			newLoc.y += e.getY() - offset.y;
			setLocation(newLoc);

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
