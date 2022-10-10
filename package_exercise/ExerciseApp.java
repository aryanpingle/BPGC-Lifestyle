package package_exercise;

import driver.App;
import driver.BackException;

public class ExerciseApp extends App {
    @Override
    public void start() throws BackException {
        // Reset the screen
        resetScreen();
        
        System.out.println("Page 1 / 2");
        System.out.println("Enter anything to continue");

        // Wait for user to press some key
        inputLine();
        
        // Reset the screen
        resetScreen();

        System.out.println("Page 2 / 2");
        System.out.println("Enter anything to continue");

        // Wait for user to press some key
        inputLine();

        return;
    }
}
