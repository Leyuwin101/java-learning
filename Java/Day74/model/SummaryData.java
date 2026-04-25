package Day74.model;

public class SummaryData {
    public String name;
    public double total;
    public Expense highest;
    public Expense lowest;

    public SummaryData(String name, double total, Expense highest, Expense lowest) {
        this.name = name;
        this.total = total;
        this.highest = highest;
        this.lowest = lowest;
    }
}
