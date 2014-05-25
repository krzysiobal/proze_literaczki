package Listeners;

import java.util.EventListener;

public interface IncomingPrivateChatMessageListener extends EventListener {
	void incomingPrivateChatMessage(String message, String from);
}
