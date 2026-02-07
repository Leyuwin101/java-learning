package Day14;
// Fields should almost always be private
// Access and Modification through the public method
// You can validate data in setters
// Protects your object from invalid states
class Student {
    private String name;
    private int age;
    private double grade;


    // getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // getter and setter for age
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if ( age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age, ano ka immortal");
        }
    }

    // getter and setter for age
    public double getGrades() {
        return grade;
    }
    public void setGradeS(double grade) {
        if (grade >= 0 && grade <= 100 ) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade, dinaig mo pa si einstein");
        }
    }

    void displayInfo() {
        System.out.println("===================");       
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Grade:" + grade);
    }
}

public class encap {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Hajime");
        s1.setAge(18);
        s1.setGradeS(88.88);
        s1.displayInfo();

        s1.setAge(-1);
        s1.setGradeS(110);
    }
}