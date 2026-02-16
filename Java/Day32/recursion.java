package Day32;
import java.util.Scanner;
public class recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // A recursive method must have:
        // Base case → stops recursion
        // Recursive case → the method calls itself

        // Factorial
        System.out.print("Enter a number to calculate a factorial: ");
        int n = sc.nextInt();
        System.out.println(n + "! = " + factorial(n));

        // Fibonnacci Sequence
        System.out.print("Enter number for fibonacci: ");
        int fiBn = sc.nextInt();
        for (int i = 0; i < fiBn; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        System.out.print("Enter N to reverse: " );
        int revN = sc.nextInt();
        printReverse(revN);
        
        sc.close();
    }
    public static long factorial(int n) {
            if ( n == 0 ) return 1;
            return n * factorial(n - 1);
    }
    public static long fibonacci(int n) {
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 1;
        return fibonacci(n - 1 ) + fibonacci(n - 2);
    }
    public static void printReverse(int n) {
        if ( n == 0 ) return;
        System.out.print(n + " ");
        printReverse(n - 1);
    }

}
