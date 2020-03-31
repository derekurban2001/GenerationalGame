//Class to get the key input from the user
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The Class KeyInput.
 */
public class KeyInput extends KeyAdapter {

/** The left paddle. */
//variables for each of the paddles
	private Paddle lp; 
	
	/** The right paddle. */
	private Paddle rp; 
	
	/** The top paddle. */
	private PaddleHorizontal tp;
	
	/** The bottom paddle. */
	private PaddleHorizontal bp;

/**
 * Instantiates a new key input.
 *
 * @param p1 the player 1
 * @param p2 the player 2
 * @param p3 the player 3
 * @param p4 the player 4
 */
//constructor to initialize each of the paddles to a variable.
	public KeyInput(Paddle p1, Paddle p2, PaddleHorizontal p3, PaddleHorizontal p4) {

		lp = p1;
		rp = p2;
		tp = p3;
		bp = p4;
		
	}

/**
 * Key pressed.
 *
 * @param e the key pressed input from user
 */
//method to get input from user and change directions for the paddles
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
	//If statement to change direction for the right paddle, changes direction every time right arrow key is pressed.
		if (key == KeyEvent.VK_RIGHT) {
			if(rp.getDirection() == 0) {
				rp.switchDirections(-1);
			}
			else if(rp.getDirection() == 1) {
				rp.switchDirections(-1);
			}
			else if(rp.getDirection() == -1) {
				rp.switchDirections(1);
			}
		}
		
	//If statement to change direction for the left paddle, changes direction every time left arrow key is pressed.
		if (key == KeyEvent.VK_LEFT) {
			if(lp.getDirection() == 0) {
				lp.switchDirections(-1);
			}
			else if(lp.getDirection() == 1) {
				lp.switchDirections(-1);
			}
			else if(lp.getDirection() == -1) {
				lp.switchDirections(1);
			}
		}
		
	//If statement to change direction for the top paddle, changes direction every time top arrow key is pressed.
		if (key == KeyEvent.VK_UP) {
			if(tp.getDirection() == 0) {
				tp.switchDirections(-1);
			}
			else if(tp.getDirection() == 1) {
				tp.switchDirections(-1);
			}
			else if(tp.getDirection() == -1) {
				tp.switchDirections(1);
			}
		}
		
	//If statement to change direction for the bottom paddle, changes direction every time bottom arrow key is pressed.
		if (key == KeyEvent.VK_DOWN) {
			if(bp.getDirection() == 0) {
				bp.switchDirections(-1);
			}
			else if(bp.getDirection() == 1) {
				bp.switchDirections(-1);
			}
			else if(bp.getDirection() == -1) {
				bp.switchDirections(1);
			}
		}
//exits the game upon pressing escape
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
}
