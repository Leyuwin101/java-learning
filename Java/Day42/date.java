package Day42;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class date {
    public static void main(String[] args) {
        // Class	                Purpose
        // LocalDate	            Represents a date (yyyy-mm-dd)
        // LocalTime	            Represents a time (hh:mm:ss)
        // LocalDateTime	        Represents both date & time
        // ZonedDateTime	        Date/time with timezone
        // Period	                Difference between two dates
        // Duration	            Difference between two times

        System.out.println("\nLocalDate");
        LocalDate today = LocalDate.now();
        System.out.println("Today is " + today);
        LocalDate birthday = LocalDate.of(2007, 3, 6);
        System.out.println("Birthday: " + birthday);
        LocalDate nextweek = today.plusWeeks(1);
        System.out.println("Next week: " + nextweek);

        System.out.println("\nLocalTime");
        LocalTime now = LocalTime.now();
        System.out.println("Now: " + now);
        LocalTime lunch = LocalTime.of(12, 30);
        System.out.println("Lunch at: " + lunch);
        LocalTime nextHour = now.plusHours(1);
        System.out.println("Next hour: " + nextHour);

        System.out.println("\nLocalDateTime");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("Now: " + now1);
        LocalDateTime meeting = LocalDateTime.of(2026, 3, 5, 14, 30);
        System.out.println("Meeting: " + meeting);
        
        System.out.println("\nPeriod and Duration");
        Period age = Period.between(birthday, today);
        System.out.println("Age: " + age.getYears() + " years");
        LocalTime start = LocalTime.of(9, 10);
        LocalTime end = LocalTime.of(17, 30);
        Duration workDuration = Duration.between(start, end);
        System.out.println("Work duration: " + workDuration.toHours() + " hours");

        System.out.println("\nFormating Dates and times");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatted = now1.format(formatter);

        System.out.println("Formatted: " + formatted);
    }
}
