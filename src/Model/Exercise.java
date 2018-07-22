package Model;
import java.util.*;

/**
 * Exercise class contains all of the neessary constructors, attributes, and methods
 * to properly model a physical exercise.
 * @author Xuting Zhang
 * @version 4/15/18
 */


public class Exercise {

    private String exerciseName;
    private double exerciseCal;

   /**
   * Parameterized constructor instantiates the instance variables.
   * @param exerciseName_ the name of the exercise
   * @param exerciseCal_ the number of calories burned in the exercise.
   */
    public Exercise(String exerciseName_, double exerciseCal_) {
        exerciseName = exerciseName_;
        exerciseCal = exerciseCal_;
    }


    /**
    * Accessor method for the number of calories burned during an exercise.
    * @return The number of calories burned during a particular exercise.
    */
    public double getExerciseCal() {
        return exerciseCal;
    }

    /**
    * Accessor method for the name of an exercise.
    * @return The name of the exercise.
    */
    public String getExerciseName() {
        return exerciseName;
    }

    /**
    * A method which calculates and returns the total number of calories burned 
    * during an exercise for a certain duration of time.
    * @return The total number of calories burned.
    */
    public double getTotalCalories() {
        double weight = 0;
        double mins = 0;


        double total = exerciseCal * (weight / 100.0) * (mins / 60.0);
        return total;
    }


}