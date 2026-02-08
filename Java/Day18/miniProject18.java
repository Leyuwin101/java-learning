package Day18;
// Create abstract class Employee
// Abstract method calculateSalary()
abstract class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();
}

// Child classes: FullTimeEmployee, PartTimeEmployee
class FullTimeEmployee extends Employee {
    double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        // For full-time, salary is just the fixed monthly salary   
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        // For part-time, salary = hourly rate * hours worked
        return hourlyRate * hoursWorked;
    }
}


public class miniProject18 {
    public static void main(String[] args) {
        Employee fullTime = new FullTimeEmployee("Jon", 1001, 70000);
        Employee partTime = new PartTimeEmployee("Jeric", 1002, 450, 80);

        System.out.println(fullTime.name + "'s salary: " + fullTime.calculateSalary() + " Pesos");
        System.out.println(partTime.name + "'s salary: " + partTime.calculateSalary() + " Pesos");
    }
}
