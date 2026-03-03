package mini;

import java.util.Scanner;

public class mini12 {
    public static void main(String[] args) {
        /**
         * Account Checker
         *
         * Email regex:
         * ^[A-Za-z0-9+_.-]+@(.+)$
         * -> Basic email format: localPart@domain
         *
         * Password regex:
         * ^(?=.*[A-Z])(?=.*\\d).{8,}
         * -> At least 8 characters
         * -> Must contain 1 uppercase letter
         * -> Must contain 1 digit
         *
         * If both match, account is valid.
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String allowedEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        String allowedPassword = "^(?=.*[A-Z])(?=.*\\d).{8,}";

        if (email.matches(allowedEmail) && password.matches(allowedPassword)) {
            System.out.println("Account is valid");
        } else {
            System.out.println("Invalid account");
        }



        sc.close();
    }
}
