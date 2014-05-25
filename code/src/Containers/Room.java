package Containers;

/** Przechowuje informacje o jednym ze dostępnych pokojów */
public class Room {
	int number;
	String name;
	String details;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		// return getDetails();
		return super.toString();
	}

}