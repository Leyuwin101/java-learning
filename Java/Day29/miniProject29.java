package Day29;
import java.util.Scanner;

public class miniProject29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            int[] numbers = new int[5];
            try {
                for (int i = 0; i < numbers.length; i++) {
                    System.out.print("Enter number " + (i + 1) + ": ");
                    numbers[i] = sc.nextInt();
                } 
                System.out.println();

                // find largest
                int largest = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    if (numbers[i] > largest) {
                        largest = numbers[i];
                    }
                }
                System.out.println("Largest number: " + largest);

                // reverse array
                for ( int i = numbers.length - 1; i >= 0; i--) {
                    System.out.print(numbers[i] + " ");
                }
                System.out.println();
                
                // sum
                int sum = 0;
                for ( int num: numbers) {
                    sum += num;
                }
                System.out.println("\nSum: " + sum);

                // average
                double average = (double) sum / numbers.length;
                System.out.println("\nAverage: " + average);

                System.out.println("\nWould you like to repeat? (yes or no): ");
                String choice = sc.next();

                if (!choice.equalsIgnoreCase("yes")) {
                    exit = true;
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter integers only.");
                sc.nextLine();

            } 
        } 
        sc.close();
    }
}
