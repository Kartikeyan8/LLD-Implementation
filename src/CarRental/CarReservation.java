package CarRental;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CarReservation {
    Car car;
    Customer customer;
    String reservationId;
    LocalDate startDate;
    LocalDate endDate;
    int totalPrice;
    public CarReservation(Customer customer,Car car, String reservationId, LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.car = car;
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = (int) calculateTotalPrice();
    }
    public Car getCar() {
        return car;
    }
    public Customer getCustomer() {
        return customer;
    }
    public String getReservationId() {
        return reservationId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    private double calculateTotalPrice() {
        long daysRented = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return car.getRentalPricePerDay() * daysRented;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "car=" + car +
                ", customer=" + customer +
                ", reservationId='" + reservationId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
