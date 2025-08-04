package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Controller {
    Map<String , User> users;
    Map<String, Product> products;
    Map<String, Order> orders;
    User user;
    Product product;
    Order order;
    static Controller instance;
    public Controller()
    {
        users = new ConcurrentHashMap<>();
        products = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
    }
    public static synchronized Controller getInstance()
    {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    public void addUser(User user)
    {
        users.put(user.getEmail(), user);
    }
    public void getUser(String email)
    {
        if(users.containsKey(email)) {
            user = users.get(email);
        } else {
            System.out.println("User not found.");
        }
    }
    public void addProduct(Product product)
    {
        products.put(product.getProductId(), product);
    }
    public void addToCart(String email,String name,int quantity)
    {
        if(users.containsKey(email)) {
            user = users.get(email);
            product = products.getOrDefault(name,null);
            if(product != null && product.isAvailable()) {
                user.getCart().add(product, quantity);
                System.out.println("Added " + quantity + " of " + name + " to cart.");
            } else {
                System.out.println("Product not available or does not exist.");
            }

        } else {
            System.out.println("User not found.");
        }
    }
    public Cart getUSerCart(String email) {
        if(users.containsKey(email)) {
            user = users.get(email);
            return user.getCart();
        } else {
            System.out.println("User not found.");
            return null;
        }
    }
    public Product getProduct(String productId) {
        return products.get(productId);
    }
    public List<Product> searchProducts(String keyword) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    public synchronized Order placeOrder(String userId, Payment payment) {
        User user = users.get(userId);
        if (user == null) throw new IllegalArgumentException("User not found");

        List<OrderItem> orderItems = new ArrayList<>();

        Map<Product, Integer> items = user.getCart().getItems();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if(product.isAvailable()) {
                product.decreaseQuantity(quantity);
                orderItems.add(new OrderItem(product, quantity));
            }
        }

        Order order = new Order(user, orderItems);
        orders.put(order.getId(), order);
        user.getCart().clear();
        user.addOrder(order);

        if (payment.processPayment(order.getTotalPrice())) {
            order.setStatus(OrderStatus.PLACED);
        } else {
            order.setStatus(OrderStatus.CANCELLED);
            // Revert the product quantities
            for (OrderItem item : orderItems) {
                Product product = item.getProduct();
                int quantity = item.getQuantity();
                product.increaseQuantity(quantity);
            }
        }

        return order;
    }

    public synchronized void cancelOrder(String orderId) {
        Order order = orders.get(orderId);
        if (order == null) throw new IllegalArgumentException("Order not found");

        order.cancel();
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItem.getProduct().increaseQuantity(orderItem.getQuantity());
        }
    }
    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

}
