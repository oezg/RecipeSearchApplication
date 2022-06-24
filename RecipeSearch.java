
import java.util.Scanner;

public class RecipeSearch {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook book = new RecipeBook();
        
        UserInterface ui = new UserInterface(scanner, book);
        ui.start();
    }

}
