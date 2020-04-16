package frogger;

/**
 * The Class Lane.
 */
//Lane class 	
public class Lane {
	//instance variables
	//Y1 represents the top y coordinate of the lane
	//Y2 represents the bottom y coordinate of the lane
	//because the lanes span the width of the screen, they do not require an x coordinate
	
	/** The top y coordinate of the lane. */
	private int y;
	
	/**
	 * Instantiates a new lane.
	 *
	 * @param a the top y coordinate of the lane
	 */
	//constructor
	public Lane (int a) {
		y = a;
		//because lane height is constant, lane bottom is simply the top of the lane plus its height
	}
	
	/**
	 * Gets the top y coordinate of the lane.
	 *
	 * @return the top
	 */
	//getter for lane top
	public int getTop() {
		return y;
	}

	/**
	 * Sets the top.
	 *
	 * @param t the new top y coordinate of the lane
	 */
	//setter for lane top
	public void setTop(int t) {
		y = t;
	}

}
