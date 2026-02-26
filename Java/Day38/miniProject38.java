package Day38;

import java.util.*;

public class miniProject38 {
    public static void main(String[] args) {
        // Create a Map<String, Integer> of products and prices
        Map<String, Integer> products = new TreeMap<>();

        products.put("Apple", 10);
        products.put("Orange", 20);
        products.put("Milk", 30 );

        // Find the most expensive product
        System.out.println("\nExpensive product:");
        Map.Entry<String, Integer> maxPrice = null;
        for(Map.Entry<String, Integer> entry: products.entrySet()) {
            if ( maxPrice == null || entry.getValue() > maxPrice.getValue()) {
                maxPrice = entry;
            }
        }

        if (maxPrice != null) {
            System.out.println("Highest Price: " + maxPrice.getKey() + " -> " + maxPrice.getValue());
        }

        // Increase all prices by 10%
        System.out.println("\nIncreased Amount");
        for (Map.Entry<String, Integer> entry: products.entrySet()) {
            double increase = 10.0;
            double increaseAmount = entry.getValue() * (increase / 100);
            System.out.println(entry.getKey() + " -> " + (entry.getValue() + increaseAmount));
        }

        // Print all products in sorted order (TreeMap)
        System.out.println("\nSorted products" );
        for (Map.Entry<String, Integer> entry: products.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
