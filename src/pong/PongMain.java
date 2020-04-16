package pong;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import superclasses.GameSuper;


// Main Class for Pong

/**
 * The Class PongMain.
 */
public class PongMain extends GameSuper{
	
	/**
	 * Instantiates a new pong main.
	 *
	 * @param iName the i name
	 */
	public PongMain(String iName) {
		super("Pong");
	}
	
	/** The game. */
	private Game game;
	
	/** The panel. */
	private JPanel panel;
	
	/** The main panel. */
	private JLayeredPane mainPanel;
	
	/**
	 * The method to check if game is active.
	 *
	 * @return true, if is active
	 */

	@Override
	public boolean isActive() {
		if(Game.running) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * The game end method.
	 */
	@Override
	public void End() {
		Game.running = false;
		panel.setVisible(false);
		panel.setEnabled(false);
		mainPanel.remove(panel);
		panel = null;
		game = null;
	}
	
	/**
	 * The Start method.
	 *
	 * @param mainFrame the main frame
	 */
	@Override
	public void Start(JLayeredPane mainFrame) {
		game = new Game();
		mainPanel = mainFrame;
		panel = Window.panel;
		panel.setVisible(true);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));	//Sets location to center
		mainFrame.add(panel, 0);
	}

	/**
	 * Gets the raw scores.
	 *
	 * @return the raw scores
	 */
	@Override
	public int[] getRawScores() {
		return game.getPaddleScore();
	}
	
}
