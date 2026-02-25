package Day37;

import java.util.*;

public class set {
    public static void main(String[] args) {
        
        Set<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicates will be ignored

        System.out.println(fruits);

        // Common Methods
        // Method	        Description
        // add(E e)	        Add element
        // remove(E e)	    Remove element
        // contains(E e)	Check if element exists
        // size()	        Number of elements
        // clear()	        Remove all elements
        // isEmpty()	    Check if empty

        System.out.println(fruits.size());
        System.out.println(fruits.contains("Apple"));
        System.out.println(fruits.isEmpty());

        // Set Type	        Description
        // HashSet	        No order, fastest access
        // LinkedHashSet	Maintains insertion order
        // TreeSet	        Sorted in natural order (ascending)

        // Using for-each loop
        for (String fruit: fruits) {
            System.out.println(fruit);
        }

        // Using iterator
        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Lambda
        fruits.forEach(System.out::println);
        
    
    }
}