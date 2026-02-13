package mini;
import java.util.ArrayList;
import java.util.Scanner;
public class mini2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> sessionAverage = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            int size = 0;
            
            while (true ) {
                try {
                    System.out.print("How many numbers would you like to enter? ");
                    size = sc.nextInt();

                    if ( size <= 0 ) {
                        System.out.println("Please enter a number greater than 0");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! please put a valid integer! ");
                    sc.nextLine();
                }
            }

            int[] numbers = new int[size];

            for (int i = 0; i < numbers.length; i++) {
                while(true) {
                    try {
                        System.out.println("Enter number " + ( i + 1 ) + ": " );
                        numbers[i] = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input! please put a valid integer! ");
                        sc.nextLine();                        
                    }
                }
            }

            // find the largest 
            int largest = numbers[0];
            for ( int i = 1; i < numbers.length; i++ ) {
                if ( numbers[i] > largest) {
                    largest = numbers[i];
                }
            }
            System.out.println("\nLargest number: " + largest);
            
            // reverses array
            System.out.println("\nReversed array: ");
            for ( int i = numbers.length - 1; i >= 0; i--) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            // Sum
            int sum = 0;
            for ( int num: numbers) {
                sum += num;
            }
            System.out.println("\nSum: " + sum);

            // Average
            double average = (double) sum / numbers.length;
            System.out.println("\nAverage: " + average);

            // store average
            sessionAverage.add(average);

            System.out.println("Would you like to try again: (yes/no)");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                exit = true;
            }
            System.out.println();
        } 
        System.out.println("=== Session Summary ===");
        for ( int i = 0; i < sessionAverage.size(); i++) {
            System.out.println("Run " + (i + 1) + " Average: " + sessionAverage.get(i));
        }
        sc.close();
    }
}