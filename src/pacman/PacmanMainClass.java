package pacman;

import superclasses.GameSuper;
import javax.swing.JLayeredPane;

/**
 * The Class PacmanMainClass.
 * 
 * This class is the main entry point for Pacman.
 * It extends GameSuper and defines how the game starts, runs and finishes.
 * 
 * @author Derek Urban
 */
public class PacmanMainClass extends GameSuper{
	
	/**
	 * Instantiates a new PacmanMainClass.
	 */
	public PacmanMainClass() {
		super("Pacman");
	}
	
	/** The main panel for the menu. */
	private JLayeredPane mainPanel;
	
	/** The panel for the game. */
	private JLayeredPane panel;
	
	/** Boolean concerning whether the game is active (running). */
	protected static boolean active = false;
	
	/**
	 * Checks if the game is active.
	 *
	 * @return true, if the game is active
	 */
	@Override
	public boolean isActive() {
		return active;
	}
	
	/**
	 * End.
	 * Controls what to do to end the game.
	 */
	@Override
	public void End() {
		active = false;
		panel.setVisible(false);
		panel.setEnabled(false);
		mainPanel.remove(panel);
		panel = null;
	}
	
	/**
	 * Start.
	 * Controls what to do to start the game.
	 *
	 * @param iMainPanel the i main panel
	 */
	@Override
	public void Start(JLayeredPane iMainPanel) {
		mainPanel = iMainPanel;
		active = true;
		try {
			new GUI();	//Develops the Graphical User Interface elements
			panel = GUI.panel;
			panel.setVisible(true);
			panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));	//Sets location to center
			mainPanel.add(panel, 0);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the raw scores.
	 *
	 * @return the raw scores
	 */
	@Override
	public int[] getRawScores() {
		return GameClock.getScores();
	}
}

