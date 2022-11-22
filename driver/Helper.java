package driver;

import java.io.File;
import java.util.Scanner;

public final class Helper {
    public static void sleep(double seconds) {
        try {
            Thread.sleep((int)(seconds * 1000));
        }
        catch(InterruptedException e) {
            // Do nothing
        }
    }
    
    public static String readTextFile(String fileName) {
        return readTextFile(new File(fileName));
    }
    
    public static String readTextFile(File file) {
        try {
            Scanner sc = new Scanner(file);

            String text = "";
            while(sc.hasNextLine()) {
                text += sc.nextLine() + "\n";
            }

            sc.close();

            return text;
        }
        catch(Exception e) {}

        return null;
    }
}
