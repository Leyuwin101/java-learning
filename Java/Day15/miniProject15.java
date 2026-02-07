package Day15;

// Create a car class
class Car {
    private String brand;
    // Static field: total numbers of cars
    private static int Countcars = 0;

    public Car(String brand) {
    // Constructor increment te counter
        this.brand = brand;
        Countcars++;
    }

    public static int getCountcars() {
        return Countcars;
    }

    public void displayInfo() {
        System.out.println("Car brand: " + brand);
    }


}
public class miniProject15 {
    public static void main(String[] args) {
    // Create 3 cars and print total cars
        Car c1 = new Car("Mitsubishi");
        Car c2 = new Car("Honda");
        Car c3 = new Car("Toyota");

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();

        System.out.println("Total cars count: " + Car.getCountcars());
    }
}