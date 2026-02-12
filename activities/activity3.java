package activities;
// 1. CREATE A BASE CLASS named Product with attributes of productName, price, stockQuantity and apply encapsulation
// 2. IN THE BASE CLASS, DECLARE 3 ABSTRACT METHODS
// 2.1 void addProduct(String name, double price, int stock)
// 2.2 boolean purchaseProduct(int quantity)
// 2.3 void displayProductInfo()
// 3. CREATE A DERIVED CLASS named ElectronicProduct
// 4. CREATE A Main CLASS

import java.util.ArrayList;
import java.util.Scanner;

abstract class Product {
    private String productName;
    private double price;
    private int stockQuantity;

    public Product() {};

    public Product(String productName, double price, int stockQuantity) {
        this.productName = productName;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void setProductName(String productName) { this.productName = productName; }
    public void setPrice(double price) { this.price = price; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public abstract void addProduct(String productName, double price, int stockQuantity);
    public abstract boolean purchaseProduct(int stockQuantity);
    public abstract void displayProductInfo();
}

class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct() {};

    public ElectronicProduct(String productName, double price, int stockQuantity, int warrantyMonths) {
        super(productName, price, stockQuantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantMonths() { return warrantyMonths; }
    public void setWarrantMonths(int warrantyMonths) { this.warrantyMonths = warrantyMonths; }

    @Override
    public void addProduct(String productName, double price, int stockQuantity) {
        setProductName(productName);
        setPrice(price);
        setStockQuantity(stockQuantity);
        System.out.println("Product added: " + productName );
    }

    @Override
    public boolean purchaseProduct(int stockQuantity) {
        if (stockQuantity <= 0) {
            System.out.println("Invalid quantity");
            return false;
        }

        if (stockQuantity <= getStockQuantity()) {
            setStockQuantity(getStockQuantity() - stockQuantity);
            System.out.println("Successfully purchased " + stockQuantity + " unit(s) of " + getProductName());
            return true;
        } else {
            System.out.println("Not enough stock available!");
            return false;
        }
    }

    @Override 
    public void displayProductInfo() {
        System.out.println("===========================");
        System.out.println("Product name: " + getProductName());
        System.out.println("Product price: " + getPrice());
        System.out.println("Product stock: " + getStockQuantity());
        System.out.println("Product warranty: " + getWarrantMonths() + " months");
    }
}

public class activity3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> items = new ArrayList<>();
        boolean exit = false;

        while(!exit) {
            System.out.println("========ONLINE SHOP SYSTEM========");
            System.out.println("> 1. Add Product");
            System.out.println("> 2. Purchase Product");
            System.out.println("> 3. Display Product Info");
            System.out.println("> 4. Exit");
            System.out.println("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:     
                    System.out.println("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter product price: ");
                    double price = sc.nextDouble();

                    System.out.println("Enter product stock: ");
                    int stock = sc.nextInt();

                    System.out.println("Enter warranty months: ");
                    int warranty = sc.nextInt();

                    ElectronicProduct ep = new ElectronicProduct();

                    ep.addProduct(name, price, stock);
                    ep.setWarrantMonths(warranty);
                    items.add(ep);
                    System.out.println("Product added succesfuly! ");

                    break;
                
                case 2: 
                    System.out.println("Enter product name to purchased: ");
                    String purchase = sc.nextLine();
                    boolean found = false;
                    
                    for (Product p: items) {
                        if (p.getProductName().equalsIgnoreCase(purchase)) {
                            System.out.println("Enter quantity: ");
                            int qty = sc.nextInt();
                            sc.nextLine();

                            p.purchaseProduct(qty);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    if (items.isEmpty()) {
                        System.out.println("No product available, add products now");
                    } else {
                        for (Product p: items ) {
                            p.displayProductInfo();
                        }
                    }
                    break;

                case 4: 
                    exit = true;
                    System.out.println("BYEEE");
                    break;
                    
            }
        }
        sc.close();
    }
}
