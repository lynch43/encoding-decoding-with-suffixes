package ie.atu.sw;

import java.util.List;
import java.util.Map;

// Plan is to covert numeric codes back into their original or suffix using a decoding map

public class Decoder {
	
	
	private Map<Integer, String> decodingMap;
	
	// Constructor for the Runner class , pretty much the same as the encoder version
	public Decoder(Map<Integer, String> decodingMap) {
			
		this.decodingMap = decodingMap;
		
	}
	
	public String decodeLine(List<Integer> codes) {
		
		StringBuilder result = new StringBuilder();
		
		// Loop through epach code as it is read
		for (Integer code : codes) {
			// Search for that word in out decoding map
			String word = decodingMap.getOrDefault(code, "[???]");
			
			//put thyye space back in between
			result.append(word).append(" ");
		}
		
		return result.toString().trim();
	}

}
