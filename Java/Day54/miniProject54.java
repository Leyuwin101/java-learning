package Day54;

import java.lang.reflect.*;

class Book {
    private String title = "Harry Potter";
    private double price = 10.00;

    public void bookInfo() {
        System.out.println("Title: " + title );
        System.out.println("Price: " + price);
    }
}

public class miniProject54 {
    /// Create class Book
    /// Add private fields: title, price
    /// Use reflection to:
    /// Print field names
    /// Access and print values
    /// Call a method using invoke()

    public static void main(String[] args) throws Exception {
        Class<?> c = Book.class;

        System.out.println("Class Name: " + c.getName());

        Field[] field = c.getDeclaredFields();

        for (Field f : field) {
            System.out.println("Fields: " + f.getName());
        }


        Object obj = c.getDeclaredConstructor().newInstance();

        Field title = c.getDeclaredField("title");
        title.setAccessible(true);

        Field price = c.getDeclaredField("price");
        price.setAccessible(true);

        System.out.println("Field Title: " + title.get(obj));
        System.out.println("Field Price: " + price.get(obj));

        Method method = c.getMethod("bookInfo");
        method.invoke(obj);









    }
}
