package Day55;
import java.util.Scanner;

public class miniProject55 {
    public static void main(String[] args) {
        /// Generate random number (1–50)
        /// Ask user to guess
        /// Print:
        /// Difference between guess and number (Math.abs)
        /// Show square of the number (Math.pow)

        int secret = (int)(Math.random() * 50) + 1;
        int attempt = 5;
        int score = 100;


        Scanner sc = new Scanner(System.in);
        int guess = 0;

        System.out.println("Guess a number from 1 - 50");
        System.out.println("You have " + attempt + " attempts! ");

        while (attempt > 0) {
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();

            if ( guess == secret) {
                System.out.println("You guessed it right");
                System.out.println("Your score: " + score);
                break;
            }

            int difference = Math.abs(guess - secret);

            if ( guess < secret) {
                System.out.println("Your guess is lower than the number");
            } else {
                System.out.println("Your guess is higher than the number");
            }

            System.out.println("Difference: " + difference);

            attempt--;
            score -= 20;

            System.out.println("Attempts left: " + attempt);
            System.out.println("---------------------");
        }

        if ( guess != secret) {
            System.out.println("The correct number was: " + secret);
            System.out.println("The square of the number: " + Math.pow(secret, 2));
        }

        sc.close();
    }
}
