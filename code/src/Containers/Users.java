package Containers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/** kolekcja uzytkownikow */
public class Users {
	/** lista uzytkownikow */
	List<User> list = new LinkedList<User>();

	/** tablica haszujaca dla szybkiego dostepu do uzytkownika po nazwie */
	ConcurrentHashMap<String, User> map = new ConcurrentHashMap<String, User>();

	/** zwraca liste uzytkownikow */
	public List<User> getList() {
		return list;
	}

	/** usuwa uzytkownika o podanym nicku */
	public void deleteUser(String username) {
		if (map.containsKey(username)) {
			list.remove(map.get(username));
			map.remove(username);
		}
	}

	/** dodaje uzytkownikow */
	public void addUsers(Collection<User> users) {
		map.clear();
		list.clear();
		for (User u : users) {
			map.put(u.getUsername(), u);
			list.add(u);
		}
	}

	/** aktualizuje informacje o podanym uzytkowniku */
	public void addUpdateUser(User u) {
		if (!map.containsKey(u.getUsername())) {
			map.put(u.getUsername(), u);
			list.add(u);
		} else {
			User uu = map.get(u.getUsername());
			uu.setNationality(u.getNationality());
			uu.setTableAt(u.getTableAt());
			uu.setRankingPosition(u.getRankingPosition());
		}
	}
}
