package pixelpartymenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import superclasses.PlayerSuper;


//CharacterPanel is the character selection screen in which players can choose their
/**
 * The Class CharacterPanel.
 */
//character colors
public class CharacterPanel {
	
	//Declare variables, some are specifically protected as they are not
	/** The panel. */
	//mean't to be encapsulated.
	protected JPanel panel;
	
	/** The player 1 icon. */
	protected static JLabel player1Icon;
	
	/** The player 2 icon. */
	protected static JLabel player2Icon;
	
	/** The player 3 icon. */
	protected static JLabel player3Icon;
	
	/** The player 4 icon. */
	protected static JLabel player4Icon;
	
	/** The color table. */
	//Color table made by a 2D list of strings in which each has an occupancy value and color code
	protected static String[][] colorTable ={{"EMPTY;255,0,0","EMPTY;255,128,0","EMPTY;255,255,0","EMPTY;188,255,0"},
									 		{"EMPTY;0,255,0","EMPTY;0,255,128","EMPTY;0,255,255","EMPTY;0,128,255"},
									 		{"EMPTY;0,0,255","EMPTY;128,0,255","EMPTY;255,0,255","EMPTY;255,0,128"}};
	
	/** The lock-in label for the game. */
	private JLabel lockInLabel;
	
	/** The info panel. */
	private JPanel infoPanel;
	
	/** The game panel. */
	private JPanel gamePanel;
	
	/** The ready check boolean. */
	private boolean readyCheck = false;
	
	/** The Image icons for Next/Back buttons, Background icon, Lock-In Debug and all the players. */
	private ImageIcon NextBIcon, NextBHIcon, BackBIcon, BackBHIcon, BackgroundIcon, 
	  				  XBIcon, XBHIcon, LockInDebug, P1, P2, P3, P4;
	
	/**
	 * Instantiates a new character panel.
	 */
	//Constructor that builds the panel
	protected CharacterPanel() {
		//initializes images used by the panel
		try {
			NextBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/NextButton.png")));
			NextBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/NextButtonHighlighted.png")));
			BackBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButton.png")));
			BackBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButtonHighlighted.png")));
			XBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButton.png")));
			XBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
			LockInDebug = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/LockInDebug.png")));
			P1 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P1.png")));
			P2 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P2.png")));
			P3 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P3.png")));
			P4 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P4.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
			P1 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P1.png")));
			P2 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P2.png")));
			P3 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P3.png")));
			P4 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P4.png")));
		}
		catch(Exception ex) {}
		
		//INITIALIZES SWING COMPONENTS
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setBounds(40, 26, 670, 670);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));
		panel.setLayout(null);
		
		JButton jNextButton = new JButton("");
		jNextButton.setIcon(NextBIcon);
		jNextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jNextButton.setIcon(NextBHIcon);
			}
			public void mouseExited(MouseEvent arg0) {
				jNextButton.setIcon(NextBIcon);
			}
		});
		jNextButton.setBorder(null);
		jNextButton.setBorderPainted(false);
		jNextButton.setContentAreaFilled(false);
		jNextButton.setFocusable(false);		
		jNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jNextButtonActionPerformed();
			}
		});
		jNextButton.setBounds(543, 580, 89, 51);
		panel.add(jNextButton);
		
		JButton jBackButton = new JButton("");
		jBackButton.setIcon(BackBIcon);
		jBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jBackButton.setIcon(BackBHIcon);
			}
			public void mouseExited(MouseEvent arg0) {
				jBackButton.setIcon(BackBIcon);
			}
		});
		jBackButton.setBorder(null);
		jBackButton.setBorderPainted(false);
		jBackButton.setContentAreaFilled(false);
		jBackButton.setFocusable(false);		
		jBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jBackButtonActionPerformed();
			}
		});
		
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
		panel.add(jExitButton);
		
		jBackButton.setBounds(41, 580, 89, 51);
		panel.add(jBackButton);
		
		player1Icon = new JLabel("");
		player1Icon.setBounds(90, 470, 70, 70);
		player1Icon.setVisible(true);
		player1Icon.setIcon(P1);
		panel.add(player1Icon);
		
		player2Icon = new JLabel("");
		player2Icon.setBounds(230, 470, 70, 70);
		player2Icon.setVisible(true);
		player2Icon.setIcon(P2);
		panel.add(player2Icon);
		
		player3Icon = new JLabel("");
		player3Icon.setBounds(370, 470, 70, 70);
		player3Icon.setVisible(true);
		player3Icon.setIcon(P3);
		panel.add(player3Icon);
		
		player4Icon = new JLabel("");
		player4Icon.setBounds(510, 470, 70, 70);
		player4Icon.setVisible(true);
		player4Icon.setIcon(P4);
		panel.add(player4Icon);
		
		lockInLabel = new JLabel("");
		lockInLabel.setBounds(144, 551, 383, 76);
		lockInLabel.setIcon(LockInDebug);
		lockInLabel.setVisible(false);
		panel.add(lockInLabel);
		
		createColorTable();

		JLabel jBackground = new JLabel("");
		jBackground.setIcon(BackgroundIcon);
		jBackground.setBounds(0, 0, 670, 670);
		panel.add(jBackground);
		
		panel.setVisible(false);
		panel.setOpaque(false);
	}
	
	/**
	 * Creates the color table.
	 */
	//Creates a color table of various color options for players
	private void createColorTable() {
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 4; column++) {
				//Creates a color label
				createColorLabel(90+(column*140), 100+(row*140), colorTable[row][column]);
			}
		}
	}
	
	/**
	 * Creates the color label.
	 *
	 * @param x the x-coordinate for the label
	 * @param y the y-coordinate for the label
	 * @param s the string used to determine RGB
	 */
	//Creates a color label to be added to the color table
	private void createColorLabel(int x, int y, String s) {
		JLabel label = new JLabel("");
		//Retrieves RGB values to create a color
		int R = Integer.valueOf(s.split(";")[1].split(",")[0]);
		int G = Integer.valueOf(s.split(";")[1].split(",")[1]);
		int B = Integer.valueOf(s.split(";")[1].split(",")[2]);
		//initializes swing component
		label.setBounds(x, y, 70, 70);
		label.setBackground(new Color(R,G,B));
		label.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		label.setOpaque(true);
		label.setVisible(true);
		panel.add(label);
	}
	
	/**
	 * Initializes the player colors.
	 */
	//Initializes the player colors *SHOULD ONLY BE RUN ON NEXT BUTTON ACTION*
	private void initPlayerColors(){
		//Creates a string list for all players
		String[] playerColors = new String[4];
		int i = 0;
		for(String[] row : colorTable) {
			for(String column: row) {
				//Only adds string values with player occupancy from the color table
				if(!column.split(";")[0].equals("EMPTY")) {
					playerColors[i] = column;
					i += 1;
				}
			}
		}
		//passes player colors to the PlayerSuper class to be initializes for the players
		PlayerSuper.setPlayerColors(playerColors);
	}
	
	/**
	 * Method for next button pressed.
	 */
	//performs when next button is pressed
	private void jNextButtonActionPerformed() {
		//If all player icons have found a color
		if((player1Icon.getY() != 470) && (player2Icon.getY() != 470) 
		&& (player3Icon.getY() != 470) && (player4Icon.getY() != 470))
			readyCheck = true;
		//If all players have found a color
		if(readyCheck) {
			//Hide debug message and change focus off this panel
			lockInLabel.setVisible(false);
			PhidgetHandler.onPreGamePanel = true;
			PhidgetHandler.onCharPanel = false;
			initPlayerColors();
			gamePanel.setVisible(true);
			panel.setVisible(false);
		}
		//otherwise
		else {
			//show debug message
			lockInLabel.setVisible(true);
		}
	}
	
	/**
	 * Method for back button pressed.
	 */
	//performs when back button is pressed
	private void jBackButtonActionPerformed() {
		//sets boolean to false to state that focus is no longer on this panel
		PhidgetHandler.onCharPanel = false;
		infoPanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Initializes neighboring panels in menu sequence.
	 *
	 * @param InfoPanel the info panel
	 * @param GamePanel the game panel
	 */
	//Set panel function that initializes neighboring panels in the menu sequence
	protected void setPanels(JPanel InfoPanel, JPanel GamePanel) {
		infoPanel = InfoPanel;
		gamePanel = GamePanel;
	}
}
