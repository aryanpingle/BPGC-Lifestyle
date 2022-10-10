package package_bmi;

import driver.App;

public class BMIApp extends App {
    @Override
    public void start() {
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
