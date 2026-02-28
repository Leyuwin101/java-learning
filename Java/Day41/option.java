package Day41;

import java.util.Optional;

public class option {
    public static void main(String[] args) {
        // Optional (to avoid NullPointerException)

        // Method	        Purpose
        // isPresent()	    Check if value exists
        // orElse()	    Return default value
        // orElseGet()	    Lazy default value
        // orElseThrow()	Throw exception
        // ifPresent()	    Execute if value exists

        // Method	                        Meaning
        // Optional.of(T value)	        Create Optional with non-null value
        // Optional.ofNullable(T value)	Create Optional that can accept null
        // Optional.empty()	            Create an empty Optional (no value)

        Optional<String> name = Optional.ofNullable(null);
        Optional<String> of = Optional.of("Seiju");
        Optional<String> empty = Optional.empty();

        System.out.println(name.isPresent());
        System.out.println(name.orElse("Default name"));

        System.out.println(of.get());
        System.out.println(empty.isEmpty());

        
    }
}