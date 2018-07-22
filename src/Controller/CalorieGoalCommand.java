package Controller;

/**
 * A command class that allows the user to edit their calorie goal.
 */
 
 public class CalorieGoalCommand implements Command{
   private double aCalorieGoal;
   
   public CalorieGoalCommand(double calorieGoal){
      this.aCalorieGoal = calorieGoal;
   }
   
   public void execute(){
      System.out.println("Calorie Goal Command was executed.");
   }
 }