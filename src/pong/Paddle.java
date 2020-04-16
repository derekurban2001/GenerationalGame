//Class for the left and right paddles
package pong;

import java.awt.Color;
import javax.swing.JLabel;
import superclasses.PlayerSuper;

/**
 * The Class Paddle.
 */
public class Paddle extends PlayerSuper{
	
	/** The x,y for top left pixel of the paddles. */
	//variables for the top left pixel of the paddles
	private int x, y;
	
	/** The velocity of the paddle. */
	//initial velocity of the paddle
	private int vel = 0;
	
	/** The speed of the paddle. */
	//speed of the paddle
	private int speed = 10;
	
	/** The width,height of the paddles. */
	//Width and height of the paddles
	private int width = 20, height = 120;
	
	/** The score of the players. */
	//initial score of the each of the players
	private int score = 5;
	
	/** The left boolean to differentiate between left and right paddles. */
	//boolean to differentiate between left and right paddle
	private boolean left;
	
	/** The label. */
	private JLabel label;
	
	/**
	 * Instantiates a new paddle.
	 *
	 * @param c the color
	 * @param left the boolean
	 * @param label the paddle label
	 */
	//constructor to determine if left or right paddle & color of the paddle
	public Paddle(Color c, boolean left, JLabel label) {
		this.label = label;
		this.left = left;

		if (left)
			x = 0;
		else
			x = Game.WIDTH - width;

		y = Game.HEIGHT / 2 - height / 2;

	}

	/**
	 * Deduct a point from player.
	 */
	//method to deduct a point from the player
	public void deductPoint() {
		score--;
	}


	/**
	 * Update the direction of the ball upon contact with paddle.
	 *
	 * @param b of type Ball
	 */
	//Method to update the ball position, checks for ball contact with either of the paddles
	public void update(Ball b) {

		y = Game.ensureRange(y + vel, 0, Game.HEIGHT - height);

		int ballX = b.getX();
		int ballY = b.getY();

		if (left) {
			if (ballX <= width + x && ballY + Ball.SIZE >= y && ballY <= y + height) {
				b.changeXDir();
				b.setX(x+width+1);
				increaseSpeed();
			}
		} else {

			if (ballX + Ball.SIZE >= x && ballY + Ball.SIZE >= y && ballY <= y + height) {
				b.changeXDir();
				b.setX(x-width-1);
				increaseSpeed();
			}
		}
		label.setLocation(x, y);
	}
	
	/**
	 * Increase speed.
	 */
	private void increaseSpeed() {
		if (Game.count % 2 == 0) {
			if(Game.speed <= 20)
				Game.speed += 1;
			Game.count = 1;
		}
		else {
			Game.count ++;
		}
	}

	/**
	 * Switch directions.
	 *
	 * @param direction the integer
	 */
	//Method to switch velocity of the paddle
	public void switchDirections(int direction) {
		vel = speed * direction;
	}
	
	/**
	 * Stop the paddle.
	 */
	//Method to stop the paddle
	public void stop() {
		vel = 0;
	}
	
	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	//Method used by KeyInput to switch direction of paddle upon input from user
	public int getDirection() {
		if (vel < 0) {
			return -1;
		}
		else if (vel > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}


}
