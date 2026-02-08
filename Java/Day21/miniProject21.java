package Day21;

// Create BankAccount class
class BankAccount {
// private balance
// public deposit() and withdraw() methods
// protected accountNumber
    private double balance;
    protected int accountNumber;

    public BankAccount(double initialBalance, int accountNumber) {
        this.accountNumber = accountNumber;
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if ( amount < 0 ) {
            System.out.println("Deposit amount must be greater than zero");
            return false;
        }
        balance += amount;
        System.out.printf("Successfully deposited %.2f. New balance: %.2f%n", amount, balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if ( amount > balance) {
            System.out.println("Insufficient Balance, Please Try Again");
            return false;
        }
        balance -= amount;
        System.out.printf("Successfully deposited %.2f. New balance: %.2f%n", amount, balance);
        return true;
    }

    public double getBalance() {
        return balance;
    }
}

class Person extends BankAccount {
    public String name;
    public int age;

    public Person(double balance, int accountNumber, String name, int age) {
        super(balance, accountNumber);
        this.name = name;
        this.age = age;
    }

    public void showPersonInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
public class miniProject21 {
    public static void main(String[] args) {

        BankAccount a1 = new BankAccount(100, 1001);
        a1.deposit(2000); // 100 + 2000
        System.out.println(a1.getBalance()); // 2100

        a1.withdraw(2000); // 2100 - 2000
        System.out.println(a1.getBalance()); // 100\

        // this also works
        Person p1 = new Person(1000, 1002, "Hajime", 18);
        p1.showPersonInfo();
    }
}
