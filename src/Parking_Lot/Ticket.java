package Parking_Lot;

public class Ticket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    long entryTimeStamp;
    long exitTimeStamp;
    public Ticket(Vehicle vehicle,ParkingSpot parkingSpot)
    {
        this.ticketId = "TICKET" + System.currentTimeMillis();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }
    public String getTicketId() {
        return ticketId;
    }
    public String getVehicleLicensePlate() {
        return vehicle.getLicensePlate();
    }


}
