package ie.atu.sw;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws Exception {
		// Scanner for the menu inputs
		Scanner scanner = new Scanner(System.in);
		// Default values
		String mappingFile = "./encodings-10000.csv";
		String inputFile = "";
		String outputFile = "./out.txt";
		String mode = "encode";

		// Main Loop
		// Program on or off
		boolean running = true;

		while (running) {
			System.out.println(ConsoleColour.WHITE);
			System.out.println("************************************************************");
			System.out.println("*     Danny Lynch: Data Structures and Algorithms ATU      *");
			System.out.println("*                                                          *");
			System.out.println("*              Encoding Words with Suffixes                *");
			System.out.println("*                                                          *");
			System.out.println("************************************************************");
			System.out.println("(1) Specify Mapping File (default: ./encodings-10000.csv)");
			System.out.println("(2) Specify Text File to Encode / Decode");
			System.out.println("(3) Specify Output File (default: ./out.txt)");
			System.out.println("(4) Configure Options");
			System.out.println("(5) Encode || Decode");
			System.out.println("(6) Exit");

			System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT + "Select Option [1-6]: ");
			System.out.flush(); // Ensure prompt appears in Eclipse console
			String choice = scanner.nextLine();

			switch (choice) {
				case "1":
					System.out.print("Enter mapping file path: ");
					System.out.flush();
					mappingFile = scanner.nextLine();
					break;

				case "2":
					System.out.print("Enter input text file path: ");
					System.out.flush();
					inputFile = scanner.nextLine();
					break;

				case "3":
					System.out.print("Enter output file path: ");
					System.out.flush();
					outputFile = scanner.nextLine();
					break;

				case "4":
					System.out.print("Choose mode (encode/decode): ");
					System.out.flush();
					mode = scanner.nextLine().trim().toLowerCase();
					break;

				case "5":
					try {
						Mapper mapper = new Mapper();
						mapper.load(mappingFile);
						FileManager fm = new FileManager();

						if (mode.equals("encode")) {
							List<String> inputLines = fm.readTextFile(inputFile);
							Encoder encoder = new Encoder(mapper.getEncodingMap());
							List<String> encodedLines = encoder.encodeFile(inputLines);
							fm.writeTextFile(outputFile, encodedLines);
							System.out.println(ConsoleColour.GREEN + "[SUCCESS] File encoded to: " + outputFile);
						} else if (mode.equals("decode")) {
							List<String> encodedLines = fm.readTextFile(inputFile);
							Decoder decoder = new Decoder(mapper.getDecodingMap());
							List<String> decodedLines = decoder.decodeFile(encodedLines);
							fm.writeTextFile(outputFile, decodedLines);
							System.out.println(ConsoleColour.GREEN + "[SUCCESS] File decoded to: " + outputFile);
						} else {
							System.out.println(ConsoleColour.RED + "[ERROR] You must choose to Encode or Decode");
						}
					} catch (Exception e) {
						System.out.println(ConsoleColour.RED + "[ ERROR ] Something has failed: " + e.getMessage());
					}
					break;

				case "6":
					running = false;
					System.out.println("Exiting Program.");
					break;

				default:
					System.out.println("INVALID, This operation chosen must be between 1-6");
			}

			System.out.println("\n\n");
		}

		// Progress meter
		System.out.print(ConsoleColour.YELLOW);
		int size = 100;
		for (int i = 0; i < size; i++) {
			printProgress(i + 1, size);
			Thread.sleep(10);
		}
	}

	/*
	 *  Terminal Progress Meter
	 *  -----------------------
	 *  You might find the progress meter below useful. The progress effect 
	 *  works best if you call this method from inside a loop and do not call
	 *  System.out.println(....) until the progress meter is finished.
	 *  
	 *  Please note the following carefully:
	 *  
	 *  1) The progress meter will NOT work in the Eclipse console, but will
	 *     work on Windows (DOS), Mac and Linux terminals.
	 *     
	 *  2) The meter works by using the line feed character "\r" to return to
	 *     the start of the current line and writes out the updated progress
	 *     over the existing information. If you output any text between 
	 *     calling this method, i.e. System.out.println(....), then the next
	 *     call to the progress meter will output the status to the next line.
	 *      
	 *  3) If the variable size is greater than the terminal width, a new line
	 *     escape character "\n" will be automatically added and the meter won't
	 *     work properly.  
	 */
	public static void printProgress(int index, int total) {
		if (index > total) return;
		int size = 50;
		char done = '█';
		char todo = '░';

		int complete = (100 * index) / total;
		int completeLen = size * complete / 100;

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append((i < completeLen) ? done : todo);
		}

		System.out.print("\r" + sb + "] " + complete + "%");

		if (done == total) System.out.println("\n");
	}
}
