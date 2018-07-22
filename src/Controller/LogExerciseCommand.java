package Controller;
import Model.DietManager;

/**
* The LogExerciseCommand class contains the funtionality for logging a food.
* @author Los Ninos Sanos
* @version 4/24/18
*/

public class LogExerciseCommand implements Command{
   
   //Attributes
   private DietManager dm;
   
   /**
   * Constructor for a LogExerciseCommand object
   */
   public LogExerciseCommand(DietManager dm){
      this.dm = dm;
   }
   
   /**
   * Execute method for the LogExerciseCommand object.
   */
   @Override
   public void execute(){
      //dm.logExercise();
      System.out.println("Log Exercise executed");
   }
   
}