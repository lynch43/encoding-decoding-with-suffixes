package ie.atu.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	
	// Reading text from a file line by line
	public List<String> readTextFile(String path) throws Exception {
		List<String> lines = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		
		reader.close();
		return lines;
	}
	
	public void writeTextFile(String path, List<String> lines) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		
		for (String line : lines) {
			writer.write(line);
			writer.newLine();
		}
		
		writer.close();
	}

}
