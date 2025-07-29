package RoomRental;

import java.time.LocalDate;

public class RoomReservation {
    Customer customer;
    Room room;
    String reservationId;
    LocalDate startDate;
    LocalDate endDate;
    RoomType roomType;
    public String getReservationId() {
        return reservationId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public Room getRoom() {
        return room;

    }
    public RoomReservation(Customer customer, Room room,RoomType roomType, String reservationId, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.room = room;
        this.roomType = roomType;
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
