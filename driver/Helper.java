package driver;

public final class Helper {
    public static void sleep(double seconds) {
        try {
            Thread.sleep((int)(seconds * 1000));
        }
        catch(InterruptedException e) {
            // Do nothing
        }
    }
}
