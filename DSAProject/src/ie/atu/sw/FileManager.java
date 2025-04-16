package ie.atu.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * file manager handles reading and writing text files for the encoder and decoder
 * i use this to get input files and save output so nothing is hardcoded
 * 
 * reading is just line by line so its O(n) and writing is same idea
 */
public class FileManager {
	
	/**
	 * reads a txt file from disk and stores each line into a list
	 *
	 * @param path the file path that the user gave from the menu
	 * @return a list of strings, each string is one line from the file
	 * @throws Exception if something goes wrong with the file
	 *
	 * Big-O: O(n) where n is number of lines in the file
	 * each line is added to list which is fast
	 */
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

	/**
	 * writes a list of lines to a text file on disk
	 * each string in the list becomes its own line in the file
	 * 
	 * @param path the file path to write to
	 * @param lines the data to write
	 * @throws Exception if writing fails
	 *
	 * Big-O: O(n) where n is number of lines to write
	 * loop just goes through the list once
	 */
	public void writeTextFile(String path, List<String> lines) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		
		for (String line : lines) {
			writer.write(line);
			writer.newLine();
		}
		
		writer.close();
	}
} 
