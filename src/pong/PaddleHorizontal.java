//Class for the top and bottom paddles
package pong;

import java.awt.Color;
import javax.swing.JLabel;
import superclasses.PlayerSuper;


/**
 * The Class PaddleHorizontal.
 */
public class PaddleHorizontal extends PlayerSuper{

	/** The x,y for top left pixel of the paddles. */
	//variables for the top left pixel of the paddles
	private int x, y;
	
	/** The velocity of the paddle. */
	//initial velocity of the paddles
	private int vel = 0;
	
	/** The speed of the paddle. */
	//speed of the paddles
	private int speed = 10;
	
	/** The width,height of the paddles. */
	//Width and height of the paddles
	private int width = 120, height = 20;
	
	/** The score of the players. */
	//initial score of the each of the players
	private int score = 5;
	
	/** The top boolean to differentiate between top and bottom paddles. */
	//boolean to differentiate between top and bottom paddle
	private boolean top;
	
	/** The label. */
	private JLabel label;
	
	/**
	 * Instantiates a new paddle horizontal.
	 *
	 * @param c the color
	 * @param top the boolean
	 * @param label the label
	 */
	//constructor to determine if top or bottom paddle & color of the paddle
	public PaddleHorizontal(Color c, boolean top, JLabel label) {
		this.label = label;
		this.top = top;

		if (top)
			y = 0 ;
		else
			y = Game.HEIGHT - height;

		x = Game.WIDTH / 2 - width / 2;

	}

	/**
	 * Deduct point from a player.
	 */
	//method to deduct a point from the player
	public void deductPoint() {
		score--;
	}


	/**
	 * Update direction of ball upon contact with the paddle.
	 *
	 * @param b of type Ball
	 */
	//Method to update the ball position, checks for ball contact with either of the paddles
	public void update(Ball b) {

		x = Game.ensureRange(x + vel, 0, Game.WIDTH - width);

		int ballX = b.getX();
		int ballY = b.getY();

		if (top) {

			if (ballY <= height + y && ballX + Ball.SIZE >= x && ballX <= x + width) {
				b.changeYDir();
				b.setY(y+height+1);
				increaseSpeed();
			}

		} else {

			if (ballY + Ball.SIZE >= y && ballX + Ball.SIZE >= x && ballX <= x+ width) {
				b.changeYDir();
				b.setY(y-height-1);
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
	 * Switch directions.
	 *
	 * @param direction the direction
	 */
	//Method to switch velocity of the paddle
	public void switchDirections(int direction) {
		vel = speed * direction;
	}
	
	/**
	 * Stop.
	 */
	//Method to stop the paddle
	public void stop() {
		vel = 0;
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
