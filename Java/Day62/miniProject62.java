package Day62;

import java.util.ArrayList;
import java.util.Scanner;

/// Create an abstract base class
/// Name it Employee.
/// Fields: name (String), id (int).
/// Encapsulate with private fields + getters/setters.
/// Add an abstract method work().
/// Optional: Add a static field employeeCount.
///
///
/// Create subclasses
/// Example: Manager and Developer.
/// Each must override work().
/// Implement a Bonus interface with calculateBonus() method.
///
///
/// Add constructors
/// Use parameterized constructors in all classes.
/// Initialize fields and static counters.
///
///
/// Main class (MiniProject2)
/// Create objects of Manager and Developer.
/// Call their work() and calculateBonus() methods.
/// Print total employees using the static method.
/// Wrap in try-catch to handle exceptions.
///
///
/// Optional enhancements
/// Ask user input for names, IDs, and bonuses.
/// Add more subclasses like Intern or Tester.
/// Experiment with static methods or fields.


public class miniProject62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        System.out.println("=== EMPLOYEE MANAGEMENT ===");

        while (true) {
            try {
                System.out.print("Enter employee name: ");
                String name = sc.nextLine();

                System.out.print("Enter employee id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter the role of the Employee (Developer, Manager): ");
                String role = sc.nextLine();

                Employee emp;
                switch (role.toLowerCase()) {
                    case "developer":
                        Developer developer = new Developer(name, id);
                        employees.add(developer);

                        developer.work();

                        System.out.print("Enter the salary of the employee: ");
                        double devSalary = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("The bonus of the developer is: " + developer.calculateBonus(devSalary));

                        break;
                    case "manager":
                        Manager manager = new Manager(name, id);
                        employees.add(manager);

                        manager.work();

                        System.out.print("Enter the salary of the employee: ");
                        double manSalary = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("The bonus of the manager is: " + manager.calculateBonus(manSalary));

                        break;
                    default:
                        System.out.println("Invalid role. Please enter Developer or Manager.");
                        break;
                }
                System.out.println("Employee Count: " + Employee.getEmployeeCount() );

                System.out.print("Add another employee? (y/n): ");
                char choice = sc.next().charAt(0);
                sc.nextLine();

                if (choice == 'n' || choice == 'N') {
                    System.out.println("Exiting....");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}
