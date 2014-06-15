package Containers;

/** klasa reprezentujaca pakiet wysylany/odbierany od serwera */
public class Packet {
	/** tablica liczb w pakiecie */
	int[] numbers;

	/** tablica ciagow znakow w pakiecie */
	String[] strings;

	/** zwraca tablice liczb w pakiecie */
	public int[] getNumbers() {
		return numbers;
	}

	/** ustawia tablice liczb w pakiecie */
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	/** zwraca tablice ciagow znakow w pakiecie */
	public String[] getStrings() {
		return strings;
	}

	/** ustawia tablice ciagow znakow w pakiecie */
	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	/** zwraca tekstowa reprezentacje pakietu */
	@Override
	public String toString() {
		String result = "PAKIET: numbers = " + numbers.length + ", strings = "
				+ strings.length + "\n        ";
		for (int n : numbers)
			result += String.format("0x%04x", n) + ", ";
		result += "\n        ";
		for (String s : strings)
			result += s + ", ";

		return result;
	}

}
