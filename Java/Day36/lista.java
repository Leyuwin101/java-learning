package Day36;

import java.util.*;

public class lista {
    public static void main(String[] args) {
        // Creating a List
        List<String> names = new ArrayList<>();

        // Add Elements
        names.add("Bob");
        names.add("The");
        names.add("Builder");

        System.out.println(names);

        // Accessing & Modifying

        // Get element
        System.out.println(names.get(1)); // Bob

        // Set element
        names.set(1, "John");
        System.out.println(names);

        // Remove element
        names.remove("Builder");
        System.out.println(names);

        // Iterating over a List

        // Using for-each loop
        for (String name: names) {
            System.out.println(name);
        }

        // Using iterator
        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Lambda
        names.forEach(System.out::println);
    }
}
