package activities;
import java.util.ArrayList;
import java.util.Scanner;
// Activity: Vehicle Management System
// 1. Create an abstract class Vehicle with attributes:
//      brand (String)
//      model (String)
//      year (int)
//      fuelLevel (double)
//      maxFuel (double
//
//  Methods:
//      drive(double distance) → reduces fuel based on some consumption rate
//      refuel(double liters) → increases fuel but not above maxFuel
//      Abstract displayInfo()
//
//  Encapsulate all fields using getters and setters.
// 
// 2. Inheritance
//  Create subclasses:
//      Car → fuel consumption: 0.1 per km
//      Truck → fuel consumption: 0.3 per km
//      Motorcycle → fuel consumption: 0.05 per km
//
//  Override drive() if needed for specific behavior (e.g., trucks consume more fuel per km)
//
// 3. Interface
//   Create an interface Loadable:
//      load(double weight)
//      unload(double weight)
//
// Implement Loadable in Truck (cars and motorcycles don’t implement it).
//
// 4: Polymorphism
//  Use method overloading in Vehicle:
//      refuel(double liters) → refuels normally
//      refuel() → refuels tank to full
//
// Use method overriding in subclasses to show specific driving or display info.
// 5: Collections & Loops
//  Maintain an ArrayList<Vehicle> in a Garage class.
//  Allow adding vehicles, listing all vehicles, and performing actions like drive or refuel.


abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double fuelLevel;
    private double maxFuel;
    private double currentSpeed;

    public Vehicle() {}

    public Vehicle(String brand, String model, int year, double fuelLevel, double maxFuel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
        this.maxFuel = maxFuel;
        this.currentSpeed = 0; // default speed
    }

    // Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getFuelLevel() { return fuelLevel; }
    public double getMaxFuel() { return maxFuel; }
    public double getCurrentSpeed() { return currentSpeed; }

    // Setters
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setFuelLevel(double fuelLevel) { this.fuelLevel = fuelLevel; }
    public void setMaxFuel(double maxFuel) { this.maxFuel = maxFuel; }
    public void setCurrentSpeed(double speed) { 
        if (speed < 0) speed = 0; 
        this.currentSpeed = speed; 
    }

    protected abstract double getConsumptionRate();

    public void drive(double distance) {
        if (distance < 0 ) throw new IllegalArgumentException("Distance must be non negative");

        double fuelNeeded = distance * getConsumptionRate();
        if (fuelNeeded > getFuelLevel()) {
            double possibleDistance = getFuelLevel() / getConsumptionRate();
            setFuelLevel(0);
            System.out.println(getBrand() + " Only able to drive " + possibleDistance + " km. Fuel empty now.");
        } else {
            setFuelLevel(getFuelLevel() - fuelNeeded);
            System.out.println(getBrand() + " Drove " + distance + " km. Fuel left: " + getFuelLevel() + " liters.");
        }
    }

    // Refuel 
    public void refuel(double liters) {
        if ( liters < 0 ) throw new IllegalArgumentException("Liters must be non negative");

        fuelLevel += liters;
        if ( fuelLevel > maxFuel ){
            fuelLevel = maxFuel;
        }
        System.out.println("Refueled in " + getBrand() + " Current fuel: " + fuelLevel + " liters.");
    }

    // Overloadding Refuel
    public void refuel() {
        fuelLevel = maxFuel;
        System.out.println("Refueled to full. Current fuel: " + fuelLevel + " liters.");
    }   

    // Abstract displayInfo
    public abstract void displayInfo();

    // Accelerate Method
    public void accelerate(double kmh) {
        if ( kmh < 0 ) throw new IllegalArgumentException("KMH must be positive");
        setCurrentSpeed(getCurrentSpeed() + kmh);
        System.out.println(getBrand() + " Accelerated by " + kmh + " km/h. Current speed: " + getCurrentSpeed() + " km/h.");
    }

    // Decrease Method
    public void decrease(double kmh) {
        if ( kmh < 0 ) throw new IllegalArgumentException("KMH must be positive");
        setCurrentSpeed(getCurrentSpeed() - kmh);
        System.out.println(getBrand() + " Slowed down by " + kmh + " km/h. Current speed: " + getCurrentSpeed() + " km/h.");
    }
}

class Car extends Vehicle {

    public Car(){}

    public Car(String brand, String model, int year, double fuelLevel, double maxFuel) {
        super(brand, model, year, fuelLevel, maxFuel);
    }

    // Override Abstract Getter
    @Override
    protected double getConsumptionRate() { return 0.1; }

    // Override Abstract displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Fuel Level: " + getFuelLevel());
        System.out.println("Max Fuel: " + getMaxFuel());
        System.out.println("Consumption rate: " + getConsumptionRate() + " per km");
    }

}

// Interface for load and unload weight
interface Loadable {
    void load(double weight);
    void unload(double weight);
}

class Truck extends Vehicle implements Loadable {
    private double currentLoad;
    private double maxLoad = 10000;

    public Truck(){}

    public Truck(String brand, String model, int year, double fuelLevel, double maxFuel) {
        super(brand, model, year, fuelLevel, maxFuel);
    }

    // Getters
    @Override
    protected double getConsumptionRate() { return 0.3; }

    // Override Load Method
    @Override
    public void load(double weight) {
        if ( weight < 0 ) throw new IllegalArgumentException("Weight must be positive");
        if ( currentLoad + weight > maxLoad) {
            System.out.println(getBrand() + " Cannot load " + weight + " kg. exceeded the max load capacity");
        } else {
            currentLoad += weight;
            System.out.println("Loaded " + weight + " kg. Current load: " + currentLoad + " kg. in " + getBrand());
        }
    }

    // Override Unload Method
    @Override
    public void unload(double weight) {
        if ( weight < 0 ) throw new IllegalArgumentException("Weight must be positive");
        if ( weight > currentLoad ) {
            System.out.println(getBrand() + "Cannot unload " + weight + " kg. Only " + currentLoad + " kg available");
        } else {
            currentLoad -= weight;
            System.out.println("UnLoaded " + weight + " kg. Current load: " + currentLoad + " kg. in " + getBrand());
        }
    }

    // allerate is reduced because its a truck
    @Override 
    public void accelerate (double kmh) {
        super.accelerate(kmh * 0.5);
    }

    // Overrid Display Info
    @Override
    public void displayInfo() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Fuel Level: " + getFuelLevel());
        System.out.println("Max Fuel: " + getMaxFuel());
        System.out.println("Consumption rate: " + getConsumptionRate() + " per km");
        System.out.println("Current load: " + currentLoad + "/" + maxLoad + " kg");
    }

}

class Motorcycle extends Vehicle {

    public Motorcycle(){}

    public Motorcycle(String brand, String model, int year, double fuelLevel, double maxFuel) {
        super(brand, model, year, fuelLevel, maxFuel);
    }

    // Getter
    @Override
    protected double getConsumptionRate() { return 0.05;}

    // Override displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Fuel Level: " + getFuelLevel());
        System.out.println("Max Fuel: " + getMaxFuel());
        System.out.println("Consumption rate: " + getConsumptionRate() + " per km");
    }
}

// abstract class extend to another abstract class
abstract class ElectricVehicle extends Vehicle {
    private double batteryLevel;
    private double maxBattery;

    public ElectricVehicle() {}
    
    public ElectricVehicle(String brand, String model, int year, double batteryLevel, double maxBattery) {
        super(brand, model, year, 0, 0);
        this.batteryLevel = batteryLevel;
        this.maxBattery = maxBattery;
        
    }
    
    // Getter
    public double getBatteryLevel() { return batteryLevel; }
    public double getMaxBattery() { return maxBattery; }

    // Setter
    public void setBatteryLevel(double batteryLevel) {
        if (batteryLevel < 0 ) batteryLevel = 0;
        if (batteryLevel > maxBattery) batteryLevel = maxBattery;
        this.batteryLevel = batteryLevel;
    }
    public void setMaxBattery(double maxBattery) { this.maxBattery = maxBattery; }

    // recharge method same as the refuel
    public void recharge(double kWh) {
        if ( kWh < 0 ) throw new IllegalArgumentException("KWH must be non negative");
        setBatteryLevel(getBatteryLevel() + kWh);
        System.out.println("Recharged " + kWh + " kWh. Current battery: " + batteryLevel + "/" + maxBattery);
    }

    // overload recharge
    public void recharge() {
        setBatteryLevel(maxBattery);
        System.out.println("Battery fully recharged. Current battery: " + batteryLevel + "/" + maxBattery);
    }   

    // Override the abstract methods
    @Override
    public abstract void drive(double distance);

    @Override
    public abstract void displayInfo();
}

class ElectricCar extends ElectricVehicle {
    private final double consumptionRate = 0.15;

    public ElectricCar() {}
    
    public ElectricCar(String brand, String model, int year, double batteryLevel, double maxBattery) {
        super(brand, model, year, batteryLevel, maxBattery);
    }

    // Getter
    @Override 
    protected double getConsumptionRate() { return consumptionRate; }

    // Override drive method 
    @Override
    public void drive(double distance) {
        if (distance < 0 ) throw new IllegalArgumentException("Distance must be non negative");

        // instead of fuel we do it by batteryLevel
        double batteryNeeded = distance * consumptionRate;
        if (batteryNeeded > getBatteryLevel()) {
            double possibleDistance = getBatteryLevel() / consumptionRate;
            setBatteryLevel(0);
            System.out.println(getBrand() + " Only able to drive " + possibleDistance + " km. Battery empty now.");
        } else {
            setBatteryLevel(getBatteryLevel() - batteryNeeded);
            System.out.println(getBrand() + "Drove " + distance + " km. Battery left: " + getBatteryLevel() + " kWh.");
        }
    }

    // Override Display Method
    @Override
    public void displayInfo() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Battery: " + getBatteryLevel() + "/" + getMaxBattery() + " kWh");
        System.out.println("Consumption rate: " + getConsumptionRate() + " per km");
    }
}

class ElectricMotorcycle extends ElectricVehicle {
    private final double consumptionRate = 0.08;

    public ElectricMotorcycle() {}
    
    public ElectricMotorcycle(String brand, String model, int year, double batteryLevel, double maxBattery) {
        super(brand, model, year, batteryLevel, maxBattery);
    }

    // Getter
    @Override 
    protected double getConsumptionRate() { return consumptionRate;}

    // Override drive method
    @Override
    public void drive(double distance) {
        if (distance < 0 ) throw new IllegalArgumentException("Distance must be non negative");

        double batteryNeeded = distance * consumptionRate;
        if (batteryNeeded > getBatteryLevel()) {
            double possibleDistance = getBatteryLevel() / consumptionRate;
            setBatteryLevel(0);
            System.out.println("Only able to drive " + possibleDistance + " km. Battery empty now.");
        } else {
            setBatteryLevel(getBatteryLevel() - batteryNeeded);
            System.out.println("Drove " + distance + " km. Battery left: " + getBatteryLevel() + " kWh.");
        }
    }

    // Overide display method
    @Override
    public void displayInfo() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Battery: " + getBatteryLevel() + "/" + getMaxBattery() + " kWh");
        System.out.println("Consumption rate: " + getConsumptionRate() + " per km");
    }
}

// Class Garage
class Garage {
    private final ArrayList<Vehicle> vehicles;

    public Garage() {
        vehicles = new ArrayList<>();
    }
    // All of this method is used in the scanner

    // Add Vehicle By user input
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        System.out.println(v.getBrand() + " added to the garrage");
    }

    // Get Vehicle by their index
    public Vehicle getVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            return vehicles.get(index);
        }
        return null;
    }

    // Display All the vehicle
    public void displayAllVehicle() {
        for ( int i = 0; i < vehicles.size(); i++) {
            System.out.println("Vehicle #" + (i + 1));
            vehicles.get(i).displayInfo();
            System.out.println("------------------");
        }
    }

    // Drive vehicle 
    public void driveVehicle(int index, double distance) {
        if ( index >= 0 && index < vehicles.size()) {
            vehicles.get(index).drive(distance);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Refuel vehicle
    public void refuelVehicle(int index, double liters) {
        if ( index >= 0 && index < vehicles.size()) {
            vehicles.get(index).refuel(liters);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Rechare Vehicle
    public void rechargeVehicle(int index, double kWh) {
        if (index >= 0 && index < vehicles.size()) {

            Vehicle v = vehicles.get(index);

            if (v instanceof ElectricVehicle) {
                ((ElectricVehicle) v).recharge(kWh);
            } else {
                System.out.println("Vehicle is not an electric");
            }
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Accelerate Vehicle 
    public void accelerateVehicle(int index, double kmh) {
        if ( index >= 0 && index < vehicles.size()) {
            vehicles.get(index).accelerate(kmh);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    //  Decrease(Break) Vehicle
    public void decreaseVehicle(int index, double kmh) {
        if ( index >= 0 && index < vehicles.size()) {
            vehicles.get(index).decrease(kmh);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    // Load or Unload in Truck only
    public void loadOrunloadTruck(int index, double weight, boolean isLoad) {
        if ( index >= 0 && index < vehicles.size()) {
            
            Vehicle v = vehicles.get(index);

            if ( v instanceof Truck) {
                Truck truck = (Truck) v;
                if (isLoad) {
                    truck.load(weight);
                } else {
                    truck.unload(weight);
                }
            } else {
                System.out.println("Selected vehicle is NOT a truck.");
            }

        } else {
        System.out.println("Vehicle not found.");
        }
    }
}

public class activity5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Garage myGarage = new Garage();
        boolean exit = false;

        // Manual adding of vehicle truck
        myGarage.addVehicle(new Truck("Mitsubishi", "Truck", 2020, 10, 20));

        while (!exit) {
                System.out.println(">>> 1. Add Vehicle");
                System.out.println(">>> 2. List Vehicles");
                System.out.println(">>> 3. Drive Vehicle");
                System.out.println(">>> 4. Refuel / Recharge Vehicle");
                System.out.println(">>> 5. Accelerate Vehicle");
                System.out.println(">>> 6. Brake Vehicle");
                System.out.println(">>> 7. Load / Unload Truck");
                System.out.println(">>> 0. Exit");
                System.out.print(">>> Choose an Option here: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch ( choice ) {
                    case 1: 
                        System.out.print("Enter Vehicle type (Car / Truck / Motorcycle / ElectricCar / ElectricMotorcycle): ");
                        String type = sc.nextLine();

                        System.out.print("Enter brand name: ");
                        String brand = sc.nextLine();

                        System.out.print("Enter model name: ");
                        String model = sc.nextLine();

                        System.out.print("Enter Year Created: ");
                        int year = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter FuelLevel / BatteryLevel: ");
                        double level = sc.nextDouble();

                        System.out.print("Enter Max Fuel / Max BatteryLevel: ");
                        double max = sc.nextDouble();
                        sc.nextLine();

                        Vehicle newVehicle = null;

                        switch (type.toLowerCase()) {
                            case "car":
                                    newVehicle = new Car(brand, model, year, level, max);
                                    break;
                            case "truck":
                                    newVehicle = new Truck(brand, model, year, level, max);
                                    break;
                            case "motorcycle":
                                    newVehicle = new Motorcycle(brand, model, year, level, max);
                                    break;
                            case "electriccar":
                                    newVehicle = new ElectricCar(brand, model, year, level, max);
                                    break;
                            case "electricmotorcycle":
                                    newVehicle = new ElectricMotorcycle(brand, model, year, level, max);
                                    break;    
                            default:
                            System.out.println("Invalid vehicle type.");
                            break;                        
                        }

                        if (newVehicle != null ) {
                            // Add the vehicle to the ArrayList
                            myGarage.addVehicle(newVehicle);
                        }
                        break;
                    case 2:
                        myGarage.displayAllVehicle();
                        break;
                    case 3: 
                        System.out.print("Enter index number to drive: ");
                        int driveIndex = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Enter how long the distance is: ");
                        double distance = sc.nextDouble();
                        sc.nextLine();
                        
                        myGarage.driveVehicle(driveIndex, distance);
                        break;
                    case 4:
                        System.out.print("Enter the index number to refuel/recharge: ");
                        int refuelIndex = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();

                        Vehicle v = myGarage.getVehicle(refuelIndex);

                        if ( v instanceof ElectricVehicle ) {
                            myGarage.rechargeVehicle(refuelIndex, amount);
                        } else {
                            myGarage.refuelVehicle(refuelIndex, amount);
                        }
                        break;
                    case 5:
                        System.out.print("Enter the index number to accelerate: ");
                        int accelerateIndex = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Enter speed increase (km/h): ");
                        double accelAmount = sc.nextDouble();
                        sc.nextLine();

                        myGarage.accelerateVehicle(accelerateIndex, accelAmount);
                        break;
                    case 6:
                        System.out.print("Enter the index number to break: ");
                        int decreaseIndex = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Enter speed decrease (km/h): ");
                        double decreaseAmount = sc.nextDouble();
                        sc.nextLine();

                        myGarage.decreaseVehicle(decreaseIndex, decreaseAmount);
                        break;
                    case 7:
                        System.out.print("Enter the index number to load or disload in the truck: ");
                        int truckIndex = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.println(">>> 1. Load");
                        System.out.println(">>> 2. Unload");
                        int action = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter weight(k/g): ");
                        double weight = sc.nextDouble();
                        sc.nextLine();

                        if ( action == 1 ) {
                            myGarage.loadOrunloadTruck(truckIndex, weight, true);
                        } else if ( action == 2) {
                            myGarage.loadOrunloadTruck(truckIndex, weight, false);
                        }
                        break;
                    case 0:
                        exit = true;
                        break;
                    default: 
                        System.out.println("Invalid choices");
                }
        }
        sc.close();
    }
}
