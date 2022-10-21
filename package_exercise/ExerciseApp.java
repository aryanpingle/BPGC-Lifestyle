package package_exercise;

import driver.App;
import driver.BackException;
import driver.SafeInput;

public class ExerciseApp extends App {
    @Override
    public void start() throws BackException {
        // Reset the screen
        resetScreen();
        
        System.out.println("Page 1 / 2");
        System.out.println("Enter anything to continue");

        // Wait for user to press some key
        SafeInput.inputLine();
        
        // Reset the screen
        resetScreen();

        System.out.println("Page 2 / 2");
        System.out.println("Enter anything to continue");

        // Wait for user to press some key
        SafeInput.inputLine();

        return;
    }
}
