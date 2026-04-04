package Day60;

import java.util.*;

public class CLP {
    public static void main(String[] args) {
        /// Uses args[] to decide mode[]
        /// Uses Scanner for interaction

        Scanner sc = new Scanner(System.in);

        /// Check mode from command-line arguments
        if (args.length == 0) {
            System.out.println("Please provide mode: basic / advanced");
            return;
        }

        String mode = args[0];

        System.out.println("Mode: " + mode);

        if (mode.equalsIgnoreCase("basic")) {

            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            System.out.println("Square: " + (num*num));
        } else if (mode.equalsIgnoreCase("advanced")) {
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
                        if ( num2 == 0) {
                            System.out.println("Number cannot be divided by zero");
                            return;
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid operator");
                        return;
                }

                System.out.println("Result: " + result);

            } catch(InputMismatchException e) {
                System.out.println("Invalid input! ");
            }

        } else {
            System.out.println("Invalid mode");
        }

        sc.close();


        /// How to run
        /// java CLP basic
        /// java CLP advanced
    }
}
