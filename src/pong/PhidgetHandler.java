package pong;

import superclasses.PhidgetHandlerSuper;

/**
 * The Class KeyInput.
 */
public class PhidgetHandler extends PhidgetHandlerSuper {
	
	//variables for each of the paddles

/** The left paddle. */
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
	protected PhidgetHandler(Paddle p1, Paddle p2, PaddleHorizontal p3, PaddleHorizontal p4) {
		super(Window.panel);
		lp = p1;
		rp = p2;
		tp = p3;
		bp = p4;
	}

/**
 * Player one action method to receive user input.
 */
@Override
public void playerOneAction() {
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

/**
 * Player two action method to receive user input.
 */
@Override
public void playerTwoAction() {
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

/**
 * Player three action method to receive user input.
 */
@Override
public void playerThreeAction() {
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

/**
 * Player four action method to receive user input.
 */
@Override
public void playerFourAction() {
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
}
