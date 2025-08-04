package Amazon;

public class AmazonMain {
    public void run()
    {
    Controller main = new Controller();
    User user1 = new User("John Doe", "kart@gmail","qwerty");
    User user2 = new User("Jane Smith", "kart2@gmail","asdfgh");
    main.addUser(user1);
    main.addUser(user2);
    Product product1 = new Product("Laptop", 23, 5);
    Product product2 = new Product("Mobile", 12, 3);
    main.addProduct(product1);
    main.addProduct(product2);
    main.addToCart("kart@gmail","Laptop", 2);
    Order order1 = main.placeOrder(user1.getId(),new Payment());




}}
