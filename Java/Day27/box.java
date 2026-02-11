package Day27;
// Autoboxing & Unboxing

import java.util.ArrayList;


public class box {
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();

        // Autoboxing
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        for (Integer num: numbers) {
            int value = num; // unboxing
            System.out.println("Value: " + value);
        }
        Integer a = 200;
        Integer b = 200;

        System.out.println("Using == : " + (a == b));
        System.out.println("Using equals(): " + a.equals(b));
    }
}
