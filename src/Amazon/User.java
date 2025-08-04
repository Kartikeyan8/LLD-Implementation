package Amazon;

import CarRental.Car;

import java.util.ArrayList;
import java.util.List;

public class User {

     Cart cart;
    String id;
    String name;
    String email;
    String password;
    List<Order> orders;
    public User(String name, String email, String password) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.orders = new ArrayList<>();
        this.cart = new Cart();
    }
    public void addOrder(Order item) {
        orders.add(item);
    }
    public Cart getCart() {
        return cart;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
