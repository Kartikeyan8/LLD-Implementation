package Coffee;

import java.util.Map;

public class Recipe {
    Map<String , Integer> ingredients;
    public Recipe(Map<String , Integer> ingredients)
    {
        this.ingredients = ingredients;
    }
    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
