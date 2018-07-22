package Model;
import java.util.*;
/**
 * ExerciseList is a class that stores an ArrayList of all the exercises
 * Also allows the addition and substraction of exercises.
 * @author Xuting Zhang 
 * @version 4/18/18
 */
public class ExerciseList{
   //Attributes
    ArrayList<Exercise> exerciseList;

    /**
    * Constructor for ExerciseList instantiates its instace
    * variable to a new ArrayList of Exercise objects.
    */
    public ExerciseList(){
      exerciseList = new ArrayList<Exercise>();
    }
    
    /**
    * A method which adds an Exercise object to the array
    * list attribute.
    * @param exercise The Exercise objecct to be added.
    */
    public void addExercise(Exercise exercise){
      exerciseList.add(exercise);
    }
    
    /**
    * A method which removes an Exercise object from the
    * array list attribute.
    * @param exercise The Exercise object to be removed.
    */
    public void removeExercise(Exercise exercise){
      exerciseList.remove(exercise);
    }
    
    /**
    * An accessor method for the Exercise array list attribute.
    * @return The array list of Exercise objects.
    */
    public ArrayList<Exercise> getExerciseList(){
      return exerciseList;
    }
}