package Day51;
import java.util.*;
public class miniProject51 {
    public static void main(String[] args) {
        /// Divide two numbers using user input
        /// Handle:
        /// Divide by zero
        /// Invalid input
        /// Always print "Done" using finally

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number to divide: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number to divide: ");
            int num2 = sc.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by Zero");
        } catch (InputMismatchException e) {
            System.out.println("Number is not valid");
        } finally {
            System.out.println("Done");
        }

        sc.close();
    }
}
