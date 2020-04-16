package frogger;


/**
 * The Class Intersects.
 */
//THIS CLASS HANDLES PLAYER BUS INTERSECTION CHECKING
public class Intersects{
	
	/**
	 * Intersect.
	 *
	 * @param J1 the Player
	 * @param J2 the Obstacle
	 * @return true, if they collide
	 */
	public static boolean Intersect(Player J1, Obstacle J2) {
		
		//test horizontal intersection
													//										   //		
		if ((J1.getX() + J1.getWidth() > J2.getX()) && (J1.getX() < J2.getX() + J2.getWidth()) && J1.getY() < J2.getY() + J2.getHeight() && J1.getY() + J1.getHeight()  > J2.getY()  ) {
			return true;
		}
		
		//test vertical intersection
		else if ((J1.getY() > J2.getY() + J2.getHeight())&&(J1.getY() + J1.getHeight() < J2.getY())) {
			return true;
		}
		
		//if it isn't vertical or horizontal intersection return false
		else {
			return false;
		}

	}
	
}
