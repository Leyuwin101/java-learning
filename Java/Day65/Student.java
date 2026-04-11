package Day65;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private int id;
    private String name;
    private double grade;
    private LocalDate birthdate;

    public Student(int id, String name, double grade, LocalDate birthdate)
    {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.birthdate = birthdate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGrade() { return grade; }
    public LocalDate getBirthdate() { return birthdate; }

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}