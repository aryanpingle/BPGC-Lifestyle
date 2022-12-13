package driver;

public abstract class App {
    /**
     * This is the entry point for Driver class
     * @throws BackException
     */
    public abstract void start() throws BackException;

    /**
     * Clears the screen, prints the header, and prints the navigation bar
     */
    public final void resetScreen() {
        UI.resetScreen();
        System.out.println();
        UI.printNavBar(this.getAppName());
    }
    
    /**
     * Returns the name of the app to be used in the nav bar
     * @return A short name for the application
     */
    public abstract String getAppName();
}