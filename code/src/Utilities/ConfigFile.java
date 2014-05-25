package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
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
	HashMap<String, HashMap<String, String>> file = new HashMap<String, HashMap<String, String>>();

	Pattern sectionNamePattern = Pattern.compile("^\\[([a-zA-Z0-9\\._]+)\\]$");
	Pattern nameValuePattern = Pattern
			.compile("^([a-zA-Z0-9\\._]+)\\s*=\\s*([a-zA-ZŻÓŁĆĘŚĄŹŃżółćęśąźń0-9\\.\\,_]+)$");

	/*
	 * returns value of given key in section
	 */
	public String getValue(String sectionName, String keyName) {
		if (!file.containsKey(sectionName))
			System.out.println("Brak klucza: " + sectionName);
		// System.out.println(file.get(sectionName).get(keyName));
		return file.get(sectionName).get(keyName);
	}

	// opens and parses the given filename
	public void parse(String fileName) throws ConfigFileParseException {

		try {
			BufferedReader r = new BufferedReader(new FileReader(fileName));
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
