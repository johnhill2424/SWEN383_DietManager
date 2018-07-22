package View;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import Controller.WeightChangeListener;
/**
 * DietManager_UI is a class that provides the user with an interface for interacting with
 * program features, such as updating weight or adding food.
 * @author Anna Jacobsen
 * @version 3/28/18
 */

public class DietManager_UI extends JFrame implements ActionListener {
    
    public static final Color BLUE_COLOR = new Color(6,104,175);
    
    /**
     * Constructor for the DietManager_UI
     */
    public DietManager_UI(AddFood_UI afui, AddExercise_UI exui,ViewLog_UI vlui){
    
        AddFood_UI foodUI = afui;
        AddExercise_UI exUI = exui;
        ViewLog_UI viewLogUI = vlui;
    
        //Create JPanels for sections of the UI
        JPanel leftSection = new JPanel(new GridLayout(0,1));
        JPanel middleSection = new JPanel(new GridLayout(4,1));
        JPanel rightSection = new JPanel(new GridLayout(0,1));
        leftSection.setOpaque(false);
        middleSection.setOpaque(false);
        rightSection.setOpaque(false);
        
        //Four buttons on home screen for opening other windows
        //View log button
        JPanel jpLogButton = new JPanel(new GridLayout(2,1));
        JButton jbLog = createJButton("View Log");
        jbLog.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               viewLogUI.setVisible(true);
            }
        });
        jpLogButton.add(new JLabel("Diet Manager, Version 2.0"));
        jpLogButton.add(jbLog);
        //Add food button
        JPanel jpFoodButton = new JPanel(new GridLayout(2,1));
        JButton jbFood = createJButton("Add Food");
        jbFood.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            foodUI.setVisible(true);
         }
        });
        jpFoodButton.add(createPadding());
        jpFoodButton.add(jbFood);
        //Add weight button
        JPanel jpWeightButton = new JPanel(new GridLayout(2,1));
        JButton jbWeight = createJButton("Track Weight");
        jbWeight.addActionListener( new WeightChangeListener());
        jpWeightButton.add(createPadding());
        jpWeightButton.add(jbWeight);
        //Add exercise button
        JPanel jpExButton = new JPanel(new GridLayout(2,1));
        JButton jbEx = createJButton("Exercise");
        jpExButton.add(createPadding());
        jpExButton.add(jbEx);
        jbEx.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            exUI.setVisible(true);
         }
        });
        
        //Add buttons to middle section
        middleSection.add(jpLogButton);
        middleSection.add(jpFoodButton);
        middleSection.add(jpWeightButton);
        middleSection.add(jpExButton);
                
        //Menu Code
        JMenuBar jmb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu about = new JMenu("About");
        JMenu help = new JMenu("Help");
        
        JMenuItem version = new JMenuItem("Version");
        JMenuItem authors = new JMenuItem("Authors");
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem instructions = new JMenuItem("Instructions");
        JMenuItem contact = new JMenuItem("Contact");
        
        //Add the actionlisteners to the menu items.
        contact.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(null, "Questions, suggestions, or concerns? \nFeel free to e-mail us at help@dietmanager.com");
         }
        });
        instructions.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(null, "This is where the instructions will go yay.");
         }
        });
        authors.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(null, "Created by John Hill, Tim Endersby, Abbey Sands, Iris Zhang, & Anna Jacobsen");
         }
        });
        version.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            JOptionPane.showMessageDialog(null, "Diet Manager, Version 2.0. \nApril 26th, 2018. \nCreated for -name of co.- \nby Los Ni�os Sanos Development.");
         }
        });
        exit.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
            System.exit(0);
         }
        });
        
        //Add JMenuItems to their respective JMenus
        help.add(instructions);
        help.add(contact);
        about.add(authors);
        about.add(version);
        file.add(exit);
        
        //Add JMenus to the JMenuBar
        jmb.add(file);
        jmb.add(about);
        jmb.add(help);
        
        this.setJMenuBar(jmb);
                
        //Settings for the window.
        this.setLayout(new BorderLayout());
        JLabel background = new JLabel(/*new ImageIcon(getClass().getResource("background.jpg")*/);
        this.add(background);
        background.setLayout(new GridLayout(1,2));
        background.add(leftSection);
        background.add(middleSection);
        background.add(rightSection);
        this.setTitle("Diet Manager, v. 1.0");
        this.setAlwaysOnTop(false);
        this.setMinimumSize(new Dimension(500,500));
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.setLocationRelativeTo( null );
        this.setVisible( true );
    }
    
    /**
    * actionPerformed method overrides the method from the ActionListener interface.
    */
    @Override
    public void actionPerformed( ActionEvent ae ){}

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
    * A method for creating JLabels of a certain color
    * @return a JLabel with 'c' colored text.
    */
    public JLabel createJLabel(String text, Color c){
      JLabel jl = new JLabel(text);
      jl.setForeground(c);
      return jl;
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
}