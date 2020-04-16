package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import superclasses.ImageChanger;

/**
 * The Class AnimationUpdater.
 * 
 * This class handles all the animations for the game objects
 * 
 * @author Derek Urban
 */
public class AnimationUpdater{
	
	/** The default colors. */
	private final Color DEFAULTCOLOR1 = new Color(100,100,100), DEFAULTCOLOR2 = new Color(200,200,200);
	
	/** The Updater thread. */
	private Thread Updater;
	
	/** Player 1. */
	private Player player1;
	
	/** Player 2. */
	private Player player2;
	
	/** The explosion folder. */
	private String[] explosionFolder;
	
	/** The pacman death folder. */
	private String[] pacmanDeathFolder;
	
	/** The pacman eating folder. */
	private String[] pacmanEatingFolder;
	
	/** Boolean as to whether the game is over. */
	private boolean gameOverCheck;
	
	/** The game over display. */
	private JLabel jGameOverDisplay;
	
	/** The ghost list. */
	private AI[] ghostList;
	
	/**
	 * Initializes the default values.
	 */
	private void initDefaults() {
		Updater = new Thread(new updater(), "Animation Updater");
		explosionFolder = new String[]{"Explosion1.png", "Explosion2.png", "Explosion3.png", "Explosion4.png", 
									   "Explosion5.png", "Explosion6.png", "Explosion7.png", "Explosion8.png", 
									   "Explosion9.png"};
		
		pacmanDeathFolder = new String[]{"PacmanDeath1.png", "PacmanDeath2.png", "PacmanDeath3.png", "PacmanDeath4.png", 
				  						 "PacmanDeath5.png", "PacmanDeath6.png", "PacmanDeath7.png", "PacmanDeath8.png"};
		
		pacmanEatingFolder = new String[]{"PacmanEating01.png", "PacmanEating02.png", "PacmanEating03.png", "PacmanEating04.png", 
										  "PacmanEating05.png", "PacmanEating06.png", "PacmanEating07.png", "PacmanEating08.png", 
										  "PacmanEating09.png", "PacmanEating10.png", "PacmanEating11.png", "PacmanEating12.png", 
										  "PacmanEating13.png", "PacmanEating14.png"};
		gameOverCheck = true;
	}
	
	/**
	 * Instantiates a new AnimationUpdater.
	 *
	 * @param iPlayerList the incoming player list argument
	 * @param iGhostList the incoming ghost list argument
	 * @param JGameOverDisplay the game over display
	 */
	protected AnimationUpdater(Player[] iPlayerList, AI[] iGhostList, JLabel JGameOverDisplay){
		initDefaults();
		jGameOverDisplay = JGameOverDisplay;
		ghostList = iGhostList;
		player1 = iPlayerList[0];
		player2 = iPlayerList[1];
		Updater.start();	//Starts the thread
	}
	
	/**
	 * The Updater thread class that implements a runnable
	 */
	public class updater implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run() {
			while(PacmanMainClass.active) {
				if(!player1.isAlive() && player1.playerLabel.isVisible() == true) {
					PlayerDeathAnimation(player1);	//if player one is dead, and the user can see the player, then play death animation
				}
				
				if(!player2.isAlive() && player2.playerLabel.isVisible() == true) {
					PlayerDeathAnimation(player2);	//if player two is dead, and the user can see the player, then play death animation
				}
				
				for(String file: pacmanEatingFolder) {	//Cycle through all frames for pacman eating animation
					file = "PacmanEating/"+file;
					if(player1.isAlive()) {	//if the player is alive, then update its image
						BufferedImage img = getImage(file, player1.getPDir(), player1.getSDir());	//Color the players animation to that of ther players color from main menu
						img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, Player.getPlayer1Color());
						img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, Player.getPlayer2Color());
						player1.playerLabel.setIcon(new ImageIcon(img));	
					}
					
					if(player2.isAlive()) {	//if the player is alive, then update its image
						BufferedImage img = getImage(file, player2.getPDir(), player2.getSDir());	//Color the players animation to that of ther players color from main menu
						img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, Player.getPlayer3Color());
						img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, Player.getPlayer4Color());
						player2.playerLabel.setIcon(new ImageIcon(img));
					}
					
					try {
						Thread.sleep(50);
					}
					catch(Exception ex) {ex.printStackTrace();}
					if((!player2.isAlive() && !player2.playerLabel.isVisible()) &&
					   (!player1.isAlive() && !player1.playerLabel.isVisible())) {
						break;	//if all the players are dead and invisible to the user, then stop the loop
					}
				}
				
				if(GameClock.isGameOver() && gameOverCheck) {	//if the game has ended and the gameOverCheck is true
					GhostsDeathAnimations();	//play the death animations for the ghosts, and display the GAME OVER label
					jGameOverDisplay.setVisible(true);
					try {
						Thread.sleep(4000);
						PacmanMainClass.active = false;
					}
					catch(Exception ex) {ex.printStackTrace();}
				}
			}
		}
	}
	
	/**
	 * Ghosts death animations.
	 */
	private void GhostsDeathAnimations() {
		for(AI ghost : ghostList) {	//Cycle through each ghost and each animation frame for the explosions
			for(String file : explosionFolder) {
				file = "Explosion/"+file;
				ImageIcon image = null;	
				try {	//play the explosion animation for a ghost
					Thread.sleep(100);
					image = new ImageIcon(ImageIO.read(getClass().getResource("/images/Pacman/"+file)));
				}
				catch(Exception ex) {}
				ghost.ghostLabel.setIcon(image);
			}
		}
		gameOverCheck = false;	//set gameOverCheck to false, to stop the dying animation
	}
	
	/**
	 * Player death animation.
	 *
	 * @param player the player
	 */
	private void PlayerDeathAnimation(Player player) {
		for(String file: pacmanDeathFolder) {	//Cycle through each frame for the players death animation
			file = "PacmanDeath/"+file;
			try {
				Thread.sleep(50);
			}
			catch(Exception ex) {ex.printStackTrace();}
			BufferedImage img = getImage(file, player.getPDir(), player.getSDir());
			
			if(player.name.equals("Player1")) {	//Color the players death animation based of the color from the main menu
				img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, Player.getPlayer1Color());
				img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, Player.getPlayer2Color());
			}
			else if(player.name.equals("Player2")) {	//Color the players death animation based of the color from the main menu
				img = ImageChanger.changeImageColor(img, DEFAULTCOLOR1, Player.getPlayer3Color());
				img = ImageChanger.changeImageColor(img, DEFAULTCOLOR2, Player.getPlayer4Color());
			}
			player.playerLabel.setIcon(new ImageIcon(img));
		}
		
		player.playerLabel.setVisible(false);	//Hide the player as it is now dead
	}
	
	/**
	 * Gets the rotated image.
	 *
	 * @param file the file
	 * @param pDir the primary direction
	 * @param sDir the secondary direction
	 * @return the image
	 */
	private BufferedImage getImage(String file, String pDir, String sDir){
		BufferedImage bImage = null;
		double num = 0;
		try {
			bImage = ImageIO.read(getClass().getResource("/images/Pacman/"+file));
		}
		catch(Exception ex) {ex.printStackTrace();}
		switch(sDir) {	//Find direction of where the player is facing, and assign num to the corresponding amount of radians to rotate
		case("up"):
			num = 1.5;
			break;
		case("down"):
			num = 0.5;
			break;
		case("right"):
			num = 0;
			break;
		case("left"):
			num = 1;
			break;
		case("none"):
			switch(pDir) {
			case("up"):
				num = 1.5;
				break;
			case("down"):
				num = 0.5;
				break;
			case("right"):
				num = 0;
				break;
			case("left"):
				num = 1;
				break;
			}
			break;
		}
		
		bImage = rotateImage(bImage, num);	//Rotate the image by the appropriate amount
		return bImage;
	}
	
	/**
	 * Rotates an image.
	 *
	 * @param bImg the incoming buffered image argument
	 * @param num the number of radians to rotate
	 * @return the rotated buffered image
	 */
	private static BufferedImage rotateImage(BufferedImage bImg, double num) {
	    int width = 36;
	    int height = 36;
	    
	    BufferedImage dest = new BufferedImage(height, width, bImg.getType());

	    Graphics2D graphics2D = dest.createGraphics();
	    graphics2D.rotate(Math.PI*num, height / 2, width / 2);
	    graphics2D.drawRenderedImage(bImg, null);
	    graphics2D.dispose();

	    return dest;
	}
}
