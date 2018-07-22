package Model;

/**
 * FoodList is a class that stores an ArrayList of all the foods
 * (both recipes and basic foods). Also allows the addition and
 * substraction of foods.
 * @author John Hill
 * @version 4/17/18
 */
 
import java.util.*;

public class FoodList{

    ArrayList<Food> foodList;
    
    public FoodList(){
      foodList = new ArrayList<Food>();
    }
    
    public void addFood(Food food){
      foodList.add(food);
    }
    
    public void removeFood(Food food){
      foodList.remove(food);
    }
    
    public ArrayList<Food> getFoodList(){
      return foodList;
    }

    
}