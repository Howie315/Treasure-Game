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
 *  |                          LegendBoard                      |
 *  |-----------------------------------------------------------|
 *  |      Responsibilities         |   Collaborating Classes   |
 *  |-------------------------------+---------------------------|
 *  |     Inform what buttons do    |                           |
 *  |                               |     TreasureGame          |
 *  |                               |                           |
 *  |     Shows legend board        |                           |
 *  |                               |                           |
 *  |-------------------------------+---------------------------|
 */
public class LegendBoard extends JPanel{
    //Creating variables
    private ImageIcon hole = new ImageIcon("hole.jpg"); //create hold icon
    private ImageIcon sand = new ImageIcon("sand.jpg"); //create sand icon 
    private ImageIcon gold = new ImageIcon("gold.jpg"); //create gold icon 
    private ImageIcon troll = new ImageIcon("troll.jpg"); //create troll icon 
    /**
     * Purpose: Constructor for objects of class legendBoard
     * signature: nothing 
     * example: LegendBoard()
     */
    public LegendBoard(){
        //main
        JPanel mainPanel = new JPanel();

        //main panels
        JPanel clickedPanel = new JPanel();
        JPanel legendPanel = new JPanel();

        //label panels
        JPanel sandPanel = new JPanel();
        JPanel treasurePanel = new JPanel();
        JPanel trollPanel = new JPanel();
        JPanel holePanel = new JPanel();

        //Create new border layouts for each panel
        clickedPanel.setLayout(new BorderLayout());
        legendPanel.setLayout(new BorderLayout());
        sandPanel.setLayout(new BorderLayout());
        treasurePanel.setLayout(new BorderLayout());
        trollPanel.setLayout(new BorderLayout());
        holePanel.setLayout(new BorderLayout());

        //create Legend labels, and set the font to "Comic Sans MS" size 15
        JLabel title = new JLabel("LEGEND");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        title.setHorizontalAlignment(JLabel.CENTER);

        JLabel sandLabel = new JLabel("SAND: ");
        sandLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        JLabel treasureLabel = new JLabel("TREASURE: ");
        treasureLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        JLabel trollLabel = new JLabel("TROLL: ");
        trollLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        JLabel holeLabel = new JLabel("HOLE: ");
        holeLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));

        //create image labels
        JLabel sandImage = new JLabel();
        JLabel treasureImage = new JLabel();
        JLabel trollImage = new JLabel();
        JLabel holeImage = new JLabel();

        //resizing images 70, 70
        hole = new ImageIcon(
            hole.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

        sand = new ImageIcon(
            sand.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

        troll = new ImageIcon(
            troll.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

        gold = new ImageIcon(
            gold.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

        //set images to image icon
        sandImage.setIcon(sand);
        treasureImage.setIcon(gold);
        trollImage.setIcon(troll);
        holeImage.setIcon(hole);  

        //add sandLabel to sandPanel to the west
        sandPanel.add(sandLabel, BorderLayout.WEST);

        //add sandImage to the sandPanel to the east
        sandPanel.add(sandImage, BorderLayout.EAST);
        
        //set the sandPanel to the color pink
        sandPanel.setBackground(Color.PINK);
        
        //add the treasureLabel to the treasurePanel to the west
        treasurePanel.add(treasureLabel, BorderLayout.WEST);

        //add the treasureImage to treasurePanel to the east 
        treasurePanel.add(treasureImage, BorderLayout.EAST);
        
        //set the treasure panel to the color pink
        treasurePanel.setBackground(Color.PINK);
        
        //add the trollLabel to the trollPanel to the west
        trollPanel.add(trollLabel, BorderLayout.WEST);

        //add the trollImage to the trollPanel to the east
        trollPanel.add(trollImage, BorderLayout.EAST);
        
        //set the trollPanel to the color pink
        trollPanel.setBackground(Color.PINK);
        
        //add the holeLabel to the holePanel to the west
        holePanel.add(holeLabel, BorderLayout.WEST);

        //add the holeImage to the holePanel to the east.
        holePanel.add(holeImage, BorderLayout.EAST);
        
        holePanel.setBackground(Color.PINK);

        //add the holePanel, treasurePanel, and the trollPanel to the clicked panel
        clickedPanel.add(holePanel, BorderLayout.NORTH);
        clickedPanel.add(treasurePanel, BorderLayout.CENTER);
        clickedPanel.add(trollPanel, BorderLayout.SOUTH);

        //add the panels to the legendPanel      
        legendPanel.add(title, BorderLayout.NORTH);
        legendPanel.add(sandPanel, BorderLayout.CENTER);
        legendPanel.add(clickedPanel, BorderLayout.SOUTH);
        legendPanel.setBackground(Color.YELLOW);

        //add the legendPanel to the mainPanel
        mainPanel.add(legendPanel);

        //add main finally
        add(mainPanel);
    }
}
