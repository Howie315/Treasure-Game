import javax.swing.*;
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
 * /
/**
 *  |-----------------------------------------------------------|
 *  |                        TreasureButton                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     of the buttons            |   TreasureButtonListener  |
 *  |                               |        EmptyButton        |
 *  |     Shows treasure            |         GameBoard         |
 *  |     when clicked              |                           |
 *  |-------------------------------+---------------------------|
 */
public class TreasureButton extends EmptyButton{
    //Image Icon used to display the gold
    private ImageIcon gold = new ImageIcon("gold.jpg");
    /**
     * Constructor for objects of class TreasureButton
     */
    public TreasureButton(){

    }
}