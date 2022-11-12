package package_bmi;

import driver.App;
import driver.BackException;
import driver.Helper;
import driver.SafeInput;

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
    }

    @Override
    public String getAppName() {
        return "BMI Information";
    }

    private void takeWeightInput() throws BackException {
        try {
            // Reset the screen
            resetScreen();
            
            System.out.print("Enter your weight (kg): ");

            weight = SafeInput.inputDouble();

            try {
                takeHeightInput();
            }
            catch(BackException e) {
                takeWeightInput();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("\n\nWRONG FORMAT");
            Helper.sleep(1.5);
            takeWeightInput();
            return;
        }
    }

    private void takeHeightInput() throws BackException {
        try {
            // Reset the screen
            resetScreen();

            System.out.println("Enter your weight (kg): " + this.weight);
            System.out.print("Enter your height (cm): ");

            height = SafeInput.inputDouble() / 100;

            displayBMI();
        }
        catch(NumberFormatException e) {
            System.out.println("\n\nWRONG FORMAT");
            Helper.sleep(1.5);
            resetScreen();
            takeHeightInput();
        }
    }

    private void displayBMI() {
        System.out.println();
        System.out.println("Calculated BMI: " + weight / (height * height));
        System.out.println("\nPress [ENTER] to continue");

        SafeInput.waitForInput();
    }
}
