package ie.atu.sw;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

/**
 * runner is where the program kicks off
 * shows the menu and lets the user pick what files to load and what mode to use
 * uses the other classes to actually do the encoding or decoding
 *
 * Big-O not really a thing here since the menu is driven by user input
 */
public class Runner {

    /**
     * 
     * Shows the menu, gets file paths and runs encode or decode based on user choice.
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
            System.out.println("(1) Configure File Paths & Options");
            System.out.println("(2) Show Current Configuration");
            System.out.println("(3) Run Encoding or Decoding");
            System.out.println("(4) Exit");

            System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT + "Select Option [1-4]: ");
            System.out.flush();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter mapping file path (default: ./encodings-10000.csv): ");
                    mappingFile = scanner.nextLine().trim();
                    if (mappingFile.isEmpty()) mappingFile = "./encodings-10000.csv";

                    System.out.print("Enter input text file path: ");
                    inputFile = scanner.nextLine().trim();

                    System.out.print("Enter output file path (default: ./out.txt): ");
                    outputFile = scanner.nextLine().trim();
                    if (outputFile.isEmpty()) outputFile = "./out.txt";

                    System.out.print("Choose mode (encode/decode): ");
                    mode = scanner.nextLine().trim().toLowerCase();
                    break;

                case "2":
                    System.out.println("\n[Current Configuration]");
                    System.out.println("Mapping File: " + mappingFile);
                    System.out.println("Input File: " + inputFile);
                    System.out.println("Output File: " + outputFile);
                    System.out.println("Mode: " + mode);
                    break;

                case "3":
                    try {
                        if (!new File(mappingFile).exists()) throw new Exception("Mapping file doesn't exist");
                        if (!new File(inputFile).exists()) throw new Exception("Input file doesn't exist");

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
                        e.printStackTrace();
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting Program.");
                    break;

                default:
                    System.out.println("INVALID, This operation chosen must be between 1-4");
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
     * @author John Healy
     * @version 1.0
     * @since java 1.0
     * 
     * The Print Progress public method is
     * just a visual progress bar for use in the terminal
     * it uses a string builder and a for loop to create a progress bar like 
     * animation in the terminal when run
     * 
     * If you run the program in the IDE ( eclipse in this case )
     * it does not show because it uses \r and that is not available
     * 
     * \r is a carriage return and overwrites the same place as it writes
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
