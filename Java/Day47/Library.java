package Day47;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Book> books;

    public Library() { books = new ArrayList<>(); }

    public void addBook(Book b) { books.add(b); }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in Library! ");
        } else {
            for (Book book: books) {
                System.out.println(book);
            }
        }
    }

    // Serialize Library
    public void saveLibrary(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            System.out.println("Library Saved! ");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialize Library
    public static Library loadLibrary(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Library) in.readObject();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Library();
        }
    }
}
