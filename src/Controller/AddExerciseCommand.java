package Controller;
import Model.Writer;
import Model.Exercise;
import Model.DietManager;

/**
 * A command class for adding an exercise to the csv file.
 * @author Anna Jacobsen
 */
 public class AddExerciseCommand implements Command{
 
   //Attributes
   private DietManager dm;
   private String name;
   private double calories;
   private Writer writer;
   private Exercise exercise;
   
   /**
   * Constructor for an AddExerciseCommand object.
   */
   public AddExerciseCommand(DietManager dm){
      this.dm = dm;
      writer = new Writer();
   }
   
   /**
   * A mutator method for setting the attributes.
   * @param name The String to be assigned to the name attribute.
   * @param calories The double to be assigned to the calories attribute.
   */
   public void setExercise(String name, double calories){
      exercise = new Exercise(name, calories);
   }
   
   /**
   * Execute method for the AddExerciseCommand writes out the exercise to the
   * csv and updates the list of exercises the user may choose from.
   */
   @Override
   public void execute(){
      System.out.println("Exercise command was executed.");
      writer.writeExercise(exercise);
      dm.readExAndUpdate();
   }
 }