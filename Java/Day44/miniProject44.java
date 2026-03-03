package Day44;

import java.util.regex.*;

public class miniProject44 {
    public static void main(String[] args) {
        // Validate Philippine mobile number (starts with 09 and 11 digits total)
        
        String no1 = "09123456789";
        /**
         * ^09        -> must start with 09
         * \\d{9}     -> followed by exactly 9 digits
         * $          -> end of string
         *
         * Ensures 11 digits total and starts with 09.
         */
        String validate = "^09\\d{9}$";

        if (no1.matches(validate)) {
            System.out.println("Philippine number");
        } else {
            System.out.println("Invalid number");
        }

        // Extract all numbers from a sentence

        String text = "123456789 JAVA IS GOOD";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println("Found digits: " + matcher.group());
        }

        // Replace all spaces with _

        String replace = text.replaceAll("\s", "_");
        System.out.println("Text replace with _: " + replace);

    }
}
