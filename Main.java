import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel numberLabel;
  JLabel factoralLabel;

  JTextField numberField;
  JTextField factoralDisplay;

  JButton calcButton;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Factoral Calculator");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 

    //initialize the class Variables
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    numberLabel = new JLabel("n");
    factoralLabel = new JLabel("factoral(n)");

    numberField = new JTextField();
    factoralDisplay = new JTextField();

    calcButton = new JButton("CALC");

    //set location and size of class Variables
    numberLabel.setBounds(20,20,10,20);
    numberField.setBounds(40,20,50,20);
    factoralLabel.setBounds(100,20,80,20);
    factoralDisplay.setBounds(190,20,50,20);
    calcButton.setBounds(250,20,80,20);

    //add an action ActionListener to the button
    calcButton.addActionListener(this);

    //Disable the factoralDisplay
    factoralDisplay.setEnabled(false);

    //add the components to the main panel
    mainPanel.add(numberLabel);
    mainPanel.add(numberField);
    mainPanel.add(factoralLabel);
    mainPanel.add(factoralDisplay);
    mainPanel.add(calcButton);

    //add main panel to frame
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //make a variable to hold the entered number (this will also be an accumulator for the final factoral)
    int number = Integer.parseInt(numberField.getText());


    //make a for loop to multiply the number by all it's consecutive decreasing integers
    for(int i = number; i > 1; i--){
      //change the number to itself time the current value of "i" minus one
      number *= i - 1;
    }
    //print the factoral to the factoralDisplay
    factoralDisplay.setText("" + number);

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
