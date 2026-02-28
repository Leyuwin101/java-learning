package mini;

import java.util.Scanner;

public class mini9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter your favorite subject: ");
        String favorite = sc.nextLine();

        System.out.println("\nWelcome " + fullName + "!");
        System.out.println("Your favorite subject is: " + favorite);

        // GRADES
        int[] grades = new int[5];

        System.out.println("\nPlease enter 5 grades:");

        for (int i = 0; i < grades.length; i++) {
            while (true) {
                try {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    grades[i] = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    sc.nextLine(); // clear invalid input
                }
            }
        }

        // CALCULATE SUM AND AVERAGE
        // DISPLAY THE HIGHEST AND LOWEST
        int sum = 0;
        int highest = grades[0];
        int lowest = grades[0];

        for (int grade : grades) {
            sum += grade;

            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }

        double average = (double) sum / grades.length;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        sc.close();
    }
}