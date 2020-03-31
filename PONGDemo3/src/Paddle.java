//Class for the left and right paddles
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * The Class Paddle.
 */
public class Paddle {
	
	/** The x,y for top left pixel of the paddles. */
	//variables for the top left pixel of the paddles
	private int x, y;
	
	/** The velocity of the paddle. */
	//initial velocity of the paddle
	private int vel = 0;
	
	/** The speed of the paddle. */
	//speed of the paddle
	private int speed = 6;
	
	/** The width,height of the paddles. */
	//Width and height of the paddles
	private int width = 10, height = 100;
	
	/** The score of the players. */
	//initial score of the each of the players
	private int score = 5;
	
	/** The color of the paddles. */
	//color of the paddle
	private Color color;
	
	/** The left boolean to differentiate between left and right paddles. */
	//boolean to differentiate between left and right paddle
	private boolean left;

	/**
	 * Instantiates a new paddle.
	 *
	 * @param c the color
	 * @param left the boolean
	 */
	//constructor to determine if left or right paddle & color of the paddle
	public Paddle(Color c, boolean left) {
		color = c;
		this.left = left;

		if (left)
			x = 0;
		else
			x = Game.WIDTH - width;

		y = Game.HEIGHT / 2 - height / 2;

	}

	/**
	 * Deduct a point form player.
	 */
	//method to deduct a point from the player
	public void deductPoint() {
		score--;
	}

	/**
	 * Draw.
	 *
	 * @param g of type Graphics
	 */
	// method to draw/set color of the ball & the score for each of the players
	public void draw(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);

		int scorePadding; //integer for pixel padding from the side of the screen
		int padding = 25; //padding from the side of the screen for the score
		String scoreText = Integer.toString(score);
		Font font = new Font("Roboto", Font.PLAIN, 25);

		if (left) {																			
			scorePadding = padding;
		} else {
			scorePadding = Game.WIDTH - padding-width;
		}

		g.setFont(font);
		g.drawString(scoreText, scorePadding, Game.HEIGHT/2);
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
			}
		} else {

			if (ballX + Ball.SIZE >= x && ballY + Ball.SIZE >= y && ballY <= y + height) {
				b.changeXDir();
			}
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
	


}
