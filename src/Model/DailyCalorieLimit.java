package Model;
import java.util.*;

/**
 * DailyCalorieLimit provides the means to create a DailyCalorieLimit object
 * for when a user adds a daily calorie limit. 
 * @author John Hill
 * @version 3/26/18
 */

public class DailyCalorieLimit{

    private Date date;
    private double calorieLimit;
    
    
    public DailyCalorieLimit(Date date_, double calorieLimit_){
      date = date_;
      calorieLimit = calorieLimit_;
    }
    
    public double getCalorieLimit(){
      return calorieLimit;
    }
    
    public Date getDate(){
      return date;
    }
    
    
    
}