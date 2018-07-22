package Controller;
import Model.DietManager;

/**
* A concrete LogFoodCommand class containing the funtionality for logging a food.
* @author Los Ninos Sanos
* @version 4/24/18
*/

public class LogFoodCommand implements Command{
   
   //Attributes
   private DietManager dm;
   
   /**
   * Constructor for a LogFoodCommand object
   */
   public LogFoodCommand(DietManager dm){
      this.dm = dm;
   }
   
   /**
   * Execute method for the LogFoodCommand object.
   */
   @Override
   public void execute(){
      //dm.logFood();
      System.out.println("Log food executed");
   }
   
}