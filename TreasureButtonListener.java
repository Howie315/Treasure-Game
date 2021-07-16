import javax.swing.*;
import java.awt.event.*;
import java.util.*;
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
 *  |-----------------------------------------------------------|
 *  |                    TreasureButtonListener                 |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create action listener    |                           |
 *  |     for the TreasureButton    |      TreasureButton       |
 *  |                               |                           |
 *  |     Shows Treasure            |       TreasureGame        |
 *  |     Update the fields         |                           |
 *  |-------------------------------+---------------------------|
 */

public class TreasureButtonListener implements ActionListener{
    //Declare private variables 
    private TreasureGame game;  //used to store game's information
    private TreasureButton treasureButton;    //used to store the treasure button 
    private GameBoard board;    //used to store game board

    //Create text fields 
    private JTextField triesField;  //used to store tries field
    private JTextField treasureField;   //used to store the treasure field
    private JTextField pointsField;     //used to store the points field 
    private JTextField lastMoveField;  //used to store the last move field

    /**
     * Purpose: Constructor for ScoreBoard
     * signature: nothing 
     * example: ScoreBoard(TreasureButton treasureButton, TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField)
     */
    public TreasureButtonListener(TreasureButton treasureButton, TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField, JTextField lastMoveField, GameBoard board){
        this.treasureButton = treasureButton;
        this.game = game;
        this.board = board;
        this.triesField = triesField;
        this.treasureField = treasureField;
        this.pointsField = pointsField;
        this.lastMoveField = lastMoveField;
    }

    /**
     * Purpose: action performed for clicking on treasure button 
     * signature: nothing 
     * example:  actionPerformed(ActionEvent e)
     */
    public void actionPerformed(ActionEvent e){

        //set the button to be disabled
        treasureButton.setEnabled(false);
        //is overwritten by empty listener ------------------------------------------------------

        //using found treasure method
        game.foundTreasure();

        //update the textfields of the game 
        pointsField.setText("" + game.getPoints());
        treasureField.setText("" + game.getTreasure());
        triesField.setText("" + game.getTries());

        //is overwritten by empty listener -----------------------------------------------------------

        //if the treasure equals zero
        if(game.getTreasure() == 0){
            //then end game decide win/lose
            lastMoveField.setText("Game Over - YOU WIN");
            board.setDisable();
        }
        //else if the game is over 
        else if(game.checkGameOver()){
            //then the game will display that the user lost.
            lastMoveField.setText("Game Over LOSER");
            //set the  board button to be disabled.
            board.setDisable();
        }
    }
}