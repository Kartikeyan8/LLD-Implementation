package RoomRental;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RentalRoomController {
    RoomReservation reservation;

    Room room;
    Customer customer;
    RoomStatus roomStatus;
    RoomType roomType;
    Map<Integer, Room> rooms;
    Map<String, RoomReservation> reservations;
    Map<String, Customer> customers;

    public RentalRoomController() {
        this.rooms = new HashMap<>();
        this.reservations = new HashMap<>();
        this.customers = new HashMap<>();
    }

    public void addRoom(Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    public Customer getCustomer(String name) {
        return customers.get(name);
    }

    public String createReservationId() {
        return "RES" + (reservations.size() + 1);
    }

    public String bookRoom(Customer customer1, Room room1, RoomType roomType, LocalDate startDate, LocalDate endDate) {

            String reservationId = createReservationId();
            reservation = new RoomReservation(customer1, room1, roomType, reservationId, startDate, endDate);
            reservations.put(reservationId, reservation);
            room1.setRoomStatus(RoomStatus.NOT_AVAILABLE);
            System.out.println("Room booked successfully with reservation ID: " + reservationId);

        return reservation.getReservationId();
    }

    public boolean checkOut(String reservationId) {
        if (reservations.containsKey(reservationId)) {
            LocalDate endDate = reservations.get(reservationId).getEndDate();
            LocalDate startDate = reservations.get(reservationId).getStartDate();
            room = rooms.get(reservation.getRoom().getRoomNumber());
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            paymentProcessor.processPayment((int) (room.getPricePerNight() * (endDate.toEpochDay() - startDate.toEpochDay())));
                reservations.remove(reservationId);
                room.setRoomStatus(RoomStatus.AVAILABLE);
                System.out.println("Check-out successful. Room is now available.");
            }
        System.out.println("Invalid reservation ID or room already available.");
        return false;
            }
            public void showAllRooms() {
                System.out.println("Available Rooms:");
                for (Room room : rooms.values()) {
                    if (room.getStatus() == RoomStatus.AVAILABLE) {
                        System.out.println("Room Number: " + room.getRoomNumber() + ", Type: " + room.getRoomType() + ", Price: " + room.getPricePerNight());
                    }
                }
            }
            public void showAllReservations() {
                System.out.println("All Reservations:");
                for (RoomReservation reservation : reservations.values()) {
                    System.out.println("Reservation ID: " + reservation.getReservationId() + ", Room Number: " + reservation.getRoom().getRoomNumber() + ", Start Date: " + reservation.getStartDate() + ", End Date: " + reservation.getEndDate());
                }
            }

}
