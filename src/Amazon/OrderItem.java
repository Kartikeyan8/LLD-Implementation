package Amazon;

public class OrderItem {
    Product product;
    int quantity;
    public int getQuantity() {
        return this.quantity;
    }
    public Product getProduct() {
        return this.product;
    }
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
