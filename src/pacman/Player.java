package pacman;

import superclasses.PlayerSuper;
import javax.swing.JLabel;

/**
 * The Class Player.
 * 
 * This class defines a player, and all the actions/characteristics of it for Pacman.
 * Things such as movement, score are the primary features.
 * 
 * @author Derek Urban
 */
public class Player extends PlayerSuper{
	
	/** The primary/secondary direction of the player. */
	private String pDir, sDir;
	
	/** The score of the player. */
	private int score;
	
	/** The name of the player. */
	protected String name;
	
	/** The lists containing all horizontal/vertical movement possibilities. */
	private boolean[] horizontalList, verticalList;
	
	/** The X/Y coordinates and X/Y speeds. */
	private int x, y, xSpeed, ySpeed;
	
	/** Boolean concerning whether the player is alive. */
	private boolean alive;
	
	/** The label for the player. */
	protected JLabel playerLabel;	//Not meant to be encapsulated
	/** PRIMARY DIRECTION: Where the player is facing */
	/** SECONDARY DIRECTION: Where the player wants to face next */
	
	/**
	 * Initializes the defaults.
	 */
	private void initDefaults() {
		pDir = "none";
		sDir = "none";
		score = 0;
		x = 252;
		y = 319;
		xSpeed = 0;
		ySpeed = 0;
		alive = true;
	}
	
	/**
	 * Instantiates a new player.
	 *
	 * @param iJLabel the incoming label argument
	 * @param iName the incoming name argument
	 */
	protected Player(JLabel iJLabel, String iName){
		initDefaults();	//initializes default values
		this.name = iName;
		playerLabel = iJLabel;
	}
	
	/**
	 * Move.
	 * 
	 * Defines a players move
	 */
	protected void move() {
		updateVerticalList();	//updates booleans for vertical and horizontal move availability lists
    	updateHorizontalList();
 		int i = -1;
 		if(sDir == "up" || sDir == "down") {	//Check secondary movement direction
 			do {	//repeat until a valid move is found
        		i += 1;
        		if(sDir == "up") {
        			ySpeed = -1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				pDir = "up";	//when a valid move is found, set it to primary move direction
        				sDir = "none";	//update the location once, and clear the secondary direction
        				y += ySpeed;
        			}
        		}
        		else if(sDir == "down") {
        			ySpeed = 1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				pDir = "down";	//when a valid move is found, set it to primary move direction
        				sDir = "none";	//update the location once, and clear the secondary direction
        				y += ySpeed;
        			}
        		}
        	}
        	while(verticalList[i] == false && i < verticalList.length-1);
 		}
 		else if(sDir == "left" || sDir == "right") {
 			do {	//repeat until a valid move is found
        		i += 1;
        		if(sDir == "left") {
        			xSpeed = -1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				pDir = "left";	//when a valid move is found, set it to primary move direction
        				sDir = "none";	//update the location once, and clear the secondary direction
        				x += xSpeed;
        			}
        		}
        		else if(sDir == "right") {
        			xSpeed = 1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				pDir = "right";	//when a valid move is found, set it to primary move direction
        				sDir = "none";	//update the location once, and clear the secondary direction
        				x += xSpeed;
        			}
        		}
        	}
        	while(horizontalList[i] == false && i < horizontalList.length-1);
 		}
 		
 		i = -1;
 		if(pDir == "up" || pDir == "down") {	//Check primary movement direction, after checking secondary movement direction
 			do {	//repeat until a valid move is found
        		i += 1;
        		if(pDir == "up") {
        			ySpeed = -1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				y += ySpeed;	
        			}
        		}
        		else if(pDir == "down") {
        			ySpeed = 1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				y += ySpeed;	//when a valid move is found, update Y location
        			}
        		}
        	}
        	while(verticalList[i] == false && i < verticalList.length-1);
 		}
 		else if(pDir == "left" || pDir == "right") {
 			do {	//repeat until a valid move is found
        		i += 1;
        		if(pDir == "left") {
        			xSpeed = -1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				x += xSpeed;	//when a valid move is found, update X location
        			}
        		}
        		else if(pDir == "right") {
        			xSpeed = 1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				x += xSpeed;	//when a valid move is found, update X location
        			}
        		}
        	}
        	while(horizontalList[i] == false && i < horizontalList.length-1);
 		}
 		if(x == 0 && y == 261) {	//If the player reaches a map loop, then update position accordingly
 			x = 502;
    	}
    	else if(x==503 && y == 261) {
    		x = 1;
    	}

        playerLabel.setLocation(x, y);	//update players label location
	}
	
	/**
	 * Go left.
	 * 
	 * Makes a left turn for the player.
	 */
	protected void goLeft() {
		if(sDir == "up") {	//Chooses a direction to face based off secondary direction
			sDir = "left";
		}
		else if(sDir == "down") {
			sDir = "right";
		}
		else if(sDir == "left") {
			sDir = "down";
		}
		else if(sDir == "right") {
			sDir = "up";
		}
		else {	//If the player has no secondary direction
			if(pDir == "up") {	//Chooses a direction to face based off primary direction
				sDir = "left";
			}
			else if(pDir == "down") {
				sDir = "right";
			}
			else if(pDir == "left") {
				sDir = "down";
			}
			else if(pDir == "right") {
				sDir = "up";
			}
			else {
				pDir = "left";
			}
		}
	}
	
	/**
	 * Go right.
	 * 
	 * Makes a right turn for the player.
	 */
	protected void goRight() {
		if(sDir == "up") {	//Chooses a direction to face based off secondary direction
			sDir = "right";
		}
		else if(sDir == "down") {
			sDir = "left";
		}
		else if(sDir == "left") {
			sDir = "up";
		}
		else if(sDir == "right") {
			sDir = "down";
		}
		else {	//If the player has no secondary direction
			if(pDir == "up") {	//Chooses a direction to face based off primary direction
				sDir = "right";
			}
			else if(pDir == "down") {
				sDir = "left";
			}
			else if(pDir == "left") {
				sDir = "up";
			}
			else if(pDir == "right") {
				sDir = "down";
			}
			else {
				pDir = "right";
			}
		}
	}
	
	/**
	 * Update horizontal list.
	 * 
	 * Boolean list of all possible routes the player is able to move horizontally.
	 */
	private void updateHorizontalList() {
    	horizontalList = new boolean[]{(x+xSpeed>=10 && x+xSpeed<=223 && y==10),
    								   (x+xSpeed>=281 && x+xSpeed<=493 && y==10),
    								   (x+xSpeed>=10 && x+xSpeed<=493 && y==87),
    								   (x+xSpeed>=10 && x+xSpeed<=106 && y==145),
    								   (x+xSpeed>=396 && x+xSpeed<=493 && y==145),
    								   (x+xSpeed>=165 && x+xSpeed<=223 && y==145),
    								   (x+xSpeed>=281 && x+xSpeed<=339 && y==145),
    								   (x+xSpeed>=165 && x+xSpeed<=339 && y==203),
    								   (x+xSpeed>=0 && x+xSpeed<=165 && y==261),
    								   (x+xSpeed>=339 && x+xSpeed<=503 && y==261),
    								   (x+xSpeed>=165 && x+xSpeed<=339 && y==319),
    								   (x+xSpeed>=10 && x+xSpeed<=223 && y==377),
    								   (x+xSpeed>=281 && x+xSpeed<=493 && y==377),
    								   (x+xSpeed>=10 && x+xSpeed<=47 && y==435),
    								   (x+xSpeed>=453 && x+xSpeed<=493 && y==435),
    								   (x+xSpeed>=106 && x+xSpeed<=396 && y==435),
    								   (x+xSpeed>=10 && x+xSpeed<=106 && y==493),
    								   (x+xSpeed>=396 && x+xSpeed<=493 && y==493),
    								   (x+xSpeed>=165 && x+xSpeed<=223 && y==493),
    								   (x+xSpeed>=281 && x+xSpeed<=339 && y==493),
    								   (x+xSpeed>=10 && x+xSpeed<=493 && y==550)};
    }
	
	/**
	 * Update vertical list.
	 * 
	 * Boolean list of all possible routes the player is able to move vertically.
	 */
	private void updateVerticalList() {
    	verticalList = new boolean[]{(y+ySpeed>=10 && y+ySpeed<=145 && x==10),
    								 (y+ySpeed>=377 && y+ySpeed<=435 && x==10),
    								 (y+ySpeed>=493 && y+ySpeed<=550 && x==10),
    								 (y+ySpeed>=435 && y+ySpeed<=493 && x==47),
    								 (y+ySpeed>=10 && y+ySpeed<=493 && x==106),
    								 (y+ySpeed>=87 && y+ySpeed<=145 && x==165),
    								 (y+ySpeed>=203 && y+ySpeed<=377 && x==165),
    								 (y+ySpeed>=435 && y+ySpeed<=493 && x==165),
    								 (y+ySpeed>=10 && y+ySpeed<=87 && x==223),
    								 (y+ySpeed>=145 && y+ySpeed<=203 && x==223),
    								 (y+ySpeed>=377 && y+ySpeed<=435 && x==223),
    								 (y+ySpeed>=493 && y+ySpeed<=550 && x==223),
    								 (y+ySpeed>=10 && y+ySpeed<=87 && x==281),
    								 (y+ySpeed>=145 && y+ySpeed<=203 && x==281),
    								 (y+ySpeed>=377 && y+ySpeed<=435 && x==281),
    								 (y+ySpeed>=493 && y+ySpeed<=550 && x==281),
    								 (y+ySpeed>=87 && y+ySpeed<=145 && x==339),
    								 (y+ySpeed>=203 && y+ySpeed<=377 && x==339),
    								 (y+ySpeed>=435 && y+ySpeed<=493 && x==339),
    								 (y+ySpeed>=10 && y+ySpeed<=493 && x==396),
    								 (y+ySpeed>=435 && y+ySpeed<=493 && x==453),
    								 (y+ySpeed>=10 && y+ySpeed<=145 && x==493),
    								 (y+ySpeed>=377 && y+ySpeed<=435 && x==493),
    								 (y+ySpeed>=493 && y+ySpeed<=550 && x==493)};
    }
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the x coordinate.
	 *
	 * @return the x
	 */
	protected int getX() {
		return x;
	}
	
	/**
	 * Gets the y coordinate.
	 *
	 * @return the y
	 */
	protected int getY() {
		return y;
	}
	
	/**
	 * Kills the player.
	 */
	protected void kill() {
		alive = false;
	}
	
	/**
	 * Checks if the player is alive.
	 *
	 * @return true, if player is alive
	 */
	protected boolean isAlive(){
		return alive;
	}
	
	/**
	 * Gets the secondary direction.
	 *
	 * @return the s dir
	 */
	protected String getSDir() {
		return sDir;
	}
	
	/**
	 * Gets the primary direction.
	 *
	 * @return the p dir
	 */
	protected String getPDir() {
		return pDir;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	protected int getScore() {
		return score;
	}
	
	/**
	 * Adds to the score.
	 *
	 * @param num the number added to the score
	 */
	protected void addScore(int num) {
		score += num;
	}
	
}
