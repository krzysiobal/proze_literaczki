package Listeners;

import java.util.EventListener;

/** interfejs listenera do powiadomiania o prywatnych wiadomosciach na stole */
public interface IncomingPrivateChatMessageListener extends EventListener {
	/** przyszla prywatna wiadomosc od uzytkownka */
	void incomingPrivateChatMessage(String message, String from);
}
