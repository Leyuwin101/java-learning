package activities;

import java.util.*;

abstract class Appliance {
    private String brand;
    private String model;
    private double powerConsumption;
    private boolean isOn;

    /** Appliance Constructor */
    public Appliance(String brand, String model, double powerConsumption, boolean isOn) {
        this.brand = brand;
        this.model = model;
        this.powerConsumption = powerConsumption;
        this.isOn = isOn;
    }

    /** GETTER */
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPowerConsumption() { return powerConsumption; }
    public boolean getIsOn() { return isOn; }

    /** SETTER */
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setPowerConsumption(double powerConsumption) { this.powerConsumption = powerConsumption; }
    public void setIsON(boolean isOn) { this.isOn = isOn; } 

    /** METHODS  */
    public void turnOn() { setIsON(true); } 

    public void turnOn(int duration) {
        turnOn();
        System.out.println(getBrand() + " will run for " + duration + " minutes.");
    }

    public void turnOff() { setIsON(false);}
    abstract public void displayStatus();
}

class Light extends Appliance {
    private int brightness;

    public Light(String brand, String model, double powerConsumption, boolean isOn, int brightness) {
        super(brand, model, powerConsumption, isOn);
        this.brightness = brightness;
    }

    /** GETTER AND SETTER */
    public int getBrightness() { return brightness; }
    public void setBrightness(int brightness) { this.brightness = brightness; }

    @Override
    public void displayStatus() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Power Consumption: " + getPowerConsumption());
        System.out.println("Is on: " + getIsOn());
        System.out.print("Brightness: " + getBrightness());
    }
}

class Heater extends Appliance implements Programmable {
    private double temperature;
    private String scheduleOnTime;
    private String scheduleOffTime;

    public Heater(String brand, String model, double powerConsumption, boolean isOn, double temperature) {
        super(brand, model, powerConsumption, isOn);
        this.temperature = temperature;
    }

    /** GETTER AND SETTER */
    public double getTemperature() { return temperature; }
    public String getScheduleOnTime() { return scheduleOnTime; }
    public String getScheduleOffTime() { return scheduleOffTime; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    @Override
    public void turnOn() { 
        setIsON(true); 
        System.out.println(getBrand() + " " + getModel() + " is turning on... ");

        for (int i = 20; i <= 36; i++) {
            temperature = i;
            System.out.println("Temperature: " + temperature + "°C"); 

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Heater reached target temperature: " + temperature + "°C");
    }

    @Override
    public void scheduleOn(String time) { scheduleOnTime = time; }

    @Override
    public void scheduleOff(String time) { scheduleOffTime = time; }

    @Override
    public void displayStatus() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Power Consumption: " + getPowerConsumption());
        System.out.println("Is on: " + getIsOn());
        System.out.print("Temperature: " + getTemperature());
    }
}

class Fan extends Appliance implements Programmable {
    private int speed;
    private String scheduleOnTime;
    private String scheduleOffTime;
    

    public Fan(String brand, String model, double powerConsumption, boolean isOn, int speed) {
        super(brand, model, powerConsumption, isOn);
        this.speed = speed;
    }

    /** GETTER AND SETTER  */
    public int getSpeed() { return speed; }
    public String getScheduleOnTime() { return scheduleOnTime; }
    public String getScheduleOffTime() { return scheduleOffTime; }
    public void setSpeed(int speed) { this.speed = speed; }

    @Override
    public void turnOn() { 
        setIsON(true); 
        System.out.println(getBrand() + " " + getModel() + " is turning on... ");

        for (int i = 1; i <= 20; i++) {
            speed = i;
            System.out.println("Speed: " + speed); 

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Speed reached target speed: " + speed);
    }

    @Override
    public void scheduleOn(String time) { 
        scheduleOnTime = time;
        System.out.println(getBrand() + " scheduled to turn ON at " + time);
    }

    @Override
    public void scheduleOff(String time) { 
        scheduleOffTime = time; 
        System.out.println(getBrand() + " scheduled to turn OFF at " + time);
    }

    @Override
    public void displayStatus() {
        System.out.println("Brand name: " + getBrand());
        System.out.println("Model name: " + getModel());
        System.out.println("Power Consumption: " + getPowerConsumption());
        System.out.println("Is on: " + getIsOn());
        System.out.print("Speed: " + getSpeed());
    }

}

interface Programmable {
    void scheduleOn(String time);
    void scheduleOff(String time);
}

class SmartHome {
    ArrayList<Appliance> appliances;

    public SmartHome() { appliances = new ArrayList<>(); }

    public void addAppliances(Appliance a) {
        appliances.add(a);
        System.out.println(a.getBrand() + " added in the SmartHome." );
    }

    public void listAllAppliances() {
        System.out.println("\n--- APPLIANCE LIST ---");
        for (Appliance appliance: appliances) {
            appliance.displayStatus();
            System.out.println("\n------------------------------");
        }
    }

    public void turnAllON() {
        System.out.println("\nTURNING ALL APPLIANCES ON");
        for (Appliance appliance: appliances) {
            appliance.turnOn();
        }
    }

    public void turnOffAll() {
        System.out.println("\nTURNING ALL APPLIANCES OFF");
        for (Appliance appliance: appliances) {
            appliance.turnOff();
        }
    }

    public void performScheduleActions(String currentTime) {
        System.out.println("\nCHECKING SCHEDULES AT " + currentTime);

        for (Appliance appliance: appliances) {
            if (appliance instanceof Programmable) {
                if (appliance instanceof Heater heater) {
                    if (heater.getScheduleOnTime() != null &&
                        heater.getScheduleOnTime().equals(currentTime)) {
                            heater.turnOn();
                    }
                    if (heater.getScheduleOffTime() != null && 
                        heater.getScheduleOffTime().equals(currentTime)) {
                            heater.turnOff();
                        }
                }
                
                if (appliance instanceof Fan fan) {
                    if(fan.getScheduleOnTime() != null &&
                        fan.getScheduleOnTime().equals(currentTime)) {
                            fan.turnOn();
                    }
                    if (fan.getScheduleOffTime() != null &&
                        fan.getScheduleOffTime().equals(currentTime)) {
                            fan.turnOff();
                    }
                }
            }
        }
    }


    public void simulateUsage() {
        System.out.println("\nSIMULATING APPLIANCES USAGES...");

        for (Appliance appliance: appliances) {
            if (appliance instanceof Heater heater && heater.getIsOn()) {
                heater.setTemperature(heater.getTemperature() + 5);
                System.out.println("HEATER TEMPERATURE INCREASED TO " + heater.getTemperature());
            }
            if (appliance instanceof Fan fan && fan.getIsOn()) {
                fan.setSpeed(fan.getSpeed() + 5);
                System.out.println("FAN SPEED INCREASED TO " + fan.getSpeed());
            }
            if (appliance instanceof Light light && light.getIsOn()) {
                light.setBrightness(light.getBrightness() + 10);
                System.out.println("LIGHT BRIGHTNESS INCREASED TO " + light.getBrightness());
            }
        }
    }
}




public class activity8 {
    public static void main(String[] args) {
        
        SmartHome smartHome = new SmartHome();
        
        Light light = new Light("Philips", "L100", 10, false, 50);
        Heater heater = new Heater("LG", "HeatX", 2000, false, 20);
        Fan fan = new Fan("Panasonic", "FanPro", 75, false, 10);

        smartHome.addAppliances(light);
        smartHome.addAppliances(heater);
        smartHome.addAppliances(fan);

        heater.scheduleOn("08:00");
        fan.scheduleOn("08:00");

        smartHome.listAllAppliances();

        smartHome.performScheduleActions("08:00");

        smartHome.simulateUsage();

        smartHome.listAllAppliances();

        smartHome.turnOffAll();
    }
}
