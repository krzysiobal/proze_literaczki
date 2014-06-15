package Containers;

/** reprezentuje położoną literę na planszy, wchodzaca w skład słowa w ruchu **/
public class MoveTile {
	/** wspolrzedna x na planszy: 0 - 14 */
	int x;

	/** wspolrzedna y na planszy: 0 - 14 */
	int y;

	/** indeks litery, np 2-A, 3-Ą */
	int letter;

	/** zwraca wspolrzedna x na planszy: 0 - 14 */
	public int getX() {
		return x;
	}

	/** ustawia wspolrzedna x na planszy: 0 - 14 */
	public void setX(int x) {
		this.x = x;
	}

	/** zwraca wspolrzedna y na planszy: 0 - 14 */
	public int getY() {
		return y;
	}

	/** ustawia wspolrzedna y na planszy: 0 - 14 */
	public void setY(int y) {
		this.y = y;
	}

	/** zwraca indeks litery, np 2-A, 3-Ą */
	public int getLetter() {
		return letter;
	}

	/** ustawia indeks litery, np 2-A, 3-Ą */
	public void setLetter(int letter) {
		this.letter = letter;
	}

}
