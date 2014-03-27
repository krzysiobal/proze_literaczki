package Containers;

public class User {
	private String username;
	private int rankingPosition;
	private Table tableAt;
	private String nationality;
	
	public User(String username, int rankingPosition, Table tableAt) {
		this.username = username;
		this.rankingPosition = rankingPosition;
		this.tableAt = tableAt;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setRankingPosition(int rankingPosition) {
		this.rankingPosition = rankingPosition;
	}

	public Table getTableAt() {
		return tableAt;
	}

	public void setTableAt(Table tableAt) {
		this.tableAt = tableAt;
	}

	public String getUsername() {
		return username;
	}

	public int getRankingPosition() {
		return rankingPosition;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}