package Day49;

class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Task running: " + i);

            try {
                Thread.sleep(500); // 0.5 sec
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class advThread {
    public static void main(String[] args) {
        // Feature	            Thread	                Runnable
        // Type	                Class	                Interface
        // Inheritance	        Extends Thread	        Implements Runnable
        // Flexibility	        Limited	                High
        // Best Practice	    Rare	                Recommended

        // Using lambda
        Thread t = new Thread(() -> {
            System.out.println("Lambda is running");
        });
        t.start();


        // Thread Methods (Important)
        try {
            t.setName("Worker thread");
            System.out.println(t.getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Thread t1 = new Thread(new Task());
        t1.start();
        
    }
}