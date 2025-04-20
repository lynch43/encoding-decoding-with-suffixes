package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * encoder takes lines of normal text and turns them into numbers
 * it looks up words in the map and builds a list of codes
 * used when converting a full txt file before saving as .encoded
 * 
 * Big-O for encoding a line is O(n)
 * Big-O for a full file is O(n * m) where n is the number of lines and m is the average number of words per line
 */
public class Encoder {

	private Map<String, Integer> encodingMap;

	/**
	 * sets the encoding map to use when matching words to numbers
	 *
	 * @param encodingMap this map comes from Mapper class
	 */
	public Encoder(Map<String, Integer> encodingMap) {
		this.encodingMap = encodingMap;

		// print first few keys to test
		System.out.println("Sample encoding map keys:");
		encodingMap.keySet().stream().limit(15).forEach(System.out::println);
	}

	/**
	 * encodes one line of text to a list of integers
	 *
	 * @param line a string like a sentence or row from a file
	 * @return list of codes (0 used if no match found)
	 *
	 * Big-O: O(n) where n = number of words in the line
	 * each lookup in the map is O(1) so it scales with word count
	 */
	public List<Integer> encodeLine(String line) {
		List<Integer> codes = new ArrayList<>();
		String[] words = line.toLowerCase().split("\\s+");

		// these are the suffixes we will check if full word not in map
		String[] suffixes = { "ing", "ed", "ly", "ion", "ment", "tion", "ness", "less", "able", "ous" };

		for (String word : words) {
			word = word.replaceAll("[^a-z]", ""); // clean up the word, just keep letters

			if (encodingMap.containsKey(word)) {
				System.out.println("Matched word: " + word);
				codes.add(encodingMap.get(word));
			} else {
				// check suffixes
				boolean matched = false;
				for (String suffix : suffixes) {
					if (word.endsWith(suffix)) {
						String key = "@@" + suffix;
						if (encodingMap.containsKey(key)) {
							System.out.println("Matched suffix: " + key + " for word: " + word);
							codes.add(encodingMap.get(key));
							matched = true;
							break;
						}
					}
				}
				if (!matched) {
					System.out.println("Error Couldn't parse: " + word);
					codes.add(0);
				}
			}
		}

		return codes;
	}

	/**
	 * takes a list of lines and encodes all of them
	 * joins the numbers as strings per line so they can be saved
	 *
	 * @param lines the full text file content, line by line
	 * @return list of encoded lines as strings of numbers
	 *
	 * Big-O: O(n * m) where n = number of lines and m = average number of words per line
	 */
	public List<String> encodeFile(List<String> lines) {
		List<String> output = new ArrayList<>();

		for (String line : lines) {
			System.out.println("checking Raw line: '" + line + "'");

			List<Integer> codes = encodeLine(line);
			System.out.println("Checking Decoding line with codes: " + codes);

			String encodedLine = codes.toString().replaceAll("[\\[\\],]", "").trim();
			output.add(encodedLine);
		}

		return output;
	}
}
