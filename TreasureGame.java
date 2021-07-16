import javax.swing.*;
import java.awt.*;
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
/**
 *  |-----------------------------------------------------------|
 *  |                         TreasureGame                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Create interface of the   |                           |
 *  |     Treasure Game             |         GameBoard         |
 *  |                               |         ScoreBoard        |
 *  |     Shows a Game when         |         MessageBoard      |
 *  |     play is used              |                           |
 *  |-------------------------------+---------------------------|
 */
public class TreasureGame extends JFrame{
    //Create boards
    private ScoreBoard scoreBoard;                  //used to store scores
    private GameBoard gameBoard;                    //used to store game board information
    private MessageBoard messageBoard;              //used to store the message baord information

    //Create booleans 
    private boolean gameOver = false;               //used to to determine game over 
    private boolean textLegal = false;              //used for editability for text fields

    private int tries = 50;                         //used for user's tries
    private int points = 0;                         //used to store points
    private int treasure = 20;                      //used to store the treasure

    //Creating text fields for score boards
    private JTextField triesField = new JTextField(2);
    private JTextField pointsField = new JTextField(2);
    private JTextField treasureField = new JTextField(2);

    //Create text field for last move
    private JTextField lastMoveField = new JTextField(12);

    /**
     * Purpose: Create a treasure game interface
     * signature: nothing 
     * example: TreasureGame()
     */
    public TreasureGame(){
        //Set window size
        setSize(1000, 800);

        //Set window title
        setTitle("Treasure Game");

       
        
        
        //Edibility
        triesField.setEditable(textLegal);                  //Set the tries field editability
        pointsField.setEditable(textLegal);                 //Set the points field editability
        treasureField.setEditable(textLegal);               //Set the treasure field editability
        lastMoveField.setEditable(textLegal);               //Set the last move field editability
        
        triesField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));      //set triesField to the  font to have "Comic Sans MS", 20
        pointsField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));     //set pointsField to the font to have "Comic Sans MS", 20
        treasureField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));   //set treasureField  to the font to have "Comic Sans MS", 20
        lastMoveField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));   //set lastmove field to the font to have "Comic Sans MS", 20
        //set the last move field to have the color pink
        lastMoveField.setBackground(Color.PINK);

        //Set text fields with accessors
        pointsField.setText("" + this.getPoints());             //Set the points field to points
        treasureField.setText("" + this.getTreasure());         //Set the treasure field to treasure
        triesField.setText("" + this.getTries());               //Set the tries field to tries

        /*
         * Set a menu
         */
        JMenuBar menuBar = new JMenuBar();                                     //Create a menu bar
        JMenu fileMenu = new JMenu("File");                                    //Create a menu dropbox file
        JMenu aboutMenu = new JMenu("About");                                  //Create a menu dropbox about

        JMenuItem exitItem = new JMenuItem("Exit");                            //Create an exit button
        JMenuItem about = new JMenuItem("About Contributors");                 //Contributors about mesage
        about.addActionListener(new AboutMenuListener());                      //add action listener to the menu item

        exitItem.addActionListener(new ExitListener());                        //Create action listener for exit
        menuBar.add(fileMenu);                                                 //Add file to menu bar
        fileMenu.add(exitItem);                                                //Add exit to file menu

        menuBar.add(aboutMenu);                                                //Add about to menu bar
        aboutMenu.add(about);                                            //Add label to about

        setJMenuBar(menuBar);                                                  //Set a menu bar

        /*
         * create title
         * 
         */
        JLabel gameName = new JLabel();                                 //Create a game name label
        gameName.setText("Treasure Cove");                              //Set game name text to say "Treasure Cove"
        gameName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));    //Set the size of the label
        gameName.setHorizontalAlignment(JLabel.CENTER);                 //Set the alignment of game name label

        /*
         * Populate board with game
         */
        gameBoard = new GameBoard(this, triesField, treasureField, pointsField, lastMoveField);

        /*
         * Set west side score board
         */
        scoreBoard = new ScoreBoard(triesField, treasureField, pointsField);

        /*
         * set south side message board
         * set last move to say something
         */
        lastMoveField.setText("READY?");
        messageBoard = new MessageBoard(lastMoveField);
        
        /*
         * set the legend board to east 
         */
        LegendBoard legendBoard = new LegendBoard();

        //Add layout of game
        add(gameName, BorderLayout.NORTH);                  //Add game name label to north
        add(gameBoard, BorderLayout.CENTER);                //Add game board to center
        add(scoreBoard, BorderLayout.WEST);                 //Add score board to west
        add(legendBoard, BorderLayout.EAST);                //Add legend board to east
        add(messageBoard, BorderLayout.SOUTH);              //Add message board to south
        
        //Set treasure game to be visible
        setVisible(true);
    }

    /**
     * Purpose: To reduce tries by one and check if game is over
     * signature: nothing
     * example: reduceNumberOfTries()
     */
    public void reduceNumberOfTries(){
        //Subtract one from tries
        tries--;

        //Check if game is over
        checkGameOver();
    }

    /**
     * Purpose: To add randomPoints and reduce treasures by one and update tries
     * signature: nothing
     * example: foundTreasure()
     */
    public void foundTreasure(){
        //random points generator
        Random myPointsGenerator = new Random();
        //have randomPoints numbers 1-3
        int randomPoints = myPointsGenerator.nextInt(3)+1;
        //Add random numbers to points
        points += randomPoints;

        //If statements to display how many points the user gets when finding treasure.
        if(randomPoints == 1){
            lastMoveField.setText("You got 1 point");
        }
        else if(randomPoints ==2 ){
            lastMoveField.setText("You got 2 points");
        }
        else if(randomPoints == 3 ){
            lastMoveField.setText("You got 3 points");
        }

        //Subtract one from tries
        treasure--;

        //Reduce tries and check game over
        reduceNumberOfTries();
    }

    /**
     * Purpose: To call reduce tries
     * signature: nothing
     * example: foundNothing()
     */
    public void foundNothing(){
        //Reduce tries and check game over
        reduceNumberOfTries();
    }

    /**
     * Purpose: To call reduce tries and take away points
     * signature: nothing
     * example: trolled()
     */
    public void trolled(){
        //Reduce tries and check game over
        reduceNumberOfTries();

        //Set points to 0
        this.points = 0;            
    }

    //Accessors

    /**
     * Purpose: To check game over
     * signature: output boolean
     * example: checkGameOver()
     */
    public boolean checkGameOver(){

        //If tries is equal to 0
        if(tries <= 0){
            //Set game over to be true
            gameOver = true;
        }

        return gameOver;
    }

    /**
     * Purpose: return tries
     * signature: output integer
     * example: getTries()
     */
    public int getTries(){
        return tries;
    }

    /**
     * Purpose: return getPoints
     * signature: output integer
     * example: getPoints()
     */
    public int getPoints(){
        return points;
    }

    /**
     * Purpose: return treasure
     * signature: output integer
     * example: getTreasure()
     */
    public int getTreasure(){
        return treasure;
    }
   
}
