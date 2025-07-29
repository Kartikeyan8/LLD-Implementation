package Parking_Lot;

import Parking_Lot.ENUMS.VehicleType;
import Parking_Lot.ENUMS.SPOTS;

public class ParkingSpot {
    String spotId;
    boolean isOccupied;
    VehicleType type;
    SPOTS spotType;
    public ParkingSpot(String spotId, VehicleType type) {
       this.spotId =spotId;
       this.type = type;
    }
    public boolean getisOccupied() {
        return isOccupied;
    }
    public boolean assignVehicle(Vehicle vehicle)
    {

        spotId = vehicle.getLicensePlate();
        isOccupied = true;
        return true;
    }
    public boolean removeVehicle() {
        if(!isOccupied) {
            throw new IllegalStateException("Spot is not occupied");
        }
        spotId = null;
        isOccupied = false;
        return true;
    }
    public SPOTS getSpotType() {
        return spotType;
    }
    public String getSpotId() {
        return spotId;
    }
    public VehicleType getVehicleType() {
        return type;
    }

}
class BikeSpot extends ParkingSpot {
    public BikeSpot(String spotId) {
        super(spotId,VehicleType.BIKE);
    }
}
class CarSpot extends ParkingSpot {
    public CarSpot(String spotId) {
        super(spotId,VehicleType.CAR);
    }
}
class TruckSpot extends ParkingSpot {
    public TruckSpot(String spotId) {
        super(spotId,VehicleType.TRUCK);

    }
}
