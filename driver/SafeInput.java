package driver;

import java.util.Scanner;

public class SafeInput {
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
    }

    private static final void validateInput(String input) throws BackException {
        if(input.equals("BACK")) {
            throw new BackException();
        }
        if(input.equals("EXIT")) {
            UI.showExitScreen();
            System.exit(0);
        }
    }

    /**
     * Returns the user input as a String
     * @return The user input
     * @throws BackException
     */
    
    public static final String inputLine() throws BackException {
        String input = sc.nextLine();
        
        validateInput(input);

        return input;
    }

    /**
     * Returns the user input as an int
     * @return The user input
     * @throws BackException
     */
    
    public static final int inputInteger() throws BackException {
        return Integer.parseInt(inputLine());
    }

    /**
     * Returns the user input as a double
     * @return The user input
     * @throws BackException
     */
    
    public static final double inputDouble() throws BackException {
        return Double.parseDouble(inputLine());
    }
    
    /**
     * Pauses execution until the user enters some value
     */

    public static final void waitForInput() {
        sc.nextLine();
    }
}