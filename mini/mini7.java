package mini;

import java.util.List;
import java.util.Arrays;
import java.util.function.*;
import java.util.Random;

public class mini7 {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(
            45, 78, 90, 33, 67, 88, 50, 29, 99
        );

        // Create a Predicate<Integer>
        // Only allow scores >= 50 (passing grade)

        Predicate<Integer> passingScore = n -> n >= 50;

        // Create a Function<Integer, String>
        // Convert score into grade:

        Function<Integer, String> convertTOgrade = n -> {
            if ( n >= 90 && n <= 100) {return "A"; } 
            else if ( n >= 80 ) { return "B"; }
            else if ( n >= 70 ) { return "C"; }
            else if ( n >= 60 ) { return "D"; }
            else { return "E"; }
        };

        // Create a Supplier<String>

        // Generate a random section:
        // "Section A"
        // "Section B"
        // "Section C"

        Supplier<String> randomSection = () -> {
            char sectionLetter = (char) ('A' + new Random().nextInt(3));
            return "Section " + sectionLetter;
        };

        // Create a Consumer<Integer>
    
        // Print formatted output like this:

        // Score: 78 → Grade: B
        // Assigned: Section C
        // -------------------------

        Consumer<Integer> print = score -> {
            System.out.println("Score: " + score + " -> Grade: " + convertTOgrade.apply(score));
            System.out.println("Assigned: " + randomSection.get());
            System.out.println("------------------------------");
        };

        scores.stream()
            .filter(passingScore)
            .forEach(print);

        // scores.stream()
        // .filter(passingScore)
        // .map(score -> "Score: " + score + " -> Grade: " + convertTOgrade.apply(score)
        //             + "\nAssigned: " + randomSection.get()
        //             + "\n------------------------------")
        // .forEach(System.out::println);
    }
}
