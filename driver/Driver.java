package driver;

// Import all apps
import package_bmi.BMIApp;
import package_exercise.ExerciseApp;
 
public final class Driver {
    public static void main(String[] args) {
        // Infinite Loop
        MainLoop:
        while(true) {
            UI.resetScreen();

            System.out.println("[1] BMI App");
            System.out.println("[2] Exercise App");
            System.out.println("[3] EXIT");
            System.out.println();
    
            System.out.print("Enter your choice: ");
            
            // Enter user's choice
            String choice = "";
            try {
                choice = SafeInput.inputLine().trim().toLowerCase();
            }
            catch(BackException e) {
                break;
            }

            // Based on user input
            App app = null;
    
            switch (choice) {
                case "1":
                    app = new BMIApp();
                    break;
                case "2":
                    app = new ExerciseApp();
                    break;
                case "3":
                    break MainLoop;
                default:
                    System.out.println("\nWRONG INPUT");
                    Helper.sleep(2);
                    continue MainLoop;
            }
            
            try {
                app.start();
            }
            catch(BackException e) {}
        }
        
        UI.showExitScreen();
    }
}