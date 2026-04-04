package Day62;

class Manager extends Employee implements Bonus {

    public Manager(String name, int employeeId) {
        super(name, employeeId);
    }

    @Override
    public void work() {
        System.out.println("The Manager manage the team");
    }

    @Override
    public double calculateBonus(double salary) {
        if ( salary < 0 ) {
            System.out.println("Salary cannot be negative");
        }

        double bonusPercentage = 0.15;

        return salary * bonusPercentage;
    }

}
