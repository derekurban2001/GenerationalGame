package frogger;

import superclasses.PhidgetHandlerSuper;
import javax.swing.JPanel;


//Handles Phidget Handler movement for players
/**
 * The Class PhidgetHandler.
 */
//connects the GUI movement to the Phidget Handler Super keys 
public class PhidgetHandler extends PhidgetHandlerSuper{
	/** The player 1 label. */
	private Player player1;
	
	/** The player 2 label. */
	private Player player2;
	
	/** The player 3 label. */
	private Player player3;
	
	/** The player 4 label. */
	private Player player4;
	
	/**
	 * Instantiates a new phidget handler.
	 *
	 * @param playerList the player list
	 * @param panel the panel
	 */
	
	//gets players and adds movement using keys
	PhidgetHandler(Player[] playerList, JPanel panel){
		super(panel);
		
		//assing player 1 in playerlist
		player1 = playerList[0];
		
		//assing player 2 in playerlist
		player2 = playerList[1];
		
		//assing player 3 in playerlist
		player3 = playerList[2];
		
		//assing player 4 in playerlist
		player4 = playerList[3];
		
	}

	
	/**
	 * Player one action.
	 */
	
	//movement for player 1 using keys and GUI
	public void playerOneAction() {
		
		//if the player is not finished add in animation and score by 10
        if(!player1.isFinished) {
        	AnimationHandler.player1Jump();
            player1.addScore(10);
        }
    }

	
	
	/**
	 * Player two action.
	 */
	//movement for player 2 using keys and GUI
	@Override
	public void playerTwoAction() {
		
		//if the player is not finished add in animation and score by 10
        if(!player2.isFinished) {
        	AnimationHandler.player2Jump();
            player2.addScore(10);
        }
    }

	/**
	 * Player three action.
	 */
	
	//movement for player 3 using keys and GUI
	public void playerThreeAction() {
		
		//if the player is not finished add in animation and score by 10
        if(!player3.isFinished) {
        	AnimationHandler.player3Jump();
            player3.addScore(10);
        }
    }

	
	/**
	 * Player four action.
	 */
	
	//movement for player 4 using keys and GUI
	public void playerFourAction() {
		
		//if the player is not finished add in animation and score by 10
        if(!player4.isFinished) {
        	AnimationHandler.player4Jump();
            player4.addScore(10);
        }
    }
}
