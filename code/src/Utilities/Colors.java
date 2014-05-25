package Utilities;

import java.awt.Color;

public class Colors {
	public static final Color fieldWhite = Color.WHITE;
	public static final Color fieldYellow = new Color(255, 255, 0, 50);
	public static final Color fieldGreen = new Color(0, 255, 0, 50);
	public static final Color fieldBlue = new Color(0, 0, 255, 50);
	public static final Color fieldRed = new Color(255, 0, 0, 50);

	public static final Color tileWhite = new Color(235, 235, 235, 255);
	public static final Color tileYellow = new Color(235, 235, 0, 255);
	public static final Color tileGreen = new Color(0, 235, 0, 255);
	public static final Color tileBlue = new Color(0, 0, 235, 255);
	public static final Color tileRed = new Color(235, 0, 0, 255);

	public static final Color tileBorderWhite = new Color(192, 192, 192, 255);
	public static final Color tileBorderYellow = new Color(192, 192, 0, 255);
	public static final Color tileBorderGreen = new Color(0, 192, 0, 255);
	public static final Color tileBorderBlue = new Color(0, 0, 192, 255);
	public static final Color tileBorderRed = new Color(192, 0, 0, 255);

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
