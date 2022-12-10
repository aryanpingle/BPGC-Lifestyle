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
     * @throws NumberFormatException
     */
    
    public static final int inputInteger() throws BackException, NumberFormatException {
        try {
            return Integer.parseInt(inputLine());
        }
        catch(NumberFormatException err) {
            UI.printError(err);

            throw err;
        }
    }

    /**
     * Returns the user input as a double
     * @return The user input
     * @throws BackException
     * @throws NumberFormatException
     */
    
    public static final double inputDouble() throws BackException, NumberFormatException {
        try {
            return Double.parseDouble(inputLine());
        }
        catch(NumberFormatException err) {
            UI.printError(err);

            throw err;
        }
    }
    
    /**
     * Pauses execution until the user enters some value
     */

    public static final void waitForInput() {
        sc.nextLine();
    }
    
    /**
     * Pauses execution until the user enters some value
     */

    public static final void waitForInput(int x) {
        System.out.println("- press [ENTER] to continue -");
        sc.nextLine();
    }
}