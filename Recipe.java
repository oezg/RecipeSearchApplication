
import java.util.ArrayList;


public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = new ArrayList<>();
    }
    
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return name + ", cooking time: " + cookingTime;
    }
    
    public boolean contains(String word) {
        return this.name.contains(word);
    }
    
    public boolean takesLessThan(int minutes) {
        return this.cookingTime <= minutes;
    }
    
    public boolean includes(String ingredient) {
        return this.ingredients.contains(ingredient);
    }
    
    
}
