package frogger;

import superclasses.PlayerSuper;
import superclasses.ImageChanger;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



/**
 * The Class Player.
 */
//THIS CLASS IS A TEMPLATE FOR PLAYERS
public class Player extends PlayerSuper{
	//player instance variables
	/** The player JLabel. */
	private JLabel label;
	
	/** The Constant DEFAULTCOLOR1. */
	private final static Color DEFAULTCOLOR1 = new Color(100,100,100);
	
	/** The Constant DEFAULTCOLOR2. */
	private final static Color DEFAULTCOLOR2 = new Color(200,200,200);
	
	/** The freeze. */
	protected boolean freeze = false;;
	
	/** The player color. */
	private Color playerColor;
	/** The player score. */
	private int score;
	
	/** The is finished. */
	protected boolean isFinished = false;
	
	/** The respawn finish. */
	protected boolean respawnFinish = false;
	
	/**
	 * Instantiates a new player.
	 *
	 * @param p the player JLabel
	 * @param s the player score
	 * @param c the c
	 */
	//constructor to give associate a score with a JLabel
	public Player(JLabel p, int s, Color c) {
		label = p;
		score = s;
		playerColor = c;
		initPlayer();
	}
	
	/**
	 * Inits the player.
	 */
	private void initPlayer() {
		
		//initiates images for players' animation 
		try {
			BufferedImage img = ImageIO.read(getClass().getResource("/images/Frogger/Anim/FrogJump0.png"));
			img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, playerColor);
			img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, getDarkerColor(playerColor));
			
			//sets icon of each player to the images used
			label.setIcon(new ImageIcon(img));
			
			//sets location
			label.setBounds(label.getX(), label.getY()-5, img.getWidth(), img.getHeight());
		}
		
		//catch exception otherwise
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	/**
	 * Gets the darker color.
	 *
	 * @param color the color
	 * @return the darker color
	 */
	private static Color getDarkerColor(Color color) {
		
		//get the original colors 
		int R = color.getRed();
		int G = color.getGreen();
		int B = color.getBlue();
		
		//change to darker color for red 
		if(R > 70)
			R -= 70;
		
		//change to darker color for green
		if(G > 70)
			G -= 70;
		
		//change to darker color for blue
		if(B > 70)
			B -= 70;
		
		return new Color(R,G,B);
	}
	
	/**
	 * Gets the player color.
	 *
	 * @return the player color
	 */
	public Color getPlayerColor() {
		return playerColor;
	}
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	//getters for x, and score
	public JLabel getLabel() {
		return label;
	}
	
	/**
	 * Gets the player x coordinate.
	 *
	 * @return the x coordinate
	 */
	public int getX() {
		return label.getX();
	}
	
	/**
	 * Gets the player y coordinate.
	 *
	 * @return the y coordinate
	 */
	public int getY() {
		return label.getY();
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return label.getWidth();
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return label.getHeight();
	}
	
	
	//setters for x,y and score
	//length and width never change so they do not require setters
	
	/**
	 * Sets the location.
	 *
	 * @param a the x coordinate
	 * @param b the y coordinate
	 */
	public void setLocation(int a, int b) {
		label.setLocation(a,b);
	}
	
	/**
	 * Respawn method for players
	 * 
	 * NOT FULLY IMPLEMENTED YET
	 * RIGHT NOW IT RESPAWNS PLAYERS TO A FIXED POINT ON THE SCREEN (468)
	 * BUT IT WILL EVENTUALLY RESPAWN THEM BASED ON HOW FAR THEY GET IN THE MAP 
	 * (THEY RESPAWN BACK TO THE NEAREST SAFEZONE THEY PASSED).
	 *
	 * @param y the y
	 */
	
	//method for respawning the players every time they hit an obstacle or are behind the map speed
	public void respawn(int y) {
		
		//set location for respawn
		label.setLocation(label.getX(), y);
		
		//subtract score by 30 every time they respawn
		this.subtractScore(30);
		
		//freeze player and respawn it
		freeze = true;
	}

	/**
	 * Sets the score.
	 *
	 * @param s the new score
	 */
	public void setScore(int s) {
		this.score = s;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Adds the score.
	 *
	 * @param num the score to add
	 */
	public void addScore(int num) {
		score += num;
	}
	
	/**
	 * Subtract score.
	 *
	 * @param num the score to subtract
	 */
	public void subtractScore(int num) {
		this.score -= num;
	}
	
}
