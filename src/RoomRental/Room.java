package RoomRental;

public class Room {
    RoomStatus status;
    int roomNumber;
    int pricePerNight;
    RoomType roomType;
    public RoomStatus getStatus() {
        return status;
    }
    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomStatus(RoomStatus status) {
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }
    public Room(int roomNumber,RoomType roomType, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.status = RoomStatus.AVAILABLE;
        this.roomType = roomType;
    }


}
