package ie.atu.sw;

import java.util.List;
import java.util.Map;

/**
 * decoder takes in a list of numbers and turns them back into words or suffixes
 * this is the reverse of what encoder does
 * we use the decoding map to look everything up
 *
 * O(n) for decodeLine where n is amount of codes in a line
 * O(n) 
 */
public class Decoder {
	


	private Map<Integer, String> decodingMap;
	

	/**
	 * sets the decoding map we gonna use to turn codes into words
	 * @param decodingMap comes from Mapper -  same way as Encoder
	 */
	public Decoder(Map<Integer, String> decodingMap) {
		this.decodingMap = decodingMap;
		
		// [ TEST ] 
		System.out.println("[TEST] Decoding map loaded: " +decodingMap.size() +
		 "entries");
		decodingMap.entrySet().stream().limit(10).forEach(entry ->
		System.out.println(entry.getKey() + " => " + entry.getValue()));
		 
	}

	/**
	 * this method takes a list of numbers and tries to turn them into words
	 * if a number isnt in the map we just throw in [???] instead
	 *
	 * @param codes list of integers from the encoded file
	 * @return a string with the decoded sentence
	 *
	 * O(n) where n = amount of codes in the line
	 */
	public String decodeLine(List<Integer> codes) {
		StringBuilder result = new StringBuilder();

		for (Integer code : codes) {
			String word = decodingMap.getOrDefault(code, "[???]");
			result.append(word).append(" ");
		}

		return result.toString().trim();
	}

	/**
	 * takes a list of lines from an encoded file and decodes them all
	 * each line has space separated codes
	 *
	 * @param encodedLines lines from a file where each number is a code
	 * @return decoded lines as readable sentences
	 *
	 * O(n) or m * n
	 */
	public List<String> decodeFile(List<String> encodedLines) {
		List<String> output = new java.util.ArrayList<>();

		for (String line : encodedLines) {
			String[] parts = line.trim().split("\\s+");
			List<Integer> codes = new java.util.ArrayList<>();

			for (String part : parts) {
				try {
					codes.add(Integer.parseInt(part));
				} catch (NumberFormatException e) {
					codes.add(0);
				}
			}

			output.add(decodeLine(codes));
		}

		return output;
	}
	
	
} 
