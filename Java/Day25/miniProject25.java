package Day25;
import java.util.Scanner;

// Create enum OrderStatus
// Values: PENDING, SHIPPED, DELIVERED, CANCELLED
// Print a message based on status

enum ShippedStatus {
    Pending, Shipped, Delivered, Cancelled
}

public class miniProject25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while ( !exit ) {
        System.out.println("\n ---Shipped Status---");
        for (ShippedStatus s: ShippedStatus.values()) {
            System.out.println(">" + s);
        }


        System.out.println("Choose an option here: ");      
        String input = sc.nextLine();

        try {
            ShippedStatus status = ShippedStatus.valueOf(input);
            switch(status) {
                case Pending:
                    System.out.println("Your order status is pending");
                    break;
                case Shipped:
                    System.out.println("Your order status is Shipped");
                    break;
                case Delivered:
                    System.out.println("Your order status is Delivered");
                    break;
                case Cancelled:
                    System.out.println("Your order status is Cancelled");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid option! Please enter a valid status.");
        }
        }
        sc.close();
    }
}
