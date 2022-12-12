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

    private int weightUnitChoice = -1; // 1 for kg, 2 for lb
    private double weight = -1;
    private int heightUnitChoice = -1; // 1 for cm, 2 for ft'in
    private double height = -1;
    private int ft = -1;
    private int in = -1;
    private double bmi = -1;

    @Override
    public void start() {
        try {
            getWeightUnits();
        }
        catch(BackException e) {
            return;
        }
        catch(Exception e) {
            UI.printError(e);
            start();
        }
    }

    @Override
    public String getAppName() {
        return "BMI Calculator";
    }

    private void getWeightUnits() throws BackException {
        resetScreen();

        System.out.println("Choose a unit of weight:");
        UI.printChoices(new String[]{"Metric System (kg)", "Imperial System (lb)"});

        System.out.print("\nEnter your choice: ");

        weightUnitChoice = SafeInput.inputInteger(weightUnitChoice);

        if(weightUnitChoice != 1 && weightUnitChoice != 2) {
            weightUnitChoice = -1;
            throw new NumberFormatException();
        }
        
        try {
            takeWeightInput();
        }
        catch(BackException e) {
            weightUnitChoice = -1;
            start();
        }
    }

    private void takeWeightInput() throws BackException {
        resetScreen();

        System.out.print("Enter your weight ("+(weightUnitChoice==1?"kg":"lb")+"): ");

        weight = SafeInput.inputDouble(weight);
        
        if(weight <= 0) {
            weight = -1;
            throw new NumberFormatException();
        }

        try {
            getHeightUnits();
        }
        catch(BackException e) {
            weight = -1;
            start();
        }
    }

    private void getHeightUnits() throws BackException {
        // Bypass choice if already done
        if(heightUnitChoice != -1) {
            try{
                takeHeightInput();
            }
            catch(BackException e) {
                heightUnitChoice = -1;
                start();
            }
            return;
        }

        System.out.println();
        System.out.println("Choose a unit of length:");
        UI.printChoices(new String[]{"Metric System (cm)", "Imperial System (ft'in)"});

        System.out.print("\nEnter your choice: ");

        heightUnitChoice = SafeInput.inputInteger(heightUnitChoice);

        if(heightUnitChoice != 1 && heightUnitChoice != 2) {
            heightUnitChoice = -1;
            throw new NumberFormatException();
        }

        start();
    }

    private void takeHeightInput() throws BackException {
        if(heightUnitChoice == 1) {
            // Normal, in cm
            System.out.print("Enter your height (cm): ");
            height = SafeInput.inputDouble(height);
            
            if(height <= 0) {
                height = -1;
                throw new NumberFormatException();
            }

            displayBMI();
        }
        else {
            // In ft/in
            takeFtInput();
        }
    }

    private void takeFtInput() throws BackException {
        System.out.print("Enter your height (just the 'ft' part): ");

        ft = SafeInput.inputInteger(ft);

        if(ft <= 0) {
            ft = -1;
            throw new NumberFormatException();
        }

        try {
            takeInInput();
        }
        catch(BackException e) {
            ft = -1;
            start();
        }
    }

    private void takeInInput() throws BackException {
        System.out.print("Enter your height (just the 'in' part): ");

        in = SafeInput.inputInteger(in);

        if(in < 0) {
            in = -1;
            throw new NumberFormatException();
        }

        displayBMI();
    }

    /**
     * Calculates the weight from the units chosen and stores in the weight attribute
     */

    private void calculateWeight() {
        if(weightUnitChoice == 1) {
            // Calculate in kg
            // Do nothing
        }
        else {
            // Convert lb to kg
            weight = weight * 0.453592;
        }
    }

    /**
     * Calculates the height from the units chosen and stores in the height attribute
     */

    private void calculateHeight() {
        if(heightUnitChoice == 1) {
            // Calculate in cm
            // Do nothing
        }
        else {
            // Convert ft'in to cm
            height = (ft * 12 + in) * 2.54;
        }
    }

    private void displayBMI() {
        calculateWeight();
        calculateHeight();

        bmi = weight / ((height/100) * (height/100));

        printBMICategories();
        
        System.out.println();
        SafeInput.waitForInput(1);
    }

    private void printBMICategories() {
        String bmiString = bmi + ".00";
        bmiString = bmiString.substring(0, bmiString.indexOf("."));

        System.out.println();
        System.out.println("+----------------------------+");
        System.out.println("|    category    | bmi range |");
        System.out.println("+----------------+-----------+");
        System.out.println("| SEVERELY OBESE |   > 35    |" + ((bmi > 35) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|      OBESE     |   30-35   |" + ((bmi <= 35 && bmi > 30) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|    OVERWEIGHT  |   25-30   |" + ((bmi <= 30 && bmi > 25) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|     HEALTHY    |  18.5-25  |" + ((bmi <= 25 && bmi > 18.5) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("|   UNDERWEIGHT  |  < 18.5   |" + ((bmi < 18.5) ? " <--- Your BMI (" + bmiString + ")" : ""));
        System.out.println("+----------------------------+");
    }
}
