package Day22;
// Create Book class
class Book {
    // Fields: title, author, price
    private String title;
    private String author;
    private double price;

    // Use this in constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Add constructor chaining
    public Book(String title, String author) {
        this(title, author, 0);
    }

    public void displayBook() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);

    }
}

public class miniProject22 {
    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter", "J.K. Rowling", 1000);
        Book b2 = new Book("No Longer Human", "Osamu Dazai");   

        b1.displayBook();
        b2.displayBook();

    }
}
