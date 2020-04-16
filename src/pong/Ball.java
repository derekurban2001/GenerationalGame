//Class to create the ball & check for contact 
package pong;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;


/**
 * The Class Ball.
 */
public class Ball {
	
	/** The paddle width. */
	protected final int paddleWidth = 10;

	/**  The x,y for the top left pixel of the ball. */
	//variable for the top left pixel of the ball
	private int x, y; 
	
	/** The Constant SIZE. */
	protected static final int SIZE = 20;
	
	/**  The x,y velocities for the ball. */
	//variables for the x and y velocities for the ball
	private int xVel, yVel; 
	
	/** The label. */
	//variable for the speed of the ball
	
	private JLabel label;
	
	/**
	 * reset ball every time somebody loses a point.
	 *
	 * @param label the ball label
	 */
	//Constructor to reset ball every time somebody loses a point
	public Ball(JLabel label) {
		this.label = label;
		reset();
	}

	/**
	 * Reset the ball to the center.
	 */
	//Method to reset the ball to the center and send it off in a random direction
	private void reset() {
		x = Game.WIDTH / 2 - SIZE / 2;
		y = Game.HEIGHT / 2 - SIZE / 2;
		
		int direction = Game.sign((Math.random() * 100 - 50));
		int magnitude = (int)(Math.random() * 6);
		
		xVel = magnitude * direction;
		
		direction = Game.sign((Math.random() * 100 - 50));
		
		yVel = (7-magnitude) * direction;
		
		Game.count = 1;
		Game.speed = 1;
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

		
		x += xVel;
		y += yVel;

		if (x + SIZE >= Game.WIDTH) { 
			rp.deductPoint();
			Window.player2Score(rp.getScore());
			reset();
		}
		if (x <= 0) { 
			lp.deductPoint();
			Window.player1Score(lp.getScore());
			reset();
		}
		label.setLocation(x, y);
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
		x+= xVel;
		y+= yVel;
		
		if(y+SIZE >= Game.HEIGHT) {
			bp.deductPoint();
			Window.player4Score(bp.getScore());
			reset();
			}
		if(y <= 0) {
			tp.deductPoint();
			Window.player3Score(tp.getScore());
			reset();
		}
		label.setLocation(x, y);
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
		int direction = Game.sign(yVel);
		int magnitude = (int)(Math.random() * 5+1);
		
		yVel = direction * magnitude;
		xVel = -1 * (7-magnitude) *  Game.sign(xVel);
	}

	/**
	 * Change Y direction of the ball.
	 */
	//Changes y velocity of the ball upon contact 
	public void changeYDir() {
		int direction = Game.sign(xVel);
		int magnitude = (int)(Math.random() * 5+1);
		
		xVel = direction * magnitude;
		yVel = -1 * (7-magnitude) *  Game.sign(yVel);
	}
	
	/**
	 * Sets the x.
	 *
	 * @param num the new x
	 */
	public void setX(int num) {
		x = num;
	}
	
	/**
	 * Sets the y.
	 *
	 * @param num the new y
	 */
	public void setY(int num) {
		y = num;
	}
}
