package Coffee;

import java.util.Map;

public class Menu {
    Map<String,Coffee> menu;
    public Menu( Map<String,Coffee> menu) {
        this.menu = menu;
    }
    public  Map<String,Coffee> getMenu() {
        return menu;
    }
    public void addCoffee( String coffeename,Coffee coffee) {
        menu.put(coffee.getName(), coffee);
    }
    public void removeCoffee(String coffeeName) {
        menu.remove(coffeeName);
    }
    public void displayAll()
    {
        System.out.println("Coffee Menu:");
        for(Map.Entry<String,Coffee> entry : menu.entrySet()) {
            Coffee coffee = entry.getValue();
            System.out.println(coffee.getName() + " - " + coffee.getPrice() + " - ");
        }
    }

}
