package Day56;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class miniProject56 {
    public static void main(String[] args) {

        ///  Currency Converter

        Scanner sc = new Scanner(System.in);

        System.out.println("1. United States Dollar(USD)");
        System.out.println("2. Euro(EUR)");
        System.out.println("3. Japanese Yen(JPY)");
        System.out.println("4. Philippine Peso(PHP)");
        System.out.print("Convert From: ");
        int from = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        System.out.println("1. United States Dollar(USD)");
        System.out.println("2. Euro(EUR)");
        System.out.println("3. Japanese Yen(JPY)");
        System.out.println("4. Philippine Peso(PHP)");
        System.out.print("Convert To: ");
        int to = sc.nextInt();

        double php = 0;
        double result = 0;

        switch (from) {
            case 1: php = amount * 56; break; // USD TO PHP
            case 2: php = amount * 61; break; // EURO TO PHP
            case 3: php = amount * 0.37; break; // YEN TO PHP
            case 4: php = amount; break; // PHP TO PHP
            default:
                System.out.println("Invalid input");
                return;
        }

        switch (to) {
            case 1: result = php / 56; break; // PHP TO USD
            case 2: result = php / 61; break; // PHP TO EURO
            case 3: result = php / 0.37; break; // PHP TO YEN
            case 4: result = php; break;
            default:
                System.out.println("Invalid input");
                return;
         }

         NumberFormat formatter;
        switch (to) {
            case 1:
                formatter = NumberFormat.getCurrencyInstance(Locale.US);
                break;
            case 2:
                formatter = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                break;
            case 3:
                formatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
                break;
            case 4:
                formatter = NumberFormat.getCurrencyInstance(new Locale("fil", "PH"));
                break;
            default:
                formatter = NumberFormat.getCurrencyInstance();

        }

        System.out.println("Converted Amount: " + formatter.format(result));
    }
}
