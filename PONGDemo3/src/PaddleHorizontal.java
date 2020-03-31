//Class for the top and bottom paddles

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * The Class PaddleHorizontal.
 */
public class PaddleHorizontal {

	/** The x,y for top left pixel of the paddles. */
	//variables for the top left pixel of the paddles
	private int x, y;
	
	/** The velocity of the paddle. */
	//initial velocity of the paddles
	private int vel = 0;
	
	/** The speed of the paddle. */
	//speed of the paddles
	private int speed = 6;
	
	/** The width,height of the paddles. */
	//Width and height of the paddles
	private int width = 100, height = 10;
	
	/** The score of the players. */
	//initial score of the each of the players
	private int score = 5;
	
	/** The color of the paddles. */
	//color of the paddle
	private Color color;
	
	/** The top boolean to differentiate between top and bottom paddles. */
	//boolean to differentiate between top and bottom paddle
	private boolean top;

	/**
	 * Instantiates a new paddle horizontal.
	 *
	 * @param c the color
	 * @param top the boolean
	 */
	//constructor to determine if top or bottom paddle & color of the paddle
	public PaddleHorizontal(Color c, boolean top) {
		color = c;
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
	 * Draw the paddle.
	 *
	 * @param g of type Graphics
	 */
	// method to draw/set color of the ball & the score for each of the players
	public void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width,height);

		int scorePaddingHorizontal; //integer for pixel padding from the side of the screen
		int padding = 25;  //padding from the side of the screen for the score
		String scoreText = Integer.toString(score);
		Font font = new Font("Gaoel", Font.PLAIN, 25);

		if (top) {																			
			scorePaddingHorizontal = 30 + padding / 2;
		} else {
			scorePaddingHorizontal = Game.HEIGHT -  padding;
		}

		g.setFont(font);
		g.drawString(scoreText, Game.WIDTH / 2 -padding/2, scorePaddingHorizontal);
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

			if (ballY <= height + y && ballX + Ball.SIZE >= x && ballX <= x + width)
				b.changeYDir();

		} else {

			if (ballY + Ball.SIZE >= y && ballX + Ball.SIZE >= x && ballX <= x + width)
				b.changeYDir();

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
	

}
