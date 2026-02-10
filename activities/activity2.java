package activities;
// 1. CREATE A BASE CLASS named LibraryItem with the attributes of title, author, yearPublished, availablecopies, with encapsulation
// 2. DECLARE 3 ABSTRACT METHODS in the base class

import java.util.ArrayList;
import java.util.Scanner;

// 3. create deruved class Book and Magazine and extend it to LibraryItem
// 4. Create a Main class and display a menu to the user:
//   1. Add new Item ( book or magazine )
//   2. borrow item
//   3. display item info

abstract class LibraryItem {
    private String title;
    private String author;
    private int yearPublished;
    private int availableCopies;

    public LibraryItem() {}
    public LibraryItem(String title, String author, int yearPublished, int availableCopies) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availableCopies = availableCopies;
    }

    // Getter
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYearPublished() { return yearPublished; }
    public int getAvailableCopies() { return availableCopies; }


    // Setter
    public void setTitle(String title) { this.title = title;}
    public void setAuthor(String author) { this.author = author;}
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished;}
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies;}
    
    public abstract void addItem(String title, String author, int yearPublished, int availableCopies); 
    public abstract boolean borrowItem();
    public abstract void displayInfo();
}

class Book extends LibraryItem {
    private String genre;

    public Book() {}

    public Book (String title, String author, int yearPublished, int availableCopies, String genre) {
        super(title, author, yearPublished, availableCopies);
        this.genre = genre;
    }

    @Override
    public void addItem(String title, String author, int yearPublished, int availableCopies) {
        setTitle(title);
        setAuthor(author);
        setYearPublished(yearPublished);
        setAvailableCopies(availableCopies);
        System.out.println("Book added: " + title);
    }
    @Override
    public boolean  borrowItem() {
        if (getAvailableCopies() > 0) {
            setAvailableCopies(getAvailableCopies() - 1);
            System.out.println("Borrowed: " + getTitle());
            return true;
        } else {
            System.out.println("No copies available for: " + getTitle());
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("=================================================");
        System.out.println("Book Title: " + getTitle());
        System.out.println("Book Author: " + getAuthor());
        System.out.println("Book Year Published: " + getYearPublished());
        System.out.println("Book Available Copies: " + getAvailableCopies());
        System.out.println("Book Genre: " + genre);
        System.out.println("=================================================");
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}

class Magazine extends LibraryItem {

    public Magazine() {}
    public Magazine(String title, String author, int setYearPublished, int availableCopies) {
        super(title, author, setYearPublished, availableCopies);
    }

    @Override
    public void addItem(String title, String author, int yearPublished, int availableCopies) {
        setTitle(title);
        setAuthor(author);
        setYearPublished(yearPublished);
        setAvailableCopies(availableCopies);
        System.out.println("Magazine added: " + title);
    }

    @Override
    public boolean borrowItem() {
        if (getAvailableCopies() > 0) {
            setAvailableCopies(getAvailableCopies() - 1);
            System.out.println("Borrowed: " + getTitle());
            return true;
        } else {
            System.out.println("No copies available for: " + getTitle());
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("=================================================");
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Magazine Author: " + getAuthor());
        System.out.println("Magazine Year Published: " + getYearPublished());
        System.out.println("Magazine Available Copies: " + getAvailableCopies());
        System.out.println("=================================================");
    }
}

class DVD extends LibraryItem {
    private String duration;

    public DVD() {}
    
    public DVD(String title, String author, int yearPublished, int availableCopies, String duration) {
        super(title, author, yearPublished, availableCopies);
        this.duration = duration;
    }

    @Override
    public void addItem(String title, String author, int yearPublished, int availableCopies) {
        setTitle(title);
        setAuthor(author);
        setYearPublished(yearPublished);
        setAvailableCopies(availableCopies);
        System.out.println("DVD added: " + title);
    }

    @Override
    public boolean borrowItem() {
        if (getAvailableCopies() > 0) {
            setAvailableCopies(getAvailableCopies() - 1);
            System.out.println("Borrowed: " + getTitle());
            return true;
        } else {
            System.out.println("No copies available for: " + getTitle());
            return false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("=================================================");
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Magazine Author: " + getAuthor());
        System.out.println("Magazine Year Published: " + getYearPublished());
        System.out.println("Magazine Available Copies: " + getAvailableCopies());
        System.out.println("=================================================");
    }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

}


public class activity2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryItem> items = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library Management Menu ---");
            System.out.println("> 1. Add new item ( Book / Magazine / DVD )");
            System.out.println("> 2. Borrow item");
            System.out.println("> 3. Display item info");
            System.out.println("> 4. Exit ");
            System.out.println("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter item type (Book/Magazine/DVD): ");
                    String type = sc.nextLine();

                    System.out.println("Enter title: ");
                    String title = sc.nextLine();

                    System.out.println("Enter author: ");
                    String author = sc.nextLine();

                    System.out.println("Enter year published: ");
                    int year = sc.nextInt();

                    System.out.println("Enter number of copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();

                    if (type.equalsIgnoreCase("Book")) {
                        System.out.println("Enter genre: ");
                        String genre = sc.nextLine();

                        Book book = new Book();
                        book.addItem(title, author, year, copies);
                        book.setGenre(genre);
                        items.add(book);
                        System.out.println("Book added successfully! ");
                    } else if (type.equalsIgnoreCase("Magazine")) {
                        Magazine magazine = new Magazine();
                        magazine.addItem(title, author, year, copies);
                        items.add(magazine);
                        System.out.println("Magazine added succefuly! ");
                    } else if (type.equalsIgnoreCase("DVD")) {
                        System.out.println("Enter the duration: ");
                        String duration = sc.nextLine();

                        DVD dvd = new DVD();
                        dvd.addItem(title, author, year, copies);
                        dvd.setDuration(duration);
                        items.add(dvd);
                        System.out.println("DVD added succesfully");

                    } else {
                        System.out.println("Invalid Item type! ");
                    }
                    break;
                
                case 2: 
                    System.out.println("Enter title to borrow: ");
                    String borrowTitle = sc.nextLine();
                    boolean found = false;

                    for (LibraryItem item: items) {
                        if (item.getTitle().equalsIgnoreCase(borrowTitle)) {
                            if ( item.borrowItem()) {
                                System.out.println("Succesfully borrowed " + borrowTitle);
                                System.out.println("Enjoy Reading!!!");
                            } else {
                                System.out.println(borrowTitle + " is not available");
                            }
                            found = true;
                            break;
                        } 
                    }
                    if (!found) {
                        System.out.println("Item not found.");
                    }
                    break;
                
                case 3:
                    for (LibraryItem item: items) {
                        item.displayInfo();
                    }
                    break;
                
                case 4: 
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                
                default: 
                    System.out.println("Invalid choice! try again");
            }
        }
        sc.close();
    }
}
