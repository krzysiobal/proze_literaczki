package Containers;

/** Przechowuje informacje o jednym z dostępnych pokojów */
public class Room {
	/** numer pokoju (np. 102) */
	int number;

	/** nazwa pokoju */
	String name;

	/** pelny opis: nazwa i numer pokoju oraz ilosc wolnych miejc */
	String details;

	/** zwraca numer pokoju (np. 102) */
	public int getNumber() {
		return number;
	}

	/** ustawia numer pokoju (np. 102) */
	public void setNumber(int number) {
		this.number = number;
	}

	/** zwraca nazwe pokoju */
	public String getName() {
		return name;
	}

	/** ustawia nazwe pokoju */
	public void setName(String name) {
		this.name = name;
	}

	/** zwraca pelny opis: nazwa i numer pokoju oraz ilosc wolnych miejc */
	public String getDetails() {
		return details;
	}

	/** ustawia pelny opis: nazwa i numer pokoju oraz ilosc wolnych miejc */
	public void setDetails(String details) {
		this.details = details;
	}
}