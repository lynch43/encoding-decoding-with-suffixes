package ie.atu.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Responsible for loading and storing mappings between words/suffixes and codes.
 * Used to support both encoding (word to number) and decoding (number to word).
 *
 * Big-O: O(n) when loading, because we read the file line-by-line once.
 */
public class Mapper {

	private Map<String, Integer> encodingMap = new HashMap<>(); // For encoding: word -> number
	private Map<Integer, String> decodingMap = new HashMap<>(); // For decoding: number -> word

	/**
	 * Loads the encoding map from a CSV file into memory.
	 * Format is: word_or_suffix,number
	 * 
	 * @param filePath path to the mapping CSV file (like encodings-10000.csv)
	 * @throws Exception if the file can't be opened or parsed
	 *
	 * Big-O: O(n) where n is the number of lines in the file
	 * Each line is read and inserted into two hash maps (O(1)) for each thing inserted
	 */
	public void load(String filePath) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;

		while ((line = reader.readLine()) != null) {
			line = line.trim(); // fix empty lines in the csv

			// skip blank or lines that are just incorrectly spaced
			if (line.isEmpty() || !line.contains(",")) continue;

			String[] parts = line.split(",");

			if (parts.length == 2) {
				String key = parts[0].toLowerCase().trim();
				int value = Integer.parseInt(parts[1].trim()); // integer or string?

				encodingMap.put(key, value);
				decodingMap.put(value, key);
			}
		}

		reader.close();
		System.out.println("Encoding map size: " + encodingMap.size());
		System.out.println("Decoding map size: " + encodingMap.size());
		System.out.println("Encoding map has this many entries: " + encodingMap.size());
		encodingMap.forEach((key, value) -> System.out.println(key + "--" + value));
	}

	/**
	 * Get the encoding map (word to code).
	 * 
	 * @return a map that lets us encode full words and suffixes
	 *
	 * Big-O: O(1) just returns the object
	 */
	public Map<String, Integer> getEncodingMap() {
		return encodingMap;
	}

	/**
	 * Get the decoding map (code to word).
	 * 
	 * @return a map that lets us turn codes back into words
	 *
	 * Big-O: O(1) just returns the object
	 */
	public Map<Integer, String> getDecodingMap() {
		return decodingMap;
	}
}
