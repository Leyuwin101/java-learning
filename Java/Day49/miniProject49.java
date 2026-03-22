package Day49;

public class miniProject49 {
    public static void main(String[] args) {
        // Create 3 threads:
        // Count 1–5
        // Print letters A–E
        // Print symbols *
        // Add sleep() so output is visible step-by-step
        // Use lambda style

        Thread count = new Thread(() -> {
            try {
                for ( int i = 1; i <= 5; i++) {
                    System.out.println("Count Number: " + i);
                    Thread.sleep(500);
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread countChar = new Thread(() -> {
            try {
                for ( char i = 'A'; i <= 'E'; i++) {
                    System.out.println("Count Character: " + i);
                    Thread.sleep(500);
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread symbol = new Thread(() -> {
            try {
                int rows = 5;

                for(int i = 1; i <= rows; ++i) {
                    int k = 0;
                    for (int space = 1; space <= rows - i; ++space) {
                        System.out.print(" ");
                    }

                    while(k != 2 * i - 1) {
                        System.out.print("*");
                        ++k;
                    }

                    Thread.sleep(500);
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            count.start();
            count.join();

            countChar.start();
            countChar.join();

            symbol.start(); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
