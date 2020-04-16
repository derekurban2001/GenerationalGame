package pixelpartymenu;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import superclasses.PhidgetHandlerSuper;


/**
 * The Class PhidgetHandler.
 */
//PhidgetHandler is meant to handle the input from the user for the Menu
public class PhidgetHandler extends PhidgetHandlerSuper{
	
	/** The on chararacter panel boolean. */
	protected static boolean onCharPanel = false;
	
	/** The on pre game panel boolean. */
	protected static boolean onPreGamePanel = false;
	
	/** The player one position integer. */
	private int playerOnePos = 0;
	
	/** The player two position integer. */
	private int playerTwoPos = 0;
	
	/** The player three position integer. */
	private int playerThreePos = 0;
	
	/** The player four position integer. */
	private int playerFourPos = 0;
	
	/** The all ready boolean. */
	protected static boolean allReady = false;
	
	/** The player one ready boolean. */
	private static boolean playerOneReady = false;
	
	/** The player two ready boolean. */
	private static boolean playerTwoReady = false;
	
	/** The player three ready boolean. */
	private static boolean playerThreeReady = false;
	
	/** The player four ready boolean. */
	private static boolean playerFourReady = false;
	
	/**
	 * Instantiates a new phidget handler.
	 *
	 * @param contentPane the content pane of type JPanel
	 */
	PhidgetHandler(JPanel contentPane){
		super(contentPane);
	}
	
	/**
	 * Method which performs actions for player one.
	 */
	@Override
	//peforms actions for player one
	public void playerOneAction() {
		if(onCharPanel) {
			playerOnePos = nextPlayerColor("PLAYER1", playerOnePos, CharacterPanel.player1Icon);
		}
		if(onPreGamePanel) {
			if(playerOneReady) {
				playerOneReady = false;
				PreGamePanel.player1IconRC.setForeground(Color.RED);
			}
			else {
				playerOneReady = true;
				PreGamePanel.player1IconRC.setForeground(new Color(31, 122, 21));
			}
			checkAllReady();
		}
	}
	
	/**
	 * Method which performs actions for player two.
	 */
	//Overrides PhidgetHandlerSuper
	@Override
	//peforms actions for player two
	public void playerTwoAction() {
		if(onCharPanel) {
			playerTwoPos = nextPlayerColor("PLAYER2", playerTwoPos, CharacterPanel.player2Icon);
		}
		if(onPreGamePanel) {
			if(playerTwoReady) {
				playerTwoReady = false;
				PreGamePanel.player2IconRC.setForeground(Color.RED);
			}
			else {
				playerTwoReady = true;
				PreGamePanel.player2IconRC.setForeground(new Color(31, 122, 21));
			}
			checkAllReady();
		}
	}

	/**
	 * Method which performs actions for player three.
	 */
	//Overrides PhidgetHandlerSuper
	@Override
	//peforms actions for player three
	public void playerThreeAction() {
		if(onCharPanel) {
			playerThreePos = nextPlayerColor("PLAYER3", playerThreePos, CharacterPanel.player3Icon);
		}
		if(onPreGamePanel) {
			if(playerThreeReady) {
				playerThreeReady = false;
				PreGamePanel.player3IconRC.setForeground(Color.RED);
			}
			else {
				playerThreeReady = true;
				PreGamePanel.player3IconRC.setForeground(new Color(31, 122, 21));
			}
			checkAllReady();
		}
	}

	/**
	 * Method which performs actions for player four.
	 */
	//Overrides PhidgetHandlerSuper
	@Override
	//peforms actions for player four
	public void playerFourAction() {
		if(onCharPanel) {
			playerFourPos = nextPlayerColor("PLAYER4", playerFourPos, CharacterPanel.player4Icon);
		}
		if(onPreGamePanel) {
			if(playerFourReady) {
				playerFourReady = false;
				PreGamePanel.player4IconRC.setForeground(Color.RED);
			}
			else {
				playerFourReady = true;
				PreGamePanel.player4IconRC.setForeground(new Color(31, 122, 21));
			}
			checkAllReady();
		}
	}
	
	/**
	 * Check all ready method.
	 */
	private static void checkAllReady() {
		allReady = playerOneReady && playerTwoReady && playerThreeReady && playerFourReady;
	}
	
	/**
	 * Reset readiness method.
	 */
	protected static void resetReadiness() {
		playerOneReady = false;
		PreGamePanel.player1IconRC.setForeground(Color.RED);
		playerTwoReady = false;
		PreGamePanel.player2IconRC.setForeground(Color.RED);
		playerThreeReady = false;
		PreGamePanel.player3IconRC.setForeground(Color.RED);
		playerFourReady = false;
		PreGamePanel.player4IconRC.setForeground(Color.RED);
		checkAllReady();
	}

	
	/**
	 * Next player color method to choose next available slot that a player can pick for a color.
	 *
	 * @param playerName the player name
	 * @param currentPos the current position of the player
	 * @param playerIcon the player's icon
	 * @return the current position integer
	 */
	//Chooses the next availiable slot that a player can pick for a color
	private int nextPlayerColor(String playerName, int currentPos, JLabel playerIcon) {
		//If the position is over the limited amount, reset it
		if(currentPos>11) {
			currentPos = 0;
		}
		
		//calculate the row and column from a position between 0-11
		int row = currentPos/4;
		int column = currentPos-(row*4);
		
		//Split the current slot section into its occupancy and color
		String playerSlot = CharacterPanel.colorTable[row][column].split(";")[0];
		String colorSlot = CharacterPanel.colorTable[row][column].split(";")[1];
		
		//if the slot is unoccupied
		if(playerSlot.equals("EMPTY")) {
			//Make the slot occupied
			CharacterPanel.colorTable[row][column] = playerName+";"+colorSlot;
			//set the location of the icon to the new occupied space
			playerIcon.setLocation(90+(column*140), 100+(row*140));
		}
		//if the slot is occupied
		else {
			//recursively call for the next position over
			currentPos = nextPlayerColor(playerName, currentPos+1, playerIcon);
			//when that spot is found, reset the original space
			if(playerSlot.equals(playerName)) {
				CharacterPanel.colorTable[row][column] = "EMPTY;"+colorSlot;
			}
		}
		
		//return and update the players position on the table
		return currentPos;
	}

}
