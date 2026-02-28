package Day41;

import java.util.*;

public class miniProject41 {
    // Create method that returns Optional<String>
    // If name length < 3 → return empty
    // Otherwise return the name
    // Use orElse("Invalid Name")
    public static Optional<String> getValidName(String name) {
        return Optional.ofNullable(name)
                        .filter(n -> n.length() >= 3);
    }
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Seiju", null, "Jo", "Majo");

        // For loop
        System.out.println("\nFor Loop");
        for (String name : names) {
            System.out.println(getValidName(name).orElse("Invalid name"));
        }

        // Stream API
        System.out.println("\nStream API");
        names.stream()
            .map(name -> getValidName(name).orElse("Invalid name"))
            .forEach(System.out::println);

    }
}
