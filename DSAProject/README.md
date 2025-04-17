# Enoding and Decoding Words&Suffixes

## Danny Lynch


## How it works

This project is a command-line Java app for encoding and decoding text files using a suffix mapping system  
It loads a CSV with word or suffix to number mappings and uses that to convert plain text into number sequences  
You can also decode number sequences back into readable sentences using the reverse map  
It supports user input through a menu where you can pick your own input, mapping, and output files

## Main Features
- Fully working CLI menu
- Can encode any plain text file line by line using a mapping file
- Automatically replaces unknown words with code 0
- Can decode encoded files back to readable text
- All file paths are user-defined through the menu
- JavaDocs added for every method including Big-O notes
- Generates terminal progress bar for visual feedback

## What do all of the classes do?

- The Mapper loads the CSV file into two maps
- The Encoder goes through text line by line and turns words into numbers using a map dat structure
- Decoder does the reverse
- The FileManager reads and write files chosen by the user


##

## Java Maps or HashMaps

If you unfamiliar with Maps or HashMaps, they are akin to Dictionaries in Python
Key Value pairs. I used them to store with the words and numbers

Word - > Number ( Encoder ) 

Number - > Word { Decoder }


## How to Run the project on Another Windows PC
-------------------------------------------------
2. Unzip the project folder anywhere  ( Desktop )

3. Folder should look like
   -dsa.jar 
   -encodings-10000.csv
   -src/
   -README.pdf 
   -any .txt files you want to use

4. Open cmd
   - Exampl
     cd Desktop\\YourProjectFolderName

5. Run the program using this command
   java -cp ./dsa.jar ie.atu.sw.Runner

6. Use the menu that appears
   - (1) Set the mapping file path
   - (2) Set the input .txt file to encode or decode
   - (3) Set the output file path
   - (4) Choose mode: encode or decode
   - (5) Run the process
   - (6) Exit

7. Your output will be saved in the file path you chose
   - You can open it in Notepad or any text editor to check

