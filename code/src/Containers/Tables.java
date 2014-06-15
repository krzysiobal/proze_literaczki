package Containers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/** kolekcja stolow */
public class Tables {
	/** lista stolow */
	List<Table> list = new LinkedList<Table>();

	/** tablica haszujaca - dla szybkiego dostepu do stolu po numerze */
	ConcurrentHashMap<Integer, Table> map = new ConcurrentHashMap<Integer, Table>();

	/** zwraca liste stolow */
	public List<Table> getList() {
		return list;
	}

	/** usuwa stol o podanym numerze */
	public void deleteTable(int number) {
		if (map.containsKey(number)) {
			list.remove(map.get(number));
			map.remove(number);
		}
	}

	/** dodaje stoly */
	public void addTables(Collection<Table> tables) {
		map.clear();
		list.clear();
		for (Table t : tables) {
			map.put(t.getNumber(), t);
			list.add(t);
		}
	}

	/** aktualizuje stol */
	public void addUpdateTable(Table t) {
		if (!map.containsKey(t.getNumber())) {
			map.put(t.getNumber(), t);
			list.add(t);
		} else {
			Table tt = map.get(t.getNumber());
			tt.setGameTime(t.getGameTime());
			tt.setRanked(t.isRanked());
			tt.setTableAvailability(t.getTableAvailability());
			tt.setTableProperties(t.getTableProperties());
			tt.setUsersAtTable(t.getUsersAtTable());

		}
	}

	/** zwraca stol o podanym numerze */
	public Table getTable(int number) {
		return map.get(number);
	}
}
