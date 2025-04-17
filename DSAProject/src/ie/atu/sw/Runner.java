package ie.atu.sw;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * runner is where the program kicks off
 * shows the menu and lets the user pick what files to load and what mode to use
 * uses the other classes to actually do the encoding or decoding
 *
 * Big-O not really a thing here since the menu is driven by user input
 */
public class Runner {

	/**
	 * shows the menu, gets file paths and runs encode or decode based on user choice
	 * 
	 * @param args not used here but main needs it
	 * @throws Exception in case something breaks like a missing file
	 */
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String mappingFile = "./encodings-10000.csv";
		String inputFile = "";
		String outputFile = "./out.txt";
		String mode = "encode";
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
			System.out.flush();
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

		System.out.print(ConsoleColour.YELLOW);
		int size = 100;
		for (int i = 0; i < size; i++) {
			printProgress(i + 1, size);
			Thread.sleep(10);
		}
	}

	/**
	 * just a visual progress bar for fun
	 * doesn't really help but it looks cool in terminal
	 *
	 * @param index current number
	 * @param total how far we go
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
