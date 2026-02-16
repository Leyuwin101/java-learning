package Day33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class methodReference {
    public static void main(String[] args) {
        // Lambda expression:   numbers.forEach(n -> System.out.println(n));
        // Method Reference:    numbers.forEach(System.out::println);

        // The 4 Types of Method References
        // 1. Static Method Reference
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println(parser.apply("145")); // 145

        // 2. Instance Method of Particular Object
        String str = "Hello";
        Supplier<String> supplier = str::toUpperCase;
        System.out.println(supplier.get()); // HELLO

        // 3. Instance Method of Arbitrary Object
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie");
        names.sort(String::compareTo);

        // 4. Constructor Reference
        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        ArrayList<String> list = listSupplier.get();
    }
}
