package Amazon;

public class Product {

    int price;
    String name;
    String id;
    int quantity_available;
    boolean isAvailable;
    public Product(String name,  int price,int quantity_available) {
        this.name = name;
        this.isAvailable = true;
        this.id = "PROD" + System.currentTimeMillis();
        this.price = price;
        this.quantity_available = quantity_available;
    }
    void getProductDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Available Quantity: " + quantity_available);
    }
    String getProductId() {
        return id;
    }
    void increaseQuantity(int quantity) {
        this.quantity_available += quantity;
    }
    void decreaseQuantity(int quantity) {
        if (this.quantity_available >= quantity) {
            this.quantity_available -= quantity;
        } else {
            System.out.println("Not enough stock available.");
        }
    }
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
