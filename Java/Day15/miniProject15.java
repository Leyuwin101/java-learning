package Day15;

class Car {
    private String brand;
    private static int Countcars = 0;

    public Car(String brand) {
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
        Car c1 = new Car("Mitsubishi");
        Car c2 = new Car("Honda");
        Car c3 = new Car("Toyota");

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();

        System.out.println("Total cars count: " + Car.getCountcars());
    }
}