package Models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Containers.User;
import Containers.Users;

/** klasa uzywana przy wyswietlaniu listy uzytkownikow */
@SuppressWarnings("serial")
public class UsersListTableModel extends AbstractTableModel {
	/** kolumny na liscie */
	private String[] columnNames = { "Username", "Rank", "At table" };

	/** dane o uzytkownikach */
	List<User> users;

	/** konstruktor */
	public UsersListTableModel(Users users) {
		this.users = users.getList();
	}

	/** zwraca kolumne o podanym indeksie */
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	/** zwraca ilosc wierszy */
	@Override
	public int getRowCount() {
		return users.size();
	}

	/** zwraca ilosc kolumn */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/** zwraca uzytkownika w danym wierszu */
	public User getUser(int rowIndex) {
		return users.get(rowIndex);
	}

	/** zwraca wartosc komorki */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User u = users.get(rowIndex);
		switch (columnIndex) {
		case -1:
			return u;
		case 0:
			return u.getUsername();
		case 1:
			return Integer.toString(u.getRankingPosition());
		case 2:
			return u.getTableAt() == 0 ? "-" : Integer.toString(u.getTableAt());
		default:
			return null;
		}
	}

	/** zwraca typ klasy przechowywanej w danej kolumnie */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		default:
			return null;
		}
	}

	/** czy komorke mozne edytowac */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}