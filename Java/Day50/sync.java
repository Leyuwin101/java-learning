package Day50;

class Bank {
    int balance = 1000;

    /// Synchronized ensures only One thread can access this method at a time
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing: " + amount);

        try {
            Thread.sleep(1000); /// 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance += amount;

        System.out.println(Thread.currentThread().getName() + " completed deposit. Balance: " + balance);
    }

    /// Synchronized prevents race condition when withdrawing
    /// Race Condition → when multiple threads change data at the same time and mess up the result
    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " is withdrawing: " + amount);

        try {
            Thread.sleep(1000); /// 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance -= amount;

        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: " + balance);
    }
}


/// Without synchronized, the execution order may be mixed
/// because threads run at the same time:
///
/// Example:
/// User-1 is depositing: 500
/// User-2 is withdrawing: 300
/// User-1 completed deposit. Balance: 1500
/// User-2 completed withdrawal. Balance: 1200
/// Final balance: 1200
///
/// With synchronized, execution happens one at a time,
/// making the output more consistent and safer:
///
/// Example:
/// User-1 is depositing: 500
/// User-1 completed deposit. Balance: 1500
/// User-2 is withdrawing: 300
/// User-2 completed withdrawal. Balance: 1200
/// Final balance: 1200

public class sync {
    public static void main(String[] args) {
        Bank acc = new Bank();

        Thread t1 = new Thread(() -> acc.deposit(500), "User-1");
        Thread t2 = new Thread(() -> acc.withdraw(300), "User-2");


        try {

            t1.start();
            t2.start();


            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + acc.balance);
    }
}
