package View;

import Controller.Invoker;
import Controller.Command;

import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

/**
 * AddFood_UI contains all of the necessary UI elements and functions for the
 * screen related to adding a new food to the program or recording a food to the
 * user's daily log
 * @author Los Ninos Sanos
 * @version 4/24/18
 */

public class AddFood_UI extends JFrame implements Observer, ActionListener {

    //Attributes
    private Command addFood;
    private Command logFood;
    private JComboBox jcbFood;
    ArrayList<String> foods = new ArrayList<String>();

   /**
   * Constructor for AddFood_UI has a Command object injected into it.
   * @param c A Command object.
   */
    public AddFood_UI(Command caf, Command clf) {
    
         //Instantiate commands.
         addFood = caf;
         logFood = clf;
    
        //Create 2 JPanels and put one on each side
        JPanel leftSection = new JPanel(new GridLayout(2, 1));
        JPanel rightSection = new JPanel(new GridLayout(15, 1));

        //Left Section - Log existing food
        JPanel jpFoods = new JPanel(new GridLayout(8, 1));
        //Food options
        jcbFood = new JComboBox();
        jcbFood.addItem("---Select a food---");
        JPanel servingsInput = new JPanel(new GridLayout(1, 4));
        //Portions
        JLabel jlServings = new JLabel("portions: ");
        jlServings.setForeground(Color.BLACK);
        JTextField servings = new JTextField(2);
        //Add to JPanel
        servingsInput.add(this.createPadding());
        servingsInput.add(jlServings);
        servingsInput.add(servings);
        servingsInput.add(this.createPadding());
        
        //Save button panel
        JPanel jpButtonPanel = new JPanel(new GridLayout(1, 3));
        Invoker jbServings = new Invoker(logFood, "Save");
        jbServings.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               if(!servings.getText().equals("")){
                  jbServings.buttonPress();
               }else{
                  JOptionPane.showMessageDialog(null, "Please enter a food and a number of servings");
               }
            }
        });
        //Header
        jpButtonPanel.add(this.createPadding());
        jpButtonPanel.add(jbServings);
        jpButtonPanel.add(this.createPadding());
        JLabel foodTitle = new JLabel("  Log a food:");
        foodTitle.setHorizontalAlignment(JLabel.CENTER);
        foodTitle.setForeground(Color.BLACK);
        
        //Add all to JPanel
        jpFoods.add(foodTitle);
        jpFoods.add(createPadding());
        jpFoods.add(jcbFood);
        jpFoods.add(createPadding());
        jpFoods.add(servingsInput);
        jpFoods.add(createPadding());
        jpFoods.add(jpButtonPanel);

        leftSection.add(jpFoods);
        leftSection.add(this.createPadding());

        this.add(leftSection);

        //Right Section - New Basic food entry
        JLabel rightTitle = new JLabel("Add New Food");
        rightTitle.setHorizontalAlignment(JLabel.CENTER);
        rightSection.add(rightTitle);
        rightSection.add(new JLabel("Name:"));
        JTextField name = new JTextField(2);
        rightSection.add(name);
        rightSection.add(new JLabel("Calories:"));
        JTextField calories = new JTextField(2);
        rightSection.add(calories);
        rightSection.add(new JLabel("Fats:"));
        JTextField fats = new JTextField(2);
        rightSection.add(fats);
        rightSection.add(new JLabel("Carbs:"));
        JTextField carbs = new JTextField(2);
        rightSection.add(carbs);
        rightSection.add(new JLabel("Proteins:"));
        JTextField proteins = new JTextField(2);
        rightSection.add(proteins);
        rightSection.add(createPadding());
        

        //Save a new food panel
        JPanel jpButtonPanelSave = new JPanel(new GridLayout(1, 3));
        Invoker jbSaveFood = new Invoker(addFood, "Save");
        jbSaveFood.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               jbSaveFood.setFoodInfo(name.getText(), Double.parseDouble(calories.getText()), Double.parseDouble(fats.getText()), Double.parseDouble(carbs.getText()), Double.parseDouble(proteins.getText()));
               jbSaveFood.buttonPress();
               JOptionPane.showMessageDialog(null, "Food saved.");
               name.setText("");
               calories.setText("");
               fats.setText("");
               carbs.setText("");
               proteins.setText("");
            }
        });
        
        System.out.println(proteins.getText());
        
        jbSaveFood.setFont(new Font("Tahoma", Font.BOLD, 12));
        jpButtonPanelSave.add(this.createPadding());
        jpButtonPanelSave.add(jbSaveFood);
        jpButtonPanelSave.add(this.createPadding());
        rightSection.add(jpButtonPanelSave);

        this.add(rightSection);

        //Settings for the window.
        this.setLayout(new BorderLayout());
        JLabel background = new JLabel();
        this.add(background);
        background.setLayout(new GridLayout(1, 2));
        background.add(leftSection);
        background.add(rightSection);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setTitle("Add a food");
        this.setResizable(false);
        this.pack();
        this.setVisible(false);
    }

    /**
     * A method for simply producing padding panels for the UI.
     * @return a translucent JPanel helping to align content where we want it.
     */
    public JPanel createPadding() {
        JPanel padding = new JPanel();
        padding.setOpaque(false);
        return padding;
    }

    /**
     * actionPerformed method overrides the method from the ActionListener interface.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
    /**
    * Update method overrides the update method from the Observer interface.
    */
    @Override
    public void update( Observable obs, Object o ){
      if(o instanceof String ){
         String name = (String) o;
         if(name.indexOf("|f") == name.length()-2){
            name = name.substring(0, name.length()-2);
            foods.add(name);
            jcbFood.addItem(name);
            validate();
            repaint();
         }
       }
    }
}
