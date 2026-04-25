package Day74.controller;

import Day74.model.Expense;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {
    /// FILE PATH
    private static final String FILE_NAME = System.getProperty("user.home") +
            "\\OneDrive\\Desktop\\LearnJava\\Java\\Day74\\students.txt";


    /// Save File
    public void save(ArrayList<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                String imageName = "";

                if (e.getImage() != null && !e.getImage().isEmpty()) {
                    imageName = new File(e.getImage()).getName();
                }

                writer.write(
                        e.getName() + "|" +
                                e.getCategory() + "|" +
                                e.getAmount() + "|" +
                                imageName + "|" +
                                e.getDate()
                );

                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /// Load File
    public ArrayList<Expense> load() {
        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) return expenses;

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null ) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    String name = parts[0];
                    String category = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String image = parts[3];
                    LocalDate date = LocalDate.parse(parts[4]);

                    expenses.add(new Expense(name, category, amount, image, date));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return expenses;
    }
}
