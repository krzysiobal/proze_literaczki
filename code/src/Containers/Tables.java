package Containers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Tables {
	List<Table> list = new LinkedList<Table>();

	// dla szybkiego dostepu do uzytkownika po nazwie
	ConcurrentHashMap<Integer, Table> map = new ConcurrentHashMap<Integer, Table>();

	public List<Table> getList() {
		return list;
	}

	public void deleteTable(int number) {
		if (map.containsKey(number)) {
			list.remove(map.get(number));
			map.remove(number);
		}
	}

	public void addTables(Collection<Table> tables) {
		map.clear();
		list.clear();
		for (Table t : tables) {
			map.put(t.getNumber(), t);
			list.add(t);
		}
	}

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

	public Table getTable(int number) {
		return map.get(number);
	}
}
