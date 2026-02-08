package Day19;
// Interfaces contain abstract methods (and constants)
// A class implements an interface using implements
// Supports multiple inheritance of type
// Ideal for defining contracts without implementation

interface Animal {
    void eat();
    void makeSound();
}

// Implementing interface
class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog eats dog foods");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat eats fish");
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
public class inter {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.eat();
        a1.makeSound();

        a2.eat();
        a2.makeSound();
    }
}
