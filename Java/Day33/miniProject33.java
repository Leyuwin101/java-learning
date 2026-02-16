package Day33;

import java.util.*;
import java.util.function.Function;

class Person {
    private String name;

    public Person(String name) { this.name = name; }

    public String getName() { return name; }

    public void displayInfo() { System.out.println("Name: " + name);}
}


public class miniProject33 {
    public static void main(String[] args) {
        //  Create a list of names
        List<String> names = new ArrayList<>();
        names.add("Seiju");
        names.add("Kenshin");
        names.add("Hajime");
        names.add("Hijumee");

        // Sort using method reference
        Collections.sort(names, String::compareTo);

        // Print using method reference
        names.forEach(System.out::println);

        System.out.println("---- Creating Objects ----");

        // Create objects using constructor reference
        Function<String, Person> personCreator = Person::new;

        List<Person> people = new ArrayList<>();
        
        for ( String name: names) {
            people.add(personCreator.apply(name)); 
        }

        // Print objects using method reference
        people.forEach(Person::displayInfo);
    }
}
