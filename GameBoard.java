import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
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
 *  |                          GameBoard                        |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create functionality      |       TrollButton         |
 *  |     of the game board         |       EmptyButton         |
 *  |                               |       TreasureButton      |
 *  |     Shows different buttons   |       TreasureGame        |
 *  |     when clicked              |                           |
 *  |-------------------------------+---------------------------|
 */

public class GameBoard extends JPanel{

    //Create a treasure game
    private TreasureGame game; //used to store the information of treasure game

    //Create text fields
    private JTextField triesField;    //create tries field
    private JTextField treasureField; //create treasure field
    private JTextField pointsField;   //create points field
    private JTextField trollsField;   //create trolls field
    private JTextField lastMoveField; //create last move field

    //Create array of empty buttons
    private EmptyButton buttons[];

    //Create a image icon for all buttons
    private ImageIcon hole = new ImageIcon("hole.jpg");
    private ImageIcon sand = new ImageIcon("sand.jpg");
    private ImageIcon gold = new ImageIcon("gold.jpg");
    private ImageIcon troll = new ImageIcon("troll.jpg");
    /**
     * Purpose: This game is intended to create a gridlayout treasure hunt game
     * signature: nothing
     * example: GameBoard(TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField, JTextField lastMoveField)
     */
    public GameBoard(TreasureGame game, JTextField triesField, JTextField treasureField,
    JTextField pointsField, JTextField lastMoveField){
        //Set game
        this.game = game;

        //Set the text fields to instant variables
        this.triesField = triesField;
        this.treasureField = treasureField;
        this.pointsField = pointsField;
        this.trollsField = trollsField;
        this.lastMoveField = lastMoveField;

        //Create 100 empty buttons
        buttons = new EmptyButton[100];

        //add the treasure game
        addGame();
    }

    /**
     * Purpose: To add the treasure
     * signature: nothing
     * example: addGame()
     */
    public void addGame(){

        //Create a panel for the game
        JPanel panel = new JPanel();

        //Set the panel size
        panel.setPreferredSize(new Dimension(550, 550));

        //Create a random generator
        Random myNumberGenerator = new Random();

        //Create a grid layout for panel
        panel.setLayout(new GridLayout(10,10));

        //loop for treasure buttons
        for(int treasureButtonIndex =0; treasureButtonIndex < 20; treasureButtonIndex++){

            //Create random number variable
            int randomNumber;

            do{
                //Create a random number
                randomNumber = myNumberGenerator.nextInt(100);

                //Repeat while random number are not null
            }while(buttons[randomNumber] != null);

            //Create a new treasure button
            TreasureButton treasureButton = new TreasureButton();

            //Add treasure button to buttons
            buttons[randomNumber] = treasureButton;

            //Add action listener to buttons
            buttons[randomNumber].addActionListener
            (new TreasureButtonListener(treasureButton, game, triesField, treasureField,
                    pointsField, lastMoveField, this));

            //resize image by 60,60
            gold = new ImageIcon(
                gold.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

            //Set a disable icon treasure for random button
            buttons[randomNumber].setDisabledIcon(gold);
        }

        //loop for troll buttons
        for(int trollButtonIndex = 0; trollButtonIndex < 20; trollButtonIndex++){

            //Create random number variable
            int trollRandomNumber;
            do{
                //Create a random troll number
                trollRandomNumber = myNumberGenerator.nextInt(100);

                //Repeat while random number are not null
            }while(buttons[trollRandomNumber] != null);

            //Create a new troll button
            TrollButton trollButton = new TrollButton();

            //Add troll button to buttons
            buttons[trollRandomNumber] = trollButton;

            //Add action listener to buttons
            buttons[trollRandomNumber].addActionListener
            (new TrollButtonListener(trollButton, game, triesField,treasureField,
                    pointsField, lastMoveField, this));

            //Resizing image by 60,60
            troll = new ImageIcon(
                troll.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

            //Set a disable icon troll for troll button
            buttons[trollRandomNumber].setDisabledIcon(troll);            
        }

        //loop for empty buttons
        for(int emptyButtonIndex = 0; emptyButtonIndex < 100; emptyButtonIndex++){

            //If button is null
            if(buttons[emptyButtonIndex] == null){

                //Create a new empty button
                EmptyButton emptyButton = new EmptyButton();

                //Add empty button to buttons
                buttons[emptyButtonIndex] = emptyButton;

                //Add action listener to buttons
                buttons[emptyButtonIndex].addActionListener(new EmptyButtonListener(emptyButton, game, triesField, treasureField,
                        pointsField, lastMoveField, this));

            }

            //Add the buttons to panel
            panel.add(buttons[emptyButtonIndex]);  
        }

        //Add panel
        add(panel);
    }

    /**
     * Purpose: To reveal game board
     * signature: nothing
     * example: setDisable()
     */
    public void setDisable(){
        for(int disabledButtonIndex =0; disabledButtonIndex < 100; disabledButtonIndex++)
        {            
            buttons[disabledButtonIndex].setEnabled(false);
        }
    }
}
