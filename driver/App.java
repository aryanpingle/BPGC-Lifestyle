package driver;

import java.util.Scanner;

import driver.UI;

public abstract class App {
    public abstract void start() throws BackException;

    public final void resetScreen() {
        UI.resetScreen();
    }
}