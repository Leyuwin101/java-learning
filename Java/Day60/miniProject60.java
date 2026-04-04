package Day60;

import java.util.*;

public class miniProject60 {
    public static void main(String[] args) {
        /// Add a new mode:
        /// stats
        /// Input 3 numbers
        /// Print:
        /// max
        /// min
        /// average
        /// Handle invalid numbers using try-catch

        Scanner sc = new Scanner(System.in);

        if ( args.length == 0) {
            System.out.println("Pleas Provide a mode: basic / advanced / godly");
            return;
        }

        String mode = args[0];

        System.out.println("Mode: " + mode);

        if ( mode.equalsIgnoreCase("basic")) {
            System.out.print("Enter a number to square: ");
            int square = sc.nextInt();

            System.out.println("Square: " + (square*square));
        } else if ( mode.equalsIgnoreCase("advanced")) {
            try {
                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter operator(+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                double result;

                switch (op) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if ( num2 == 0 ) {
                            System.out.println("Number cannot be divided by 0");
                            return;
                        }

                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid Operator");
                        return;
                }

                System.out.println("Result: " + result);
            } catch (InputMismatchException e) {
                System.out.println("Pls put a valid input!");
            }
        } else if (mode.equalsIgnoreCase("godly")) {
            try {
                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                System.out.print("Enter third number: ");
                double c = sc.nextDouble();

                System.out.println("Max: " + Math.max(a, Math.max(b, c)));
                System.out.println("Min: " + Math.min(a, Math.min(b, c)));
                System.out.println("Average: " + (a + b + c) / 3);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values only");
            }
        }

        sc.close();
    }
}
