package Day65;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class miniProject65 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Seiju", 85.60, LocalDate.of(2006, 3, 06)));
        students.add(new Student(102, "Kenji", 74.00, LocalDate.of(2007, 8, 11)));
        students.add(new Student(103, "Kenshin", 98.60, LocalDate.of(2006, 1, 1)));

        String pattern = "^[A-Za-z]+$";
        Pattern namePattern = Pattern.compile(pattern);

        System.out.println("==== STUDENT REPORT ==== ");
        System.out.printf("%-10s %-10s %-10s %-5s%n", "Name", "ID", "Grade", "Age");


        List<Student> passing = students.stream()
                .filter(s -> s.getGrade() >= 75)
                .toList();

        for ( Student s: students) {
            if (!namePattern.matcher(s.getName()).matches()) {
                System.out.println("Invalid name: " + s.getName());
                continue;
            }

            System.out.printf("%-10s %-10s %-10s %-5s%n",
                            s.getName(),
                            s.getId(),
                            s.getGrade(),
                            s.getAge());
        }

        double avg = students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0);

        double passRate = (passing.size() * 100.0) / students.size();

        System.out.println("\nAverage Grade: " + avg);
        System.out.println("Pass Rate: " + passRate + "%");

        Optional<Student> result = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase("Kenji"))
                .findFirst();

        result.ifPresentOrElse(
                s -> System.out.println("\nFound: " + s.getName() + " (Grade: " + s.getGrade() + ")"),
                () -> System.out.println("\nStudent not found")
        );

        System.out.println("\n--- Sorted By Grade ---");
        students.stream()
                .sorted((a, b) -> Double.compare(b.getGrade(), a.getGrade()))
                .forEach(s -> System.out.println(s.getName() + " - " + s.getGrade()));

        Map<String, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(s -> s.getGrade() >= 75 ? "Pass" : "Fail"));

        System.out.println("\nGrouped");
        grouped.forEach((k, v ) -> {
            System.out.println(k + ": " + v.size());
        });


        try (FileWriter writer = new FileWriter("C:\\Users\\Dave\\OneDrive\\Desktop\\LearnJava\\Java\\Day65\\student_report.txt ")) {
            writer.write("===== STUDENT REPORT ====\n");
            for (Student s: students) {
                writer.write(s.getName() + " | " + s.getId() + " | " + s.getGrade() + "\n");
            }
            writer.write("\nAverage: " + avg);
            writer.write("\nPass Rate: " + passRate + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
