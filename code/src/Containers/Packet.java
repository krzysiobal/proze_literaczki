package Containers;

public class Packet {
	int[] numbers;
	String[] strings;

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

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
