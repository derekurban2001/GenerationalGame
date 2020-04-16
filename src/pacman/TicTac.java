package pacman;

import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The Class TicTac.
 * 
 * This class defines a game object called "TicTac".
 * These are the little white dots/points the player sees on the map,
 * and can eat in order to obtain more points.
 * 
 * @author Derek Urban
 */
public class TicTac extends Object{
	
	/** The label of the TicTac. */
	private JLabel label;
	
	/** The x coordinate. */
	private int x = 0;
	
	/** The y coordinate. */
	private int y = 0;
	
	/**
	 * Instantiates a new TicTac.
	 *
	 * @param iX the incoming X coordinate argument.
	 * @param iY the incoming Y coordinate argument.
	 */
	protected TicTac(int iX, int iY) {
		x = iX;
		y = iY;
		createTicTacLabel();	//creates the label for the TicTac
		ObjectMovementHandler.ticTacList.add(this);	//Adds the TicTac to a master list
	}
	
	/**
	 * Creates the label for the TicTac.
	 */
	private void createTicTacLabel(){
		label = new JLabel("");
		label.setBounds(x, y, 36, 36);
		label.setForeground(Color.white);
		try {
			label.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/Pacman/TicTac.png"))));
		}
		catch(Exception ex) {ex.printStackTrace();}
		GUI.panel.add(label, 10);	//Adds the label to the panel of the GUI
	}
	
	/**
	 * An action that is performed when the TicTac has been "eaten".
	 */
	protected void eat() {	
		label.setVisible(false);	
		label.setEnabled(false);
		GUI.panel.remove(label);	//Removes the object from the panel
	}
	
	/**
	 * Gets the x coordinate of the TicTac.
	 *
	 * @return the x
	 */
	protected int getX() {
		if(label != null) {
			return label.getX();
		}
		else {
			return x;
		}
	}
	
	/**
	 * Gets the y coordinate of the TicTac.
	 *
	 * @return the y
	 */
	protected int getY() {
		if(label != null) {
			return label.getY();
		}
		else {
			return y;
		}
	}
	
	/**
	 * Checks if the TicTac has any close neighbours.
	 *
	 * @param x the x
	 * @param y the y
	 * @return true, if it is alone
	 */
	protected static boolean isAlone(int x, int y) {
		for(TicTac tac : ObjectMovementHandler.ticTacList) {	//Cycle through each TicTac
			if((x >= tac.getX()-36 && x <= tac.getX() + 36) && (y >= tac.getY()-36 && y <= tac.getY() + 36))
				return false;	//If a TicTac is nearby, then return false
		}
		return true;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "TicTac at: x="+getX()+", y="+getY();
	}
}
