package Model;

/**
 * User is a class that stores the users recorded weights, and daily calorie limits
 * @author John Hill
 * @version 3/26/18
 */


import java.util.*;

public class User{

    private ArrayList<RecordedWeight> recordedWeights = new ArrayList<RecordedWeight>();
    private ArrayList<DailyCalorieLimit> calorieLimits = new ArrayList<DailyCalorieLimit>();

    public User(){

    }
    
    public void addRecordedWeights(ArrayList<RecordedWeight> recordedWeights_){
      recordedWeights = recordedWeights_;
      
      //ONLY FOR TESTING PURPOSES
      int j = 0;
      System.out.println("Recorded Weights: ");

      while (recordedWeights.size() > j) {
         System.out.println(recordedWeights.get(j).getYear());
         System.out.println(recordedWeights.get(j).getMonth());
         System.out.println(recordedWeights.get(j).getDay());
         System.out.println(recordedWeights.get(j).getRecordedWeight());
			j++;
		}
      
    }
    
    public void addCalorieLimits(ArrayList<DailyCalorieLimit> calorieLimits_){
      calorieLimits = calorieLimits_;
      
      //ONLY FOR TESTING PURPOSES
      int j = 0;
      System.out.println("Calorie Limits: ");

      while (calorieLimits.size() > j) {
         System.out.println(calorieLimits.get(j).getYear());
         System.out.println(calorieLimits.get(j).getMonth());
         System.out.println(calorieLimits.get(j).getDay());
         System.out.println(calorieLimits.get(j).getCalorieLimit());
			j++;
		}
      
      
    }
    
}