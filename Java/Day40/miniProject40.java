package Day40;

import java.util.*;

public class miniProject40 {
    public static void main(String[] args) {

        // Create a List of 10 numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Print only even numbers
        // Square them
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);
        
        // Get the total sum
        int sum = numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n)
                        .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);


    }
}
