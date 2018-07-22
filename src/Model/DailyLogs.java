package Model;

/**
 * DailyLogs is a class that stores a HashMap of a DailyLog object.
 * Also the DailyLogs class provides methods to add a Log object or remove
 * a log object from the HashMap.
 * @author John Hill
 * @version 3/26/18
 */
 
import java.util.*;

/**
* A class containing all of the necessary methods and constructors for a 
* DailyLogs object.
*/
public class DailyLogs{
   
   //Attributes
    Map<Date, DailyLog> log;
    
    /**
    * Constructor for the DailyLogs object instantiates the class attribtue
    * to a new HashMap object.
    */
    public DailyLogs(){
      log = new HashMap<Date, DailyLog>();
    }
    
    /**
    * A method which adds a new log to the collection of logs.
    * @param date The date of the log to be added.
    * @param dailyLog The log object to be added.
    */
    public void addLog(Date date, DailyLog dailyLog){
      log.put(date, dailyLog);
    }
    
    /**
    * A method which removes a log from the collection of logs.
    * @param The key date of the log to be removed.
    */
    public void removeDailyLog(Date date){
      log.remove(date);
    }
    
    /**
    * A method which returns the entire HashMap attribute.
    * @return The HashMap of logs.
    */
    public Map<Date, DailyLog> getMap(){
      return log;
    }
}