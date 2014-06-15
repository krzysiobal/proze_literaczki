package Models;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Containers.Table;
import Containers.Tables;

/** klasa uzywana przy wyswietlaniu listy stolow */
@SuppressWarnings("serial")
public class TablesListTableModel extends AbstractTableModel {
	/** kolumny na liscie */
	private String[] columnNames = { "Number", "Time", "1st player",
			"2nd player" };

	/** dane o stolach */
	List<Table> tables;

	/** konstruktor */
	public TablesListTableModel(Tables tables) {
		this.tables = tables.getList();
	}

	/** zwraca kolumne o podanym indeksie */
	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	/** zwraca ilosc wierszy */
	@Override
	public int getRowCount() {
		return tables.size();
	}

	/** zwraca ilosc kolumn */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/** zwraca stol w danym wierszu */
	public Table getTable(int rowIndex) {
		return tables.get(rowIndex);
	}

	/** zwraca wartosc komorki */
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
		case 3:
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