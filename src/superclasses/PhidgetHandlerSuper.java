package superclasses;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;


//PhidgetHandlerSuper is supposed to be a parent class to all PhidgetHandler
//classes and to replace the handling method for the physical controller, instead
/**
 * The Class PhidgetHandlerSuper.
 */
//this class allows for keyboard input, instead of a physical true/false button as input.
public abstract class PhidgetHandlerSuper{
	
	/** The main frame. */
	//Declare important constants and variables
	private JComponent mainFrame;
	
	/** The player 1 action boolean. */
	private boolean p1Act = true;
	
	/** The player 2 action boolean. */
	private boolean p2Act = true;
	
	/** The player 3 action boolean. */
	private boolean p3Act = true;
	
	/** The player 4 action boolean. */
	private boolean p4Act = true;
	
	/** The input map. */
	private static InputMap iMap;
	
	/** The action map. */
	private static ActionMap aMap;
	
	/**
	 * Instantiates a new phidget handler super.
	 *
	 * @param frame the frame of type JComponent
	 */
	//constructor that takes in a frame to overwrite the default frame (one on the main menu)
	protected PhidgetHandlerSuper(JComponent frame){
		mainFrame = frame;
		//Adds keybinds
		addKeyBind(KeyEvent.VK_Q, "playerOne", playerOnePerformAction, playerOneRelease);
		addKeyBind(KeyEvent.VK_R, "playerTwo", playerTwoPerformAction, playerTwoRelease);
		addKeyBind(KeyEvent.VK_U, "playerThree", playerThreePerformAction, playerThreeRelease);
		addKeyBind(KeyEvent.VK_P, "playerFour", playerFourPerformAction, playerFourRelease);
	}
	
	/**
	 * Player one action method.
	 */
	//abstract classes that each game will use in its PhidgetHandler class
	public abstract void playerOneAction();
	
	/**
	 * Player two action method.
	 */
	public abstract void playerTwoAction();
	
	/**
	 * Player three action method.
	 */
	public abstract void playerThreeAction();
	
	/**
	 * Player four action method.
	 */
	public abstract void playerFourAction();
	
	/**
	 * Adds the key bind.
	 *
	 * @param key the key
	 * @param playerConstant the player constant string
	 * @param act the action by the player
	 * @param actRelease the action release by the player
	 */
	//Adds a keybind
	private void addKeyBind(int key, String playerConstant, Action act, Action actRelease) {
		//adds to the input map and action map with the appropriate key and action
	    iMap = mainFrame.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    aMap = mainFrame.getActionMap();
	    iMap.put(KeyStroke.getKeyStroke(key, 0, false), playerConstant);
	    iMap.put(KeyStroke.getKeyStroke(key, 0, true), playerConstant+"Release");
	    aMap.put(playerConstant, act);
	    aMap.put(playerConstant+"Release", actRelease);
	}
	
	//DECLARES ALL THE ACTIONS FOR EACH PLAYER, INSTANTIATED BY THE CHILD CLASSES.
	
	/** The player one perform action method. */
	Action playerOnePerformAction = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(p1Act)
				playerOneAction();
			p1Act = false;
		}
	};
	
	/** The player two perform action method. */
	Action playerTwoPerformAction = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(p2Act)
				playerTwoAction();
			p2Act = false;
		}
	};
	
	/** The player three perform action method. */
	Action playerThreePerformAction = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(p3Act)
				playerThreeAction();
			p3Act = false;
		}
	};
	
	/** The player four perform action method. */
	Action playerFourPerformAction = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(p4Act)
				playerFourAction();
			p4Act = false;
		}
	};
	
	/** The player one release method. */
	Action playerOneRelease = new AbstractAction() {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {p1Act = true;}
	};
	
	/** The player two release method. */
	Action playerTwoRelease = new AbstractAction() {
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {p2Act = true;}
	};
	
	/** The player three release method. */
	Action playerThreeRelease = new AbstractAction() {
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {p3Act = true;}
	};
	
	/** The player four release method. */
	Action playerFourRelease = new AbstractAction() {
		private static final long serialVersionUID = 1L;
		@Override
		public void actionPerformed(ActionEvent e) {p4Act = true;}
	};
}
