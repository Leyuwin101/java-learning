package mini;

import java.util.Scanner;

public class mini10 {

    public static void main(String[] args) {
        // WITHOUT THE LOOP
        Scanner sc = new Scanner(System.in);

        // User Info
        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter your favorite subject: ");
        String favorite = sc.nextLine();

        System.out.println("\nWelcome " + fullName + "!");
        System.out.println("Your favorite subject is: " + favorite);

        // Store 5 grades
        int[] grades = new int[5];

        System.out.println("\nPlease enter 5 grades:");

        System.out.print("Enter grade 1: ");
        grades[0] = sc.nextInt();

        System.out.print("Enter grade 2: ");
        grades[1] = sc.nextInt();

        System.out.print("Enter grade 3: ");
        grades[2] = sc.nextInt();

        System.out.print("Enter grade 4: ");
        grades[3] = sc.nextInt();

        System.out.print("Enter grade 5: ");
        grades[4] = sc.nextInt();

        // Sum
        int sum = grades[0] + grades[1] + grades[2] + grades[3] + grades[4];

        // Average
        double average = (double) sum / 5;

        // Highest
        int highest = Math.max(
                Math.max(grades[0], grades[1]),
                Math.max(Math.max(grades[2], grades[3]), grades[4])
        );

        // Lowest 
        int lowest = Math.min(
                Math.min(grades[0], grades[1]),
                Math.min(Math.min(grades[2], grades[3]), grades[4])
        );

        // Output
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        sc.close();
    }
}