package mini;

import java.util.ArrayList;
import java.util.Scanner;

class RestaurantShop {
    protected String food;
    protected String drinks;
    protected String dessert;
    protected double price;
    protected int quantity;

    public RestaurantShop() {}

    public RestaurantShop(String food, String drinks, String desserts, double price, int quantity) {
        this.food = food;
        this.drinks = drinks;
        this.dessert = desserts;
        this.price = price;
        this.quantity = quantity;
    }

    public String getFood() { return food; }
    public String getDrinks() { return drinks; }
    public String getDessert() { return dessert; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setFood(String food) { this.food = food; }
    public void setDrinks(String drinks) { this.drinks = drinks; }
    public void setDessert(String dessert) { this.dessert = dessert; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void addFood(String food, String drinks, String dessert, int quantity, double price) {
        setFood(food);
        setDrinks(drinks);
        setDessert(dessert);
        setQuantity(quantity);
        setPrice(price);
    }

    public void displayInfo() {
        System.out.println("Food Name: " + getFood());
        System.out.println("Drinks: " + getDrinks());
        System.out.println("Dessert: " + getDessert());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Total price: " + getPrice());
    }
}



public class mini1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<RestaurantShop> items = new ArrayList<>();
        boolean exit = false;

        while(!exit) {
            System.out.println("Welcome to our Restaurant");
            System.out.println("Heres our Menu: ");
            System.out.println("Food: ");
            System.out.println("> Fried Chicken");
            System.out.println("> Spicy Chicken");
            System.out.println("> Grilled Chicken");
            System.out.println("> Buffalo wings");
            System.out.println("Drinks: ");
            System.out.println("> Coke");
            System.out.println("> Pepsi");
            System.out.println("> Mountain Dew");
            System.out.println("Desserts: ");
            System.out.println("> Ice Cream");
            System.out.println("> Cake");
            System.out.println("> Pudding");

            System.out.println("Choose an option here: ");
            System.out.println("1. Order Food");
            System.out.println("2. Check info: ");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: 
                    String addmore;

                    do {
                        System.out.println("Add food: ");
                        String food = sc.nextLine();

                        System.out.println("Add food quantity: ");
                        int foodqty = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Add drinks: ");
                        String drinks = sc.nextLine();
                        
                        System.out.println("Add drinks quantity: ");
                        int drinksqty = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Add dessert: ");
                        String dessert = sc.nextLine();

                        System.out.println("Add dessert quantity: ");
                        int dessertqty = sc.nextInt();
                        sc.nextLine();

                        System.out.println("\nOrder added: ");
                        System.out.println("Food: " + food + " Quantity: " + foodqty);
                        System.out.println("Drinks: " + drinks + " Quantity: " + drinksqty);
                        System.out.println("Dessert: " + dessert + " Quantity: " + dessertqty);

                        int totalqty = foodqty + drinksqty + dessertqty;
                        double totalprice = (foodqty * 50) + (drinksqty * 30) +(dessertqty * 20);

                        RestaurantShop rs = new RestaurantShop();
                        rs.addFood(food, drinks, dessert, totalqty, totalprice);
                        items.add(rs);
                        System.out.println("Order added!!");

                        System.out.println("Would you like to add more? (yes/no)");
                        addmore = sc.nextLine();

                    } while (addmore.equalsIgnoreCase("yes"));
                    break;

                case 2: 
                    if(items.isEmpty()) {
                        System.out.println("No order found!" );
                    } else {
                        for (RestaurantShop r : items ) {
                            System.out.println(r);
                        }
                    }
                    break;
                
                case 3:
                    exit = true;
                    System.out.println("Thanks for ordering!");
                    break;
                
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}