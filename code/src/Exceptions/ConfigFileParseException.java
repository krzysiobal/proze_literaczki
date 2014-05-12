package Exceptions;

/** Wyjątek zgłaszany podczas błędu parsowania pliku konfiguracyjnego */
@SuppressWarnings("serial")
public class ConfigFileParseException extends Exception {
	public ConfigFileParseException(String message) {
		super(message);
	}
}
