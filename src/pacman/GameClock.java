package pacman;

import javax.swing.JLabel;

/**
 * The Class GameClock.
 * 
 * This class handles the clocking elements of the game, essentially any
 * element of the game that responds to a one second time interval.
 * This class also handles and determines when the game is over, and what
 * actions should be performed when that happens.
 * 
 * @author Derek Urban
 */
public class GameClock {
	
	/** The Difficulty Scaler thread. */
	private static Thread DifficultyScaler;
	
	/** The difficulty value and end count value. */
	private static int difficulty, endCount;
	
	/** The clock label. */
	private static JLabel jClock;
	
	/** The player list. */
	private static Player[] playerList;
	
	/** The ghost list. */
	private static AI[] ghostList;
	
	/** Players 1/2. */
	private static Player player1, player2;
	
	/** Boolean as to whether the game has ended. */
	private static boolean gameOver;
	
	/**
	 * Initializes the default values.
	 */
	private void initDefaults() {
		DifficultyScaler = new Thread(new difficultyScaler(), "Hitbox Checker");
		difficulty = 1;
		endCount = 3;
		gameOver = false;
	}
	
	/**
	 * Instantiates a new game clock.
	 *
	 * @param iClock the incoming clock argument
	 * @param iPlayerList the incoming player list argument
	 * @param iGhostList the incoming ghost list argument
	 */
	protected GameClock(JLabel iClock, Player[] iPlayerList, AI[] iGhostList){
		initDefaults();
		playerList = iPlayerList;
		ghostList = iGhostList;
		player1 = playerList[0];
		player2 = playerList[1];
		jClock = iClock;
		DifficultyScaler.start();	//Starts the thread
	}
	
	/**
	 * The Difficulty Scaler thread class that implements a runnable.
	 */
	private static class difficultyScaler implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			int count = 0;
			while(PacmanMainClass.active) {
				try {	//Pause for one second
					Thread.sleep(1000);
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				if(count<90 && (playerList[0].isAlive() || playerList[1].isAlive())) {	//If the count is under 90 (didn't run out of time) and atleast one player is alive
					count+=1;	//then update the clock and slowly increase difficulty
					jClock.setText("Timer: "+count);
					if(count%8 == 0) {
						if(difficulty+1 < 15) {
							difficulty += 1;
						}
					}
					if(count % 3 == 0) {
						for(AI ghost : ghostList) {
							ghost.dropTicTac(ghost.getX(), ghost.getY());
						}
						if(player1.isAlive())	//update the scores for all alive players
							player1.addScore(50);
						if(player2.isAlive())
							player2.addScore(50);
					}
				}
				else if (!gameOver){	//If the game has ended
					
					jClock.setText("");	//hide the clock and exponentially decrease difficulty (i.e. slow things down fast!)
					difficulty -= endCount;
					if(difficulty < -200) {
						gameOver = true;	//when objects have practically stopped, end the game
					}
					endCount *= 2;
				}
			}
		}
	}
	
	/**
	 * Gets the difficulty.
	 *
	 * @return the difficulty
	 */
	protected static int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * Gets the scores.
	 *
	 * @return the scores
	 */
	protected static int[] getScores() {
		return new int[]{player1.getScore(), player1.getScore(), player2.getScore(), player2.getScore()};
	}
	
	/**
	 * Checks if the game is over.
	 *
	 * @return true, if the game is over
	 */
	protected static boolean isGameOver() {
		return gameOver;
	}
}

