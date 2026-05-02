package Day82;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Represents a shared bank account accessed by multiple threads.
 *
 * Demonstrates:
 * - ReentrantLock for exclusive write operations
 * - tryLock() for non-blocking access
 * - tryLock(timeout) to prevent indefinite waiting
 * - ReadWriteLock for efficient concurrent reads
 */


class BankAccount {
    private int balance = 1000;

    /// ReentrantLock: explicit lock with more control than synchronized
    private final ReentrantLock transactionLock = new ReentrantLock();
    /// ReadWriteLock: allows multiple readers, but only one writer
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void withdraw(String name, int amount) {
        try {
            /// tryLock with timeout: waits up to 2 seconds, avoids indefinite blocking
            if (transactionLock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    if (balance >= amount) {
                        System.out.println(name + " withdrawing " + amount);
                        Thread.sleep(500);
                        balance -= amount;
                        System.out.println(name + " new balance: " + balance);
                    } else {
                        System.out.println(name + " insufficient balance");
                    }
                } finally {
                    /// must always release lock to prevent blocking other threads
                    transactionLock.unlock();
                }
            } else {
                /// lock not acquired within time limit
                System.out.println(name + " could not acquire lock(timeout)");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int checkBalance(String name) {
        /// readLock: shared access, multiple threads can read at the same time
        rwLock.readLock().lock();
        try {
            System.out.println(name + " checking balance: " + balance);
            return balance;
        } finally {
            rwLock.readLock().unlock();
        }
    }


    public void deposit(String name, int amount) {
        /// tryLock(): non-blocking, skips if lock is already held
        if (transactionLock.tryLock()) {
            try {
                System.out.println(name + " depositing " + amount);
                balance += amount;
                System.out.println(name + " new balance: " + balance);
            } finally {
                transactionLock.unlock();
            }
        } else {
            System.out.println(name + " skipped deposit (lock busy)");
        }
    }
}

class User extends Thread {
    private BankAccount account;
    private int amount;

    public User(BankAccount account, String name, int amount) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.checkBalance(getName());
        account.deposit(getName(), 200);
        account.withdraw(getName(), amount);
    }
}
public class advSynchro {
    public static void main(String[] args) {
        /// Why not just synchronized?
        ///
        /// synchronized works, but:
        ///
        /// blocks entire method
        /// no flexibility
        /// can reduce performance
        /// no advanced control (timeout, fairness, etc.)

        BankAccount account = new BankAccount();

        Thread t1 = new User(account, "Seiju", 700);
        Thread t2 = new User(account, "Kenshin", 500);
        Thread t3 = new User(account, "Seiko", 300);

        t1.start();
        t2.start();
        t3.start();

    }
}
