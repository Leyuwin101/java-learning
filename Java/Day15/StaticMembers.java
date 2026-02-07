package  Day15;

class Student {
    private String name;
    private static int studentCount = 0; // shared across all objects

    // parameterized constructor
    public Student(String name) {
        this.name = name;
        studentCount++; // increment whenever a new student is created
    }

    // Getter
    public static int getStudentCount() {
        return studentCount;
    }

    public void displayInfo() {
        System.err.println("Student: " + name);
    }

}
public class StaticMembers {
    public static void main(String[] args) {
        Student s1 = new Student("Juan");
        Student s2 = new Student("Jan");
        Student s3 = new Student("Jon-Jon");

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        System.out.println("Total students: " + Student.getStudentCount());
    }
}