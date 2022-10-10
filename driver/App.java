package driver;

import java.util.Scanner;

import driver.Helper;

public abstract class App {
    static Scanner sc;

    public abstract void start();
    
    public final String inputLine() {
        return sc.nextLine();
    }
    
    public final int inputInteger() {
        return sc.nextInt();
    }

    public final void resetScreen() {
        Helper.resetScreen();
    }
}