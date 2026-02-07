package Day16;
// Child class inherits all non-private members of parent
// Child can override methods of parent
// super keyword accesses parent constructor or methods
// Use inheritance for an  "is-a" relationship

// Parent Class

class Vehicle {
    String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println(brand + " says: Beep beep!");
    }
}

// Child Class 
class Car extends Vehicle {
    int doors;

    public Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }

    // Overriding method
    @Override
    public void honk() {
        System.out.println(brand + " car says: Honk honk!");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Doors: " + doors);
    }

}
public class Inherit {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Generic Vehicle");
        v1.honk();

        Car c1 = new Car("Toyota", 4);
        c1.honk();
        c1.displayInfo();
    }
}
