package Day31;

public class com {
    // args is an array of Strings.
    // It stores values you pass when running the program.
    public static void main(String[] args) {
        // if you file is javac com.java
        // run like this java com 10 20 30
        // Inside the program:
        // args[0] → "10"
        // args[1] → "20"
        // args[2] → "30"

        System.out.println("Number of arguments: " + args.length);

        for ( int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        if (args.length < 2) {
            System.out.println("Please provide 2 numbers.");
            return;
        }
        
        int sum = num1 + num2;
        System.out.println("Sum: " + sum);
    }   
}
