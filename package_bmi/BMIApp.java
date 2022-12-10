package package_bmi;

import driver.App;
import driver.BackException;
import driver.Helper;
import driver.SafeInput;
import driver.UI;

public class BMIApp extends App {
    // Constants
    private static final double UNDERWEIGHT_LT = 18.5;
    private static final double HEALTHY_LT = 25;
    private static final double OVERWEIGHT_LT = 30;
    private static final double OBESE_LT = 35;
    // Severely obese is greater than 35 BMI

    private double weight;
    private double height;
    private double bmi;

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
        return "BMI Calculator";
    }

    private void takeWeightInput() throws BackException {
        try {
            // Reset the screen
            resetScreen();
            
            System.out.print("Enter your weight (kg): ");

            weight = SafeInput.inputDouble();
            
            if(weight <= 0) throw new NumberFormatException();

            try {
                takeHeightInput();
            }
            catch(BackException e) {
                takeWeightInput();
            }
        }
        catch(NumberFormatException e) {
            takeWeightInput();
        }
    }

    private void takeHeightInput() throws BackException {
        try {
            // Reset the screen
            resetScreen();

            System.out.println("Enter your weight (kg): " + this.weight);
            System.out.print("Enter your height (cm): ");

            height = SafeInput.inputDouble() / 100;

            if(height <= 0) throw new NumberFormatException();

            displayBMI();
        }
        catch(NumberFormatException e) {
            takeHeightInput();
        }
    }

    private void displayBMI() {
        bmi = weight / (height * height);

        printBMICategories();
        
        System.out.println();
        SafeInput.waitForInput(1);
    }

    private void printBMICategories() {
        String[] bmiCategories = {"Severely Obese", "Obese", "Overweight", "Healthy", "Underweight"};
        
        String bmiString = bmi + ".00";
        bmiString = bmiString.substring(0, bmiString.indexOf("."));

        System.out.println();
        System.out.println(" ---------------------------- ");
        System.out.println("|    category    | bmi range |");
        System.out.println("|----------------+-----------|");
        System.out.println("| SEVERELY OBESE |   > 35    |" + ((bmi > 35) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|      OBESE     |   30-35   |" + ((bmi <= 35 && bmi > 30) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|    OVERWEIGHT  |   25-30   |" + ((bmi <= 30 && bmi > 25) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|     HEALTHY    |  18.5-25  |" + ((bmi <= 25 && bmi > 18.5) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|   UNDERWEIGHT  |  < 18.5   |" + ((bmi < 18.5) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println(" ---------------------------- ");
    }
}
