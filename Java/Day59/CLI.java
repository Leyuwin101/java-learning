package Day59;

import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        ///  Basic CLI Input

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Hello " + name + "! You are " + age + " years old" );

        ///  Handling Multiple Inputs
        System.out.println("Enter 3 numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = a + b + c;
        System.out.println("Sum: " + sum );

    }
}
