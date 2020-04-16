package superclasses;

import javax.swing.JLayeredPane;


/**
 * The Class GameSuper.
 */
public abstract class GameSuper {
	
	/** The String name. */
	private String name;
	
	/**
	 * Instantiates a new game super.
	 *
	 * @param iName the name
	 */
	public GameSuper(String iName){
		name = iName;
	}
	
	/**
	 * Abstract method checks if game is active.
	 *
	 * @return true, if is active
	 */
	public abstract boolean isActive();
	
	/**
	 * End method.
	 */
	public abstract void End();
	
	/**
	 * Start method.
	 *
	 * @param mainFrame the main frame
	 */
	public abstract void Start(JLayeredPane mainFrame);
	
	/**
	 * Gets the raw scores.
	 *
	 * @return the raw scores
	 */
	public abstract int[] getRawScores();
	
	/**
	 * Gets the parsed scores.
	 *
	 * @return the parsed scores
	 */
	public int[] getParsedScores() {
		if(getRawScores().length != 4) {
			System.out.println("Invalid Raw Scores (List not of length 4!)");
			return null;
		}
		int[] rawScores = getRawScores();
		int[] parsedScores = {-1, -1, -1, -1};
		for(int i = 0; i < rawScores.length; i++) {
			int points = 1;
			for(int num2 : rawScores) {
				if(rawScores[i] > num2) {
					points++;
				}
			}
			parsedScores[i] = points;
		}
		return parsedScores;
	}
	
	/**
	 * To string method to return the name.
	 *
	 * @return the string
	 */
	public String toString() {
		return name;
	}
}
