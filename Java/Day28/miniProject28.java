package Day28;
import java.util.Scanner;

public class miniProject28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user to enter a sentence
        System.out.println("Please enter a sentence: ");
        String sentence = sc.nextLine();

        // Count number of vowels
        int vowelCount = 0;
        String lower = sentence.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {
            char ch = lower.charAt(i);
            if ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        } 

        System.err.println("Number of vowels: " + vowelCount);

        // Reverse the sentence using StringBuilder
        StringBuilder sb = new StringBuilder(sentence);
        String rev = sb.reverse().toString();

        System.out.println("Reversed sentence: " + rev);
                
        // Check if it is a palindrome
        String cleaned = sentence.replaceAll("\\s+", "").toLowerCase();
        String reversedCleaned = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversedCleaned)) {
            System.out.println("The sentence is a palindrome");
        } else {
            System.out.println("The sentence is not a palindrome");
        }

        sc.close();
    }
}
