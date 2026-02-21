package mini;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class mini6 {
    public static void main(String[] args) {
        List<String> usernames = Arrays.asList(
        "Alex",
            "Jonathan",
            "Kim",
            "Samantha",
            "Ray",
            "Christopher"
        );

        // Create a Predicate<String>
        // Condition: username length must be greater than 5

        Predicate<String> usernameLength = str -> str.length() > 5;

        // Create a Function<String, String>
        // Reverse the username

        Function<String, String> reverseUsername = str -> new StringBuilder(str).reverse().toString();

        // Create a Supplier<Integer>
        // Generate a random number from 1–100

        Supplier<Integer> randomNumber = () -> new Random().nextInt(100) + 1;

        // Create a Consumer<String>
        // Print formatted output like this:
        // Original: Jonathan
        // Reversed: nahtanoJ
        // Random ID: 42
        // ---------------------

        Consumer<String> print = username -> {
            String reversed = reverseUsername.apply(username);
            int randomId = randomNumber.get();

            System.out.println("Original: " + username);
            System.out.println("Reversed: " + reversed);
            System.out.println("Random ID: " + randomId);
            System.out.println("---------------------");
        };

        usernames.stream()
                .filter(usernameLength)
                .forEach(print);

    }
}
