package Day42;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class miniProject42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        // Ask user for their birthdate (yyyy-mm-dd)
        System.out.print("Enter the year of your birthday: ");
        int year = sc.nextInt();
        
        System.out.print("Enter the month of your birthday: ");
        int month = sc.nextInt();

        System.out.print("Enter the day of your birthday: ");
        int day = sc.nextInt();

        LocalDate birth = LocalDate.of(year, month, day);
        System.out.println(birth);

        // Calculate and print their age in years
        Period age = Period.between(birth, today);
        System.out.println("Your age is: " + age.getYears());

        // Calculate days until next birthday
        LocalDate nextBirthday = birth.withYear(today.getYear());
        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long daysUntil = ChronoUnit.DAYS.between(today, nextBirthday);
        System.out.println("Days until next birthday: " + daysUntil);

        // Print current time in HH:mm:ss format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formatted = now.format(formatter);

        System.out.println("Formatted: " + formatted);
    }
}
