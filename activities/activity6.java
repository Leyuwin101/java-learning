package activities;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    private String firstName;
    private String lastName;
    private int employeeId;
    private String job;
    private String specialization;
    private double salary;

    // Empty constructor 
    public Employee() {}

    public Employee(String firstName, String lastName, int employeeId, String job, String specialization, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.job = job;
        this.specialization = specialization;
        this.salary = salary;
        
    }

    // Getter 
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getEmployeeId() { return employeeId; }
    public String getJob() { return job; }
    public String getSpecialization() { return specialization; }
    public double getSalary() { return salary; }

    // Setter
    // public void setFirstName(String firstName) { this.firstName = firstName; }
    // public void setLastName(String lastName) { this.lastName = lastName; }
    // public void setEmployeeID(int employeeId) { this.employeeId = employeeId; }
    // public void setJob(String job) { this.job = job; }
    // public void setSpecialization(String specialization) { this.specialization = specialization; }
    // public void setSalary(double salary) { this.salary = salary; }


    public void displayInfo() {
        System.out.println("Employee First Name: " + getFirstName());
        System.out.println("Employee Last Name: " + getLastName());
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Employee Job: " + getJob());
        System.out.println("Employee Specialization: " + getSpecialization());
        System.out.println("Employee Salary: $" + getSalary());

    }
}

class SoftwareDeveloper extends Employee {

    // Empty Constructor
    public SoftwareDeveloper() {}

    public SoftwareDeveloper(String firstName, String lastName, int employeeId, String job, String specialization, double salary ) {
        super(firstName, lastName, employeeId, job, specialization, salary);
    }

    @Override
    public void displayInfo() {
        System.out.println("========================SOFTWARE DEVELOPER========================");
        super.displayInfo();
    }
}

class DevOps extends Employee {

    // Empty Constructor
    public DevOps() {}

    public DevOps(String firstName, String lastName, int employeeId, String job, String specialization, double salary ) {
        super(firstName, lastName, employeeId, job, specialization, salary);
    }

    @Override
    public void displayInfo() {
        System.out.println("========================DEVOPS========================");
        super.displayInfo();
    }
}


class TechCompany {
    private final ArrayList<Employee> emp;

    public TechCompany() { emp = new ArrayList<>(); }

    public void addEmployee(Employee e) { 
        emp.add(e);
        System.out.println(e.getLastName() + " added in the company");
    }

    public void displayAllEmployee() {
        for ( int i = 0; i < emp.size(); i++ ) {
            System.out.println("Employee #" + ( i + 1));
            emp.get(i).displayInfo();
            System.out.println("--------------------------------------------------------------------------------");
        }   
    }
}

public class activity6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TechCompany company = new TechCompany();
        boolean menu = true;

        company.addEmployee(new SoftwareDeveloper("Seiju", "Hajime", 1001, "Full-Stack Developer", "Java", 10000.0));
        company.addEmployee(new DevOps("Kenshin", "Himura", 1002, "Security Analyst", "Python", 7500.0));

        company.displayAllEmployee();

        while(menu) {
            System.out.println("Welcome to TechCompany: ");
            System.out.println(">>> 1. Add Employee ");
            System.out.println(">>> 2. View Employee(s) ");
            System.out.println(">>> 0. Exit ");
            System.out.println("Choose an option here: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    try {
                        System.out.println("Employee Types:");
                        System.out.println(">>> Software Developer");
                        System.out.println(">>> DevOps");

                        System.out.print("Enter the type of Employee: ");
                        String types = sc.nextLine();

                        System.out.print("Enter Employee First Name: ");
                        String firstName = sc.nextLine();

                        System.out.print("Enter Employee Last Name: ");
                        String lastName = sc.nextLine();

                        System.out.print("Enter Employee ID: ");
                        int empId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Employee Job: ");
                        String job = sc.nextLine();

                        System.out.print("Enter Employee Specialization: ");
                        String specialization = sc.nextLine();

                        System.out.print("Enter Employee Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        Employee newEmployee = null;

                        switch(types.toLowerCase()) {
                            case "softwaredeveloper":
                                newEmployee = new SoftwareDeveloper(firstName, lastName, empId, job, specialization, salary);
                                break;
                            case "devops":
                                newEmployee = new DevOps(firstName, lastName, empId, job, specialization, salary);
                                break;
                            default:
                                System.out.println("Invalid types");
                                break;
                        }

                        if (newEmployee != null ) { company.addEmployee(newEmployee); }
                        break;

                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    company.displayAllEmployee();
                    break;
                case 0:
                    menu = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid Choices");
            }

        }
        sc.close();
    }
}
