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
 *  |                      EmptyButtonListener                  |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create action listener    |                           |
 *  |     for the EmptyButton       |        EmptyButton        |
 *  |                               |                           |
 *  |     Shows empty when clicked  |       TreasureGame        |
 *  |     Update the fields         |                           |
 *  |-------------------------------+---------------------------|
 */
public class EmptyButtonListener implements ActionListener{
    //Declare private variables 
    private TreasureGame game;  //used to store game's information
    private EmptyButton btn;    //used to store empty button 
    private GameBoard board;    //used to store game board

    //Create text fields 
    private JTextField triesField;  //used to store tries field
    private JTextField treasureField;   //used to store the treasure field
    private JTextField pointsField;     //used to store the points field 
    private JTextField lastMoveField;  //used to store the last move field

    /**
     * Purpose: contructor that intializes the empty button, treasure game, tries, points,  last move, and gameboard.
     * signature: nothing 
     * example: EmptyButtonListener(EmptyButton btn, TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField, JTextField lastMoveField, GameBoard board)
     */
    public EmptyButtonListener(EmptyButton btn, TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField, JTextField lastMoveField, GameBoard board){

        this.btn = btn;
        this.game = game;
        this.board = board;
        this.triesField = triesField;
        this.treasureField = treasureField;
        this.pointsField = pointsField;
        this.lastMoveField = lastMoveField;
    }

    /**
     * Purpose: action perform when clicking on empty button, suppose to update each field, and disable buttons 
     * signature: nothing 
     * example: actionPerformed(ActionEvent e)
     */
    public void actionPerformed(ActionEvent e){

        //set the button ot be disabled  
        btn.setEnabled(false);

        //using the found nothing method 
        game.foundNothing();

        //update the game's text fields
        pointsField.setText("" + game.getPoints());
        treasureField.setText("" + game.getTreasure());
        triesField.setText("" + game.getTries());
        lastMoveField.setText("Miss owo");
        //if the game is over, then the game will say "Game Over LOSER"
        //then set the board functions to be disabled.
        if(game.checkGameOver()){
            //end game decide win/lose
            lastMoveField.setText("Game Over LOSER");
            board.setDisable();
        }
    }
}