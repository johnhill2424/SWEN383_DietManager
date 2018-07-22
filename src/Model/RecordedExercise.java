package Model;
import java.util.*;

/**
 * RecordedExercise is a class that provides the means to create
 * a RecordedExercise object for when a user records the exercise that they did 
 * in the daily log file
 * @author John Hill
 * @version 4/23/18
 */
 
public class RecordedExercise{

    private Date date;
    private double minutes;
    private String name;
    
    /**
    * Parameterized constructor for a RecordedExercise object
    * @param date_ The date the exercise was completed
    * @param name_ The name of the Exercise
    * @param minutes_ The amount of time in minutes that the exercise was done
    */
    public RecordedExercise(Date date_, String name_, double minutes_){
      date = date_;
      minutes = minutes_;
      name = name_;
    }
    
    /**
    * Setter to set the amount of time that an exercise was completed
    * @param minutes_ The amount of time in minutes that the exercise was done
    */
    public void setRecordedExercise(double minutes_){
      minutes = minutes_;
    }
     
    /**
    * getMinutes method returns the amount of time that the exercise was done
    * @return Amount of time as a double
    */
    public double getMinutes(){
      return minutes;
    }
    
    /**
    * getDate method returns the date that the exercise was completed
    * @return The Date that the exercise was completed
    */
    public Date getDate(){
      return date;
    }
    
    /**
    * getName method returns the name of the exercise
    * @return The name of the exercise as a string
    */
    public String getName(){
      return name;
    }
    
    /**
    * toString method returns the information about a performed exercise.
    * @return The information of a performed exercise.
    */
    public String toString(){
      String exInfo = name + " for " + Double.toString(minutes) + " minutes";
      return exInfo;
    }
}