package pacman;

/**
 * The Class Object.
 * 
 * This abstract class is extended by the game objects in which the player interacts.
 * Simply ensures that each object has the necessary components to be defined as an object.
 * 
 * @author Derek Urban
 */
public abstract class Object {
	
	/**
	 * Gets the x of the object.
	 *
	 * @return the x
	 */
	protected abstract int getX();
	
	/**
	 * Gets the y value of the object.
	 *
	 * @return the y
	 */
	protected abstract int getY();
}
