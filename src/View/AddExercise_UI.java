package View;
import Controller.Invoker;
import Controller.Command;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * AddExercise_UI provides the UI for adding a new Exercise
 * @author Tim Endersby, John Hill, Anna Jacobsen
 * @version 4/18/18
 */

public class AddExercise_UI extends JFrame implements Observer, ActionListener {

   //Attributes
   private ArrayList<String> exercises = new ArrayList<String>();
   private JComboBox jcbExercise;
   private Command exerciseCommand;
   private Command logExCommand;

   /**
   * Constructor for the AddExercise_UI.
   * @param exerC The command for adding an exercise.
   * @param logExC The command for logging an exercise.
   */
    public AddExercise_UI(Command exerC, Command logExC){
    
        exerciseCommand = exerC;
        logExCommand = logExC;
    
        JPanel leftSection = new JPanel(new GridLayout(2, 1));
        JPanel rightSection = new JPanel(new GridLayout(15,1));

        //Left Section - Log existing exercise
        JPanel jpExercise = new JPanel(new GridLayout(8, 1));
        jcbExercise = new JComboBox();
        jcbExercise.addItem("---Select an Exercise---");
        JPanel timeInput = new JPanel(new GridLayout(1,2));
        JLabel jlTime = new JLabel("Time (in minutes): ");
        jlTime.setForeground(Color.BLACK);
        jlTime.setHorizontalAlignment(SwingConstants.RIGHT);
        JTextField time = new JTextField(2);
        timeInput.add(jlTime);
        timeInput.add(time);
        JPanel jpButtonPanel = new JPanel(new GridLayout(1, 3));
        Invoker jbTime = new Invoker(exerciseCommand/*new AddExerciseCommand("AddToLog", 20.0)*/,"Save");

        jbTime.setFont(new Font("Tahoma", Font.BOLD, 12));
        jpButtonPanel.add(this.createPadding());
        jpButtonPanel.add(jbTime);
        jpButtonPanel.add(this.createPadding());
        JLabel exerciseTitle = new JLabel("  Log an Exercise:");
        exerciseTitle.setHorizontalAlignment(JLabel.CENTER);
        exerciseTitle.setForeground(Color.BLACK);
        jpExercise.add(exerciseTitle);
        jpExercise.add(createPadding());
        jpExercise.add(jcbExercise);
        jpExercise.add(createPadding());
        jpExercise.add(timeInput);
        jpExercise.add(createPadding());
        jpExercise.add(jpButtonPanel);

        leftSection.add(jpExercise);
        leftSection.add(this.createPadding());

        this.add(leftSection);

        //New Exercise entry
        JLabel rightTitle = new JLabel("Add New Exercise");
        rightTitle.setHorizontalAlignment(JLabel.CENTER);
        rightSection.add(rightTitle);
        rightSection.add(new JLabel("Name:"));
        JTextField name = new JTextField(2);
        rightSection.add(name);
        rightSection.add(new JLabel("Calories expended in 1 hour for"));
        rightSection.add(new JLabel("100 pound person:"));
        JTextField calories = new JTextField(2);
        rightSection.add(calories);;
        rightSection.add(createPadding());

        //Save Panel
        JPanel jpButtonPanelSave = new JPanel(new GridLayout(1, 3));
        Invoker jbSaveExercise = new Invoker(exerciseCommand, "Save");
        jbSaveExercise.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               jbSaveExercise.setExInfo(name.getText(), Double.parseDouble(calories.getText()));
               jbSaveExercise.buttonPress();
               JOptionPane.showMessageDialog(null, "Exercise added.");
               name.setText("");
               calories.setText("");
            }
        });

        
        jbSaveExercise.setFont(new Font("Tahoma", Font.BOLD, 12));
        jpButtonPanelSave.add(this.createPadding());
        jpButtonPanelSave.add(jbSaveExercise);
        jpButtonPanelSave.add(this.createPadding());
        rightSection.add(jpButtonPanelSave);

        this.add(rightSection);

        //Settings for the window.
        this.setLayout(new BorderLayout());
        JLabel background = new JLabel(/*new ImageIcon(getClass().getResource("background.jpg")*/);
        this.add(background);
        background.setLayout(new GridLayout(1,2));
        background.add(leftSection);
        //background.add(middleSection);
        background.add(rightSection);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.setTitle("Exercise");
        this.setResizable(false);
        this.pack();
        this.setVisible(false);
    }

    /**
     * A method for simply producing padding panels for the UI.
     * @return a translucent JPanel helping to align content where we want it.
     */
    public JPanel createPadding(){
        JPanel padding = new JPanel();
        padding.setOpaque(false);
        return padding;
    }

    /**
     * A method for building JButtons in the style of the UI
     */
    public JButton createJButton(String text){
        JButton jb = new JButton(text);
        jb.setBackground(Color.WHITE);
        jb.setForeground(new Color(3, 43, 76));
        jb.setFocusPainted(false);
        jb.setFont(new Font("Tahoma", Font.BOLD, 12));
        return jb;
    }   
    
    /**
    * actionPerformed method overrides the method from the ActionListener interface.
    */
    @Override
    public void actionPerformed( ActionEvent ae ){}
    
    /**
    * Update method overrides the update method from the Observer interface.
    * @param obs The observable object.
    * @param o The object passed to the observer.
    */
    @Override
    public void update( Observable obs, Object o ){
      if(o instanceof String ){
         String name = (String) o;
         if(name.indexOf("|ex") == name.length()-3){
            name = name.substring(0, name.length()-3);
            exercises.add(name);
            jcbExercise.addItem(name);
            validate();
            repaint();
         }
      }
    }

}
