package CarRental;

public class Customer {
    String name;
    String driverLicense;
    String email;
    public Customer(String name, String driverLicense, String email) {
        this.name = name;
        this.driverLicense = driverLicense;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getDriverLicense() {
        return driverLicense;
    }
    public String getEmail() {
        return email;
    }
}
