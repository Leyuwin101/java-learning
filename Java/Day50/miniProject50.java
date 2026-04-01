package Day50;

import java.util.ArrayList;

/// Create a shared BankAccount
/// 3 threads:
/// Deposit
/// Withdraw
/// Deposit
/// Use synchronized to protect balance
/// Print final balance

class BankAccount {
    int balance = 1000;

    ///  List to store transaction logs
    ArrayList<String> logs = new ArrayList<>();


    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing: " + amount);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance += amount;

        String log = Thread.currentThread().getName() + " deposited " + amount + " | Balance: " + balance;
        logs.add(log);
        System.out.println(log);
    }


    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is withdrawing: " + amount);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (balance >= amount) {
            balance -= amount;
            String log = Thread.currentThread().getName() + " withdrew " + amount + " | Balance: " + balance;
            logs.add(log);
            System.out.println(log);
        } else {
            String log = Thread.currentThread().getName() + " failed to withdraw " + amount + " | Insufficient balance";
            logs.add(log);
            System.out.println(log);
        }


    }

    public synchronized int getBalance() { return balance; }
}




public class miniProject50 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        Thread acc1 = new Thread(() -> acc.deposit(2000), "User-1");
        Thread acc2 = new Thread(() -> acc.withdraw(1500), "User-2");
        Thread acc3 = new Thread(() -> acc.deposit(200), "User-3");

        try {
            acc1.start();
            acc2.start();
            acc3.start();

            acc1.join();
            acc2.join();
            acc3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Balance: " + acc.getBalance());

    }
}