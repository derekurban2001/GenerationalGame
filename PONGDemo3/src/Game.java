//Some of the code in this game was created using the following tutorial: https://www.youtube.com/watch?v=MPJ8XRpZZCk
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 * The Class Game.
 */
public class Game extends Canvas implements Runnable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/** The Constant WIDTH of the window. */
//Variables for the size of the window
	public final static int WIDTH = 600;
	
	/** The Constant HEIGHT of the window. */
	public final static int HEIGHT = 600; 
	
/** The boolean running. */
//Boolean and Thread variables for the game; boolean running is set to true when game is created.
	public boolean running = false; 
	
	/** The game thread. */
	private Thread gameThread; 

/** The ball variable, used to initialize ball. */
//Variable of class Ball later used to initialize the ball.
	private Ball ball;

/** The left paddle. */
//Variables for the vertical and horizontal paddles later used to initialize paddles
	private Paddle leftPaddle;
	
	/** The right paddle. */
	private Paddle rightPaddle;
	
	/** The top paddle. */
	private PaddleHorizontal topPaddle;
	
	/** The bottom paddle. */
	private PaddleHorizontal bottomPaddle;
	
/** The draw boolean, used to draw the paddles/ball. */
//Boolean draw to set to true when the game is initialized, used to draw the paddles/ball.
	public static boolean draw = false;

/**
 * Instantiates a new game.
 */
//Constructor - used to initialize everything including the window, input from user. 
	public Game() {
		
		canvasSetup();

		new Window("Pong", this);

		initialize();

		this.addKeyListener(new KeyInput(leftPaddle, rightPaddle,topPaddle,bottomPaddle));

		this.setFocusable(true);
		
	}

/**
 * Initializes the ball and paddle, also sets boolean draw to true.
 */
//Method to initialize the ball and the paddles, and sets boolean draw to true which will draw them. 
	private void initialize() {
		ball = new Ball();

		leftPaddle = new Paddle(Color.WHITE, true);
		rightPaddle = new Paddle(Color.DARK_GRAY, false);
		topPaddle = new PaddleHorizontal(Color.LIGHT_GRAY, true);
		bottomPaddle = new PaddleHorizontal(Color.gray, false);

		this.start();
		this.draw = true;
	}

/**
 * Canvas setup with corresponding width and height.
 */
//method to set the dimension to the corresponding width and height.
	private void canvasSetup() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	}

	
/**
 * The method run - starts the time loop for the game when running and updates location of the ball/paddles.
 */
//method run, which starts the time loop for the game when running & updates the location of the ball/paddles
	@Override
	public void run() {

		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running) {
		long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				update(); //updates location of the ball and paddles
				delta--;
				draw();
			}
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
			
		}
		stop();
	}


/**
 * Start the game. Sets boolean running to true and creates the thread.
 */
// Method to start the create start the game/sets boolean running to true and creates the thread.
	public synchronized void start() {
		gameThread = new Thread(this);
		gameThread.start(); 
		running = true;
	}

/**
 * Stops the game.
 */
//Method to stop the game. 
	public void stop() {
		try {
			gameThread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
/**
 * Draws the ball/paddles in the window.
 */
//method to draw the ball/paddles in the window & calls methods from the other classes to do so
	public void draw() {

		BufferStrategy buffer = this.getBufferStrategy(); 

		if (buffer == null) { 
			this.createBufferStrategy(3); 
	
			return;
		}

		Graphics g = buffer.getDrawGraphics(); 

		drawBackground(g);

		if (draw == true)

		ball.draw(g);

		leftPaddle.draw(g);
		rightPaddle.draw(g);
		topPaddle.draw(g);
		bottomPaddle.draw(g);

		g.dispose(); 
		buffer.show(); 

	}

/**
 * Draws background.
 *
 * @param g the g
 */
//Method to draw the background for the game using Width/Height variables and set color. 
	private void drawBackground(Graphics g) {
		g.setColor(Color.black.brighter());
		g.fillRect(0, 0, WIDTH, HEIGHT);
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

}
