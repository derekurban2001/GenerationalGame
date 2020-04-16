package pixelpartymenu;

import superclasses.GameSuper;
import superclasses.PlayerSuper;
import javax.swing.JLayeredPane;
import pacman.PacmanMainClass;
import pong.PongMain;
import frogger.CrossyRoadMainClass;


/**
 * The Class GameHandler.
 */
public class GameHandler {
	
	/** The game running boolean. */
	protected static boolean gameRunning = false;
	
	/** The game pause boolean. */
	private static boolean gamePause = false;
	
	/** The Handler. */
	private Thread Handler;
	
	/** The game order array. */
	private String[] gameOrderArray;
	
	/** The panel. */
	private JLayeredPane panel;
	
	/** The index. */
	protected static int index = -1;
	
	/**
	 * Initializes the defaults.
	 */
	private void initDefaults() {
		Handler = new Thread(new handler());
	}
	
	/**
	 * Instantiates a new game handler.
	 *
	 * @param iGameOrderArray the randomized game order array
	 * @param iPanel the game panel
	 */
	protected GameHandler(String[] iGameOrderArray, JLayeredPane iPanel){
		initDefaults();
		panel = iPanel;
		gameOrderArray = iGameOrderArray;
		Handler.start();
	}
	
	/**
	 * The Class handler.
	 */
	private class handler implements Runnable{
		
		/**
		 * Run the game.
		 */
		@Override
		public void run() {
			gameRunning = true;
			for(int i = 0; i < gameOrderArray.length; i++) {
				index = i;
				if(gameOrderArray[i].equals("Frogger"))
					playFrogger();
				
				if(gameOrderArray[i].equals("Pacman"))
					playPacman();
				
				if(gameOrderArray[i].equals("Pong"))
					playPong();
				
				if(i == 0 || i == 1) {
					GamePanel.goBack();
					pauseGame();
				}
			}

			gameRunning = false;
			GamePanel.goBack();
		}
	}
	
	/**
	 * Play next game.
	 */
	protected static void playNextGame() {
		gamePause = false;
	}
	
	/**
	 * Play frogger.
	 */
	private void playFrogger() {
		GameSuper frogger = new CrossyRoadMainClass();
		frogger.Start(panel);
		
		while(frogger.isActive()) {
			try {
				Thread.sleep(100);
			}
			catch(Exception ex) {ex.printStackTrace();}
		}
		
		PlayerSuper.updateScores(frogger.getParsedScores());
		
		frogger.End();
		PreGamePanel.gameDone("Frogger");
	}

	/**
	 * Pause game.
	 */
	private void pauseGame(){
		gamePause = true;
		while(gamePause) {
			try {
				Thread.sleep(100);
			}
			catch(Exception ex) {ex.printStackTrace();}
		}
	}
	
	/**
	 * Play pacman.
	 */
	private void playPacman() {
		GameSuper pacman = new PacmanMainClass();
		pacman.Start(panel);
		
		while(pacman.isActive()) {
			try {
				Thread.sleep(100);
			}
			catch(Exception ex) {ex.printStackTrace();}
		}
		
		PlayerSuper.updateScores(pacman.getParsedScores());
		
		pacman.End();
		PreGamePanel.gameDone("Pacman");
	}

	/**
	 * Play pong.
	 */
	private void playPong() {
		GameSuper pong = new PongMain("Pong");
		pong.Start(panel);
		
		while(pong.isActive()) {
			try {
				Thread.sleep(100);
			}
			catch(Exception ex) {ex.printStackTrace();}
		}
		
		PlayerSuper.updateScores(pong.getParsedScores());
		
		pong.End();
		PreGamePanel.gameDone("Pong");
	}
}
