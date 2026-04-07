
class Vehicle {
    String brand;
    String fuel;
    int maxSpeed;
    int wheels;

    Vehicle(String brand, String fuel, int maxSpeed, int wheels) {
        this.brand = brand;
        this.fuel = fuel;
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Fuel: " + fuel);
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Wheels: " + wheels);
    }

    void start() {
        System.out.println("Vehicle is starting...");
    }

    void stop() {
        System.out.println("Vehicle is stopping...");
    }
}

class ManualVehicle extends Vehicle {

    ManualVehicle(String brand, int maxSpeed, int wheels) {
        super(brand, "None", maxSpeed, wheels);
    }

    @Override
    void displayInfo() {
        System.out.println("Manual Vehicle Details:");
        super.displayInfo();
    }
}
class AutoVehicle extends Vehicle {
    double mileage;

    AutoVehicle(String brand, String fuel, int maxSpeed, int wheels, double mileage) {
        super(brand, fuel, maxSpeed, wheels);
        this.mileage = mileage;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Mileage: " + mileage + " km/l");
    }
}

// Bike Class
class Bike extends AutoVehicle {

    Bike(String brand, String fuel, int maxSpeed, double mileage) {
        super(brand, fuel, maxSpeed, 2, mileage);
    }

    @Override
    void displayInfo() {
        System.out.println("Bike Details:");
        super.displayInfo();
    }

    void ride() {
        System.out.println("Riding the bike...");
    }
}


class Car extends AutoVehicle {

    Car(String brand, String fuel, int maxSpeed, double mileage) {
        super(brand, fuel, maxSpeed, 4, mileage);
    }

    @Override
    void displayInfo() {
        System.out.println("Car Details:");
        super.displayInfo();
    }

    void honk() {
        System.out.println("Car is honking...");

}
}

public class VehicleManagement {
    public static void main(String[] args) {

        Vehicle v1 = new Bike("Yamaha", "Petrol", 120, 45);
        Vehicle v2 = new Car("Honda", "Diesel", 180, 20);
        Vehicle v3 = new ManualVehicle("Atlas", 25, 3);
        Vehicle v4 = new AutoVehicle("Tesla", "battery", 230, 4, 70);
        Vehicle v5 = new AutoVehicle("Tata", "Petrol", 180, 4, 30.0);
        Vehicle v6 = new AutoVehicle("Volvo", "Diesel", 190, 4, 25.0);

        System.out.println("----- Vehicle 1 -----");
        v1.displayInfo();
        v1.start();
        v1.stop();

        System.out.println("----- Vehicle 2 -----");
        v2.displayInfo();
        v2.start();
        v2.stop();

        System.out.println("----- Vehicle 3 -----");
        v3.displayInfo();
        v3.start();
        v3.stop();

        System.out.println("----- Vehicle 4 -----");
        v4.displayInfo();
        v4.start();
        v4.stop();
    
        System.out.println("----- Vehicle 5 -----");
        v5.displayInfo();
        v5.start();
        v5.stop();

         System.out.println("----- Vehicle 6 -----");
        v6.displayInfo();
        v6.start();
        v6.stop(); 

     }
}
