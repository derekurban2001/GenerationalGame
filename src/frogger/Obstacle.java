package frogger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * The Class Obstacle.
 */
//THIS CLASS IS A TEMPLATE FOR ANY OBSTACLES THAT THE PLAYERS MIGHT ENCOUNTER
public class Obstacle {
	
	//instance variables
	
	/** The bus. */
	private JLabel bus;
	
	private int busSpeed;
	
	private final String ImageList[] = {"Sprite-0001","Sprite-0002","Sprite-0003","Sprite-0004","Sprite-0005", "Sprite-0006", "Sprite-0007" };

	
	/**
	 * Instantiates a new obstacle.
	 *
	 * @param b the Bus JLabel
	 */
	//constructor to give associate a bus with a JLabel
	public Obstacle(JLabel b, int bS) {
		busSpeed = bS;
		bus = b;
		setImage();
	}

	/**
	 * Gets the x coordinate
	 *
	 * @return the c coordinate
	 */
	//getters for x,y width, and height
	public int getX() {
		return bus.getX();
	}
	
	/**
	 * Gets the y coordinate
	 *
	 * @return the y coordinate
	 */
	public int getY() {
		return bus.getY();
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return bus.getWidth();
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return bus.getHeight();
	}
	
	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public JLabel getLabel() {
		return bus;
	}
	
	public void reset() {
		
		if(busSpeed > 0) {
			resetLeft();
		}
			
		if(busSpeed < 0) {
			resetRight();
		}
	}
	
	/**
	 * Method to reset bus position to right of screen
	 */
	//method to reset bus position to the right side of the screen if it moves too far left
	public void resetRight() {
		if (bus.getX() + bus.getWidth() < -1) {
			bus.setLocation(668, bus.getY());
			setImage();
		}
	}
	
	/**
	 * Method to reset bus position to left of screen
	 */
	//method to reset bus position to the left side of the screen if it moves too far right
	public void resetLeft() {
		if (bus.getX() > 668) {
			bus.setLocation(-110, bus.getY());
			setImage();
		}
	}
	
	public int getSpeed() {
		return busSpeed;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	//setter for bus location
	public void setLocation(int x, int y) {
		bus.setLocation(x, y);
	}
	
	public void setImage() {
		
		String stem = ("images/Frogger/Buses/");
		int index = (int) (Math.random() * 7);
		
		if (getSpeed() < 1) {
			
			String filepath = stem + ImageList[index] + "left.png";
			 
			try {
				ImageIcon image = (new ImageIcon(ImageIO.read(getClass().getResource("/"+filepath))));
				bus.setIcon(image);
				
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			
			String filepath =stem + ImageList[index] + "right.png";
			 
			try {
				ImageIcon image = (new ImageIcon(ImageIO.read(getClass().getResource("/"+filepath))));
				bus.setIcon(image);
				
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
