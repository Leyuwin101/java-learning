package Day23;
// Create parent class Employee with salary
// Child class Manager adds bonus
// Use super to initialize salary
// Override display method

class Employee {
    public int employeeId;
    public String employeeName;
    public double salary;

    public Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public void display() {
        System.out.println("--------------------------------------------------");
        System.out.println("Employee Id: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Salary: " + salary);
    }
}

class Manager extends Employee {
    public double bonus;

    public Manager(int employeeId, String employeeName, double salary, double bonus) {
        super(employeeId, employeeName, salary);
        this.bonus = bonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee bonus: " + bonus);
        System.out.println("Total Pay: " + salary + bonus);
    }
}
public class miniProject23 {
    public static void main(String[] args) {
        Employee e = new Employee(1001, "Seiju", 50000.80);
        e.display();

        Employee e1 = new Manager(1001, "Hajime", 70000.80, 10000);
        e1.display();
    }
}
