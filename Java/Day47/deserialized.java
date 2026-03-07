package Day47;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class deserialized {
    public static void main(String[] args) {
        // Converting a byte stream back into an object that was previously serialized.

        // Connected to the Day 46 

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Student.ser"))) {
            Student s = (Student) in.readObject();
            System.out.println("Name: " + s.name);
            System.out.println("Age: " + s.age);

        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
