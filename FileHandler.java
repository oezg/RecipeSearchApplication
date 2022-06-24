
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {
    private String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }
    
    public void readLines(ArrayList<String> lines) {
        try (Scanner reader = new Scanner(Paths.get(filename))) {
            
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                lines.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
}
