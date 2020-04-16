package pacman;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The Class AI.
 * 
 * This class defines that ghosts (AI) for the game, it handles
 * things like their movement, and when they drop the TicTacs for the player
 * 
 * @author Derek Urban
 */
public class AI extends Object{
	
	/** The secondary direction. */
	private String pDir, sDir;
	
	/** The name. */
	private String  name;
	
	/** The horizontal/vertical list of possible movements. */
	private boolean[] horizontalList, verticalList;
	
	/** The X/Y and old X/old Y locations and X/Y speeds. */
	private int x, y, oldX, oldY, xSpeed, ySpeed;
	
	/** The ghost label. */
	protected JLabel ghostLabel;	//Not meant to be encapsulated
	
	/** The player list. */
	private Player[] playerList;
	/** PRIMARY DIRECTION: Where the AI is facing */
	/** SECONDARY DIRECTION: Where the AI wants to face next */
	
	/**
	 * Initializes the default values.
	 */
	private void initDefaults() {
		pDir = "up";
		sDir = "up";
		x = 252;
		y = 260;
		oldX = -1;
		oldY = -1;
		xSpeed = 0;
		ySpeed = 0;
	}
	
	/**
	 * Instantiates a new AI.
	 *
	 * @param iJLabel the incoming label argument
	 * @param imageFilePath the image file path
	 * @param iName the incoming name argument
	 * @param iPlayerList the incoming player list argument
	 */
	protected AI(JLabel iJLabel, String imageFilePath, String iName, Player[] iPlayerList){
		initDefaults();
		
		playerList = iPlayerList;
		name = iName;
		ghostLabel = iJLabel;
		try {
			ghostLabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/"+imageFilePath))));
		} 
		catch (Exception ex) {ex.printStackTrace();}
	}
	
	/**
	 * Performs a move for the ghost
	 */
	protected void move() {
		updateVerticalList();	//updates booleans for vertical and horizontal move availability lists
    	updateHorizontalList();
    	
 		int i = -1;
 		if(sDir == "up" || sDir == "down") {	//Checks the secondary direction of the AI
 			do {
        		i += 1;
        		if(sDir == "up") {
        			ySpeed = -1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				pDir = "up";	//Updates the primary direction and picks a new secondary direction
        				pickMovement("down");
        				y += ySpeed;
        			}
        		}
        		else if(sDir == "down" && x != 252) {
        			ySpeed = 1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				pDir = "down";	//Updates the primary direction and picks a new secondary direction
        				pickMovement("up");
        				y += ySpeed;
        			}
        		}                		
        	}
        	while(verticalList[i] == false && i < verticalList.length-1);
 		}
 		else if(sDir == "left" || sDir == "right") {
 			do {
        		i += 1;
        		if(sDir == "left") {
        			xSpeed = -1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				pDir = "left";	//Updates the primary direction and picks a new secondary direction
        				pickMovement("right");
        				x += xSpeed;
        			}
        		}
        		else if(sDir == "right") {
        			xSpeed = 1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				pDir = "right";	//Updates the primary direction and picks a new secondary direction
        				pickMovement("left");
        				x += xSpeed;
        			}
        		}
        	}
        	while(horizontalList[i] == false && i < horizontalList.length-1);
 		}
 		i = -1;
 		if(pDir == "up" || pDir == "down") {	//Checks the primary direction of the AI
 			do {
        		i += 1;
        		if(pDir == "up") {
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				y += ySpeed;
        			}
        		}
        		else if(pDir == "down" && x != 252) {
        			ySpeed = 1;
        			updateVerticalList();	//updates booleans for vertical move availability lists
        			if(verticalList[i]) {
        				y += ySpeed;
        			}
        		}
        	}
        	while(verticalList[i] == false && i < verticalList.length-1);
 		}
 		else if(pDir == "left" || pDir == "right") {
 			do {
        		i += 1;
        		if(pDir == "left") {
        			xSpeed = -1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				x += xSpeed;
        			}
        		}
        		else if(pDir == "right") {
        			xSpeed = 1;
        			updateHorizontalList();	//updates booleans for horizontal move availability lists
        			if(horizontalList[i]) {
        				x += xSpeed;
        			}
        		}
        	}
        	while(horizontalList[i] == false && i < horizontalList.length-1);
 		}
 		
 		if(oldX == x && (pDir == "left" || pDir == "right")) {	//If the AI becomes stuck on anything horizontally
			if(sDir == "up") {	//then choose a new horizontal direction
				sDir = "down";
			}
			else if(sDir == "down") {
				sDir = "up";
			}
			else {
				int random = (int)(Math.random()*100)+1;
				if(random < 50)
					sDir = "up";
				if(random >= 50)
					sDir = "down";
			}
		}
 		else if(oldY == y && (pDir == "down" || pDir == "up")) {	//If the AI becomes stuck on anything vertically
			if(sDir == "left") {	//then choose a vertical direction
				sDir = "right";
			}
			else if(sDir == "right") {
				sDir = "left";
			}
			else {
				int random = (int)(Math.random()*100)+1;
				if(random < 50)
					sDir = "right";
				if(random >= 50)
					sDir = "left";
			}
		}
 		
 		if(x == 0 && y == 261) {	//if the AI moves towards a map loop, update location accordingly
 			x = 502;
    	}
    	else if(x==503 && y == 261) {
    		x = 1;
    	}
 		
 		oldX = x;	//update the old X,Y location of the AI, and the new X/Y location
 		oldY = y;
        ghostLabel.setLocation(x, y);	
	}
	
	/**
	 * Pick the movement for the AI.
	 *
	 * @param iDir the incoming direction argument
	 */
	private void pickMovement(String iDir) {
		int random = (int)(Math.random()*100)+1;	//Picks a random value between 1-100
		
		if(random < 90-(GameClock.getDifficulty()*6)) {	//Make a random move if less than 90% (this percentage decreases as the game progresses)
			randomMove(iDir);
		}
		else {	//otherwise make a calculated move
			calculatedMove();
		}
	}
	
	/**
	 * Make a random move.
	 *
	 * @param iDir the incoming direction argument
	 */

	private void randomMove(String iDir) {
		String tempDir = "";
		do {	//Pick a random, yet valid move
			int random = (int)(Math.random()*100)+1;
			if(random< 25)
				tempDir = "up";
			if(random >= 25 && random < 50)
				tempDir = "left";
			if(random >= 50 && random < 75)
				tempDir = "down";
			if(random >= 75)
				tempDir = "right";
		}
		while(tempDir.equals(iDir));
		sDir = tempDir;
	}
	
	/**
	 * Drop a TicTac.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	protected void dropTicTac(int x, int y) {
		if(TicTac.isAlone(x, y))	//If it is a valid location to drop a TicTac, then drop a TicTac
			new TicTac(x, y);
	}
	
	/**
	 * Make a Calculated move.
	 */
	private void calculatedMove() {
		int random;
		if(!playerList[0].isAlive()) {	//chooses randomly between any alive players
			random = 1;
		}
		else if(!playerList[1].isAlive()) {
			random = 0;
		}
		else {
			random = (int)(Math.random()*2);
		}
		
		int playerX = playerList[random].getX();	//selects the X,Y location of the target
		int playerY = playerList[random].getY();

		if(playerX < x) {	//Moves horizontally towards the player
			if(pDir == "up" || pDir == "down")
				sDir = "left";
		}
		else if(playerX > x){
			if(pDir == "up" || pDir == "down")
				sDir = "right";
		}
		else {
			sDir = "none";
		}
		
		if(playerY < y) {	//Moves vertically towards the player
			if(pDir == "right" || pDir == "left")
				sDir = "up";
		}
		else if(playerY > y){
			if(pDir == "right" || pDir == "left")
				sDir = "down";
		}
		else {
			sDir = "none";
		}
	}
	
	/**
	 * Update horizontal list.
	 * 
	 * Boolean list of all possible routes the player is able to move horizontally
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
	 * Boolean list of all possible routes the player is able to move vertically
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
    								 (y+ySpeed>=203 && y+ySpeed<=260 && x==252),
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
}
