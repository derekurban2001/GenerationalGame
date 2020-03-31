//Class to create the ball & check for contact 
import java.awt.Color;
import java.awt.Graphics;

/**
 * The Class Ball.
 */
public class Ball {
	

	/** The Constant SIZE  */
	//variable for size of the ball - used in the paddle classes
	public static int SIZE = 25;

	/** The x,y for the top left pixel of the ball */
	//variable for the top left pixel of the ball
	private int x, y; 
	
	/** The x,y velocities for the ball */
	//variables for the x and y velocities for the ball
	private int xVel, yVel; 
	
	/** The speed of the ball. */
	//variable for the speed of the ball
	private double speed = 1.0;

	/**
	 * reset ball every time somebody loses a point
	 */
	//Constructor to reset ball every time somebody loses a point
	public Ball() {
		reset();
	}

	/**
	 * Reset the ball to the center.
	 */
	//Method to reset the ball to the center and send it off in a random direction
	private void reset() {
		x = Game.WIDTH / 2 - SIZE / 2;
		y = Game.HEIGHT / 2 - SIZE / 2;

		xVel = Game.sign(Math.random() * 2.0 - 1);
		yVel = Game.sign(Math.random() * 2.0 - 1);
	}

	/**
	 * Draws the ball.
	 *
	 * @param g of type Graphics
	 */
	//Method to set the color of the ball and sets the size of the ball
	public void draw(Graphics g) {
		g.setColor(Color.PINK);
		g.fillRect(x, y, SIZE, SIZE);
	}

	//Method to deduct points from left/right paddles & resets the ball to the middle
	/**
	 * Update upon contact with a wall.
	 *
	 * @param lp the left paddle
	 * @param rp the right paddle
	 */
	//speeds up the ball every time a player loses a point
	public void update(Paddle lp, Paddle rp) {

		x += xVel * speed;
		y += yVel * speed;

		if (x + SIZE >= Game.WIDTH) { 
			rp.deductPoint();
			reset();
			speed +=0.1;
		}
		if (x <= 0) { 
			lp.deductPoint();
			reset();
			speed += 0.1;
		}
	}
	//Method to deduct points from top/bottom paddles & resets the ball to the middle
	/**
	 * Update upon contact with a wall.
	 *
	 * @param tp the top paddle
	 * @param bp the bottom paddle
	 */
	//speeds up the ball every time a player loses a point
	public void update(PaddleHorizontal tp, PaddleHorizontal bp) {
		x+= xVel * speed;
		y+= yVel * speed;
		
		if(y >= Game.HEIGHT) {
			bp.deductPoint();
			reset();
			speed += 0.1;
			}
		if(y + SIZE <= 0) {
			tp.deductPoint();
			reset();
			speed +=0.1;

		}
	}

	/**
	 * Gets the x for the top left corner of the ball.
	 *
	 * @return the x for top left corner of the ball
	 */
	//Getter for the top left x-pixel value of the ball
	public int getX() {
		return x;
	}

	/**
	 * Gets the y for the top left corner of the ball.
	 *
	 * @return the y for the top left corner of the ball
	 */
	//Getter for the top left y-pixel value of the ball
	public int getY() {
		return y;
	}

	/**
	 * Change X direction of the ball.
	 */
	//Changes x velocity of the ball upon contact
	public void changeXDir() {
		xVel *= -1;
	}

	/**
	 * Change Y direction of the ball.
	 */
	//Changes y velocity of the ball upon contact 
	public void changeYDir() {
		yVel *= -1;
	}
	
	
}
