package Day36;

import java.util.*;

class ListPerson {
    private String name;
    private int age;
    
    public ListPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name;
    }
}
public class miniProject36 {    
    public static void main(String[] args) {
        List<ListPerson> person = new ArrayList<>();

        // Create a List<> of 5 names
        person.add(new ListPerson("Seiju", 18));
        person.add(new ListPerson("Hajime", 19));
        person.add(new ListPerson("Kenshin", 18));
        person.add(new ListPerson("Seiko", 18));
        person.add(new ListPerson("Konan", 18));

        // Remove the first and last element
        person.remove(0);
        person.remove(3);

        for (ListPerson p : person) {
            System.out.println(p.getName().toUpperCase());
        }
        
        // Find the longest name
        ListPerson longest = person.get(0);
        for ( ListPerson p : person) {
            if (p.getName().length() > longest.getName().length()) {
                longest = p;
            }
        } 
        System.out.println(longest);

    }
}
