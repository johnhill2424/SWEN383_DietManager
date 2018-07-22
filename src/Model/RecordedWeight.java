package Model;
import java.util.Date;

/**
 * RecordedWeight is a class that provides the means to create
 * a RecordedWeight object for when a user records their weight 
 * in the daily log file
 * @author John Hill
 * @version 3/26/18
 */

public class RecordedWeight{
   //Attributes
    private Date date;
    private double recordedWeight;
    
    /**
    * Parameterized constructor for a RecordedWeight object.
    * @param date_ The date the weight was recorded.
    * @param weight_ The weight to be recorded.
    */
    public RecordedWeight(Date date_, double weight_){
      date = date_;
      recordedWeight = weight_;
    }
    
    /**
    * A method which sets the recordedWeight.
    * @param newWeight The new weight to be assigned to the class variable.
    */
    public void setRecordedWeight(double newWeight){
      recordedWeight = newWeight;
    }
    
    /**
    * An accessor method for the recorded weight class variable.
    * @return The recorded weight.
    */
    public double getRecordedWeight(){
      return recordedWeight;
    }
    
    /**
    * An accessor method for getting the date the weight was recorded on.
    * @return The date the weight was recorded.
    */
    public Date getDate(){
      return date;
    }
    
    /**
    * toString method provides a textual representation of a RecordedWeight object.
    * @return the weight information as a String.
    */
    public String toString(){
      String weightInfo = "Weight recorded as: " + Double.toString(recordedWeight);
      return weightInfo;
    }
}