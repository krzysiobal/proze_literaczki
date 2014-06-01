package Models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Containers.User;
import Containers.Users;

@SuppressWarnings("serial")
public class UsersListTableModel extends AbstractTableModel {
	private String[] columnNames = { "Username", "Rank", "At table" };
	List<User> users;

	public UsersListTableModel(Users users) {
		this.users = users.getList();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public User getUser(int rowIndex) {
		return users.get(rowIndex);
	}

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

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}