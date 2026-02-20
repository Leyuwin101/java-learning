package Day34;

import java.util.Arrays;
import java.util.List;

public class miniProject34 {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Filter even numbers using lambda and square each number
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number) 
                .forEach(System.out::println);
        

        
    }
}
