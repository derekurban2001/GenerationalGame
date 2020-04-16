package frogger;

import superclasses.GameSuper;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


/**
 * The Class CrossyRoadMainClass.
 */
//THIS CLASS IS A MAIN CLASS THAT THE GAME CAN BE RUN FROM TO MAKE IT EASIER TO BUNDLE ALL 3 GAMES TOGETHER
public class CrossyRoadMainClass extends GameSuper{
	
	/** The active. */
	protected static boolean active;
	
	/** The gui. */
	private static GUI gui;
	
	/** The panel. */
	private JPanel panel;
	
	/** The main panel. */
	private JLayeredPane mainPanel;
	
	/**
	 * Instantiates a new crossy road main class.
	 */
	public CrossyRoadMainClass(){
		super("Frogger");
	}
	
	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/**
	 * End.
	 */
	@Override
	public void End() {
		active = false;
		panel.setVisible(false);
		panel.setEnabled(false);
		mainPanel.remove(panel);
		panel = null;
		gui = null;
	}

	/**
	 * Start.
	 *
	 * @param mainFrame the main frame
	 */
	@Override
	public void Start(JLayeredPane mainFrame) {
		active = true;
		try {
			mainPanel = mainFrame;
			gui = new GUI();
			panel = GUI.contentPane;
			panel.setVisible(true);
			panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));	//Sets location to center
			mainPanel.add(panel, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the raw scores.
	 *
	 * @return the raw scores
	 */
	@Override
	public int[] getRawScores(){
		return gui.getScore();
	}
}

