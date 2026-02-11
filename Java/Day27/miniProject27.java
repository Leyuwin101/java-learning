package Day27;

import java.util.ArrayList;

public class miniProject27 {
    public static void main(String[] args) {
        // Create ArrayList<Double>
        ArrayList<Double> numbers = new ArrayList<>();

        // Add values using primitives
        numbers.add(10.0);
        numbers.add(20.0);
        numbers.add(30.0);

        // Calculate total sum
        double total = 0.0;
        for (double num: numbers) {
            total += num;
        }

        System.out.println("Total sum: " + total);

        // Avoid using == when comparing Double
        Double valueTocompare = 20.0;

        for (Double num: numbers) {
            if(num.equals(valueTocompare)) {
                System.out.println("Found: " + num);
            }
        }

    }
}
