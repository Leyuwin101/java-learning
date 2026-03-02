package mini;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mini11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean calculate = true;
        while (calculate) {
            System.out.println("\n===== WELCOME TO CALCULATOR ======");
            System.out.print(">>> Enter the first number: ");
            double num1 = sc.nextDouble();
            sc.nextLine();

            System.out.print(">>> Enter an operator(+, -, x, /): ");
            String ope = sc.nextLine();

            System.out.print(">>> Enter the second number: ");
            double num2 = sc.nextDouble();
            sc.nextLine();

            try {
                double choice = switch (ope) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "x" -> num1 * num2;
                    case "/" -> {
                        if ( num2 == 0) {
                            throw new ArithmeticException("Cannot be divide to zero");
                        }
                        yield num1 / num2;
                    }
                    default -> throw new IllegalArgumentException("Invalid operation " + ope);
                };

                System.out.println("The result is: " + choice );

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to calculate again? (yes/no)");
            String again = sc.nextLine();

            if (again.equalsIgnoreCase("no")) {
                calculate = false;
            }


        }

        sc.close();

    }
}
