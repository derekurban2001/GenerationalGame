// method to create the window using JFrame
package pong;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import superclasses.PlayerSuper;
import java.awt.Font;
import javax.swing.SwingConstants;


/**
 * The Class Window.
 */
public class Window{

	/** The Constant WIDTH. */
	public final static int WIDTH = 600;

	/** The Constant HEIGHT. */
	public final static int HEIGHT = 600;

	/** The panel. */
	protected static JPanel panel;
	
	/** The left paddle. */
	private static Paddle lp;
	
	/** The right paddle. */
	private static Paddle rp;
	
	/** The top paddle. */
	private static PaddleHorizontal tp;
	
	/** The bottom paddle. */
	private static PaddleHorizontal bp;
	
	/** The right score label. */
	private static JLabel rightScoreLabel;
	
	/** The left score label. */
	private static JLabel leftScoreLabel;
	
	/** The top score label. */
	private static JLabel topScoreLabel;
	
	/** The bottom score label. */
	private static JLabel bottomScoreLabel;
	
	/** The game over display. */
	private static JLabel gameOverDisplay;
	
	/** The ball. */
	protected static Ball ball;
// Constructor - Creates the window for the game
// Parameters: 
// title: takes the String title for the name of the game.
/**
 * Instantiates a new window.
 *
 * @param title the String title
 * @param game the game
 */
// game: Parameter of the class type "Game" to create the game
	public Window(String title, Game game) {
		panel = new JPanel();
		panel.setBounds(0,0, WIDTH, HEIGHT);
		panel.setBackground(Color.black);
		panel.setLayout(null);
		
		JLabel leftLabel = new JLabel("P1");
		leftLabel.setFont(new Font("Arial", Font.BOLD, 12));
		leftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftLabel.setOpaque(true);
		leftLabel.setBackground(PlayerSuper.getPlayer1Color());
		leftLabel.setBounds(0, 240, 20, 120);
		
		JLabel rightLabel = new JLabel("P2");
		rightLabel.setFont(new Font("Arial", Font.BOLD, 12));
		rightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightLabel.setOpaque(true);
		rightLabel.setBackground(PlayerSuper.getPlayer2Color());
		rightLabel.setBounds(WIDTH-20, 240, 20, 120);
		
		JLabel topLabel = new JLabel("P3");
		topLabel.setFont(new Font("Arial", Font.BOLD, 12));
		topLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topLabel.setOpaque(true);
		topLabel.setBackground(PlayerSuper.getPlayer3Color());
		topLabel.setBounds(240, 0, 120, 20);
		
		JLabel bottomLabel = new JLabel("P4");
		bottomLabel.setFont(new Font("Arial", Font.BOLD, 12));
		bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bottomLabel.setOpaque(true);
		bottomLabel.setBackground(PlayerSuper.getPlayer4Color());
		bottomLabel.setBounds(240, HEIGHT-20, 120, 20);
		
		JLabel ballLabel = new JLabel("");
		ballLabel.setOpaque(true);
		ballLabel.setBackground(Color.white);
		ballLabel.setBounds(290, 290, 20, 20);
		
		leftScoreLabel = new JLabel("Lives: 5");
		leftScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
		leftScoreLabel.setForeground(PlayerSuper.getPlayer1Color());
		leftScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftScoreLabel.setBounds(30, 290, 70, 20);
		
		rightScoreLabel = new JLabel("Lives: 5");
		rightScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
		rightScoreLabel.setForeground(PlayerSuper.getPlayer2Color());
		rightScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightScoreLabel.setBounds(WIDTH-100, 290, 70, 20);
		
		topScoreLabel = new JLabel("Lives: 5");
		topScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
		topScoreLabel.setForeground(PlayerSuper.getPlayer3Color());
		topScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topScoreLabel.setBounds(265, 30, 70, 20);
		
		bottomScoreLabel = new JLabel("Lives: 5");
		bottomScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
		bottomScoreLabel.setForeground(PlayerSuper.getPlayer4Color());
		bottomScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bottomScoreLabel.setBounds(265, HEIGHT-50, 70, 20);
		
		gameOverDisplay = new JLabel("GAME OVER");
		gameOverDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverDisplay.setFont(new Font("Arial", Font.BOLD, 70));
		gameOverDisplay.setForeground(Color.YELLOW);
		gameOverDisplay.setBounds(30,151, 540, 100);
		gameOverDisplay.setVisible(false);
		
		panel.add(gameOverDisplay);
		panel.add(ballLabel);
		panel.add(leftLabel);
		panel.add(rightLabel);
		panel.add(topLabel);
		panel.add(bottomLabel);
		panel.add(leftScoreLabel);
		panel.add(rightScoreLabel);
		panel.add(topScoreLabel);
		panel.add(bottomScoreLabel);
		
		ball = new Ball(ballLabel);
		lp = new Paddle(Color.WHITE, true, leftLabel);
		rp = new Paddle(Color.DARK_GRAY, false, rightLabel);
		tp= new PaddleHorizontal(Color.LIGHT_GRAY, true, topLabel);
		bp = new PaddleHorizontal(Color.gray, false, bottomLabel);
	}
	
	/**
	 * Player 1 score.
	 *
	 * @param score the player 1 score
	 */
	public static void player1Score(int score) {
		if(score == 0)
			leftScoreLabel.setText("Dead");
		else
			leftScoreLabel.setText("Lives: "+score);
	}
	
	/**
	 * Player 2 score.
	 *
	 * @param score the player 2 score
	 */
	public static void player2Score(int score) {
		if(score == 0)
			rightScoreLabel.setText("Dead");
		else
			rightScoreLabel.setText("Lives: "+score);
	}

	/**
	 * Player 3 score.
	 *
	 * @param score the player 3 score
	 */
	public static void player3Score(int score) {
		if(score == 0)
			topScoreLabel.setText("Dead");
		else
			topScoreLabel.setText("Lives: "+score);
	}

	/**
	 * Player 4 score.
	 *
	 * @param score the player 4 score
	 */
	public static void player4Score(int score) {
		if(score == 0)
			bottomScoreLabel.setText("Dead");
		else
			bottomScoreLabel.setText("Lives: "+score);
	}
	
	/**
	 * Game over method.
	 */
	public static void gameOver() {
		gameOverDisplay.setVisible(true);
		try {
			Thread.sleep(4000);
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	/**
	 * Gets the ball.
	 *
	 * @return the ball
	 */
	public Ball getBall() {
		return ball;
	}
	
	/**
	 * Gets the left paddle.
	 *
	 * @return the left paddle
	 */
	public Paddle getLeftPaddle() {
		return lp;
	}
	
	/**
	 * Gets the right paddle.
	 *
	 * @return the right paddle
	 */
	public Paddle getRightPaddle() {
		return rp;
	}
	
	/**
	 * Gets the top paddle.
	 *
	 * @return the top paddle
	 */
	public PaddleHorizontal getTopPaddle() {
		return tp;
	}
	
	/**
	 * Gets the bottom paddle.
	 *
	 * @return the bottom paddle
	 */
	public PaddleHorizontal getBottomPaddle() {
		return bp;
	}
}
