package Containers;

/** Klasa przechowująca dane o użytkowinku */
public class User {
	/** nick */
	private String username;

	/** pozycja rankingowa */
	private int rankingPosition;

	/** numer stol una ktorym przebywa */
	private int tableAt;

	/** narodowosc */
	private String nationality;

	/** Konstruktor klasy */
	public User(String username, int rankingPosition, int tableAt,
			String nationality) {
		this.username = username;
		this.rankingPosition = rankingPosition;
		this.tableAt = tableAt;
		this.nationality = nationality;
	}

	/** Ustawia nazwe użytkownika */
	public void setUsername(String username) {
		this.username = username;
	}

	/** Ustawia ilość punktów rankingowych uzytkownika */
	public void setRankingPosition(int rankingPosition) {
		this.rankingPosition = rankingPosition;
	}

	/**
	 * Zwraca stół, na którym przebywa użytkownik lub null, gdy przy żadnym
	 * stole nie siedzi
	 */
	public int getTableAt() {
		return tableAt;
	}

	/** Ustawia stół, na którym przebywa użytkownik */
	public void setTableAt(int tableAt) {
		this.tableAt = tableAt;
	}

	/** Zwraca nazwę użytkownika */
	public String getUsername() {
		return username;
	}

	/** Zwraca ilość punktów użytkownika */
	public int getRankingPosition() {
		return rankingPosition;
	}

	/** Zwraca narodowość użytkownika */
	public String getNationality() {
		return nationality;
	}

	/** Ustawia narodowość użytkownika */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

}