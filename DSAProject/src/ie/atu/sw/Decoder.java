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
		System.out.println("[TEST] Decoding map loaded: " + decodingMap.size() + " entries");
		decodingMap.entrySet().stream().limit(10).forEach(entry ->
			System.out.println(entry.getKey() + " => " + entry.getValue()));
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("Testing specific number. does decodingMap contain 107");
		
		// KNOWN CODES
		System.out.println("172 | " + decodingMap.get(172));
		System.out.println("698 | " + decodingMap.get(698));
		System.out.println("107 | " + decodingMap.get(107));
		System.out.println("114 | " + decodingMap.get(114));
		
	
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

		System.out.println("Checking Decoding line with codes: " + codes);

		for (Integer code : codes) {
			String word = decodingMap.get(code);

			if (word == null) {
				System.out.println("Code: " + code + " not found in decodingMap");
				word = "[???]";
			}

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
	 * O(n)
	 */
	public List<String> decodeFile(List<String> encodedLines) {
		List<String> output = new java.util.ArrayList<>();

		System.out.println("checking Decoding " + encodedLines.size() + " lines");
		//TEST  check is the map is empty or not laoding
		System.out.println("Decoding map available size: " + decodingMap.size());


		for (String line : encodedLines) {
			System.out.println("checking Raw line: '" + line + "'");

			String[] parts = line.trim().split("\\s+");
			List<Integer> codes = new java.util.ArrayList<>();

			for (String part : parts) {
				try {
					int parsed = Integer.parseInt(part);
					codes.add(parsed);
				} catch (NumberFormatException e) {
					System.out.println("Error Couldn't parse: " + part);
					codes.add(0); // still adds 0 so we can tes
				}
			}

			output.add(decodeLine(codes));
		}

		return output;
	}
}
