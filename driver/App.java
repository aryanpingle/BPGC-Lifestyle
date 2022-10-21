package driver;

import java.util.Scanner;

import driver.UI;

public abstract class App {
    static Scanner sc;

    public abstract void start() throws BackException;

    private void validateInput(String input) throws BackException {
        if(input.equals("BACK")) {
            throw new BackException();
        }
        if(input.equals("EXIT")) {
            System.exit(0);
        }
    }
    
    public final String inputLine() throws BackException {
        String input = sc.nextLine();
        
        validateInput(input);

        return input;
    }
    
    public final int inputInteger() throws BackException {
        return Integer.parseInt(inputLine());
    }
    
    public final double inputDouble() throws BackException {
        return Double.parseDouble(inputLine());
    }

    public final void waitForInput() {
        sc.nextLine();
    }

    public final void resetScreen() {
        UI.resetScreen();
    }
}