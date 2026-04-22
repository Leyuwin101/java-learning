package Day71.Controller;

import java.io.*;
import java.util.ArrayList;
import Day71.model.Student;

public class FileController {
    private static final String FILE_NAME = System.getProperty("user.home") +
            "\\OneDrive\\Desktop\\LearnJava\\Java\\Day71\\students.txt";

    /// Save file
    public void save(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s: students) {
                writer.write(s.getName() + "," + s.getSection() + "," + s.getAge());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> load() {
        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) return students;

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3 ) {
                    String name = parts[0];
                    String section = parts[1];
                    int age = Integer.parseInt(parts[2]);

                    students.add(new Student(name, section, age));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;

    }
}
