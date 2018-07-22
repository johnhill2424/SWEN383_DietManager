package Model;
import java.io.*; //For PrintWriter
import java.util.*;
//import java.lang.*;
import java.net.*;

/**
 * Writer class writes to the basic foods and the log file
 * @author John Hill, Xuting Zhang
 
 * @version 4/1/18
 */

public class Writer{
	
   Calendar calendar = Calendar.getInstance();
   
   DietManager dm = new DietManager();
   
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;
	int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);    
   
   public Writer(){

   }
   
   /**
   * writeFood method writes a basic food to the recipefoods.csv file
   * @param basicFood takes in a basic Food object
   */
   
   public void writeFood(Basic basicFood){
      try{
         
         //also write to the internal data structure in DietManager
         dm.addFood(basicFood);
         
         
         //FileWriting 
         
         URL resourceUrl = getClass().getResource("../data/recipefoods.csv");
         File file = new File(resourceUrl.toURI());
         PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
   
         pw.printf("%s,%s,%.2f,%.2f,%.2f,%.2f%n", "b", basicFood.getName(), basicFood.getCalories(), basicFood.getFat(), basicFood.getCarbs(), basicFood.getProtein());
         pw.flush();
         pw.close();
      
      }
      catch(IOException ioe){
         System.out.println("Writing error");
         System.exit(0);
      }  
      catch (URISyntaxException uri){
         uri.printStackTrace();
      }
   }
   
   
   /**
   * writeLog method writes a consumed food to the log.csv file
   * @param foodName the name of the food that was consumed
   * @param servingsConsumed the amount of the food that was eaten
   */
   
   public void writeLog(String foodName, double servingsConsumed){
      try{
         //FileWriting 
         
         URL resourceUrl = getClass().getResource("../data/log.csv");
         File file = new File(resourceUrl.toURI());
         PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
         
         System.out.println("Month: "+month);
   
         pw.printf("%d,%d,%d,%s,%s,%.1f%n", year, month, dayOfMonth, "f", foodName, servingsConsumed);
         pw.flush();
         pw.close();
      }
      catch(IOException ioe){
         ioe.printStackTrace();
         System.out.println("Writing error");
         System.exit(0);
      }    
      catch (URISyntaxException uri){
         uri.printStackTrace();
      }
   }
   
   /**
   * writeCalorieLog method writes a Daily Calorie Intake to the log.csv file
   * @param dailyCalorieIntake is the amount that the user wants to intake for a given day
   */
   
   public void writeCalorieLog(int dailyCalorieIntake){
      try{
         //FileWriting 
         
         URL resourceUrl = getClass().getResource("../data/log.csv");
         File file = new File(resourceUrl.toURI());
         PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
   
         pw.printf("%d,%d,%d,%s,%d%n", year, month, dayOfMonth, "c", dailyCalorieIntake);
         pw.flush();
         pw.close();
      
      }
      catch(IOException ioe){
         System.out.println("Writing error");
         System.exit(0);
      }   
      catch (URISyntaxException uri){
         uri.printStackTrace();
      } 
   }
   
   
   /**
   * writeWeightLog method writes a recoreded Weight object to the log.csv file
   * @param recordedWeight the weight that the user weighs on a given day
   */
   
   public void writeWeightLog(double recordedWeight){
      try{
         //FileWriting 
         
         URL resourceUrl = getClass().getResource("../data/log.csv");
         File file = new File(resourceUrl.toURI());
         PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
   
         pw.printf("%d,%d,%d,%s,%.2f%n", year, month, dayOfMonth, "w", recordedWeight);
         pw.flush();
         pw.close();
      
      }
      catch(IOException ioe){
         ioe.printStackTrace();
         System.out.println("Writing error");
         System.exit(0);
      }    
      catch (URISyntaxException uri){
         uri.printStackTrace();
      }
   }
   
   /**
   * writeExercise method writes a new Exercise to the exercise.csv file
   * @param exercise an Exercise object
   */
   
   public void writeExercise(Exercise exercise)
   {
   
      //also write to the internal data structure in DietManager
      dm.addExercise(exercise);
   
      try{
          URL resourceUrl = getClass().getResource("../data/exercise.csv");
          File file = new File(resourceUrl.toURI());
          PrintWriter pw = new PrintWriter(new FileOutputStream(file,true ));      
          pw.printf("%s,%s,%.2f%n", "e", exercise.getExerciseName(), exercise.getExerciseCal() );
          pw.flush();
          pw.close();
  
      }catch(IOException ioe){
         System.out.println("Writing error");
         System.exit(0);
      
      }catch (URISyntaxException uri){
         uri.printStackTrace();
      
      }
 
   }
  

}//end of Writer class
