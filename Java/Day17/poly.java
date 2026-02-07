package Day17;
// Overloading = same method name, different parameters
// Overriding = child class redefines parent method
// Polymorphism = many forms

class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class poly {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Dog(); // Parent reference, child object
        Animal a3 = new Cat();

        a1.makeSound(); // Some generic animal sound
        a2.makeSound(); // Woof! Woof!
        a3.makeSound(); // Meow!

        // Method overloading
        MathOperations op = new MathOperations();
        System.out.println(op.add(5, 10));  // int
        System.out.println(op.add(5.5, 3.2)); // double
    }
}

// Overloading 
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}