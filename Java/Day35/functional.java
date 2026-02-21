package Day35;
import java.util.*;
import java.util.function.*;

// Concept	            Works With
// Lambda	            Functional Interface
// Method               Reference	Functional Interface
// Streams	            Functional Interfaces
// Predicate	        filter()
// Function	            map()
// Consumer	            forEach()

public class functional {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        // Predicate<T> -> Used for testing conditions (returns boolean).
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Constumer<T> -> Takes input, returns nothing.
        Consumer<Integer> print = n -> System.out.println(n);
        
        // Function<T> -> Takes input and returns output.
        Function<Integer, Integer> square = n -> n * n;

        numbers.stream()
                .filter(isEven)
                .map(square)
                .forEach(print);


        // Supplier<T> -? Returns value, takes no input.
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());
    }
}
