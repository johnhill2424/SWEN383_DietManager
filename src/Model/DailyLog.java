package Model;
import java.util.*;

/**
 * DailyLog is a class that stores the users consumed foods that are
 * read in from the DailyLog csv file
 * @author John Hill
 * @version 3/26/18
 */
public class DailyLog{
   
   //Attributes
    private ArrayList<ConsumedFood> consumedFood;
    private ArrayList<RecordedWeight> recordedWeight;
    private ArrayList<RecordedExercise> recordedExercise;
   
   /**
   * Constructor for a DailyLog object instantiates all attributes/class variables
   * to new ArrayLists of the proper type of object.
   */
    public DailyLog(){
      consumedFood = new ArrayList<ConsumedFood>();
      recordedWeight = new ArrayList<RecordedWeight>();
      recordedExercise = new ArrayList<RecordedExercise>();
    }
    
    /**
    * A method which adds a consumed food to the list of consumed foods.
    * @param consumedFood_ The eaten food.
    */
    public void addConsumedFood(ConsumedFood consumedFood_){
      consumedFood.add(consumedFood_);
    }
    
    /**
    * A method which adds a recorded weight to the array list of recorded weights.
    * @param recordedWeight_ The recorded weight to be added.
    */
    public void addRecordedWeight(RecordedWeight recordedWeight_){
      recordedWeight.add(recordedWeight_);
    }
    
    /**
    * A method which adds a recorded exercise to the array list of recorded exercises.
    * @param exercise The exercise to be added.
    */
    public void addRecordedExercise(RecordedExercise exercise){
      recordedExercise.add(exercise);
    }
    
    /**
    * An accessor method for the consumed food array list.
    * @return The consumed food array list.
    */
    public ArrayList<ConsumedFood> getConsumedFood(){
      return consumedFood;
    }
    
    /**
    * An accessor method for the recorded weight array list.
    * @return The recorded weight array list.
    */
    public ArrayList<RecordedWeight> getRecordedWeight(){
      return recordedWeight;
    }
    
    /**
    * An accessor method for the recorded exercise array list.
    * @return The array list of recorded exercises.
    */
    public ArrayList<RecordedExercise> getRecordedExercise(){
      return recordedExercise;
    }
   
   /**
   * toString method provides a textual representation of the DailyLog object.
   * @return A string representation of DailyLog.
   */
   public String toString(){
      String printOutLog = "";
      if(consumedFood.size() > 0){
         printOutLog += "Foods consumed today: \n";
         for(int i = 0; i < consumedFood.size(); i++){
            printOutLog += consumedFood.get(i).toString() + "\n";
         }
      }
      if(recordedWeight.size() > 0){
         printOutLog += "Recorded weights: \n";
         for(int i = 0; i < recordedWeight.size(); i++){
            printOutLog += recordedWeight.get(i).toString() + "\n";
         }
      }
      if(recordedExercise.size() > 0){
         printOutLog += "Recorded exercises: \n";
         for(int i = 0; i < recordedExercise.size(); i++){
            printOutLog += recordedExercise.get(i).toString() + "\n";
         }
      }
      return printOutLog;
   }
}