package Day44;

import java.util.Scanner;
import java.util.regex.*;

public class regex {
    public static void main(String[] args) {
        // REGEX
        // Pattern	        Meaning
        // .	            Any character
        // [abc]	        a OR b OR c
        // [0-9]	        Any digit
        // [a-z]	        Lowercase letters
        // [A-Z]	        Uppercase letters
        // \d	            Digit
        // \s	            Whitespace
        // +	            One or more
        // *	            Zero or more
        // ?	            Optional
        // {n}	            Exactly n times

        // Simple Validation (matches)

        String number = "12345";

        if (number.matches("\\d+")) {
            System.out.println("Only Digits");
        } else {
            System.out.println("Invalid");
        }

        // Validate Email
        String email = "Test@gmail.com";
        /**
         * ^                      -> Start of string
         * [A-Za-z0-9+_.-]+       -> One or more letters, digits, + _ . -
         * @                      -> Literal '@' symbol
         * (.+)                   -> One or more of any character (domain part)
         * $                      -> End of string
         *
         * Ensures format: localPart@domain
        */
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (email.matches(regex)) {
            System.out.println("Valid email");
        } else {
            System.out.println("Invalid email");
        }

        // Using Pattern & Matcher
        /**
         * \\d+  -> matches one or more digits (a whole number)
         * find() -> searches for matches in the text
         * group() -> returns the matched value
         *
         * Prints any number found in the string.
         */
        String text = "My number is 09123456789";

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println("Found: " + matcher.group());
        }

        // Replace Using Regex
        
        String rep = "JAVA123PROGRAMMING456";

        String result = rep.replaceAll("\\d+", "#");
        
        System.out.println("Text digits: " + rep + " Replaced with: " + result);

        // Password Validator

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        // (?=.*[A-Z]) → at least one uppercase
        // (?=.*\\d) → at least one digit
        // .{8,} → minimum 8 characters
        String reg = "^(?=.*[A-Z])(?=.*\\d).{8,}";

        if (password.matches(reg)) {
            System.out.println("Strong password");
        } else {
            System.out.println("Weak passwrod");
        }

        sc.close();
    }
}
