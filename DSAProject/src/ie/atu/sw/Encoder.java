package ie.atu.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Need this class to convert the plain .txt files , more specifically the words inside them
// into a list of numeric codes using a provided encoding map.

public class Encoder {
	
	
	private Map<String, Integer> encodingMap;
	
	// parameter line = the line of text that will get encoded
	// Returns a list of integer codes the = to the words / suffix in the line
	public Encoder(Map<String, Integer> encodingMap) {
		
		this.encodingMap = encodingMap;
		
	}
	
	public List<Integer> encodeLine(String line) {
		
		List<Integer> codes = new ArrayList<>();
		
		
		// This will lower case the word then split the line of text into individual words using 
		String[] words = line.toLowerCase().split("\\s+");
		
		for (String word: words) {
			// Match any character not in a-z or then replace with empty string. 
			word = word.replaceAll("[^a-z@]"," ");
		
		
			if (encodingMap.containsKey(word)) {
				codes.add(encodingMap.get(word));
			} else {
				// if the word is not in the map then we need it to just have a 0
				codes.add(0);
			}
		
		}
		return codes; // Return the final list of encoded numbers
	}

}
