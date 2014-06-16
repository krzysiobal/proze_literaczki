package Utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exceptions.ConfigFileParseException;

/**
 * Klasa wczytuje podany plik konfiguracyjny, parsuje go i zwraca w postaci
 * słownika (jako klucze - nazwy sekcji) zawierającego słownik (jako klucze -
 * nazwy parametrów)
 */
public class ConfigFile {
	/** wczytany plik do haszmapy */
	HashMap<String, HashMap<String, String>> file = new HashMap<String, HashMap<String, String>>();

	/** wzorzec uzywany do parsowania nazw sekcji */
	Pattern sectionNamePattern = Pattern.compile("^\\[([a-zA-Z0-9\\._]+)\\]$");

	/** wzorzec uzywany do parsowania pary klucz=wartosc */
	Pattern nameValuePattern = Pattern
			.compile("^([a-zA-Z0-9\\._]+)\\s*=\\s*([a-zA-ZŻÓŁĆĘŚĄŹŃżółćęśąźń0-9\\.\\,_]+)$");

	/** zwraca wartosc z podanej sekcji dla podanego klucza */
	public String getValue(String sectionName, String keyName) {
		if (!file.containsKey(sectionName))
			System.out.println("Brak klucza: " + sectionName);
		// System.out.println(file.get(sectionName).get(keyName));
		return file.get(sectionName).get(keyName);
	}

	/** parsuje podany plik */
	public void parse(String fileName) throws ConfigFileParseException {

		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF8"));
			String line;
			String currentSection = "";
			Matcher m;
			while ((line = r.readLine()) != null) {
				line = line.trim();
				if (line.equals(""))
					continue; // skip empty lines

				if (line.startsWith("#"))
					continue; // skip comments

				m = sectionNamePattern.matcher(line);
				if (m.matches()) {
					currentSection = m.group(1);
					file.put(currentSection, new HashMap<String, String>());
					continue;
				}

				m = nameValuePattern.matcher(line);
				if (m.matches()) {
					String name = m.group(1);
					String value = m.group(2);
					file.get(currentSection).put(name, value);
					continue;
				}
				r.close();

				throw new ConfigFileParseException("Blad parsowania linijki: "
						+ line);

			}
			r.close();
		} catch (Exception e) {
			throw new ConfigFileParseException("Blad przetwarzania pliku: "
					+ e.getMessage());
		}
	}
}
