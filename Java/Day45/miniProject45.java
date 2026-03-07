package Day45;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class miniProject45 {
    public static void main(String[] args) {
        // Create program that:
        // Asks user for 3 names
        // Saves them to names.txt
        // Read the file and display names in uppercase

        Scanner sc = new Scanner(System.in);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("names.txt", true))) {

            for (int i = 1; i <= 3; i++) {
                System.out.print("Enter name " + i + ": ");
                String name = sc.nextLine();
                writer.write(name);
                writer.newLine();
            }

            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("names.txt"));

            String lines; 
            
            System.out.println("\nNames in uppercase: ");
            
            while((lines = reader.readLine()) != null ) {
                System.out.println(lines.toUpperCase());
            }

            reader.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

        sc.close();

    }
}
