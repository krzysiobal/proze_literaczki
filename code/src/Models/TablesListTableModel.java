package Models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Containers.Table;
import Containers.Tables;

@SuppressWarnings("serial")
public class TablesListTableModel extends AbstractTableModel {
	private String[] columnNames = { "Number", "Time", "1st player",
			"2nd player" };
	List<Table> tables;

	public TablesListTableModel(Tables tables) {
		this.tables = tables.getList();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public int getRowCount() {
		return tables.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public Table getTable(int rowIndex) {
		return tables.get(rowIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Table t = tables.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return "#" + Integer.toString(t.getNumber());
		case 1:
			return t.getGameTime();
		case 2:
			return t.getUsersAtTable()[0];
		case 3:
			return t.getUsersAtTable()[1];
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
		case 3:
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