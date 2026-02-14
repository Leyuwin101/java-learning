package activities;

import java.util.ArrayList;
import java.util.Scanner;

// 1. Create a base class with 3 attributes and encapsulated
// 2. Create Derived Classes (ElectronicProduct, ClothingProduct, FoodProduct)
// 3. Create an Interface discountable
// 4. Create a Cart System
// 5. Create a Main Class
abstract class ShopProduct {
    private String name;
    private double price;
    private int stock;

    // Constructor to initialize values
    public ShopProduct() {}

    public ShopProduct(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter and setter for each attribute
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    // void displayInfo() → abstract method
    public void displayInfo() {
        System.out.println("Product name: " + getName());
        System.out.println("Product price: " + getPrice());
        System.out.println("Product stock: " + getStock());
    }

    // boolean purchase(int quantity) → decreases stock if enough available, returns true if purchase successful
    public boolean purchase(int quantity) {
        if ( quantity <= 0 ) {
            System.out.println("Invalid Quantity");
            return false;
        }

        if ( quantity <= getStock() ) {
            setStock(getStock() - quantity);
            System.out.println("Successfully purchased " + quantity + " unit(s) of " + getName());
            return true;
        } else {
            System.out.println("Not enough stock available!");
            return false;
        }
    }

    public void increaseStock(int quantity) {
        if ( quantity <= 0 ) throw new IllegalArgumentException("Quantity must be greater than 0");
        

        setStock(getStock() + quantity);
    }
} 

class ElectricProduct extends ShopProduct implements discountable {
    private int warrantyMonths;

    public ElectricProduct(){}

    public ElectricProduct(String name, double price, int stock, int warrantyMonths) {
        super(name, price, stock);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() { return warrantyMonths; }
    public void setWarrantyMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Product warranty: " + getWarrantyMonths() + " months");
    }

    @Override
    public double applyDiscount(double percentage) {
        if (percentage < 0.0 || percentage > 100.0) {
            throw new IllegalArgumentException("Discount percent must be between 0 to 100.");
        }

        double discountAmount = (getPrice() * percentage) / 100.0;
        double newPrice = getPrice() - discountAmount;

        setPrice(newPrice); // 
        return newPrice;
    }
}

class ClothingProduct extends ShopProduct implements discountable {
    private String size;
    private String color;

    public ClothingProduct(){}

    public ClothingProduct(String name, double price, int stock, String size, String color) {
        super(name, price, stock);
        this.size = size;
        this.color = color;
    }

    public String getSize() { return size; }
    public String getColor() { return color; }

    public void setSize(String size) { this.size = size; }
    public void setColor(String color) { this.color = color; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Product size: " + getSize());
        System.out.println("Product color: " + getColor());
    }

    @Override
    public double applyDiscount(double percentage) {
        if (percentage < 0.0 || percentage > 100.0) {
            throw new IllegalArgumentException("Discount percent must be between 0 to 100.");
        }

        double discountAmount = (getPrice() * percentage) / 100.0;
        double newPrice = getPrice() - discountAmount;

        setPrice(newPrice); // 
        return newPrice;
    }
} 

class FoodProduct extends ShopProduct {
    private String expirationDate;

    public FoodProduct() {}
    
    public FoodProduct(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Product expiration date: " + getExpirationDate());
    }
} 

interface discountable {
    // double applyDiscount(double percentage) → returns price after discount
    // Electronics and Clothing can implement Discountable
    public double applyDiscount(double percentage);
}

class CartItem {
    private ShopProduct product;
    private int quantity;

    public CartItem(ShopProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ShopProduct getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

// Cart only tracks user’s intended items.
class ShoppingCart  {
    ArrayList<CartItem> items = new ArrayList<>();

    // void addProduct(Product p, int quantity)
    // Add product to cart
    public void addProduct(ShopProduct p, int quantity) {
        if ( p == null ) throw new IllegalArgumentException("Product can't be null");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than 0");
        if (quantity > p.getStock()) throw new IllegalArgumentException("Cannot add more than available stock (" + p.getStock() + ")");
    
        for (CartItem item: items) {
            if (item.getProduct().equals(p)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        items.add(new CartItem(p, quantity));
    }

    // void removeProduct(Product p)
    // remove product to cart
    public void removeProduct(ShopProduct p) {
        if ( p == null ) throw new IllegalArgumentException("Procuct can't be null");

        items.removeIf(item -> item.getProduct().equals(p));
    }


    // get all product
    public ArrayList<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    // check if cart is empty 
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Clear cart
    public void clear() {
        items.clear();
    }
}

class Order {
    ArrayList<CartItem> purchasedItems = new ArrayList<>();
    private double totalPrice;

    // process to checkout
    public void checkout(ShoppingCart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        // Reset totalPrice and purchasedItems in case Order object is reused
        totalPrice = 0;
        purchasedItems.clear();

        // Validates all product stocks
        for (CartItem item: cart.getItems()) {
            ShopProduct p = item.getProduct();
            int quantity = item.getQuantity();
            if (p.getStock() <= 0) {
                throw new IllegalArgumentException(p.getName() + " is out of stock");
            }
        }
        
        // Reduce stock and add to purchasedItems
        for (CartItem item: cart.getItems()) {
            ShopProduct p = item.getProduct();
            int quantity = item.getQuantity();
            p.purchase(quantity); // reduce stock by 1 per reference
            purchasedItems.add(item);
            totalPrice += p.getPrice() * quantity;
        }

        // Print receipt
        System.out.println("====== RECEIPT ======");
        for (CartItem item : purchasedItems) {
        System.out.println(item.getProduct().getName() + " x " + item.getQuantity() +
                               " - $ " + (item.getProduct().getPrice() * item.getQuantity()));
        }
        System.out.println("-------------------");
        System.out.println("Total: $" + totalPrice);

        // Clear cart
        cart.clear();
    }
}

public class activity4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ShopProduct> items = new ArrayList<>();

        items.add(new ElectricProduct("Laptop", 100.00, 10, 6));
        items.add(new ElectricProduct("Mobile Phone", 50.00, 10, 6));
        items.add(new ElectricProduct("Tablet", 75.00, 10, 6));

        items.add(new ClothingProduct("Gucci Shirt", 150.70, 5, "Large", "White"));
        items.add(new ClothingProduct("Stussy Shirt", 250.70, 5, "Medium", "Black"));
        items.add(new ClothingProduct("Blue Corner Shirt", 75.70, 5, "Large", "White"));

        items.add(new FoodProduct("Fried Chicken", 50.5, 20, "December 10 2026"));
        items.add(new FoodProduct("Hamburger", 30.5, 10, "March 6 2026"));
        items.add(new FoodProduct("Pork Steak", 20.5, 21, "December 10 2026"));
        
            //  Create multiple products of each type
            // Show menu to user:
            // List all products
            // Add product to cart
            // Remove product from cart
            // Checkout

            // Allow user to apply discount if applicable
            // Use loops, Scanner, and conditionals to interact
        ShoppingCart cart = new ShoppingCart();
        Order order = new Order();

        boolean shopping = true;
        while (shopping) {
                System.out.println("-----Welcome to Our Shop-----");
                System.out.println("-----MENU-----");
                System.out.println(">> 1. List all Product");
                System.out.println(">> 2. Add product to cart");
                System.out.println(">> 3. Remove product from cart");
                System.out.println(">> 4. Apply discount (Electronics/Clothing only)");
                System.out.println(">> 5. View Product Info");
                System.out.println(">> 6. Checkout");
                System.out.println(">> 7. Exit");
                System.out.print("Enter a choice here: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: 
                            System.out.println("Heres the available Product for today");
                            for ( int i = 0; i < items.size(); i++) {
                                ShopProduct p = items.get(i);
                                System.out.println((i+1) + ". " + p.getName() + " - $" + p.getPrice() + " | Stock: " + p.getStock());
                            }
                            break;
                    case 2: 
                            System.out.print("Enter product number to add: ");
                            int addIndex = sc.nextInt() - 1;
                            System.out.print("Enter quantity: ");
                            int qty = sc.nextInt();

                            try {
                                cart.addProduct(items.get(addIndex), qty);
                                System.out.println("Added " + qty + " x " + items.get(addIndex).getName() + " to cart.");
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                    case 3:
                            System.out.print("Enter product number to remove from cart: ");
                            int removeIndex = sc.nextInt() - 1;

                            try {
                                cart.removeProduct(items.get(removeIndex));
                                System.out.println("Removed " + items.get(removeIndex).getName() + " from cart");
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;
                    case 4: 
                            System.out.print("Enter product number to apply discount: ");
                            int discounIndex = sc.nextInt() - 1;
                            ShopProduct p = items.get(discounIndex);

                            if (p instanceof discountable) {
                                System.out.print("Enter discount percentage (0 - 100%): ");
                                double percent = sc.nextDouble();
                                try {
                                    ((discountable) p).applyDiscount(percent);
                                    System.out.println("New price of " + p.getName() + ": $" + p.getPrice());
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } else {
                                System.out.println("Product is not discountable");
                            }
                            break;
                    case 5:
                            if (items.isEmpty()) {
                                System.out.println("No products added yet!");
                            } else {
                                System.out.print("Enter product number to view info: ");
                                int viewIndex = sc.nextInt() - 1;

                                if ( viewIndex >= 0 && viewIndex < items.size()) {
                                    ShopProduct view = items.get(viewIndex);
                                    view.displayInfo();
                                } else {
                                    System.out.println("Invalid product number");
                                }
                            }
                            break;

                    case 6:
                            order.checkout(cart);
                            break;
                    case 7:
                            shopping = false;
                            System.out.println("Exiting. Thank you!");
                            break;
                    default:
                            System.out.println("Invalid choices");
                }
        }
        sc.close();
    }
}