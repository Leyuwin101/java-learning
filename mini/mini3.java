package mini;
import java.util.Scanner;

public class mini3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            int rows = 0;
            int columns = 0;

            while (true) {
                try {
                    System.out.print("How many numbers would you like to enter for rows: ");
                    rows = sc.nextInt();
                    sc.nextLine();

                    System.out.print("How many numbers would you like to enter for columns: ");
                    columns = sc.nextInt();
                    sc.nextLine();

                    if ( rows <= 0 || columns <= 0) {
                        System.out.println("Please enter a number greater than 0");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input! please put a valid integer! ");
                    sc.nextLine();
                }
            }

            int[][] matrix = new int[rows][columns];
            for (int i = 0; i < matrix.length; i++) {
                for ( int j = 0; j < matrix[i].length; j++) {
                    while(true) {
                        try {
                            System.out.println("Enter number for [" + i + "][" + j + "]: ");
                            matrix[i][j] = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input! please put a valid integer! ");
                            sc.nextLine();                        
                        }
                    }
                }
            }

            int largest = matrix[0][0];
            for (int i = 0; i < matrix.length; i++) {
                for ( int j =0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > largest) {
                        largest = matrix[i][j];
                    }
                }
            }
            System.out.println("Largest number: " + largest);

            System.out.println("Reversed array: ");
            for (int i = matrix.length - 1; i >= 0; i--) {
                for ( int j = matrix[i].length - 1; j >= 0; j-- ) {
                        System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Formatted Table: ");
            for (int[] row: matrix) {
                for (int val: row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.print("Do you want to exit? (yes/no): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("yes")) {
                exit = true;
            }
        }
        sc.close();
    }
}
