package driver;

public class Helper {
    static void resetScreen() {
        clearScreen();
        printHeader();
    }
 
    private static void printHeader() {
        System.out.println("----------------------------------------------");
        System.out.println("--------------- BPGC LIFESTYLE ---------------");
        System.out.println("----------------------------------------------");
        System.out.println();
    }
 
    private static void clearScreen() {
        System.out.print("\f");
        System.out.print("\033[H\033[2J");
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")) {        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
            else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
 
                startProcess.waitFor();
            } 
        }
        catch(Exception e) {
            System.out.println(e);
        }
        System.out.flush();
    }
}
