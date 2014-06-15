package UserInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

/** literka z mozliwoscia prezciagania */
@SuppressWarnings("serial")
public class DraggableField extends Field implements MouseListener,
		MouseMotionListener {
	JFrame frame;
	Point offset = new Point();
	boolean dragging = false;
	Point origLoc, newLoc;
	Field f;

	/** konstruktor */
	public DraggableField(Color color, String text, JFrame frame) {
		super(color, text);
		this.frame = frame;
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
		f = new Field(Color.RED, "bla");
		frame.add(f);
		f.setBounds(getBounds());
		dragging = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// JLabel label = new JLabel(new ImageIcon(selectedImage));
		// label.setBorder(BorderFactory.createEtchedBorder());
		// mainPanel.add(label);
		// Point p = SwingUtilities.convertPoint(df, r.x, r.y, frame);
		// label.setBounds(p.x, p.y, r.width, r.height);
		// mainPanel.repaint();
		// df.setBounds(p.x, p.y, r.width, r.height);
		dragging = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (dragging) {
			newLoc = getLocation();
			newLoc.x += e.getX() - offset.x;
			newLoc.y += e.getY() - offset.y;
			f.setLocation(newLoc);
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
