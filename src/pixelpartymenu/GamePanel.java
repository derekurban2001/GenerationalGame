package pixelpartymenu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


//GamePanel is the main panel, this is where the games are be hosted
/**
 * The Class GamePanel.
 */
//and ran to be made visible to the user
public class GamePanel {
	
	//Declare variables, some are specifically protected as they are not
	/** The JLayeredPane panel. */
	//mean't to be encapsulated.
	protected static JLayeredPane panel;
	
	/** The Image icons. */
	private ImageIcon BackgroundIcon, XBIcon, XBHIcon;
	
	/** The pre game panel. */
	private static JPanel preGamePanel;
	
	/** The game order array. */
	private static String[] gameOrderArray;
	
	/**
	 * Instantiates a new game panel.
	 */
	//Constructs the panel
	protected GamePanel() {
		//initializes all images used by the panel
		try {
			XBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButton.png")));
			XBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
		}
		catch(Exception ex) {}
		
		//INITIALIZE SWING COMPONENTS
		panel = new JLayeredPane();
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setBounds(40, 26, 670, 670);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));
		panel.setLayout(null);
		
		JButton jExitButton = new JButton("");
		jExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jExitButton.setIcon(XBHIcon);
			}
			public void mouseExited(MouseEvent e) {
				jExitButton.setIcon(XBIcon);
			}
		});
		jExitButton.setIcon(XBIcon);
		jExitButton.setFocusable(false);
		jExitButton.setContentAreaFilled(false);
		jExitButton.setBorder(null);
		jExitButton.setBackground(new Color(0,0,0,0));
		jExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jExitButton.setBounds(631, 0, 41, 41);
		panel.add(jExitButton, 9);

		JLabel jBackground = new JLabel("");
		jBackground.setIcon(BackgroundIcon);
		jBackground.setBounds(0, 0, 670, 670);
		panel.add(jBackground, 10);
		
		panel.setVisible(false);
		panel.setOpaque(false);
		
		pickGameOrder();
	}
	
	/**
	 * Play games.
	 */
	protected void playGames() {
		System.gc();
		//start the game Handler to process games.
		new GameHandler(gameOrderArray, panel);
	}
	
	/**
	 * Default game names.
	 *
	 * @return the array list
	 */
	private static ArrayList<String> defaultGameNames(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Frogger");
		names.add("Pacman");
		names.add("Pong");
		return names;
	}
	
	/**
	 * Pick game order.
	 */
	protected static void pickGameOrder() {
		ArrayList<String> gameNames = defaultGameNames();
		
		gameOrderArray = new String[3];
		int randomFirstGame = (int)(Math.random()*3);
		int randomSecondGame = (int)(Math.random()*2);
		
		gameOrderArray[0] = gameNames.get(randomFirstGame);
		gameNames.remove(randomFirstGame);
		
		gameOrderArray[1] = gameNames.get(randomSecondGame);
		gameNames.remove(randomSecondGame);
		
		gameOrderArray[2] = gameNames.get(0);
		
		PreGamePanel.updateGameOrder();
	}
	
	/**
	 * Go back.
	 */
	//Perform when back button is pressed
	protected static void goBack() {
		PhidgetHandler.onPreGamePanel = true;
		PhidgetHandler.resetReadiness();
		CoreFrame.preGamePanel.updateLeaderboard();
		if(!GameHandler.gameRunning)
			CoreFrame.preGamePanel.playAgain();
		preGamePanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Gets the game order.
	 *
	 * @return the game order array
	 */
	protected static String[] getGameOrder() {
		return gameOrderArray;
	}
	
	/**
	 * Sets the panels.
	 *
	 * @param PreGamePanel the neighboring panels in menu sequence
	 */
	//Set panel function that initializes neighbouring panels in the menu sequence
	protected void setPanels(JPanel PreGamePanel) {
		preGamePanel = PreGamePanel;
	}

}

