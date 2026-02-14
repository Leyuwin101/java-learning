package Day31;

public class miniProject31 {
    public static void main(String[] args) {
        
        if ( args.length < 3) {
            System.out.println("Usage: java MiniProject31 num1 operator num2");
            return;
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            String operator = args[1];
            int num2 = Integer.parseInt(args[2]);

            switch (operator) {
                case "+":
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case "-":
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case "*": 
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case "/":
                    if (num2 == 0) {
                            System.out.println("Cannot divide by zero!");
                    } else {
                            System.out.println("Result: " + (num1 / num2));
                    }
                    break; 
                default:
                    System.out.println("Invalid Operator");
            }
        } catch (Exception e) {
            System.out.println("Invalid input please try to put an Integer");
        }

        // Multiply all numbers passed in arguments
        int product = 1;
        boolean hasNumber = false;
        for (String arg: args) {
            try {
                int n = Integer.parseInt(arg);
                product *= n;
            } catch (NumberFormatException e) {
            }
        }
        if (hasNumber) {
            System.out.println("Product of numbers: " + product);
        } else {
            System.out.println("No valid integers found to calculate product.");
        }

        // Find the largest argument
        Integer max = null;
        for (String arg: args) {
            try {
            int n = Integer.parseInt(arg);
            if (max == null || n > max) {
                max = n;
                hasNumber = true;
            } 
            } catch (NumberFormatException e) {
                // Skip non-integer args
            }
        }
        if (max != null) {
            System.out.println("Largest number: " + max);
        } else {
            System.out.println("No valid integers found to determine largest number.");
        }

        // Handle invalid numbers safely
    }
}
