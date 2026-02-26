package Day38;

import java.util.*;
import javax.print.DocFlavor;

public class mapa {
    public static void main(String[] args) {
        Map<String, Integer> studentScores = new HashMap<>();

        // Add entries
        studentScores.put("Alice", 90);
        studentScores.put("Bob", 88);
        studentScores.put("Jane", 95);

        System.out.println(studentScores); // [Bob=88, Alice=90, Jane=95]
        System.out.println(studentScores.keySet()); // [Bob, Alice, Jane]
        System.out.println(studentScores.values()); // [88, 90, 95]
        System.out.println(studentScores.entrySet()); // [Bob=88, Alice=90, Jane=95]
        System.out.println(studentScores.containsKey("Alice")); // true
        System.out.println(studentScores.containsValue(95)); // true
        System.out.println(studentScores.get("Alice")); // 90

        // Common Methods
        // Method	                Description
        // put(K key, V val)	    Add or update entry
        // get(K key)	            Retrieve value for key
        // remove(K key)	        Remove entry by key
        // containsKey(K key)	    Check if key exists
        // containsValue(V val)	    Check if value exists
        // size()	                Number of entries
        // keySet()	                Get all keys
        // values()	                Get all values
        // entrySet()	            Get all key-value pairs

        // Iterating Over a Map

        // Using entrySet()
        for(Map.Entry<String, Integer> entry: studentScores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Using keySet()
        for(String key: studentScores.keySet()){
            System.out.println(key + " -> " + studentScores.get(key));
        }

        // Using lambda
        studentScores.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}