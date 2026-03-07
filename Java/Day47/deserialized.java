package Day47;

import Day46.Student;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class deserialized {
    public static void main(String[] args) {
        // Converting a byte stream back into an object that was previously serialized.

        // Connected to the Day 46 Student Class

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Student.ser"))) {
            Student s = (Student) in.readObject();
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);

        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
