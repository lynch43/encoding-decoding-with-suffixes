package ie.atu.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


// The idea of this Mapper class will be to load the csv on moodle (word/suffix to number)
public class Mapper {
	
	private Map<String, Integer> encodingMap = new HashMap<>();
	private Map<Integer, String> decodingMap = new HashMap<>();
	
	public void load(String filePath) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length == 2) {
				String key = parts[0];
				Integer value = Integer.parseInt(parts[1]);
				
				encodingMap.put(key, value);
				decodingMap.put(value, key);
			}
		}
		
		reader.close();
	}
	
	public Map<String, Integer> getEncodingMap() {
		return encodingMap;
	}
	
	public Map<Integer, String> getDecodingMap() {
		return decodingMap;
	}

}
