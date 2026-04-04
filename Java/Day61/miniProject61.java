package Day61;

import java.util.ArrayList;
import java.util.Scanner;

public class miniProject61 {
    /// Goal
    ///
    /// Combine everything from:
    ///
    /// Variables
    /// Data types
    /// Operators
    /// Conditionals
    /// Loops
    /// Methods
    /// Arrays
    /// Strings
    /// Scanner
    /// Basic logic

    // method to calculate average
    public static double getAverage(int[] grades) {
        // Variable to store sum of all grades
        int sum = 0;

        // loop through each grade and add it to sum
        for (int g : grades) {
            sum += g;

        }

        // divide the total sum by number of grades to get average
        // cast to double to allow decimal results
        return (double) sum / grades.length;
    }

    // method to convert numeric grade into letter grade
    public static String getGrade(double avg) {
        // determine letter grade based on average
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 75) return "C";
        else return "D";
    }

    // method to find the highest grade in an array
    public static int getHighest(int[] grades) {
        // start by assuming the first grade is the highest
        int highest = grades[0];

        // loop through all the grades and update highest if a larger grade is found
        for (int g : grades) {
            if ( g > highest) {
                highest = g;
            }
         }
        // return the highest grade
        return highest;
    }


    public static void main(String[] args) {

        // List to Store students name and grades
        ArrayList<String> students = new ArrayList<>();
        ArrayList<int[]> allGrades = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("=== STUDENT MANAGER ===");

        // Infinite loop to allow adding of multiple students
        while (true) {

            System.out.print("\nEnter Student Name: ");
            String name = sc.nextLine();

            // add the name to the students list
            students.add(name);

            // array to store 3 grades for the current student
            int[] grades = new int[3];

            // try-catch to handle invalid input
            try {
                for (int i = 0; i < grades.length; i++) {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    grades[i] = sc.nextInt();
                }

                // add the grades array to the allGrades list
                allGrades.add(grades);
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Enter a valid grades.");
                sc.nextLine();
                continue;
            }

            // display all students
            System.out.println("\nList of all students");

            // check first if the students list is empty
            if (students.isEmpty()) {
                System.out.println("No students to display");
            } else {

                for (int i = 0; i < students.size(); i++) {
                    String studentName = students.get(i);
                    int[] studentGrades = allGrades.get(i);

                    System.out.println((i + 1) + ". " + studentName);
                    System.out.println("--------------------------");

                    double avg = getAverage(studentGrades);
                    String grade = getGrade(avg);
                    int highest = getHighest(studentGrades);

                    System.out.println("\n--- RESULT ---");
                    System.out.println("Name: " + studentName);
                    System.out.println("Average: " + avg);
                    System.out.println("Grade: " + grade);
                    System.out.println("Highest Grades: " + highest);
                }


                System.out.print("\nAdd another student? (y/n): ");
                char choice = sc.next().charAt(0);
                sc.nextLine();

                if (choice == 'n' || choice == 'N') {
                    System.out.println("Exiting...");
                    break;
                }

            }
        }
    }
}