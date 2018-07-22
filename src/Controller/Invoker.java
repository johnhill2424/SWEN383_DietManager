package Controller;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;

/**
* The invoker class for the Command pattern.
*/
public class Invoker extends JButton{
   private Command aCommand;
   private String name;
   private double calories;
   private double fats;
   private double carbs;
   private double protein;
   private Date date;
   
   /**
   * Constructor for the invoker object accepts a Command object as a parameter.
   * @param aCommand The Command which this invoker's attribute shall be set to.
   */
   public Invoker(Command aCommand, String text){
      this.aCommand = aCommand;
      this.setText(text);
      this.setBackground(Color.WHITE);
      this.setForeground(new Color(3, 43, 76));
      this.setFocusPainted(false);
      this.setFont(new Font("Tahoma", Font.BOLD, 12));
   }
   
   /**
   * The invocation method which calls the execute method for a command and 
   * calls any other necessary methods depending on what type of command is being handled.
   */
   public void buttonPress(){
      if(aCommand instanceof AddFoodCommand){
          AddFoodCommand afc = (AddFoodCommand) aCommand;
          afc.setBasic(name, calories, fats, carbs, protein);
      }
      else if(aCommand instanceof AddExerciseCommand){
         AddExerciseCommand aec = (AddExerciseCommand) aCommand;
         aec.setExercise(name, calories);
      }
      else if(aCommand instanceof SearchCommand){
         SearchCommand sc = (SearchCommand) aCommand;
         sc.setDate(date);
      }
      aCommand.execute();
   }
   
   /**
   * A mutator method which sets all of the attributes relevant to food.
   * @param name The name of the food
   * @param calories The number of calories in a serving.
   * @param fats The number of grams of fat in a serving.
   * @param carbs The number of carbs in a serving.
   * @param protein The amount of protein in a serving.
   */
   public void setFoodInfo(String name, double calories, double fats, double carbs, double protein){
      this.setName(name);
      this.setCalories(calories);
      this.setCarbs(carbs);
      this.setProtein(protein);
   }
   
   /**
   * A method which sets the necessary attributes for an exercise.
   * @param name The name of the exercise.
   * @param calories The calories burned during the exercise.
   */
   public void setExInfo(String name, double calories){
      this.setName(name);
      this.setCalories(calories);
   }
   
   /**
   * A mutator method which sets the name attribute.
   * @param name The string which the name is set to.
   */
   public void setName(String name){
      this.name = name;
   }
   
   /**
   * A mutator method which sets the calories attribute.
   * @param calories the number of calories.
   */
   public void setCalories(double calories){
      this.calories = calories;
   }
   
   /**
   * A mutator method which sets the number of carbs.
   * @param carbs The number of carbs.
   */
   public void setCarbs(double Carbs){
      this.carbs = carbs;
   }
   
   /**
   * A mutator method which sets the protein amount.
   * @param protein The amount of protein.
   */
   public void setProtein(double protein){
      this.protein = protein;
   }
   
   /**
   * A mutator method for setting the date attribute of the invoker.
   * @param The desired date that the attribute will be set to.
   */
   public void setDate(Date date){
      this.date = date;
   }
   
   /**
   * A mutator method which sets the Command attribute of the invoker.
   * @param command The command object which the command attribute shall be set to.
   */
   public void setCommand(Command command){
      this.aCommand = command;
   }
}