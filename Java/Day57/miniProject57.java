package Day57;

import java.util.Scanner;

public class miniProject57 {
    public static void main(String[] args) {
        /// Ask user for:
        /// String number
        /// Convert to:
        /// int
        /// double
        /// Convert back to String
        /// Print all results

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string number: ");
        String str = sc.nextLine();

        try {
            // Convert to double first
            double d = Double.parseDouble(str);
            // Convert to int safely by truncation decimals
            int num = (int) d;
            String s1 = String.valueOf(num);
            String s2 = String.valueOf(d);

            System.out.println("Integer: " + num);
            System.out.println("Double: " + d);
            System.out.println("String from int: " + s1);
            System.out.println("String from double: " + s2);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter a valid number");
        }


    }
}
