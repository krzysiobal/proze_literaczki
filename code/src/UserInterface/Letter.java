package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

/** Klasa reprezentująca pole z literką */
@SuppressWarnings("serial")
public class Letter extends JButton {
	/** Zmienna przechowująca kolor pola */
	private Color color;

	/** Zmienna przechowująca tekst pola (literkę) */
	private String text;

	/** Konstruktor pola */
	public Letter(Color color, String text) {
		super(text);
		this.text = text;
		this.color = color;
		setFieldProperties();
	}

	/** Ustawia właściwości przycisku */
	public void setFieldProperties() {
		setPreferredSize(new Dimension(30, 30));
		setFont(new Font("Droid Sans Mono", Font.BOLD, 16));
		setBackground(color);
		setBorder(null);
		setEnabled(true);
	}

	/** Zwraca kolor pola */
	public Color getColor() {
		return color;
	}

	/** Zwraca literkę pola */
	public String getText() {
		return text;
	}

	/** Ustawia literkę pola */
	public void setText(String text) {
		this.text = text;
	}

	/** Ustawia kolor pola */
	public void setColor(Color color) {
		this.color = color;
	}
}