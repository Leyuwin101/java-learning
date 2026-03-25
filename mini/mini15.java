package mini;

import java.util.*;

class Bank {
    private String accountName;
    private int accountNumber;
    private double balance;


    // Constructor
    public Bank(String accountName, int accountNumber, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter
    public int getAccountNumber() { return accountNumber; }


    // Deposit
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw
    public void withdraw(double amount) {
        if ( amount <= balance ) {
            balance -= amount;
            System.out.println("Withdraw: " + amount);
        } else { 
            System.out.println("Insufficient Balance");
        }
    }

    public void displayInfo() {
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + balance);
    }
}


public class mini15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Bank> bankList = new ArrayList<>();
        boolean exit = false;

        while(!exit) {
            System.out.println("====== WELCOME TO OUR BANK ======");
            System.out.println(">>  1. Create Account");
            System.out.println(">>  2. Deposit");
            System.out.println(">>  3. Withdraw");
            System.out.println(">>  4. Account Info");
            System.out.println(">>  5. Exit");
            System.out.print(">> Choose an option here: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    System.out.print("Enter an Account Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter an Account Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter your Current Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    Bank newBank = new Bank(name, number, balance);
                    bankList.add(newBank);
                    System.out.println("Account Created");
                    break;
                case 2:
                    System.out.print("Enter account number to deposit: ");
                    int depAcc = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter amount to Deposit: ");
                    double depAmount = sc.nextDouble();
                    sc.nextLine();

                    boolean foundDep = false;

                    for (Bank acc: bankList) {
                        if (acc.getAccountNumber() == depAcc) {
                            acc.deposit(depAmount);
                            foundDep = true;
                            break;
                        }
                    }

                    if (!foundDep) System.out.println("Account not found! "); 
                    break;
                case 3:
                    System.out.print("Enter account number to Withdraw: ");
                    int accWith = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter amount to Withdraw: ");
                    double withAmount = sc.nextDouble();
                    sc.nextLine();

                    boolean foundWith = false;

                    for (Bank acc: bankList) {
                        if (acc.getAccountNumber() == accWith) {
                            acc.withdraw(withAmount);
                            foundWith = true;
                            break;
                        }
                    }

                    if (!foundWith) System.out.println("Account not found! "); 
                    break;
                case 4:
                    System.out.print("Enter account number to display info: ");
                    int accInfo = sc.nextInt();
                    sc.nextLine();

                    boolean foundAcc = false;
                    for (Bank acc: bankList) {
                        if (acc.getAccountNumber() == accInfo) {
                            acc.displayInfo();
                            foundAcc = true;
                            System.out.println("======================");
                        }
                    }

                    if(!foundAcc) System.out.println("Account not found!");
                    break;
                case 5: 
                    exit = true;
                    System.out.println("Exiting Bank!");
                    break;
                default:
                    System.out.println("Invalid Choices");
            }
        }

        sc.close();
    }
}
