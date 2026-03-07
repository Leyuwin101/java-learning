package Day46;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Making a Class Serializable
// serialVersionUID (Important)
// Used to maintain compatibility

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    // transient Keyword
    transient String password;
    // password will NOT be saved.

    Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

}
public class serialized {
    public static void main(String[] args) {
        // Converting an object into a byte stream so it can be saved to a file or sent over a network.

        // Writing Object to File (Serialization)
        Student s = new Student("Seiju", 18, "SeijuPogi");

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Student.ser"))) {
            out.writeObject(s);
            System.out.println("Object saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
