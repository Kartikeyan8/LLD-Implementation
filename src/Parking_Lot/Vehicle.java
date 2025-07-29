package Parking_Lot;

import Parking_Lot.ENUMS.VehicleType;

public class Vehicle {
    String licensePlate;
    VehicleType type;
    public Vehicle(String licensePlate,VehicleType type)
    {
        this.licensePlate = licensePlate;
        this.type = type;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public VehicleType getType() {
        return type;
    }
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getVehicleType() == this.type;
    }


}
class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}
class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}
class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.CAR); // Assuming Parking_Lot.Truck is treated as a CAR type for this example
    }
}
