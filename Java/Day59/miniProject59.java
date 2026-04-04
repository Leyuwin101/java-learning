package Day59;

import java.util.InputMismatchException;
import java.util.Scanner;

public class miniProject59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter the operator(+, -, *, /): ");
            char op = sc.next().charAt(0);

            System.out.print("Enter the second number: ");
            double num2 = sc.nextDouble();

            double result;

            switch (op) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Number cannot be divided into 0");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number! ");
        }

        sc.close();

    }
}
