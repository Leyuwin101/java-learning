package Day47;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class miniProject47 {
    public static void main(String[] args) {
        // Serialized first
        Book b = new Book("Harry Potter", "J.K Rowlings", 10.00);

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            out.writeObject(b);

            System.out.println("Object saved! ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialized
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("book.ser"))) {
            Book bs = (Book) in.readObject();
            System.out.println("Title: " + bs.title);
            System.out.println("Author: " + bs.author);
            System.out.println("Price: " + bs.price);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
