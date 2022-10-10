package package_bmi;

import driver.App;
import driver.BackException;

public class BMIApp extends App {
    private double weight = 0;
    private double height = 0;

    @Override
    public void start() {
        try {
            takeWeightInput();
        }
        catch(BackException e) {
            return;
        }
        catch(InterruptedException e) {}
    }

    private void takeWeightInput() throws BackException, InterruptedException {
        try {
            // Reset the screen
            resetScreen();
            
            System.out.print("Enter your weight (kg): ");

            weight = inputDouble();

            takeHeightInput();
        }
        catch(NumberFormatException e) {
            System.out.println("\n\nWRONG FORMAT");
            Thread.sleep(1000);
            takeWeightInput();
            return;
        }
        catch(BackException e) {
            return;
        }
    }

    private void takeHeightInput() throws BackException, InterruptedException {
        try {
            // Reset the screen
            resetScreen();
            
            System.out.print("Enter your height (cm): ");

            height = inputDouble() / 100;

            displayBMI();
        }
        catch(NumberFormatException e) {
            System.out.println("\n\nWRONG FORMAT");
            Thread.sleep(1000);
            takeHeightInput();
        }
        catch(BackException e) {
            throw new BackException();
        }
    }

    private void displayBMI() {
        resetScreen();

        System.out.println("Your BMI is: " + weight / (height * height));

        waitForInput();
    }
}
