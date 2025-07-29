package Coffee;

public class Coffee {
    String name;
    int price;
    Recipe recipe;
    public Recipe getRecipe() {
        return recipe;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Coffee(String name, int price, Recipe recipe) {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }
}
