package RoomRental;

public class PaymentProcessor {
    public boolean processPayment(int amount) {

        if (amount > 0) {
            System.out.println("Processing payment of $" + amount);
            return true;
        } else {
            System.out.println("Invalid payment amount: $" + amount);
            return false;
        }
    }
}
