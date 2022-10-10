package driver;

// Import all apps
import package_bmi.BMIApp;

// Other imports
import java.util.Scanner;
 
public final class Main {
    public static void main(String[] args) {
        // Create only one copy of Scanner
        Scanner sc = new Scanner(System.in);
        App.sc = sc;

        // Infinite Loop
        while(true) {
            Helper.resetScreen();

            System.out.println("[1] BMI App");
            System.out.println("[2] EXIT");
    
            System.out.print("Enter your choice: ");
            
            // Enter user's choice
            String choice = sc.nextLine().trim().toLowerCase();
    
            // If user wants to exit
            if(choice.equals("2")) {
                showExitScreen();
                break;
            }

            // Based on user input
            App app = null;
    
            switch (choice) {
                case "1":
                    app = new BMIApp();
                    break;
            }
            
            app.start();
        }
        
        showExitScreen();
    }

    private static void showExitScreen() {
        Helper.resetScreen();
        System.out.println("PROGRAM FINISHED!");
    }
}