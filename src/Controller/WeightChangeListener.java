/*
 * Listener class for weight.
 * @Author - Abbey Sands
*/

package Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import Model.Writer;

public class WeightChangeListener implements ActionListener{
   private Writer weightWriter = new Writer();
   private Double newRecordedWeight;
   private JTextField JInputField;
   private String weightInputText;
   
   public WeightChangeListener(){
      
   }
   
   public void actionPerformed(ActionEvent ae){
      weightInputText = JOptionPane.showInputDialog("Please Enter a Weight");
      newRecordedWeight = Double.parseDouble(weightInputText);
      weightWriter.writeWeightLog(newRecordedWeight);
   }
}