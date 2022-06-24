
import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    private Scanner scanner;
    private RecipeBook book;

    public UserInterface(Scanner scanner, RecipeBook book) {
        this.scanner = scanner;
        this.book = book;
    }
    
    private void printCommands() {
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }
    
    private void getLines(ArrayList<String> lines) {
        System.out.print("File to read: ");
        String filename = scanner.nextLine();
        FileHandler handler = new FileHandler(filename);
        handler.readLines(lines);
    }

    private void menu() {
        String command = "";
        
        while (!command.equals("stop")) {
            System.out.println("");
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            if (command.equals("list")) {
                book.list();
            } else if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String word = scanner.nextLine();
                book.find(word);
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int minutes = Integer.valueOf(scanner.nextLine());
                book.find(minutes);
            } else if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                book.findIngredient(ingredient);
            }
            
        }
    }
    
    private void writeBook(ArrayList<String> lines) {
        ArrayList<String> recipe = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) {
                book.makeRecipe(recipe);
            } else {
                recipe.add(lines.get(i));
            }
        }
        if (!recipe.isEmpty()) {
            book.makeRecipe(recipe);
        }
    }
    
    public void start() {
        ArrayList<String> lines = new ArrayList<>();
        getLines(lines);
        writeBook(lines);
        printCommands();
        menu();
        
        
    }
}
