package Day12;
// Class = blueprint
// Object = actual thing created from the blueprint
class Student {
    String name;
    int age;
    double grade;

    void displayInfo() {
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Grade:" + grade);
    }
}

public class oop {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Hirotaka";
        s1.age = 18;
        s1.grade = 99.9;

        Student s2 = new Student();
        s2.name = "Nifuji";
        s2.age = 18;
        s2.grade = 89.75;

        s1.displayInfo();
        System.out.println("--------");
        s2.displayInfo();
    }
}