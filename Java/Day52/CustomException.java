package Day52;
/// Creating custom exception

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

///  Unchecked Custom Exception

class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class BankAccount {
    double balance;

    BankAccount(double balance) { this.balance = balance; }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if ( balance < amount) {
            throw new InsufficientBalanceException("Not enough money");
        }
        balance -=  amount;
        System.out.println("Withdraw successful. Remaining Balance: " + balance);
    }
}


public class CustomException {
    ///  Using the exception
    public static void checkAge(int age) throws InvalidAgeException {
        if ( age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access Granted");
        }
    }
    public static void main(String[] args) {
        /// What is Custom Exception
        /// A custom exception is a class you create that extends:
        ///
        ///     Exception → Checked exception
        ///     RuntimeException → Unchecked exception

        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

       BankAccount acc = new BankAccount(1000);

        try {
            acc.withdraw(1500);
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException(e);
        }

        /// Type	                            Use Case
        /// Checked (Exception)	                When caller MUST handle it
        /// Unchecked (RuntimeException)	    Programming errors or optional handling

    }
}
