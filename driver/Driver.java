package driver;

// Import all apps
import package_bmi.BMIApp;
import package_credits.CreditsApp;
import package_exercise.ExerciseApp;
 
public final class Driver {
    public static void main(String[] args) {
        UI.showSplashScreen();
        // Infinite Loop
        MainLoop:
        while(true) {
            UI.resetScreen();

            System.out.println();
            String[] choices = {
                "BMI Information",
                "Targeted Excercise",
                "Pharmacy API",
                "Nutrition Tracker",
                "Credits",
                "EXIT"
            };
            UI.printChoices(choices);
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
                case "5":
                    app = new CreditsApp();
                    break;
                case "6":
                    break MainLoop;
                default:
                    UI.printError("INVALID OPTION");
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