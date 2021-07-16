import javax.swing.*;
import java.awt.*;
/**
 * Contributor(s): 
 * Your name: Howie Nguyen; CSID: 0005774775
 *            Reese Johnson; CSID: 0005689389
 *            
 * Sources:
 * Starting Out with Java, 6th edition, T. Gaddis
 * http://MyProgrammingLab.com: Starting Out with Java, 6th edition
 * https://docs.oracle.com/javase/tutorial/uiswing/layout/using.html#set
 * Jason Hawk phone number: 510-996-2264
 *
 * Version: 12092019
 * 
/**
 *  |-----------------------------------------------------------|
 *  |                          ScoreBoard                       |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     to update each field      |                           |
 *  |                               |                           |
 *  |     Shows scores              |        TreasureGame       |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

public class ScoreBoard extends JPanel{
    //Create text fields
    private JTextField triesField;  //create tries field
    private JTextField treasureField; //create treasure field
    private JTextField pointsField; //create points field 
    /**
     * Purpose: Constructor for ScoreBoard
     * signature: nothing 
     * example: ScoreBoard(JTextField triesField, JTextField treasureField,
    JTextField pointsField))
     */
    public ScoreBoard(JTextField triesField, JTextField treasureField,
    JTextField pointsField){

        //Set the text fields to instance variables
        this.triesField = triesField;
        this.treasureField = treasureField;
        this.pointsField = pointsField;

        //Create new panels
        JPanel mainPanel = new JPanel();
        JPanel panel = new JPanel();

        //Create panel for each field
        JPanel triesPanel = new JPanel();
        JPanel pointsPanel = new JPanel();
        JPanel treasurePanel = new JPanel();

        //Set border layout
        panel.setLayout(new BorderLayout());
        mainPanel.setLayout(new BorderLayout());
        triesPanel.setLayout(new BorderLayout());
        pointsPanel.setLayout(new BorderLayout());
        treasurePanel.setLayout(new BorderLayout());

        //Label and assign names to have "Comic Sans MS" font 20
        JLabel title = new JLabel("Score Board");        
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
 

        JLabel triesLabel = new JLabel("Tries: ");
        triesLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        JLabel treasureLabel = new JLabel("Treasure: ");
        treasureLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        JLabel pointsLabel = new JLabel("Points: ");
        pointsLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        //Add to tries panel
        triesPanel.add(triesLabel, BorderLayout.WEST);
        triesPanel.add(triesField, BorderLayout.EAST);

        //set color to pink
        triesPanel.setBackground(Color.PINK);

        //Add to points panel
        pointsPanel.add(pointsLabel, BorderLayout.WEST);
        pointsPanel.add(pointsField, BorderLayout.EAST);

        //set color to pink
        pointsPanel.setBackground(Color.PINK);

        //Add to treasure panel
        treasurePanel.add(treasureLabel, BorderLayout.WEST);
        treasurePanel.add(treasureField, BorderLayout.EAST);

        //set color to yellow
        treasurePanel.setBackground(Color.YELLOW);

        //Set preferred size of score panel
        mainPanel.setPreferredSize(new Dimension(150, 250));

        //Position the score board title
        title.setPreferredSize(new Dimension(70, 70));
        title.setHorizontalAlignment(JLabel.CENTER);

        //Add text panels to panel
        panel.add(triesPanel, BorderLayout.NORTH);
        panel.add(treasurePanel, BorderLayout.SOUTH);
        panel.add(pointsPanel, BorderLayout.CENTER);

        //Add title and panel to main panel
        mainPanel.add(title, BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.SOUTH);

        //Add main panel
        add(mainPanel);
    }
}
