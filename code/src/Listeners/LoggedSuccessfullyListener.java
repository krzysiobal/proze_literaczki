package Listeners;

import java.util.EventListener;

/** interfejs listenera do powiadomiania o pomyslnym zalogowaniu do gry */
public interface LoggedSuccessfullyListener extends EventListener {
	/** udalo sie zalogowac, mozna pokazac juz okno z otwartym pokojem */
	void loggedSuccesfully();
}
