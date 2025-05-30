package ie.atu.sw;

import java.util.List;
import java.util.Map;

/**
 * decoder takes in a list of numbers and turns them back into words or suffixes
 * this is the reverse of what encoder does
 * we use the decoding map to look everything up
 *
 * Big-O: O(n) for decodeLine where n is amount of codes in a line
 * @see Encoder
 */
public class Decoder {

    private Map<Integer, String> decodingMap;

    /**
     * sets the decoding map we gonna use to turn codes into words
     * good for decodeLine and decodeFile
     *
     * @param decodingMap comes from Mapper - same way as Encoder
     * @see Mapper getDecodingMap()
     */
    public Decoder(Map<Integer, String> decodingMap) {
        this.decodingMap = decodingMap;
    }

    /**
     * this method takes a list of numbers and tries to turn them into words
     * if a number isn't in the map we just throw in [???] instead
     *
     * @param codes list of integers from the encoded file
     * @return a string with the decoded sentence
     *
     * Big-O: O(n) where n = amount of codes in the line
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
     * uses decodeLine for each line
     *
     * @param encodedLines lines from a file where each number is a code
     * @return decoded lines as readable sentences
     * @see decodeLine(List)
     */
    public List<String> decodeFile(List<String> encodedLines) {
        List<String> output = new java.util.ArrayList<>();

        System.out.println("checking Decoding " + encodedLines.size() + " lines");
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
                    codes.add(0); // still adds 0 so we can test
                }
            }

            output.add(decodeLine(codes));
        }

        return output;
    }
}
