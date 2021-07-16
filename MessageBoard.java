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
 *  |                          MessageBoard                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     of the buttons            |                           |
 *  |                               |                           |
 *  |     Shows message             |        TreasureGame       |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */

public class MessageBoard extends JPanel{

    //create text field
    private JLabel lastMoveLabel; //used to display last move.

    /**
     * Purpose: Constructor for MessageBoard
     * signature: nothing 
     * example: MessageBoard(JTextField lastMoveField)
     */
    public MessageBoard(JTextField lastMoveField){

        //Create new JPanel
        JPanel panel = new JPanel();

        //set borderLayout
        panel.setLayout(new BorderLayout());

        //label, assign and set the font to have "Comic Sans MS", 20
        lastMoveLabel = new JLabel("Last Move: ");
        lastMoveLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        
        //set the last move panel to the color pink
        panel.setBackground(Color.YELLOW);

        //Add and set the lastMoveLabel to West
        panel.add(lastMoveLabel, BorderLayout.WEST);
        //add and set the lastmoveField to the east
        panel.add(lastMoveField, BorderLayout.EAST);
        //add them to the panel
        add(panel);
    }
}