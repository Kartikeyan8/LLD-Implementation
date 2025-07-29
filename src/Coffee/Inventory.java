package Coffee;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> ingredients;

    public Inventory() {
        this.ingredients = new HashMap<>();
    }

    public void addIngredient(String ingredient, int quantity) {
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + quantity);
    }

    public void removeIngredient(String ingredient, int quantity) {
        if (ingredients.containsKey(ingredient)) {
            int currentQuantity = ingredients.get(ingredient);
            if (currentQuantity >= quantity) {
                ingredients.put(ingredient, currentQuantity - quantity);
            } else {
                System.out.println("Not enough " + ingredient + " in inventory.");
            }
        } else {
            System.out.println(ingredient + " not found in inventory.");
        }
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
