package pacman;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * The Class ObjectMovementHandler.
 * 
 * This class handles all the object movements for Pacman.
 * 
 * @author Derek Urban
 */
public class ObjectMovementHandler extends GameClock{
	
	/** The list of all TicTacs. */
	protected static ArrayList<TicTac> ticTacList;	//Not meant to be encapsulated
	
	/** The Handler Thread. */
	private Thread Handler;
	
	/** The player list. */
	private Player playerList[];
	
	/** The ghost list. */
	private AI ghostList[];
	
	/** The player 1/2 score displays. */
	private JLabel player1ScoreDisplay, player2ScoreDisplay;
	
	/**
	 * Initializes the default values.
	 */
	private void initDefaults() {
		Handler = new Thread(new handler(), "Hitbox Checker");	//Starts a new thread
	}
	
	/**
	 * Instantiates a new object movement handler.
	 *
	 * @param iPlayerList the incoming player list argument.
	 * @param iGhostList the incoming ghost list argument.
	 * @param jClock the incoming clock argument.
	 * @param iPlayer1ScoreDisplay the incoming player 1 score display argument.
	 * @param iPlayer2ScoreDisplay the incoming player 2 score display argument.
	 */
	protected ObjectMovementHandler(Player[] iPlayerList, AI[] iGhostList, JLabel jClock, JLabel iPlayer1ScoreDisplay, JLabel iPlayer2ScoreDisplay){
		super(jClock, iPlayerList, iGhostList);
		initDefaults();
		ticTacList = new ArrayList<TicTac>();
		player1ScoreDisplay = iPlayer1ScoreDisplay;
		player2ScoreDisplay = iPlayer2ScoreDisplay;
		playerList = iPlayerList;
		ghostList = iGhostList;
		Handler.start();	//Starts the new thread
	}
	
	/**
	 * The Class handler.
	 * 
	 * Handles the thread and its runnable.
	 */
	private class handler implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			while(PacmanMainClass.active) {
				try {
					Thread.sleep(15-getDifficulty());	//Sets object update interval smaller as time progresses (objects get faster).
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				updateScores();	//update the scores for each player
				
				for(Player player:playerList) {	//Move each player if the player is alive
					if(player.isAlive())
						player.move();
				}
				
				for(AI ghost:ghostList) {	//Move each ghost
					ghost.move();
				}
				
				for(Player player:playerList) {	
					for(AI ghost:ghostList) {	//if any player overlaps with any ghost, kill the player
						if(checkOverlap(player, ghost, 25)){
							player.kill();
						}
					}
					for(int i = 0; i < ticTacList.size(); i++) {	//if any player overlaps with any TicTac, eat the TicTac
						if(checkOverlap(player, ticTacList.get(i), 10)) {
							TicTac tac = ticTacList.get(i);
							tac.eat();
							tac = null;
							ticTacList.remove(i);
							player.addScore(100);	//Give the player points for eating the TicTac
						}
					}
				}
			}
		}
	}
	
	/**
	 * Check overlap.
	 *
	 * @param player the player
	 * @param object the object
	 * @param overlapWidth the overlap width
	 * @return true, if successful
	 */
	//Checks overlap between a player and a ghost
	private boolean checkOverlap(Player player, Object object, int overlapWidth) {
		int playerX = player.getX()+5, playerY = player.getY()+5;
		int objX = object.getX()+5, objY = object.getY()+5;
		int width = overlapWidth;	//The acceptable amount of overlap in which nothing is done
		
		if((playerX >= objX && playerX <= objX+width) && (playerY >= objY && playerY <= objY+width) ) {	//if the player is within the objects X value, return true
			return true;
		}
		else if((playerX+width >= objX && playerX+width <= objX+width) && (playerY+width >= objY && playerY+width <= objY+width) ) {	//if the player is within the objects Y value, return true
			return true;
		}
		
		return false;	//otherwise return false
	}
	
	/**
	 * Update scores.
	 */
	private void updateScores() {
		String temp1 = "00000"+playerList[0].getScore();
		String temp2 = "00000"+playerList[1].getScore();
		String p1Score = temp1.substring(temp1.length()-5);
		String p2Score = temp2.substring(temp2.length()-5);
		player1ScoreDisplay.setText(p1Score);
		player2ScoreDisplay.setText(p2Score);
	}
}
