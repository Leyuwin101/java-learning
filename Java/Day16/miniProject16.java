package Day16;
// Create Animal parent class with eat() method
class Animal {
    String name;
    public static int AnimalCount = 0;

    public Animal(String name) {
        this.name = name;
        // Only increment if this is an actual Animal, not a subclass
        if (this.getClass() == Animal.class) {
            AnimalCount++;
        }
    }

    public static int GetAnimalCount() {
        return AnimalCount;
    }

    public void eat() {
        System.out.println(name + " can eat");
    }
}

// Create Dog and Cat Child Classes
// Override eat() for each child
class Dog extends Animal {
    private static int dogCount = 0; 

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void eat() {
        System.out.println(name + " eats dog food");
    }

    public void dogInfo() {
        System.out.println("Name: " + name  );
    }
}

class Cat extends Animal {
    public static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void eat() {
        System.out.println(name + " eats cat food");
    }

    public void catInfo() {
        System.out.println("name: " + name);
    }
}
public class miniProject16 {
    public static void main(String[] args) {
        // Create Objects and call their methods
        Animal a1 = new Animal("Domestic Animal");
        a1.eat();

        Dog d1 = new Dog("Oreo");
        Dog d2 = new Dog("Blackie");

        d1.dogInfo();
        d1.eat();
        d2.dogInfo();
        d2.eat();
        System.out.println("Total dog count: " + Dog.getDogCount());
        
        Cat c1 = new Cat("Garfield");
        c1.catInfo();
        c1.eat();
        System.out.println("Total cat count: " + Cat.getCatCount());

        System.out.println("Animal count: " + Animal.GetAnimalCount());
    }
}