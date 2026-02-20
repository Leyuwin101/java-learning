package Day34;

import java.util.*;

// USING LAMBA WITH INTERFACE
interface MathOperation {
    int operation(int a, int b);
}
public class lamba {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract  = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> a / b;

        System.out.println(add.operation(1, 5));
        System.out.println(subtract.operation(5, 2));
        System.out.println(multiply.operation(10, 5));
        System.out.println(divide.operation(10, 2));

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie");

        // Using lamba 
        names.forEach(name -> System.out.println(name));

        // Using lamba to filter
        names.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(System.out::println);

        // Using sort lamba
        names.sort((a, b) -> b.compareTo(a));
        System.out.println("Sorted descending: " + names);

        // Map to uppercase
        names.stream()
            .map(name -> name.toUpperCase())
            .forEach(System.out::println);
    }
}
