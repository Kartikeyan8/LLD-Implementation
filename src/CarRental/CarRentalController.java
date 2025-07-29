package CarRental;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalController {
    private final Map<String, Car> cars;
    private Map<String, CarReservation> reservations;
    private PaymentService paymentProcessor;
    public CarRentalController()
    {
        cars = new HashMap<>();
        reservations = new ConcurrentHashMap<>();
    }
    void addCar(Car car)
    {
        cars.put(car.getName_of_car(), car);
    }
    void removeCar(String carName)
    {
        cars.remove(carName);
    }
    public Car searchCar(String carName)
    {
        if(cars.containsKey(carName)) {
            return cars.get(carName);
        } else {
            System.out.println("Car not found.");
            return null;
        }
    }
    public String makeReservation(Customer customer, Car car, LocalDate startdate, LocalDate enddate)
    {
        if(searchCar(car.getName_of_car()) != null) {
            String reservationId = reservationId();
            CarReservation reservation = new CarReservation(customer, car, reservationId, startdate, enddate);
            reservations.put(reservationId, reservation);
            System.out.println("Reservation made with ID: " + reservationId);
            return reservationId;
        }
        return null;
    }
    public void showAllReservations()
    {
        if(reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for(CarReservation reservation : reservations.values())
            {
                System.out.println("Reservation ID: " + reservation.getReservationId() +
                        ", Car: " + reservation.getCar().getName_of_car() +
                        ", Customer: " + reservation.getCustomer().getName() +
                        ", Start Date: " + reservation.getStartDate() +
                        ", End Date: " + reservation.getEndDate());
            }
        }
    }
    public void showAllCars()
    {
        for(Car car : cars.values())
        {
            System.out.println("Car Name: " + car.getName_of_car() + ", ID: " + car.getCarId()
            );
        }
    }
    public void cancelReservation(String reservationId)
    {
        if(reservations.containsKey(reservationId))
        {
            reservations.remove(reservationId);
            System.out.println("Reservation with ID: " + reservationId + " has been cancelled.");
        } else {
            System.out.println("No reservation found with ID: " + reservationId);
        }

    }

    public String reservationId()
    {
        return "RES" + System.currentTimeMillis();
    }



}
