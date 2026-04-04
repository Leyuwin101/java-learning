package Day62;

abstract class Employee {
    private String name;
    private int employeeId;
    private static int employeeCount = 0;


    ///  Constructor
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
        employeeCount++;
    }

    ///  GETTER
    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }
    public static int getEmployeeCount() { return employeeCount; }

    ///  SETTER
    public void setName(String name) { this.name = name; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    /// Abstract method work

    public abstract void work();


}
