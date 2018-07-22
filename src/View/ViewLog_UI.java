package View;
import Controller.Invoker;
import Controller.Command;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Observer;
import java.util.Observable;

/**
 * ViewLog_UI is a class that provides the interface for the user to see
 * their current Log
 * @author John Hill
 * @version 4/9/18
*/

public class ViewLog_UI extends JFrame implements ActionListener, Observer {
   
   //Attributes
   private JTextArea jtaLog;
   private JTextField jtfDate;
   private JButton jbDate;
   private JButton jbClear; 
   private Command command;
   
   /**
   * Constructor for the ViewLog_UI has a command injected into it.
   * @param command The command object to be used in this class.
   */
   public ViewLog_UI(Command command){
        
      this.command = command;
      
      // Create panels jpText and jpFind and jpFind1
      JPanel jpLog = new JPanel();
      
      //this will hold the buttons, label and textfields
      JPanel jpDate = new JPanel(new BorderLayout());
      JPanel jpButtons = new JPanel(); //this will hold the buttons
      JPanel jpLabText = new JPanel(); //this will hold the label and textfield
      
            
      //Initialize text area and add scrolling
      jtaLog = new JTextArea(20,30);
      jtaLog.setEditable(false);
      
      final JScrollPane scroll = new JScrollPane(jtaLog);
      add(scroll);
      
      jbClear = new JButton("Clear");
      jtfDate = new JTextField(10);
      JLabel jlDate = new JLabel("Filter by Date: ");
      
      //Creates invoker.
      Invoker jbDate = new Invoker(command, "Search");
      jbDate.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            String [] dateInput = jtfDate.getText().split("\u002F");
            if(dateInput[0].length() == 4){
               int year = Integer.parseInt(dateInput[0]);
               int month = Integer.parseInt(dateInput[1]) - 1;
               int day = Integer.parseInt(dateInput[2]);
               Date date = new Date(year, month, day);
               jbDate.setDate(date);
               jbDate.buttonPress();
            }
            else{
               JOptionPane.showMessageDialog(null, "Please enter the date in the format of 'yyyy//mm//dd'");
            }
          }
      });
      
      
      //Highlighter highlighter = jtaText.getHighlighter();


      // Add text area to panel jpLog
      jpLog.add(jtaLog);
      
      // Add label and textfield
      jpLabText.add(jlDate);
      jpLabText.add(jtfDate);
      
      // Add buttons to JPanel
      jpButtons.add(jbDate);
      jpButtons.add(jbClear);
           
//       // Add ActionListener for jbFind
//       jbDate.addActionListener(new FindText(jtaText, jtfFind));
         
      jpDate.add(jpLabText, BorderLayout.NORTH);
      jpDate.add(jpButtons, BorderLayout.SOUTH);
      
      // Add panels to frame 
      add(jpLog, BorderLayout.CENTER);
      add(jpDate, BorderLayout.SOUTH);

      // Windows settings and visibility 
      this.setDefaultCloseOperation(HIDE_ON_CLOSE);
      this.setMinimumSize(new Dimension(500,500));
      this.setLocationRelativeTo(null);
      this.setTitle("Log");
      this.pack();
      this.setVisible(false);


      
   
//       //Anon inner class for clear button
//       jbClear.addActionListener(new ActionListener(){
//          public void actionPerformed (ActionEvent ae){
//             jtfFind.setText(null);
//             jtfFind.requestFocus();
//             highlighter.removeAllHighlights();
//          }
//       });
      
      
//       //Anon inner class for window listener 
//       addWindowListener(
//          new WindowAdapter(){
//             @Override 
//  	         public void windowClosing(WindowEvent e) {
//  		         JOptionPane.showMessageDialog(null, "Thank you for using finder");
//  		         System.exit(0);
//  	         }
//          });  

   
   }
   
   
//    public class FindText implements ActionListener{
//       
//       
//       public FindText(JTextArea jtaT, JTextField jtfF){
//          jtaText = jtaT;
//          jtfFind = jtfF;
//       }// End of Find constructor      
//       
//       public void actionPerformed (ActionEvent ae){
//          String areaText = jtaText.getText();
//          String findText = jtfFind.getText();
//          
//          int start = areaText.indexOf(findText);
//          int length = findText.length(); 
//          
//          Highlighter highlighter = jtaText.getHighlighter();
//          highlighter.removeAllHighlights();
// 
//          
//          try{
//             highlighter.addHighlight(start, start+length, DefaultHighlighter.DefaultPainter); 
//          }
//          catch (BadLocationException be){
//             JOptionPane.showMessageDialog(null, "No match found");
//          }
// 
//       } // End of actionperformed 
//       
//       
//    
//    }// End of Find class 


        

    //}
    
    @Override
    public void actionPerformed(ActionEvent ae){}
    
    /**
    * Update method updated the jtextarea with the information from the daily log
    */
    @Override
    public void update(Observable o, Object obj){
      if(obj instanceof String){
         String log = (String) obj;
         if(log.indexOf("|dl") == log.length()-3){
            log = log.substring(0, log.length()-3);
            jtaLog.setText(log);
         }
      }
    }
}
