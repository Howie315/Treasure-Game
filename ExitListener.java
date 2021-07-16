import java.awt.event.*;
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
 */
/**
 *  |-----------------------------------------------------------|
 *  |                          ExitListener                     |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     for exiting game          |                           |
 *  |                               |                           |
 *  |     exits the game            |        TreasureGame       |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class ExitListener implements ActionListener{
    /**
     * Purpose: action perform to exit the program
     * signature: nothing 
     * example: actionPerformed(ActionEvent e)
     */
    public void actionPerformed(ActionEvent e){    
        //Exit system
        System.exit(0);
    }
}