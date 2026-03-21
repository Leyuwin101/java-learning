package Day48;
class MyThread extends Thread {
    public void run() { 
        for ( int i = 1; i <= 5; i++) {
            System.out.println("Thread A: " + i);
        }
    }
}

// Implement Runnable Interface
class MyRunnable implements Runnable {
    public void run() {
        for ( int i = 1; i <= 5; i++) {
            System.out.println("Thread B: " + i);
        }
    }
}
public class threads {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        Thread tr2 = new Thread(new MyRunnable());
        tr2.start();


        // Thread Methods
        // Method	        Description
        // start()	        Begin thread execution
        // run()	        The task of thread (do not call directly to start thread)
        // sleep(ms)	    Pause thread for ms milliseconds
        // join()	        Wait for thread to finish
        // setPriority()	Set thread priority (1–10)
    }
}
