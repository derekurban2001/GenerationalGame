//Some of the code in this game was created using the following tutorial: https://www.youtube.com/watch?v=MPJ8XRpZZCk
package pong;


/**
 * The Class Game.
 */
public class Game{
	
	/** The Handler. */
	Thread Handler = new Thread(new handler());

/** The Constant WIDTH of the window. */
//Variables for the size of the window
	public final static int WIDTH = 600;
	
	/** The Constant HEIGHT of the window. */
	public final static int HEIGHT = 600; 
	
/** The boolean running. */
//Boolean and Thread variables for the game; boolean running is set to true when game is created.
	public static boolean running = false; 

/** The ball variable, used to initialize ball. */
//Variable of class Ball later used to initialize the ball.
	private Ball ball;

/** The left paddle. */
//Variables for the vertical and horizontal paddles later used to initialize paddles
	protected Paddle leftPaddle;
	
	/** The right paddle. */
	protected Paddle rightPaddle;
	
	/** The top paddle. */
	protected PaddleHorizontal topPaddle;
	
	/** The bottom paddle. */
	protected PaddleHorizontal bottomPaddle;
	
	/** The speed. */
	protected static int speed = 1;
	
	/** The integer count. */
	protected static int count = 0;
	
	/** The window. */
	private Window window;
/**
 * Instantiates a new game.
 */
//Constructor - used to initialize everything including the window, input from user. 
	public Game() {
		running = true;
		
		window = new Window("Pong", this);
		
		initialize();
		
		Handler.start();
	}

/**
 * Initializes the ball and paddle.
 */
//Method to initialize the ball and the paddles, and sets boolean draw to true which will draw them. 
	private void initialize() {
		ball = window.getBall();
		
		leftPaddle = window.getLeftPaddle();
		rightPaddle = window.getRightPaddle();
		topPaddle = window.getTopPaddle();
		bottomPaddle = window.getBottomPaddle();
		
		new PhidgetHandler(leftPaddle, rightPaddle,topPaddle,bottomPaddle);
	}
	
/**
 * The Class handler.
 */
public class handler implements Runnable{
	
	/**
	 * Run.
	 */
	@Override
	public void run() {
		while(running) {
			try {
				Thread.sleep(26-speed);
			}
			catch(Exception ex) {ex.printStackTrace();}
			
			if(leftPaddle.getScore() == 0 || rightPaddle.getScore() == 0 ||
			   topPaddle.getScore() == 0 || bottomPaddle.getScore() == 0){
				Window.gameOver();
				running = false;
			}
			update();
		}
	}
}
	
/**
 * Updates the paddle and ball locations.
 */
//method to update location of the ball and paddles, calls methods from the ball and paddle classes to do so. 
	public void update() {

			ball.update(leftPaddle, rightPaddle);
			ball.update(topPaddle, bottomPaddle);

			leftPaddle.update(ball);
			rightPaddle.update(ball);
			topPaddle.update(ball);
			bottomPaddle.update(ball);
	}

/**
 * Ensure range.
 *
 * @param value the current location value
 * @param min the minimum range
 * @param max the maximum range
 * @return the integer to ensure within the range
 */
//method used in the paddle classes to ensure ball remains within window
	public static int ensureRange(int value, int min, int max) {
		return Math.min(Math.max(value, min), max);
	}
	
/**
 * Sign of the direction of the ball.
 *
 * @param d the double based on random math generator
 * @return the integer for random direction of the ball
 */
//method to used in Ball class to randomly generate direction for ball when starting game
	public static int sign(double d) {
		if (d <= 0)
			return -1;

		return 1;
	}
	
	/**
	 * Gets the paddle score.
	 *
	 * @return the paddle score
	 */
	public int[] getPaddleScore() {
		int scoreP1 = 0,scoreP2 = 0,scoreP3 = 0,scoreP4 = 0;
		scoreP1 = leftPaddle.getScore();
		scoreP2 = rightPaddle.getScore();
		scoreP3 = topPaddle.getScore();
		scoreP4 = bottomPaddle.getScore();
		
		int[] data = new int[4];		
		data[0] = scoreP1;
		data[1] = scoreP2;
		data[2] = scoreP3;
		data[3] = scoreP4;
		return data;
	}

}
