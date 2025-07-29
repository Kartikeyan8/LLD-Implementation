package CarRental;

import java.time.LocalDate;

public class CarRentalMain {
    public static void run() {
        CarRentalController controller = new CarRentalController();
        try {
            controller.addCar(new Car("toyota", 3000, "Sedan123", 1000));
            controller.addCar(new Car("honda", 3500, "Sedan456", 1200));
            controller.addCar(new Car("yamaha", 1500, "Bike123", 500));
            controller.addCar(new Car("ford", 4000, "Truck123", 1500));
            controller.addCar(new Car("suzuki", 2000, "Bike456", 600));
            controller.addCar(new Car("chevrolet", 4500, "SUV123", 1800));
            controller.showAllCars();
            controller.showAllReservations();
            Customer customer = new Customer("John Doe", "1234567890", "kart@gmail.com");
            Car searchedcar = controller.searchCar("toyota");
            String reservationId = controller.makeReservation(customer, searchedcar, LocalDate.now(), LocalDate.now().plusDays(5));
            controller.showAllReservations();
           controller.cancelReservation(reservationId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
