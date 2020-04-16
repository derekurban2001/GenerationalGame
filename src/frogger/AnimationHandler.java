package frogger;

import superclasses.ImageChanger;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * The Class AnimationHandler.
 */
public class AnimationHandler {
	
	/** The Handler 1. */
	private Thread Handler1 = new Thread(new handler1());
	
	/** The Handler 2. */
	private Thread Handler2 = new Thread(new handler2());
	
	/** The Handler 3. */
	private Thread Handler3 = new Thread(new handler3());
	
	/** The Handler 4. */
	private Thread Handler4 = new Thread(new handler4());
	
	/** The player list. */
	private static Player[] playerList;
	
	/** The Constant DEFAULTCOLOR1. */
	private final static Color DEFAULTCOLOR1 = new Color(100,100,100);
	
	/** The Constant DEFAULTCOLOR2. */
	private final static Color DEFAULTCOLOR2 = new Color(200,200,200);
	
	/** The player1 jump. */
	private static boolean p1Jump = false;
	
	/** The player2 jump. */
	private static boolean p2Jump = false;
	
	/** The p 3 jump. */
	private static boolean p3Jump = false;
	
	/** The p 4 jump. */
	private static boolean p4Jump = false;

	/**
	 * Instantiates a new animation handler.
	 *
	 * @param p the p
	 */
	protected AnimationHandler(Player[] p){
		playerList = p;
		//handle/start player 1 animation
		Handler1.start();
		//handle/start player 2 animation
		Handler2.start();
		//handle/start player 3 animation
		Handler3.start();
		//handle/start player 4 animation
		Handler4.start();	
	}
	
	/**
	 * The Class handler1.
	 */
	private class handler1 implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			while(CrossyRoadMainClass.active) {
				try {
					Thread.sleep(50);
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				//if the first player jumps initiate animations for frogger 1
				if(p1Jump) {
					Jump(playerList[0]);
					p1Jump = false;
				}
				playerList[0].freeze = false;
			}
		}
	}
	
	/**
	 * The Class handler2.
	 */
	private class handler2 implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(50);
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				//if the second player jumps initiate animations for frogger 2
				if(p2Jump) {
					Jump(playerList[1]);
					p2Jump = false;
				}
				playerList[1].freeze = false;
			}
		}
	}
	
	/**
	 * The Class handler3.
	 */
	private class handler3 implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(50);
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				//if the third player jumps initiate animations for frogger 3
				if(p3Jump) {
					Jump(playerList[2]);
					p3Jump = false;
				}
				playerList[2].freeze = false;
			}
		}
	}
	
	/**
	 * The Class handler4.
	 */
	private class handler4 implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(50);
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				//if the fourth player jumps initiate animations for frogger 4
				if(p4Jump) {
					Jump(playerList[3]);
					p4Jump = false;
				}
				playerList[3].freeze = false;
			}
		}
	}
	
	/**
	 * Player 1 jump.
	 */
	public static void player1Jump() {
		p1Jump = true;
	}
	
	/**
	 * Player 2 jump.
	 */
	public static void player2Jump() {
		p2Jump = true;
	}

	/**
	 * Player 3 jump.
	 */
	public static void player3Jump() {
		p3Jump = true;
	}

	/**
	 * Player 4 jump.
	 */
	public static void player4Jump() {
		p4Jump = true;
	}
	
	/**
	 * Jump.
	 *
	 * @param p the p
	 */
	private void Jump(Player p) {
		JLabel label = p.getLabel();
		String[] folder = {"FrogJump0.png", "FrogJump1.png", "FrogJump2.png", "FrogJump3.png", 
						   "FrogJump4.png", "FrogJump5.png", "FrogJump6.png", "FrogJump7.png", 
						   "FrogJump8.png", "FrogJump9.png"};
		
		//create loop for every file used from the files
		for(String file : folder) {
			try {
				BufferedImage img = ImageIO.read(getClass().getResource("/images/Frogger/Anim/"+file));
				
				//change color of frog for frogger animation every time they jump
				img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, p.getPlayerColor());
				
				//change it to a second darker color for frogger animation
				img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, getDarkerColor(p.getPlayerColor()));
				
				//set icon to the images you add 
				label.setIcon(new ImageIcon(img));
				
				Thread.sleep(10);
				
				//if player is still moving set the location
				if(!p.freeze) {
					label.setBounds(label.getX(), label.getY()-5, img.getWidth(), img.getHeight());
				}
				
			}
			catch(Exception ex) {ex.printStackTrace();}
		}
	}
	
	/**
	 * Gets the darker color.
	 *
	 * @param color the color
	 * @return the darker color
	 */
	private static Color getDarkerColor(Color color) {
		
		//get the original colors 
		int R = color.getRed();
		int G = color.getGreen();
		int B = color.getBlue();
		
		//change to darker color for red 
		if(R > 70)
			R -= 70;
		
		//change to darker color for green
		if(G > 70)
			G -= 70;
		
		//change to darker color for blue
		if(B > 70)
			B -= 70;
		
		return new Color(R,G,B);
	}
}
