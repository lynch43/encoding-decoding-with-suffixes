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
 * Big-O for a full file is O()
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

		for (String word : words) {
			word = word.replaceAll("[^a-z@]", " ");
			if (encodingMap.containsKey(word)) {
				codes.add(encodingMap.get(word));
			} else {
				boolean found = false;
				String[] suffixes = { "ed", "ing", "tion", "able", "ion", "ment", "ness", "ous"};
				
				for (String suffix : suffixes) {
					
					if (word.endsWith(suffix)) {
						String key = "@@" + suffix;
						if(encodingMap.containsKey(key)) {
							found = true;
							break;
						}
						
					}
					
				}
				;
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
	 * Big-O: O( n? ) I am not sure or is it quadratic? because it is lines * words in the line
	 */
	public List<String> encodeFile(List<String> lines) {
		List<String> output = new ArrayList<>();

		for (String line : lines) {
			List<Integer> codes = encodeLine(line);
			String encodedLine = codes.toString().replaceAll("[\\[\\],]", "").trim();
			output.add(encodedLine);
		}

		return output;
	}
} 
