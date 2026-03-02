package Day43;

import java.util.Scanner;

public class miniProject43 {
    public static void main(String[] args) {
        // Ask user for name, age, and salary
        // Print them in table format
        // Salary should show 2 decimal places
        // Align everything properly


        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        /**
         * This program asks the user for their name, age, and salary.
         * It then displays the information in a formatted table.
         *
         * Formatting explanation:
         * %s      -> used for String values
         * %d      -> used for integer values
         * %f      -> used for floating-point values (double)
         * %.2f    -> formats a double to 2 decimal places
         * %10s    -> reserves 10 spaces, right-aligned
         * %-10s   -> reserves 10 spaces, left-aligned
         * %n      -> newline (platform independent)
         */
        
        System.out.println("------------------------------");
        System.out.printf("| %-8s : %-12s |%n", "Name", name);
        System.out.printf("| %-8s : %-12d |%n", "Age", age);
        System.out.printf("| %-8s : %-12.2f |%n", "Salary", salary);
        System.out.println("------------------------------");

        sc.close();
    }
}
