package mini;

public class mini14 {
    public static void main(String[] args) {
        
        Thread even = new Thread(() -> { 
            for ( int i = 2; i <= 20; i += 2) {
                System.out.println("Even: " + i);

                try {
                    Thread.sleep(500);
                } catch(InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        });


        Thread odd = new Thread(() -> {
            for ( int i = 1; i <= 19; i += 2) {
                System.out.println("Odd: " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        odd.start();
        even.start();
    }
}
