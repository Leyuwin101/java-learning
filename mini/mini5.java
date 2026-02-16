package mini;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.List;

// 1️⃣ Create a Student class
//  Attributes:
//      String name
//      int age
//      double grade
// 
//  Include:
//      Constructor
//      Getters
//      toString()
// Static method: public static int compareByGrade(Student s1, Student s2)
// Instance method: public int compareByName(Student other)
// 
// 2️⃣ In Main class
// Create:
//      ArrayList<Student> students = new ArrayList<>();
//      Add at least 5 students.

class Student {
    private final String name;
    private final int age;
    private final double grade;


    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Student(String name) { this(name, 0, 0.0); }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }


    @Override
    public String toString() { return "Name: " + name + "||  age: " + age +  " || Grade: " + grade; }

    public static int compareByGrade(Student s1, Student s2) {
        return Double.compare(s1.getGrade(), s2.getGrade());
    } 

    public int compareByName(Student other) { return this.name.compareToIgnoreCase(other.name); }

    public boolean isTopStudent() { return this.grade >= 85; }

}

@FunctionalInterface
interface StudentFilter {
    boolean filter(Student s);
}
public class mini5 {
    public static List<Student> filterStudents(List<Student> students, StudentFilter filter) {
        List<Student> result = new ArrayList<>();
        for (Student s: students) {
            if (filter.filter(s)) result.add(s);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Seiju", 18, 95.9));
        students.add(new Student("Haji", 25, 85.9));
        students.add(new Student("Meisu", 19, 96.9));
        students.add(new Student("Suji", 17, 75.9));
        students.add(new Student("Jisu", 16, 75.9));

        // Lambda expresion convert to Method Reference
        // Task 1 – Static Method Reference
        students.sort((s1, s2) -> Student.compareByGrade(s1, s2));
        students.sort(Student::compareByGrade);

        // Task 2 – Instance Method Reference (Object)
        students.forEach(s -> System.out.println(s));
        students.forEach(System.out::println);

        // Task 3 – Instance Method Reference (Class)
        students.sort((s1, s2) -> s1.compareByName(s2));
        students.sort(Student::compareByName);

        // Task 4 – Constructor Reference

        List<String> names = List.of("Alex" , "Bern" , "Catty");
        // Use Stream + constructor reference to create Student objects
        List<Student> newStudents = names.stream()
            .map(Student::new)
            .collect(Collectors.toList());

        System.out.println("New Students: ");
        newStudents.forEach(s -> System.out.println(s));
        
        List<Student> topStudents = filterStudents(students, Student::isTopStudent);
        for (Student s: topStudents) {
            System.out.println("Top student: " + s);
        }

    }
}
