package Day45;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class files {
    public static void main(String[] args) {
        // Writing to a file
        
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hello this is my first file!\n");
            writer.write("Java File I/O Day 45\n");
            writer.close();

            System.out.println("File written succesfully.");
        } catch(IOException e) {
            System.out.println("Error writing file.");
        }

        // This creates a file named output.txt.

        // Reading from a File (FileReader + Scanner)

        try {
            File file = new File("output.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

            sc.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }

        // Buffered Reader
        /**
         * Opens a text file using BufferedReader
         * Reads the file line by line
         * readLine() returns null when the file ends
         * Each line is printed to the console
         * try-with-resources automatically closes the file
         */
        try {
            BufferedReader reader = new BufferedReader(new FileReader(java.nio.file.Path.of("C:/Users/Dave/OneDrive/Desktop/Backend/Internet.txt").toFile()));
            
            String line;

            while ((line = reader.readLine()) != null ) {
                System.out.println(line);
            }
            
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading a file");
        }
        
        // Try-With-Resources (Best Practice)
        // OverWrite the output.txt
        try(FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write("auto closed file");
        } catch(IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter note: ");
        String note = sc.nextLine();

        try (FileWriter writer = new FileWriter("notes.txt", true)){
            writer.write(note + "\n");
            System.out.println("note saved!");
        } catch(IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
