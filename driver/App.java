package driver;

public abstract class App {
    public abstract void start() throws BackException;

    public final void resetScreen() {
        UI.resetScreen();
        System.out.println(">> Main > " + this.getAppName());
        System.out.println();
    }
    
    public abstract String getAppName();
}