package Day47;

public class miniProject47 {
    public static void main(String[] args) {

        Library library = new Library();
        library.addBook(new Book("Harry Potter", "J.K Rowlings", 10.00));
        library.addBook(new Book("The Hobbit", "J.R.R Tolkien", 15.00));
        library.addBook(new Book("1984", "George Orwell", 12.55));

        // Save Library
        library.saveLibrary("Library.ser");

        // Load Library
        Library loadedLibrary = Library.loadLibrary("Library.ser");
        System.out.println("\nBooks in Library");
        loadedLibrary.showBooks();

    }
}
