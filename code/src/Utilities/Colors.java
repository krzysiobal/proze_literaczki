package Utilities;

import java.awt.Color;

/** dane o kolorach */
public class Colors {
	/** bialy kolor pola */
	public static final Color fieldWhite = Color.WHITE;

	/** zolty kolor pola */
	public static final Color fieldYellow = new Color(240, 240, 192, 255);

	/** zielony kolor pola */
	public static final Color fieldGreen = new Color(192, 240, 191, 255);

	/** niebieski kolor pola */
	public static final Color fieldBlue = new Color(192, 192, 240, 255);

	/** czerwony kolor pola */
	public static final Color fieldRed = new Color(240, 191, 191, 255);

	/** bialy kolor kafelka z literka */
	public static final Color tileWhite = new Color(235, 235, 235, 255);

	/** zolty kolor kafelka z literka */
	public static final Color tileYellow = new Color(235, 235, 0, 255);

	/** zielony kolor kafelka z literka */
	public static final Color tileGreen = new Color(0, 235, 0, 255);

	/** niebieski kolor kafelka z literka */
	public static final Color tileBlue = new Color(0, 0, 235, 255);

	/** czerwony kolor kafelka z literka */
	public static final Color tileRed = new Color(235, 0, 0, 255);

	/** bialy kolor obwodki kolor kafelka z literka */
	public static final Color tileBorderWhite = new Color(192, 192, 192, 255);

	/** zolty kolor obwodki kolor kafelka z literka */
	public static final Color tileBorderYellow = new Color(192, 192, 0, 255);

	/** zielony kolor obwodki kolor kafelka z literka */
	public static final Color tileBorderGreen = new Color(0, 192, 0, 255);

	/** niebieski kolor obwodki kolor kafelka z literka */
	public static final Color tileBorderBlue = new Color(0, 0, 192, 255);

	/** czerwony kolor obwodki kolor kafelka z literka */
	public static final Color tileBorderRed = new Color(192, 0, 0, 255);

	/** zwraca kolor kafelka z literka dla podanej liczby punktow za literke */
	public static Color getLetterTileColor(int letterPoints) {
		if (letterPoints == 1)
			return tileYellow;
		else if (letterPoints == 2)
			return tileGreen;
		else if (letterPoints == 3)
			return tileBlue;
		else if (letterPoints == 5)
			return tileRed;
		else
			return tileWhite;
	}

	/**
	 * zwraca kolor obwodki kafelka z literka dla podanej liczby punktow za
	 * literke
	 */
	public static Color getLetterTileBorderColor(int letterPoints) {
		if (letterPoints == 1)
			return tileBorderYellow;
		else if (letterPoints == 2)
			return tileBorderGreen;
		else if (letterPoints == 3)
			return tileBorderBlue;
		else if (letterPoints == 5)
			return tileBorderRed;
		else
			return tileBorderWhite;
	}

}
