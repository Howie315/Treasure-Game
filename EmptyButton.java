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
 *  |                          EmptyButton                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     of the buttons            |     EmptyButtonListener   |
 *  |                               |       TreasureButton      |
 *  |     Shows empty when clicked  |         GameBoard         |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class EmptyButton extends JButton{
    //Creating Image icons
    ImageIcon hole = new ImageIcon("hole.jpg");  //create hole icon
    ImageIcon sand = new ImageIcon("sand.jpg");  //create sand icon

    /**
     * Purpose: Constructor for objects of class EmptyButton
     * signature: nothing
     * example: EmptyButton()
     */
    public EmptyButton(){

        //Resizing the images to be 60,60
        hole = new ImageIcon(
            hole.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        sand = new ImageIcon(
            sand.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        //setting the icon to be "sand"
        this.setIcon(sand);
        //Set a disable icon hole for empty button
        this.setDisabledIcon(hole);

    }
}
