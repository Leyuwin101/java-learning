package Day22;
// this = current object
// Used when parameter names match field names
// Can call another constructor in the same class
// Makes code cleaner and safer
class Person {
    private String name;
    private int age;

    // Constructor using this
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Constructor chaining
    public Person(String name) {
        this(name, 0); // calls the other constructor
    }

    public void showInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }


}
public class dis {
    public static void main(String[] args) {
        Person p1 = new Person("Juan", 20);
        Person p2 = new Person("Maria");

        p1.showInfo();
        System.out.println("-----");
        p2.showInfo();
    }
}
