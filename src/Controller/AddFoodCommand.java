package Controller;
import Model.Basic;
import Model.DietManager;
import Model.Writer;
import javax.swing.*;

/**
* A command class for adding food to the csv file.
*/
public class AddFoodCommand implements Command{

   private Basic basicFood;
   private Writer writer;
   private String name;
   private double cals;
   private double fats;
   private double carbs;
   private double protein;
   private DietManager dm;
   
   /**
   * Constructor for the AddFoodCommand accepts a DietManager object via injection.
   * @param dm The injected DietManager.
   */
   public AddFoodCommand(DietManager dm){
      this.dm = dm;
      writer = new Writer();
   }
   
   /**
   * A method which creates a new basic food.
   */
   public void setBasic(String name, double cals, double fats, double carbs, double protein){
      basicFood = new Basic(name, cals, fats, carbs, protein);
   }
   
   //add a writer to this so it can write to the csv file
   public void execute(){
      writer.writeFood(basicFood);
      dm.readFoodsAndUpdate();
   }
   
   
}