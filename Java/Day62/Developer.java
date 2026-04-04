package Day62;

class Developer extends Employee implements Bonus {
    public Developer(String name, int employeeId) {
        super(name, employeeId);
    }

    @Override
    public void work() {
        System.out.println("The Developer handles the website");
    }

    @Override
    public double calculateBonus(double salary) {
        if ( salary < 0 ) {
            System.out.println("Salary cannot be negative");
        }

        double bonusPercentage = 0.10;

        return salary * bonusPercentage;
    }

}
