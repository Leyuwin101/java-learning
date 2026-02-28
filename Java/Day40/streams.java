package Day40;

import java.util.*;

public class streams {
    public static void main(String[] args) {
        // A Stream is not a data structure.
        // It is a pipeline used to process data from collections like List, Set, etc

        // stream → start pipeline
        // parallelStream → start parallel pipeline

        // filter → keep
        // map → change
        // mapToInt / mapToDouble / mapToLong → change to primitive
        // flatMap → flatten
        // sorted → order
        // distinct → unique
        // limit / skip → control amount
        // peek → inspect (debug)

        // forEach → perform action
        // collect → store
        // toList → store as list
        // reduce → combine
        // sum → add
        // min / max → smallest / largest
        // average → mean
        // count → total elements

        // anyMatch → at least one matches
        // allMatch → all match
        // noneMatch → none match

        // findFirst → get first
        // findAny → get any
        
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        numbers.stream()
                .filter(n-> n > 10) // keep all the numbers greater than 10
                .map(n -> n * 2) // multiply by 2 
                .sorted() // sort
                .forEach(System.out::println); // print

    }
}
