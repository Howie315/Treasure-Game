import java.awt.*;
import java.awt.event.*;
import java.util.*;
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
 * 
/**
 *  |-----------------------------------------------------------|
 *  |                       AboutMenuistener                    |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |                           |
 *  |     for displaying message    |                           |
 *  |                               |                           |
 *  |     show the contributors     |        TreasureGame       |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class AboutMenuListener implements ActionListener
{
    /**
     * Purpose: action performed for displaying the contributors 
     * signature: nothing 
     * example:  actionPerformed(ActionEvent e)
     */
    public void actionPerformed(ActionEvent e){
        //Create a JOption pane 
        JOptionPane pane = new JOptionPane();
        //display dialog 
        pane.showMessageDialog(null, "Developers: " + "Howie Nguyen and Reese Nevada"  + "\nEmails: nguyen.howie2010@gmail.com" +
            "\n" + "reesenevada@gmail.com");
    }
}
