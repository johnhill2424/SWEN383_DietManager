import Model.DietManager;
import View.DietManager_UI;
import View.AddFood_UI;
import View.AddExercise_UI;
import View.ViewLog_UI;
import Controller.Command;
import Controller.AddFoodCommand;
import Controller.AddExerciseCommand;
import Controller.SearchCommand;
import Controller.LogFoodCommand;
import Controller.LogExerciseCommand;
import java.util.Date;

/**
 * DietManagerApp intializes the entire Diet Program.
 * @author Los Ninos Sanos
 * @version 3/25/18
 */

class DietManagerApp {
   
   /**
   * Main method constructs all of the necessary components for the DietManager program
   */
    public static void main(String[] args) {
    
        DietManager dietManager = new DietManager();
        
        //Create foods commands and inject dietmanager into them
        Command foodC = new AddFoodCommand(dietManager);
        Command exerC = new AddExerciseCommand(dietManager);
        Command searchC = new SearchCommand(dietManager);
        Command logFoodC = new LogFoodCommand(dietManager);
        Command logExC = new LogExerciseCommand(dietManager);
        
        //Create the user interfaces.
        AddFood_UI afui = new AddFood_UI(foodC, logFoodC);
        AddExercise_UI exui = new AddExercise_UI(exerC, logExC);
        ViewLog_UI vlui = new ViewLog_UI(searchC);
        DietManager_UI ui = new DietManager_UI(afui, exui, vlui);
        
        //Add observers to diet manager
        dietManager.addObserver(afui);
        dietManager.addObserver(exui);
        dietManager.addObserver(vlui);
        
        //Make the initial calls to read in the food and exercises.
        dietManager.displayFoods();
        dietManager.displayExercises();
         //Create a date for today and set the timestamp to 00:00:00, as that is what all of the
         //keys will have for the hours, minutes, and seconds.
         Date todaysDate = new Date();
         todaysDate.setHours(0);
         todaysDate.setMinutes(0);
         todaysDate.setSeconds(0);
        dietManager.displayDailyLog(todaysDate);
        
    }
}
