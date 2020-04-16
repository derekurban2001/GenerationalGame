package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import superclasses.ImageChanger;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * The Class GUI.
 * 
 * This class handles all the Graphical User Interface elements.
 * 
 * @author Derek Urban
 */
public class GUI{	
	/** The panel. */
	protected static JLayeredPane panel;	//Not meant to be encapsulated
    
    /** Pacman player 1. */
    private Player pacmanPlayer1;
    
    /** Pacman player 2. */
    private Player pacmanPlayer2;
    
    /** The player list. */
    private Player playerList[];
    
    /** The clock label. */
    private JLabel jClock;
    
    /** The default colors for image changing. */
    private final Color DEFAULTCOLOR1 = new Color(100,100,100), DEFAULTCOLOR2 = new Color(200,200,200);
	
    /**
     * Instantiates a new GUI.
     */
    public GUI() {
		initComponents();	//Initializes components
	}
	
    /**
     * Initializes the components.
     */
	private void initComponents() {
	    JLabel pacmanBoard;
	    JLabel pacmanLabel1;
	    JLabel pacmanLabel2;
	    JLabel ghostLabel1 = null;
	    JLabel ghostLabel2 = null;
	    JLabel ghostLabel3 = null;
	    JLabel ghostLabel4 = null;
		
		panel = new JLayeredPane();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 541, 598);
		panel.setLayout(null);
		
		pacmanLabel1 = new JLabel("");
		pacmanLabel1.setBounds(10, 10, 36, 36);
		panel.add(pacmanLabel1, 2);
		
		pacmanLabel2 = new JLabel("");
		pacmanLabel2.setBounds(10, 10, 36, 36);
		panel.add(pacmanLabel2, 1);
		
		pacmanBoard = new JLabel("");
		pacmanBoard.setHorizontalTextPosition(SwingConstants.LEFT);
		pacmanBoard.setHorizontalAlignment(SwingConstants.LEFT);
		try {
			pacmanBoard.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/Pacman/pacmanBoard.png"))));
		} 
		catch (Exception ex) {}
		pacmanBoard.setBounds(0, 0, 540, 597);
		
		jClock = new JLabel("Timer: 0");
		jClock.setForeground(new Color(255, 255, 0));
		jClock.setHorizontalAlignment(SwingConstants.CENTER);
		jClock.setFont(new Font("Terminator Two", Font.BOLD, 19));
		jClock.setBorder(null);
		jClock.setBounds(213, 262, 115, 36);
		jClock.setBackground(new Color(0, 0, 0));
		panel.add(jClock, 992);
		
		JLabel jGameOverDisplay = new JLabel("Game Over");
		jGameOverDisplay.setVerticalTextPosition(SwingConstants.TOP);
		jGameOverDisplay.setHorizontalTextPosition(SwingConstants.LEADING);
		jGameOverDisplay.setBounds(0, 248, 540, 66);
		jGameOverDisplay.setForeground(Color.YELLOW);
		jGameOverDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		jGameOverDisplay.setFont(new Font("Terminator Two", Font.BOLD, 72));
		jGameOverDisplay.setBorder(null);
		jGameOverDisplay.setBackground(new Color(0, 0, 0));
		jGameOverDisplay.setVisible(false);
		panel.add(jGameOverDisplay, 993);
		
		JLabel player2DisplayScore1 = new JLabel("Score:");
		player2DisplayScore1.setHorizontalAlignment(SwingConstants.CENTER);
		player2DisplayScore1.setFont(new Font("Terminator Two", Font.BOLD, 20));
		player2DisplayScore1.setForeground(Color.YELLOW);
		player2DisplayScore1.setBounds(448, 311, 92, 24);
		panel.add(player2DisplayScore1, 994);
		
		JLabel player2DisplayScore2 = new JLabel("00000");
		player2DisplayScore2.setHorizontalAlignment(SwingConstants.CENTER);
		player2DisplayScore2.setFont(new Font("Terminator Two", Font.BOLD, 20));
		player2DisplayScore2.setForeground(Color.YELLOW);
		player2DisplayScore2.setBounds(448, 336, 92, 26);
		panel.add(player2DisplayScore2, 995);
		
		JLabel player2DisplayIcon = new JLabel("P3/4");
		player2DisplayIcon.setHorizontalAlignment(SwingConstants.CENTER);
		player2DisplayIcon.setFont(new Font("Terminator Two", Font.BOLD, 20));
		try {	//call ImageChanger to set team icons to appropriate colors
			BufferedImage img = ImageIO.read(getClass().getResource("/images/Pacman/PacmanEating/PacmanEating08.png"));
			img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, Player.getPlayer3Color());
			img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, Player.getPlayer4Color());
			player2DisplayIcon.setIcon(new ImageIcon(img));
		}
		catch(Exception ex) {ex.printStackTrace();}
		player2DisplayIcon.setForeground(Color.YELLOW);
		player2DisplayIcon.setBounds(448, 197, 92, 48);
		panel.add(player2DisplayIcon, 996);
		
		JLabel player1DisplayScore1 = new JLabel("Score:");
		player1DisplayScore1.setHorizontalAlignment(SwingConstants.CENTER);
		player1DisplayScore1.setForeground(Color.YELLOW);
		player1DisplayScore1.setFont(new Font("Terminator Two", Font.BOLD, 20));
		player1DisplayScore1.setBounds(0, 311, 92, 24);
		panel.add(player1DisplayScore1, 997);
		
		JLabel player1DisplayScore2 = new JLabel("00000");
		player1DisplayScore2.setHorizontalAlignment(SwingConstants.CENTER);
		player1DisplayScore2.setForeground(Color.YELLOW);
		player1DisplayScore2.setFont(new Font("Terminator Two", Font.BOLD, 20));
		player1DisplayScore2.setBounds(0, 335, 92, 26);
		panel.add(player1DisplayScore2, 998);
		
		JLabel player1DisplayIcon = new JLabel("P1/2");
		try {	//call ImageChanger to set team icons to appropriate colors
			BufferedImage img = ImageIO.read(getClass().getResource("/images/Pacman/PacmanEating/PacmanEating08.png"));
			img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, Player.getPlayer1Color());
			img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, Player.getPlayer2Color());
			player1DisplayIcon.setIcon(new ImageIcon(img));
		}
		catch(Exception ex) {}
		player1DisplayIcon.setHorizontalAlignment(SwingConstants.CENTER);
		player1DisplayIcon.setForeground(Color.YELLOW);
		player1DisplayIcon.setFont(new Font("Terminator Two", Font.BOLD, 20));
		player1DisplayIcon.setBounds(0, 197, 92, 48);
		panel.add(player1DisplayIcon, 999);
		
		pacmanPlayer1 = new Player(pacmanLabel1, "Player1");	//Make two new players based off player labels
		pacmanPlayer2 = new Player(pacmanLabel2, "Player2");
		playerList = new Player[]{pacmanPlayer1, pacmanPlayer2};	//create player list
		
		AI ghostAI1;
	    AI ghostAI2;
	    AI ghostAI3;
	    AI ghostAI4;
	    ghostAI1 = addGhost(ghostLabel1, "images/Pacman/Ghosts/ghostRed.png", "Red Ghost");	//initialize ghosts through addGhost function
		ghostAI2 = addGhost(ghostLabel2, "images/Pacman/Ghosts/ghostBlue.png", "Blue Ghost");
		ghostAI3 = addGhost(ghostLabel3, "images/Pacman/Ghosts/ghostPink.png", "Pink Ghost");
		ghostAI4 = addGhost(ghostLabel4, "images/Pacman/Ghosts/ghostOrange.png", "Orange Ghost");
	    AI ghostList[] = {ghostAI1, ghostAI2, ghostAI3, ghostAI4};	//create ghost list

	    new ObjectMovementHandler(playerList, ghostList, jClock, player1DisplayScore2, player2DisplayScore2);	//start ObjectMovementHandler

		new AnimationUpdater(playerList, ghostList, jGameOverDisplay);	//start AnimationUpdater

		new PhidgetHandler(pacmanPlayer1, pacmanPlayer2);	//start PhidgetHandler
		
		panel.add(pacmanBoard, 1000);
	}
    
	/**
	 * Adds the ghost.
	 *
	 * @param iLabel the incoming label argument
	 * @param imageFilePath the image file path
	 * @param iName the incoming name argument
	 * @return the AI
	 */
	private AI addGhost(JLabel iLabel, String imageFilePath, String iName) {
    	iLabel = new JLabel("");
    	iLabel.setBounds(10, 10, 36, 36);
		GUI.panel.add(iLabel, 5);
		return new AI(iLabel, imageFilePath, iName, playerList);
    }
}

