package Controller;
import java.util.*;
import Model.DietManager;
/**
 * SearchCommand allows a user to find a daily log for a specific date.
 * @author Los Ninos Sanos
 * @version 4/24/18
 */
 
 public class SearchCommand implements Command{ 
   //Attributes
   private Date searchDate;
   private DietManager dm;
   
   /**
   * Constructor for the search command takes in a DietManager object.
   * @param dm A DietManager object.
   */
   public SearchCommand(DietManager dm){
      this.dm = dm;
   }
   
   /**
   * A mutator method for the searchDate attribtue.
   * @param searchDate The date to be assigned to the class attribute.
   */
   public void setDate(Date searchDate){
      this.searchDate = searchDate;
      System.out.println("Search date set: " + searchDate);
   }
   
   /**
   * The execute method for the Search Command.
   */
   @Override
   public void execute(){
      System.out.println("Step 1. We have fired the execute method of the search command");
      dm.displayDailyLog(searchDate);
   }
 }