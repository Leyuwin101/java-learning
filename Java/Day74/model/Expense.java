package Day74.model;

import java.time.LocalDate;

public class Expense {
    private String name;
    private String category;
    private double amount;
    private LocalDate date;
    private String image;

    public Expense(String name, String category, double amount, String image, LocalDate date) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.image = image;
        this.date = date;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }
    public String getImage() { return image; }


    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDate(LocalDate date) {this.date = date;}
}
