package pacman;

import superclasses.PhidgetHandlerSuper;

/**
 * The Class PhidgetHandler.
 * 
 * This class handles all the user input for Pacman.
 * It originally was synced up to an external game controller, but due to
 * social distancing and restrictions it has been modified to respond to
 * keyboard input.
 * 
 * This class is also extends PhidgetHandlerSuper, which is the parent
 * class to all user-input systems for the entire project.
 * 
 * @author Derek Urban
 */
public class PhidgetHandler extends PhidgetHandlerSuper{
    
    /** Players 1/2. */
    private Player player1, player2;
    
	/**
	 * Instantiates a new PhidgetHandler.
	 *
	 * @param player1
	 * @param player2
	 */
	protected PhidgetHandler(Player player1, Player player2){
		super(GUI.panel);
		this.player1 = player1;
		this.player2 = player2;
    }
	
	/**
	 * Player 1's action.
	 */
	@Override
	public void playerOneAction() {
		player1.goLeft();	//Player 1 will make the team object go left
	}

	/**
	 * Player 2's action.
	 */
	@Override
	public void playerTwoAction() {
		player1.goRight();	//Player 2 will make the team object go right
	}

	/**
	 * Player 3's action.
	 */
	@Override
	public void playerThreeAction() {
		player2.goLeft();	//Player 3 will make the team object go left
	}

	/**
	 * Player 4's action.
	 */
	@Override
	public void playerFourAction() {
		player2.goRight();	//Player 4 will make the team object go right
	}
}
