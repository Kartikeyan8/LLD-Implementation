package Parking_Lot;

import Parking_Lot.ENUMS.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<String,ParkingSpot> spots = new HashMap<>();
    Map<String,Ticket> tickets = new HashMap<>();
    Payment payment2;
    int totalTicketsIssued = 0;
    public int totalSpotsAvailable = 3;
    public ParkingLot()
    {
        spots = new HashMap<>();
        tickets = new HashMap<>();
        payment2 = new Payment();
        for(int i = 0; i < totalSpotsAvailable; i++) {
            String spotId = "Spot" + (i+1);
            spots.put(spotId,new ParkingSpot(spotId, VehicleType.CAR));
            String spotIdBike = "Spot" + (i+1) + "Parking_Lot.Bike";
            spots.put(spotIdBike,new ParkingSpot(spotIdBike, VehicleType.BIKE));
            String spotIdTruck = "Spot" + (i+1) + "Parking_Lot.Truck";
            spots.put(spotIdTruck,new ParkingSpot(spotIdTruck, VehicleType.TRUCK));

        }
    }
    public Ticket parkVehicle(Vehicle vehicle)
    {
        for(ParkingSpot spot : spots.values())
        {
            if(!spot.isOccupied && vehicle.canFitInSpot(spot)) {
                spot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle, spot);
                ticket.entryTimeStamp = System.currentTimeMillis();
                tickets.put(ticket.getTicketId(), ticket);
                if(vehicle.getType() == VehicleType.CAR) {;
                    totalTicketsIssued+=2;
                    totalSpotsAvailable -=2;
                }
                else if(vehicle.getType() == VehicleType.BIKE) {
                    totalTicketsIssued+=1;
                    totalSpotsAvailable -=1;
                }
                else if(vehicle.getType() == VehicleType.TRUCK) {
                    totalTicketsIssued+=3;
                    totalSpotsAvailable -=3;
                }
                return ticket;
            }
        }
        System.out.println("Parking Lot is Full");
        return null;
    }
    public void unparkVehicle(String ticketId)
    {
        Ticket tic = tickets.get(ticketId);
        if(tic == null )
        {
            System.out.println("Invalid Parking_Lot.Ticket ID");
            return;
        }
        System.out.println("Parking_Lot.Vehicle with License Plate " + tic.getVehicleLicensePlate() + " has been unparked.");
        System.out.println("Total Fee: " + payment2.calculateFee(tic, tic.parkingSpot));
    }
    public void totalTicketsIssued()
    {
        System.out.println("Total Tickets Issued: " + totalTicketsIssued);
    }
    public void totalSpotsAvailable()
    {
        int availableSpots = 0;
        for(ParkingSpot spot : spots.values())
        {
            if(!spot.isOccupied) {
                availableSpots++;
            }
        }
        System.out.println("Total Spots Available: " + availableSpots);
    }

}
