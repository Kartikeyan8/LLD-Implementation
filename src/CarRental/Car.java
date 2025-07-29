package CarRental;

public class Car {
    String name_of_car;
    int year_of_manufacture;
    String CarId;
    int rentalPricePerDay;
    boolean available;
    public String getName_of_car() {
        return name_of_car;
    }

    public int getYear_of_manufacture() {
        return year_of_manufacture;
    }

    public String getCarId() {
        return CarId;
    }

    public int getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }
    public Car(String name_of_car, int year_of_manufacture, String carId, int rentalPricePerDay) {
        this.name_of_car = name_of_car;
        this.year_of_manufacture = year_of_manufacture;
        this.CarId = carId;
        this.rentalPricePerDay = rentalPricePerDay;
        this.available = true;
    }



}
