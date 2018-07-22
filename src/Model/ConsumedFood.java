package Model;
import java.util.Date; 

/**
 * ConsumedFood is a class that provides the means to create a
 * consumed food object for when the user records the food that they consumed
 * on a particular day. 
 * @author John Hill
 * @version 3/26/18
 */

public class ConsumedFood{
   //Attributes
    private Date date;
    private String foodName;
    double servingsConsumed;
    
    /**
    * Parameterized constructor for a ConsumedFood object.
    * @param date_ The date the food was cconsumed.
    * @param foodName_ The name of the consumed food.
    * @param servingsConsumed_ The number of servings consumed of the food.
    */
    public ConsumedFood(Date date_, String foodName_, double servingsConsumed_){
      date = date_;
      foodName = foodName_;
      servingsConsumed = servingsConsumed_;
    }
    
    /**
    * getServings method returns the servings of the consumed food
    * @return the servings consumed as a double
    */
    public double getServings(){
      return servingsConsumed;
    }
    
    /**
    * getName method returns the string name of the consumed food
    * @return the name of the consumed food
    */
    public String getName(){
      return foodName;
    }
    
    /**
    * getDate method returns the Date of when the food was consumed
    * @return Date the date of the consumed food
    */
    public Date getDate(){
      return date;
    }  
    
    /**
    * toString method returns a string with the information about a consumed food.
    * @return The name and servings of the consumed food in a String.
    */
    public String toString(){
      String cfInfo = foodName + Double.toString(servingsConsumed) + " servings";
      return cfInfo;
    } 
}