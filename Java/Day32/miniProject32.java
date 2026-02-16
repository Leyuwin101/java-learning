package Day32;
import java.util.Scanner;
public class miniProject32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Write a recursive method to sum numbers from 1 to N
        System.out.print("Enter a number to sum: ");
        int s = sc.nextInt();
        System.out.println("Sum: " + sum(s));
        sc.nextLine();

        // Reverse a string using recursion
        System.out.print("Enter a string to reverse: ");
        String str = sc.nextLine();
        System.out.println(rev(str));

        // Print all elements of an array recursively
        System.out.print("Enter an Element of array to print: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements");
        for ( int i = 0; i < n; i++ ) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array elements (recursively):");
        printArray(arr, 0);


        sc.close();
    }
    public static int sum ( int n ) {
        if ( n <= 0 ) return 0;
        return n + sum(n - 1);
    }

    public static String rev ( String s ) {
        if ( s == null || s.length() <= 1) {
            return s;
        }
        return rev(s.substring(1)) + s.charAt(0);
    }

    public static void printArray(int[] arr, int index) {
        if ( index >= arr.length ) return;
        System.out.println(arr[index]);
        printArray(arr, index + 1);
    }
}
