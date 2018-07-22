package Controller;
import Model.RecordedWeight;
/**
* A command for adding a weight to the log.
* @author Anna Jacobsen
* @version 4/17/18
*/
public class AddWeightCommand implements Command{

   RecordedWeight weight;
   /**
   * Parameterized constructor is passed a double representing the user's weight
   * which is used to isntantiate the Weight object instance variable.
   */
   public AddWeightCommand(){}
   
   @Override
   public void execute(){
      System.out.println("Add weight command executed");
   }
}