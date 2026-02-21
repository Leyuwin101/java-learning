package Day35;
import java.util.Random;
import java.util.function.*;
public class miniProject35 {
    public static void main(String[] args) {
        
        // Predicate<String> to check length > 5
        Predicate<String> checkLength = str -> str.length() > 5;

        // Create a Function<String, String> to reverse a string
        Function<String, String> reverseString = str -> new StringBuilder(str).reverse().toString();
        
        // Supplier<Integer> that returns random 1–100
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100) + 1;

        // Use Consumer to print results
        Consumer<Object> printer = obj -> System.out.println(obj);

        String word = "Hello World";

        printer.accept("Length > 5:  " + checkLength.test(word));
        printer.accept("Reverse String: " + reverseString.apply(word));
        printer.accept("Random Number: " + randomNumber.get());
    }
}
