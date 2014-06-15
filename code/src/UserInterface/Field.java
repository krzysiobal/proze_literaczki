package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Klasa reprezentująca pole, dziedzicząca po JButton. Domyślnie granice
 * tekstowe pola są wyłączone oraz przycisk jest nieaktywny
 */
@SuppressWarnings("serial")
public class Field extends JButton {
	/** Zmienna przechowująca kolor przycisku */
	private Color color;

	/** Zmienna przechowująca tekst wyświetlany przez przycisk */
	private String text;

	/** Konstruktor pola */
	public Field(Color color, String text) {
		super(text);
		this.text = text;
		this.color = color;
		setFieldProperties();
	}

	/** Ustawia właściwości przycisku */
	public void setFieldProperties() {
		setPreferredSize(new Dimension(30, 30));
		setFont(new Font("Droid Sans Mono", Font.BOLD, 24));
		setBackground(color);
		setBorder(new LineBorder(new Color(192, 192, 192), 1));
		setEnabled(false);
	}

	/** Zwraca kolor pola */
	public Color getColor() {
		return color;
	}

	/** Zwraca literkę na polu */
	public String getText() {
		return text;
	}

	/** Ustawia literkę na polu */
	public void setText(String text) {
		this.text = text;
	}

	/** Ustawia kolor pola */
	public void setColor(Color color) {
		this.color = color;
	}
}