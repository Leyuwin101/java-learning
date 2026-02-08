package Day20.main;
// Create package vehicles
// Add classes Car and Bike with methods drive()
// Create Main class in a separate package and call both methods

import Day20.vehicle.Bike;
import Day20.vehicle.Car;
public class miniProject20 {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();

        bike.drive();
        car.drive();
    }
}
