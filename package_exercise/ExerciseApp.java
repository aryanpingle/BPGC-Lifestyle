package package_exercise;

import driver.App;
import driver.BackException;
import driver.SafeInput;

public class ExerciseApp extends App {
    @Override
    public void start() {
        try {
            showPage(1, 5);
        }
        catch(BackException err) {
            // Do Nothing
        }
    }

    @Override
    public String getAppName() {
        return "Targeted Exercises";
    }

    private void showPage(int pageNumber, int totalPages) throws BackException {
        if(pageNumber > totalPages) return;

        // Reset the screen
        resetScreen();

        // Show Page Number
        System.out.println("This is page " + pageNumber + "/" + totalPages);

        System.out.println("Enter anything to continue");

        SafeInput.inputLine();

        try {
            // Show the next page
            showPage(pageNumber + 1, totalPages);
        }
        catch(BackException err) {
            // Show the same page again
            showPage(pageNumber, totalPages);
        }
    }
}
