
import java.util.ArrayList;


public class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }
    
    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    public void list(ArrayList<Recipe> selection) {
        System.out.println("");
        System.out.println("Recipes: ");
        for (Recipe recipe: selection) {
            System.out.println(recipe);
        }
    }
    
    public void list() {
        this.list(this.recipes);
    }
    
    public void find(String word) {
        ArrayList<Recipe> selection = new ArrayList<>();
        for (Recipe recipe: this.recipes) {
            if (recipe.contains(word)) {
                selection.add(recipe);
            }
        }
        this.list(selection);
    }
    
    public void find(int minutes) {
        ArrayList<Recipe> selection = new ArrayList<>();
        for (Recipe recipe: this.recipes) {
            if (recipe.takesLessThan(minutes)) {
                selection.add(recipe);
            }
        }
        this.list(selection);
    }
    
    public void findIngredient(String ingredient) {
        ArrayList<Recipe> selection = new ArrayList<>();
        for (Recipe recipe: this.recipes) {
            if (recipe.includes(ingredient)) {
                selection.add(recipe);
            }
        }
        this.list(selection);
    }
    
    public void makeRecipe(ArrayList<String> recipeLines) {
        String name = recipeLines.get(0);
        int cookingTime = Integer.valueOf(recipeLines.get(1));
        Recipe recipe = new Recipe(name, cookingTime);
        for (int i = 2; i < recipeLines.size(); i++) {
            String ingredient = recipeLines.get(i);
            recipe.addIngredient(ingredient);
        }
        addRecipe(recipe);
        recipeLines.clear();
    }
    
}
