package Amazon;

import java.util.List;
import java.util.UUID;

public class Order {
    String id;
    User user;
    OrderStatus status;
    int totalPrice;
    List<OrderItem> orderItems;
    public Order( User user, List<OrderItem> orderItems) {
        this.id = generateId();
        this.user = user;
        this.status = OrderStatus.PENDING;
        this.orderItems = orderItems;

    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void cancel() {
        status = OrderStatus.CANCELLED;
    }
    String generateId() {
        return UUID.randomUUID().toString();
    }
    public void cancelOrder() {
        this.status = OrderStatus.CANCELLED;
        System.out.println("Order " + id + " has been cancelled.");
    }
    public int totalPriceOfOrder()
    {
        int count = 0 ;
        for(OrderItem item : orderItems)
        {
            int priceOfOne = item.getProduct().getPrice();
            int quantity = item.getQuantity();
            count = count + (priceOfOne * quantity);
        }
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return id;
    }

}
