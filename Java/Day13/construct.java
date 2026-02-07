package Day13;
// Constructor name = class name
// Run automatically when you use new
// No return type (not even void)
// this refers to the current object
class Student {
    String name;
    int age;
    double grade;

    // Default Constructor
    Student() {
        name = "Unc";
        age = 99;
        grade = 75.69;
    }

    // Parameterized Constructor
    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void displayInfo() {
        System.out.println("===================");        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Grade:" + grade);
    }

}
public class construct {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Juan", 18, 99.89);

        s1.displayInfo();
        s2.displayInfo();
    }
}
