package Coffee;

public class Ingredients {
    String name;
    int quantity;
    public Ingredients(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public void use(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough " + name + " available.");
        }
    }
}
