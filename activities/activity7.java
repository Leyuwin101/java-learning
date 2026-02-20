package activities;

// =================================================================
// SIMPLE ACTIVITY TO TRAIN MY SKILL
// =================================================================
import java.util.List;
import java.util.ArrayList;

abstract class Person {
    private final String name;
    private final String email;
    private final int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    public void displayInfo() { 
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Age: " + getAge());
    }
}


class Student extends Person {
    private final int studentId;
    private final List<Course> courseList;

    public Student(String name, String email, int age, int studentId ) {
        super(name, email, age);
        this.studentId = studentId;
        this.courseList = new ArrayList<>();
    }
    public int getStudentId() { return studentId; }


    public boolean enrollCourse(Course c) {
        for (Course course : courseList) {
            if ( course.getCourseId() == c.getCourseId()) {
                return false;
            }
        }
        courseList.add(c);
        System.out.println(getStudentId() + " added in Course " + c.getCourseName());
        return true;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student Id: " + getStudentId());
    }
}

class Professor extends Person{
    private final int employeeId;
    private final String department;
    private final List<Course> courseList;

    public Professor(String name, String email, int age, int employeeId, String department) {
        super(name, email, age);
        this.employeeId = employeeId;
        this.department = department;
        this.courseList = new ArrayList<>();
    }

    public int getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }

    public boolean assignCourse(Course c) {
        for ( Course course: courseList) {
            if (course.getCourseId() == c.getCourseId()) {
                return false;
            }
        }
        courseList.add(c);
        System.out.println(getEmployeeId() + " added in Course " + c.getCourseName());
        return true;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Professor Id: " + getEmployeeId());
        System.out.println("Professor Department: " + getDepartment());
    }
}

class Course {
    private final int  courseId;
    private final String courseName;
    private final List<Professor> professorList;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.professorList = new ArrayList<>();
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }

    public boolean assignProfessor(Professor p ) {
        for ( Professor professor : professorList ) {
            if ( professor.getEmployeeId() == p.getEmployeeId()) {
                System.out.println("Professor with id " + p.getEmployeeId() + " already existed");
                return false;
            }
        }
        professorList.add(p);
        System.out.println(p.getEmployeeId() + " added in the course");
        return true;
    }

    public void displayInfo() {
        System.out.println("Course id: " + getCourseId());
        System.out.println("Course name: " + getCourseName());
    }
}

class Department {
    private final String deptName;
    private final List<Student> studentList;
    private final List<Professor> professorList;

    public Department(String deptName) {
        this.deptName = deptName;
        this.studentList = new ArrayList<>();
        this.professorList = new ArrayList<>();
    }

    public String getDeptName() { return deptName; }

    public boolean addStudent(Student s ) {
        for ( Student students: studentList) {
            if (students.getStudentId() == s.getStudentId()) {
                System.out.println("Student with id " + s.getStudentId() + " already existed");
                return false;
            } 
        }
        studentList.add(s);
        System.out.println(s.getStudentId() + " added in the department");
        return true;
    }

    public boolean addProfessor(Professor p ) {
        for ( Professor professor: professorList) {
            if (professor.getEmployeeId() == p.getEmployeeId()) {
                System.out.println("Professor with id " + p.getEmployeeId() + " already existed");
                return false;
            } 
        }
        professorList.add(p);
        System.out.println(p.getEmployeeId() + " added in the department");
        return true;
    }
}

public class activity7 {
    public static void main(String[] args) {
        Department comscie = new Department("Computer Science");
        Professor prof = new Professor("John", "John@gmail.com", 18, 101, "CS101");
        comscie.addProfessor(prof);

        Course oop = new Course(101, "Object-Oriented Programming");
        oop.assignProfessor(prof);

        Student student1 = new Student("Alice", "alice@uni.com", 20, 1001);
        student1.enrollCourse(oop);
        comscie.addStudent(student1);

        student1.displayInfo();
        prof.displayInfo();
        oop.displayInfo();
    }
}
