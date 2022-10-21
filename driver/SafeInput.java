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
    
    public static final String inputLine() throws BackException {
        String input = sc.nextLine();
        
        validateInput(input);

        return input;
    }
    
    public static final int inputInteger() throws BackException {
        return Integer.parseInt(inputLine());
    }
    
    public static final double inputDouble() throws BackException {
        return Double.parseDouble(inputLine());
    }

    public static final void waitForInput() {
        sc.nextLine();
    }
}