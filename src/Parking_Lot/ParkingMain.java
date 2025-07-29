package Parking_Lot;
import Parking_Lot.ENUMS.VehicleType;


public class ParkingMain {
    public static void run() throws InterruptedException {
    ParkingLot parkinglot = new ParkingLot() ;
    Vehicle car = new Vehicle("ABC123", VehicleType.CAR);
    Ticket ticket = parkinglot.parkVehicle(car);
        System.out.println("Parking_Lot.Ticket ID: " + ticket.getTicketId() + " For Parking_Lot.Vehicle with License Plate: " + ticket.getVehicleLicensePlate());
        Thread.sleep(5000);
        System.out.println("Total spots available: " + parkinglot.totalSpotsAvailable);
        System.out.println("Unparking Parking_Lot.Vehicle...");
        parkinglot.unparkVehicle(ticket.getTicketId());
        System.out.println("Total tickets issued: " + parkinglot.totalTicketsIssued);
        System.out.println("Total spots available after unparking: " + parkinglot.totalSpotsAvailable);
}
}
