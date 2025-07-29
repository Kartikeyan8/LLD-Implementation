package Parking_Lot;

import Parking_Lot.ENUMS.VehicleType;

public class Payment {
    long exitTimeStamp = System.currentTimeMillis();
    public double calculateFee(Ticket ticket ,
                         ParkingSpot parkingSpot) {
        System.out.println("Calculating fee for ticket ID: " + ticket.getTicketId());
long duration = Math.abs(exitTimeStamp - ticket.entryTimeStamp);
        System.out.println("Duration in milliseconds: " + duration);
        double fee = 0.0;

        if (parkingSpot.getVehicleType() == VehicleType.CAR) {
            fee = duration * 2.0; // Example rate for cars
        } else if (parkingSpot.getVehicleType() == VehicleType.BIKE) {
            fee = duration * 1.0; // Example rate for bikes
        } else if (parkingSpot.getVehicleType() == VehicleType.TRUCK) {
            fee = duration * 3.0; // Example rate for trucks
        }
        return fee;
    }
}
