import javax.swing.*;
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
 * /
/**
 *  |-----------------------------------------------------------|
 *  |                    TrollButtonListener                    |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create action listener    |                           |
 *  |     for the TrollButton       |      TrollButton          |
 *  |                               |                           |
 *  |     Resets the points         |       TreasureGame        |
 *  |     Update the fields         |                           |
 *  |-------------------------------+---------------------------|
 */
public class TrollButtonListener implements ActionListener{
    //Declare private variables 
    private TreasureGame game;  //used to store game's information
    private TrollButton trollButton;    //used to store troll button 
    private GameBoard board;    //used to store game board

    //Create text fields 
    private JTextField triesField;  //used to store tries field
    private JTextField treasureField;   //used to store the treasure field
    private JTextField pointsField;     //used to store the points field 

    private JTextField lastMoveField;  //used to store the last move field

    /**
     * Purpose: contructor that intializes the troll button, treasure game, tries, points,  last move, and gameboard.
     * signature: nothing 
     * example: TrollButtonListener(TrollButton trollButton, TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField,JTextField lastMoveField, GameBoard board)
     */
    public TrollButtonListener(TrollButton trollButton, TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField,JTextField lastMoveField, GameBoard board){
        //class objects to apply the troll functionality 
        this.trollButton = trollButton;
        this.game = game;
        this.board = board;

        //JTextFields used to update game 
        this.triesField = triesField;
        this.treasureField = treasureField;
        this.pointsField = pointsField;
        this.lastMoveField = lastMoveField;

    }

    /**
     * Purpose: action perform when clicking on troll button, suppose to update each field, disable buttons, and reset points
     * signature: nothing 
     * example: actionPerformed(ActionEvent e)
     */
    public void actionPerformed(ActionEvent e){
        //Set the troll button to be disabled
        trollButton.setEnabled(false);
        //troll button method 
        game.trolled();

        //update each of the fields 
        pointsField.setText("" + game.getPoints());
        treasureField.setText("" + game.getTreasure());
        triesField.setText("" + game.getTries());
        lastMoveField.setText("Trolled");

        //if game is over then set the last move field to be "Game Over Loser"
        //and set board functions to be disabled.
        if(game.checkGameOver()){          
            lastMoveField.setText("Game Over LOSER");
            board.setDisable();
        }
    }

}
