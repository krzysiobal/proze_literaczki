package Listeners;

import java.util.EventListener;
import java.util.List;

import Containers.Table;

public interface TablesInRoomListListener extends EventListener {
	void tablesInRoomList(List<Table> tables);
}
