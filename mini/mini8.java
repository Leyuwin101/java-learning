package mini;

import java.util.List;
import java.util.Random;
import java.util.Arrays;
import java.util.function.*;

class StudentGrade {
    private String name;
    private int score;

    public StudentGrade(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return "Student{ name = '" + name + "', score = " + score + "}";
    }
}
public class mini8 {
    public static void main(String[] args) {
        List<StudentGrade> students = Arrays.asList(
            new StudentGrade("Alex", 50),
            new StudentGrade("Jonathan", 78),
            new StudentGrade("Kim", 90),
            new StudentGrade("Samantha", 33),
            new StudentGrade("Ray", 67),
            new StudentGrade("Christopher", 88)
        );

        Predicate<Integer> passingScore = n -> n >= 70;

        Function<Integer, String> convertTOgrade = n -> {
            if ( n >= 90 ) { return "A"; }
            else if ( n >= 80 ) { return "B"; }
            else if ( n >= 70 ) { return "C"; }
            else if ( n >= 60 ) { return "D"; }
            else { return "F"; }
        };

        Supplier<String> randomSection = () -> {
            char sectionLetter = (char) ('A' + new Random().nextInt(3));
            return "Section " + sectionLetter;
        };

        Consumer<String> print = System.out::println;

        students.stream()
        .filter(student-> passingScore.test(student.getScore()))
        .map(student -> "Student: " + student.getName() +
                    "\nScore: " + student.getScore() + 
                    " -> Grade: " + convertTOgrade.apply(student.getScore()) +
                    "\nAssigned: " + randomSection.get() +
                    "\n------------------------------")
        .forEach(print);
    }
}
