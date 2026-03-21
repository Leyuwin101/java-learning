package Day48;
// Create two threads:
// Print even numbers 1–20
// Print odd numbers 1–20
// Run them simultaneously using Thread class or Runnable.

class ThreadEven implements  Runnable {
    public void run() {
        for ( int i = 2; i <= 20; i += 2 ) {
            System.out.println("Even: " + i);
        }
    }
}


class ThreadOdd implements  Runnable {
    public void run() {
        for ( int i = 1; i <= 20; i += 2 ) {
            System.out.println("Odd: " + i);
        }
    }
}


public class miniProject48 {
    public static void main(String[] args) {        
        Thread t1 = new Thread(new ThreadEven());
        Thread t2 = new Thread(new ThreadOdd());

        t1.start();
        t2.start();
    }
}
