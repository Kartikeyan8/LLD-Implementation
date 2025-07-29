package RoomRental;

public class Customer {
    String name;
    String mobileNumber;
    String email;
    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }


    public Customer(String name, String mobileNumber, String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

}
