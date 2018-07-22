package Model;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Reader class reads in the basic foods and the log file
 * @author John Hill, Tim Endersby, Xuting Zhang
 * @version 4/1/18
 */

public class Reader{

   //Attributes
   private String csvFile;
   private BufferedReader br;
   private String line;
   
   /**
   * Constructor for a Reader object.
   */
   public Reader(){
       br = null;
       line = "";
   }
   
   /**
   * A method which reads the foods in from a CSV data file.
   * @return a FoodList object.
   */
   public FoodList readFoods(){
            
       //define a FoodList object
       FoodList fl = new FoodList();
                    
       try {
            
            //set up input stream for reading, needed to do this because we are using packages
            InputStream in = this.getClass().getResourceAsStream("../Data/recipefoods.csv");
            
            br = new BufferedReader(new InputStreamReader(in));
            
            //keep reading until there is no more data
            while ((line = br.readLine()) != null) {
                //read in one line into an array
                String[] food = line.split(","); //split on the specified character, create an array of all the comma separated values
                if (food[0].equals("b")) {
                    //create a basic food object
                    Basic basic = new Basic(food[1], Double.parseDouble(food[2]), Double.parseDouble(food[3]), Double.parseDouble(food[4]), Double.parseDouble(food[5]));

                    //add this basic food to the AL of basic foods
                    fl.addFood(basic);
                    
                    
                } else if (food[0].equals("r")) {
                    int i = 2;
                    ArrayList<Food> subIng = new ArrayList<Food>();
                    while (i < food.length){
                        String name = food[i];
                        double servings = Double.parseDouble(food[i+1]);

                        //Match ingredients to foods already in the database
                        int check = 0;//Used for error checking
                         for (Food f : fl.getFoodList()) {
                             if (f.getName().equals(name)) {
                                 Food a = f;
                                 a.setServings(servings);
                                 subIng.add(a);
                                 check++;
                             }
                         }
                        //Error printouts
                        if(check == 0){
                            //System.out.println("Error: " + name + " is missing from the database");
                        }else if (check > 1){
                            //System.out.println("Error: Multiple " + name + " object in the database");
                        }
                        i += 2;
                    }
                    //Construct recipe
                    Recipe recipe = new Recipe(food[1], subIng);
                    
                    //Add new recipe to database
                    fl.addFood(recipe);
                    
                    
                } else{
                    System.out.println("Error, food identified as " + food[0]);
                }
            }
            
            in.close();
            br.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return fl;
            
   } //End of readFoods() method
   
   
   
   /**
   * A method which reads in the Log CSV file
   * @return a DailyLogs object.
   */
    
   public DailyLogs readLog(){
   
       //define a DailyLogs object
       DailyLogs logs = new DailyLogs();
       
       DailyLog dailyLog = new DailyLog();
       
       int count = 0;
                    
       try {
            //set up inputstream for reading, needed to do this because we are using packages
            InputStream in = this.getClass().getResourceAsStream("../Data/log.csv");
            
            br = new BufferedReader(new InputStreamReader(in));
            
            Date oldDate = new Date();
            Date newDate;
            
            
            //keep reading until there is no more data
            while ((line = br.readLine()) != null) {
            
                //System.out.println(count); 
               
                //read in one line into an array
                String[] log = line.split(","); //split on the specified character
                newDate = new Date(Integer.parseInt(log[0]),Integer.parseInt(log[1]),Integer.parseInt(log[2]));
                
                //System.out.println(newDate.getDate());
                
                //System.out.println("Old Date" + oldDate.toString());
                //System.out.println("New Date" + newDate.toString());

                
                //don't check on the first time
                if (count != 0){

                   if (oldDate.equals(newDate)){      
                     
                   }
                   else{
                      //create a new DailyLog object since the date has changed
                      //System.out.println("new DailyLog");
                      dailyLog = new DailyLog();
                   }           
                }

                char indicator = log[3].charAt(0); //looks at the fourth comma separated value and makes it a char
                //switch on the indicator value either 'w' for weight, 'c' for calorie, or 'f' for food, or 'e' for exercise
                switch (indicator){
                   case 'w':
                     RecordedWeight recordedWeight = new RecordedWeight(newDate, Double.parseDouble(log[4]));  
                     dailyLog.addRecordedWeight(recordedWeight);
                     break;
                   case 'f':
                     ConsumedFood consumedFood = new ConsumedFood(newDate, log[4], Double.parseDouble(log[5]));
                     dailyLog.addConsumedFood(consumedFood);
                     break;
                   case 'e':
                     RecordedExercise recordedExercise = new RecordedExercise(newDate, log[4], Double.parseDouble(log[5]));
                        dailyLog.addRecordedExercise(recordedExercise);
                     break;    
                } //end of switch statement
                
                
                oldDate = newDate;
                
                //after the date changes, add DailyLog to DailyLogs
                logs.addLog(oldDate, dailyLog);  
                
                
                                
                count++;  

            } //end of outer reading while loop
            
            br.close();
            in.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        return logs;
    } 
    
    
   /**
   * A method which reads in the Exercise CSV file
   * @return a ExerciseList object
   */
    
    
    public ExerciseList readExercises(){ 
    
       //define a Excerise List object
       ExerciseList el = new ExerciseList();  
    
       try{
      
          //set up inputstream for reading, needed to do this because we are using packages
          InputStream in = this.getClass().getResourceAsStream("../Data/exercise.csv");
               
          br = new BufferedReader(new InputStreamReader(in));
   
              String line = "";
              while ((line = br.readLine()) != null) {
              
                  String[] exercise = line.split(",");
                  
                  Exercise ex = new Exercise(exercise[1],Double.parseDouble(exercise[2]));
                  el.addExercise(ex);
              }
       } 
       catch (IOException io){
         io.printStackTrace();
       }
       
       return el;
    }//end public list
    
    
} //End of class