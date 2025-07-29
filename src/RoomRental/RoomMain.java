package RoomRental;

import java.time.LocalDate;

public class RoomMain {

        public static void run ()
        {
            RentalRoomController controller = new RentalRoomController();
            Room room1 = new Room(1, RoomType.SUITE, 100);
            Room room2 = new Room(2, RoomType.SUITE, 150);
            controller.addRoom(room1);
            controller.showAllRooms();
            controller.addRoom(room2);
            Customer customer1 = new Customer("John Doe", "123456789", "kart@gmail.co");
            Customer customer2 = new Customer("Jane Smith", "987654321", "kart2@gmail.com");
            try {
                String booked_room = controller.bookRoom(customer1, room1, room1.getRoomType(), LocalDate.now(), LocalDate.now().plusDays(3));
                String booked_room2 = controller.bookRoom(customer2, room2, room2.getRoomType(), LocalDate.now(), LocalDate.now().plusDays(5));

                controller.showAllReservations();
                controller.checkOut(booked_room); // Cancel reservation for room1
                controller.showAllReservations();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}