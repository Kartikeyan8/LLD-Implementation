package Amazon;

public class Payment {
    boolean processPayment(int amount) {
        if (amount > 0) {
            System.out.println("Payment of " + amount + " processed successfully.");
            return true;
        } else {
            System.out.println("Payment failed. Invalid amount: " + amount);
            return false;
        }
    }
}
