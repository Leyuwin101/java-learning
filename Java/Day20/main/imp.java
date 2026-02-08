package Day20.main;
// What a package is
// How to create and use packages
// Using the import statement
// Organizing classes for better readability

import Day20.animals.Dog;
import Day20.animals.Cat;

public class imp {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.bark();
        cat.meow();
    }
}
