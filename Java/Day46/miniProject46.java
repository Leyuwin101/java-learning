package Day46;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Fields:
// name
// salary
// department

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    double salary;
    String department;

    Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
public class miniProject46 {
    public static void main(String[] args) {
        
        Employee e1 = new Employee("Seiju", 1000.00, "IT Department");

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Employee.ser"))) {
            out.writeObject(e1);
            System.out.println("Object saved! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}