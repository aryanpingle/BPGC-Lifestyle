package driver;

// Import all apps
import package_bmi.BMIApp;
import package_exercise.ExerciseApp;

// Other imports
import java.util.Scanner;
 
public final class Driver {
    public static void main(String[] args) {
        // Create only one copy of Scanner
        Scanner sc = new Scanner(System.in);
        App.sc = sc;

        // Infinite Loop
        MainLoop:
        while(true) {
            UI.resetScreen();

            System.out.println("[1] BMI App");
            System.out.println("[2] Exercise App");
            System.out.println("[3] EXIT");
            System.out.println("****************");
            System.out.println("type BACK anytime to go to the previous page");
            System.out.println();
    
            System.out.print("Enter your choice: ");
            
            // Enter user's choice
            String choice = sc.nextLine().trim().toLowerCase();

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
            }
            
            try {
                app.start();
            }
            catch(BackException e) {}
        }
        
        UI.showExitScreen();
    }
}