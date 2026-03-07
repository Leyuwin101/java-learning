package Day47;

import java.io.Serializable;

public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    public String title;
    public String author;
    public double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
