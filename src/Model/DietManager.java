package Model;

import java.util.*;
import java.util.Observable;

/**
 * DietManager is the "meat & potatoes" class that creates all the other model objects and connects them to each other.
 *
 * @author Los Ninos Sanos
 * @version 3/26/18
 */
public class DietManager extends Observable {

   //Atributes.
    private ArrayList<Food> foods; //Holds all food objects
    private ArrayList<Exercise> exercises; //holds all the exercise objects
    private Map<Date, DailyLog> log;

    //Creates the necessary class objects for the program.
    //private User user = new User();
    private FoodList fl;
    private ExerciseList el;
    private DailyLogs dailyLogs;
    private Reader reader = new Reader();

   /**
   * Constructor for a DietManager object.
   */
    public DietManager() {
    
        //read in all the foods and return the foodlist
        fl = reader.readFoods();
        foods = fl.getFoodList();
        
        //read in all the exercises and return the exerciseList
        el = reader.readExercises();
        exercises = el.getExerciseList();
        
        //read in all the dailylogs and return the dailylog object
        dailyLogs = reader.readLog();
        log = dailyLogs.getMap();
      
        for (Map.Entry<Date, DailyLog> hey : log.entrySet())
        {
            //System.out.println(hey.getKey() + "/" + hey.getValue());
        }
        
//         ArrayList<ConsumedFood> cs = dl.getConsumedFood();
//         for (ConsumedFood f : cs){
//             System.out.println("sdfdsf" + f.getName());
//         }
        
        //get the AL from the foodList object
        //ArrayList<Food> foodList = fl.getList();
        
        //print out all the foods
//          for (Food f : foodList){
//             System.out.println(f.getName());
//          }

        //reader.readLog();

        //user.addCalorieLimits(reader.getCalorieLimits());
        //user.addRecordedWeights(reader.getRecordedWeights());
        //dailyLog.addConsumedFoods(reader.getConsumedFoods());
        
                Iterator it = log.entrySet().iterator();
         while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        //System.out.println(pair.getKey() + " = " + pair.getValue());
        Date date = (Date)pair.getKey();
        //System.out.println("Date key: " + date.toString());
        /*System.out.println("Year: "+ date.getYear());
        System.out.println("Month: " + date.getMonth());
        System.out.println("Day: " + date.getDate());*/
        DailyLog dl = (DailyLog)pair.getValue();
        ArrayList<ConsumedFood> consumed = dl.getConsumedFood();
        for (ConsumedFood i : consumed){
           //System.out.println(i.getName());
           //System.out.println(i.getServings());
        }
         ArrayList<RecordedWeight> recorded = dl.getRecordedWeight();
         for (RecordedWeight j : recorded){
            //System.out.println(j.getRecordedWeight());
         }
         ArrayList<RecordedExercise> exer = dl.getRecordedExercise();
         for (RecordedExercise x : exer){
            //System.out.println(x.getMinutes());
         }
                
        //it.remove(); // avoids a ConcurrentModificationException
         }
    }
    
    /**
    * A method which adds a food to the food array list.
    * @param food The food to be added.
    */
    public void addFood(Food food){
      foods.add(food);  
    }
    
    /**
    * A method which adds an exercise to the exercise ArrayList
    * @param exercise The exercise to be added.
    */
    public void addExercise(Exercise exercise){
      exercises.add(exercise);  
    }   
    
    /**
    * A method which logs a consumed food to the log.
    * Skeleton outline, not implemented.
    */
    public void addConsumedFood(){}
    
    /**
    * A method which logs an exerccise to the log.
    * Skeleton outline, not implemented.
    */
    public void logExercise(){}
    
    /**
    * A method which calls the reader function and updates the observers
    */
    public void readFoodsAndUpdate(){
      fl = reader.readFoods();
      foods = fl.getFoodList();
      System.out.println(foods.get(foods.size()-1).getName());
      displayFoods();
    }
    
    /**
    * A method which calls the reader function for exercises and updates the observers.
    */
    public void readExAndUpdate(){
      el = reader.readExercises();
      exercises = el.getExerciseList();
      displayExercises();
    }
    
    /**
    * Display daily log updates the observers with the daily log information
    * @param d The date of the log to be displayed.
    */
    public void displayDailyLog(Date d){
      //System.out.println("Step 2. We have entered the displayDailyLog method");
      setChanged();
      DailyLog today = log.get(d);

      //System.out.println("Step 3. The log associated with that key is: " + today);
      String logString = "";
      if(today == null){
         System.out.println("The log was null");
         logString = "No entries found.|dl";
      }
      else{
         logString = today.toString() + "|dl";
      }
      notifyObservers(logString);
    }

    /**
    * Display foods is called to update the observers with new foods.
    */
    public void displayFoods(){
      for (Food f : foods) {
          setChanged();
          notifyObservers(f.getName() + "|f");
      }
    }
    
    /**
    * Display exercises is called to update the observers with exercises
    */
    public void displayExercises(){
      for( Exercise e: exercises){
         setChanged();
         notifyObservers(e.getExerciseName() + "|ex");
      }
    }
}
