package Day23;
// Create parent class Employee with salary
// Child class Manager adds bonus
// Use super to initialize salary
// Override display method
import java.util.Arrays;

class Employee {
    protected int employeeId;
    protected  String employeeName;
    protected  double salary;

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
    protected  double bonus;

    public Manager(int employeeId, String employeeName, double salary, double bonus) {
        super(employeeId, employeeName, salary);
        this.bonus = bonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee bonus: " + bonus);
        System.out.println("Total Pay: " + (salary + bonus));
    }
}

class IT extends Employee {
    protected String[] pl;
    protected String work;

    public IT(int employeeId, String employeeName, double salary, String[] pl, String work) {
        super(employeeId, employeeName, salary);
        this.pl = pl;
        this.work = work;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee Programming Languages: " + Arrays.toString(pl));
        System.out.println("Employee work: " + work);
    }
}
public class miniProject23 {
    public static void main(String[] args) {
        Employee e = new Employee(1001, "Seiju", 50000.80);
        e.display();

        Employee e1 = new Manager(1002, "Hajime", 70000.80, 10000);
        e1.display();

        Employee e2 = new IT(1003, "Pedro", 100000.90, new String[] {"Java", "Javascript"}, "IT");
        e2.display();
    }
}
