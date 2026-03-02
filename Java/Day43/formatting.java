package Day43;

import java.time.LocalDate;

public class formatting {
    public static void main(String[] args) {
        // printf() allows formatted printing
        System.out.printf("Hello %s%n", "Seiju");
        // Common Format Specifiers
        // Specifier	Meaning
        // %s	        String
        // %d	        Integer
        // %f	        Decimal (float/double)
        // %n	        New line
        // %c	        Character
        // %b	        Boolean
        // %.2f         2 decimal places

        // Formatting numbers
        int age = 18;
        System.out.printf("Age %d%n", age);

        double price = 123.4567;
        System.out.printf("Price &.2f%n", price);

        // Width & Alignment
        System.out.printf("|%20s|%n", "JAVA RIGHT");
        System.out.printf("|%-20s|%n", "JAVA LEFT");

        // Multiple Values
        String name = "Seiju";
        int score = 95;
        double average = 92.567;

        System.out.printf("Name: %s | Score: %d | Avg: %.1f5n", name, score, average);
        System.out.println();


        // String.format()
        // works like printf() but returns string
        double total = 199.99;

        String result = String.format("Total: %.2f PHP", total);

        System.out.println(result);

        // Formatting Date Example
        LocalDate now = LocalDate.now();

        System.out.printf("Year: %d Month: %d Day: %d5n", now.getYear(), now.getMonthValue(), now.getDayOfMonth());




    }
}
