package pixelpartymenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import superclasses.PlayerSuper;
import java.awt.Font;
import javax.swing.SwingConstants;


//PreGamePanel is the panel before the game panel, this will
//hold the leaderboard, current game, and next games to come.
/**
 * The Class PreGamePanel.
 */
//Sort of the information panel but for the game as it runs
public class PreGamePanel {
	
	//Declare variables, some are specifically protected as they are not
	/** The panel. */
	//mean't to be encapsulated.
	protected JPanel panel;
	
	/** The Image icons. */
	private ImageIcon NextBIcon, NextBHIcon, BackBIcon, BackBHIcon, BackgroundIcon, XBIcon, XBHIcon, CrownIcon,
					  FrTitle, PaTitle, PoTitle, P1, P2, P3, P4, AD, PABIcon, PABHIcon, HTPIcon, HTPHIcon, rdyMSG, GOHeader, LBHeader;
	
	/** The Image icons. */
	private static ImageIcon FrTitleD, PaTitleD, PoTitleD;
	
	/** The character panel. */
	private JPanel characterPanel;
	
	/** The How to Play panel. */
	private JPanel hTPPanel;
	
	/** The ready message. */
	private JLabel jReadyMsg;
	
	/** The player 1 icon LB. */
	private JLabel player1IconLB;
	
	/** The player 2 icon LB. */
	private JLabel player2IconLB;
	
	/** The player 3 icon LB. */
	private JLabel player3IconLB;
	
	/** The player 4 icon LB. */
	private JLabel player4IconLB;
	
	/** The next button. */
	private JButton jNextButton;
	
	/** The play again button. */
	private JButton jPlayAgainButton;
	
	/** The HTP button. */
	private JButton jHTPButton;
	
	/** The frogger title. */
	private static JLabel jFroggerTitle;
	
	/** The pacman title. */
	private static JLabel jPacmanTitle;
	
	/** The pong title. */
	private static JLabel jPongTitle;
	
	/** The player 1 icon RC. */
	protected static JLabel player1IconRC;
	
	/** The player 2 icon RC. */
	protected static JLabel player2IconRC;
	
	/** The player 3 icon RC. */
	protected static JLabel player3IconRC;
	
	/** The player 4 icon RC. */
	protected static JLabel player4IconRC;
	
	/** The game panel. */
	private JLayeredPane gamePanel;
	
	/**
	 * Instantiates a new pre game panel.
	 */
	//Constructs the panel
	protected PreGamePanel() {
		//initializes the images that are used by the panel
		try {
			NextBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/NextButton.png")));
			NextBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/NextButtonHighlighted.png")));
			BackBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButton.png")));
			BackBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButtonHighlighted.png")));
			XBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButton.png")));
			XBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
			P1 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P1.png")));
			P2 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P2.png")));
			P3 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P3.png")));
			P4 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P4.png")));
			PABIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PlayAgain.png")));
			PABHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PlayAgainHighlighted.png")));
			HTPIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/HTPButton.png")));
			HTPHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/HTPButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
			P1 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P1.png")));
			P2 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P2.png")));
			P3 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P3.png")));
			P4 = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/P4.png")));
			AD = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/ArrowDown.png")));
			CrownIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/CrownIcon.png")));
			FrTitle = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/FroggerTitle.png")));
			PaTitle = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PacmanTitle.png")));
			PoTitle = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PongTitle.png")));
			FrTitleD = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/FroggerTitleDone.png")));
			PaTitleD = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PacmanTitleDone.png")));
			PoTitleD = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PongTitleDone.png")));
			rdyMSG = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/ReadyUpDebug.png")));
			LBHeader = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/LeaderboardHeader.png")));
			GOHeader = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/GameOrderHeader.png")));
		}
		catch(Exception ex) {}
		//INITIALIZES SWING COMPONENTS
		initComponents();
		
		updateLeaderboard();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents() {
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(40, 26, 670, 670);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));
		panel.setLayout(null);
		
		jNextButton = new JButton("");
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
		
		jPlayAgainButton = new JButton("");
		jPlayAgainButton.setIcon(PABIcon);
		jPlayAgainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jPlayAgainButton.setIcon(PABHIcon);
			}
			public void mouseExited(MouseEvent arg0) {
				jPlayAgainButton.setIcon(PABIcon);
			}
		});
		jPlayAgainButton.setBorder(null);
		jPlayAgainButton.setBorderPainted(false);
		jPlayAgainButton.setContentAreaFilled(false);
		jPlayAgainButton.setFocusable(false);		
		jPlayAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPlayAgainButtonActionPerformed();
			}
		});
		jPlayAgainButton.setEnabled(false);
		jPlayAgainButton.setVisible(false);
		jPlayAgainButton.setBounds(242, 536, 199, 51);
		panel.add(jPlayAgainButton);
		
		jHTPButton = new JButton("");
		jHTPButton.setIcon(HTPIcon);
		jHTPButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jHTPButton.setIcon(HTPHIcon);
			}
			public void mouseExited(MouseEvent arg0) {
				jHTPButton.setIcon(HTPIcon);
			}
		});
		jHTPButton.setBorder(null);
		jHTPButton.setBorderPainted(false);
		jHTPButton.setContentAreaFilled(false);
		jHTPButton.setFocusable(false);		
		jHTPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jHowToPlayButtonActionPerformed();
			}
		});
		jHTPButton.setVisible(true);
		jHTPButton.setBounds(400, 332, 213, 51);
		panel.add(jHTPButton);
		
		jBackButton.setBounds(41, 580, 89, 51);
		panel.add(jBackButton);
		
		player1IconLB = createPlayerLBIcon(P1);
		panel.add(player1IconLB);
		
		player2IconLB = createPlayerLBIcon(P2);
		panel.add(player2IconLB);
		
		player3IconLB = createPlayerLBIcon(P3);
		panel.add(player3IconLB);
		
		player4IconLB = createPlayerLBIcon(P4);
		panel.add(player4IconLB);
		
		player1IconRC = createPlayerRCIcon(P1, 60, 400);
		panel.add(player1IconRC);
		
		player2IconRC = createPlayerRCIcon(P2, 355, 400);
		panel.add(player2IconRC);
		
		player3IconRC = createPlayerRCIcon(P3, 60, 460);
		panel.add(player3IconRC);
		
		player4IconRC = createPlayerRCIcon(P4, 355, 460);
		panel.add(player4IconRC);
		
		jReadyMsg = new JLabel("");
		jReadyMsg.setIcon(rdyMSG);
		jReadyMsg.setBounds(113, 511, 458, 100);
		jReadyMsg.setVisible(false);
		panel.add(jReadyMsg);
		
		JLabel jLeadboardHeader = new JLabel("");
		jLeadboardHeader.setIcon(LBHeader);
		jLeadboardHeader.setBounds(60, 60, 275, 51);
		panel.add(jLeadboardHeader);
		
		JLabel jGameOrderHeader = new JLabel("");
		jGameOrderHeader.setIcon(GOHeader);
		jGameOrderHeader.setBounds(392, 60, 240, 51);
		panel.add(jGameOrderHeader);
		
		jFroggerTitle = new JLabel("");
		jFroggerTitle.setIcon(FrTitle);
		jFroggerTitle.setBounds(390, 110, 240, 51);
		panel.add(jFroggerTitle);
		
		jPacmanTitle = new JLabel("");
		jPacmanTitle.setIcon(PaTitle);
		jPacmanTitle.setBounds(390, 190, 240, 51);
		panel.add(jPacmanTitle);
		
		jPongTitle = new JLabel("");
		jPongTitle.setIcon(PoTitle);
		jPongTitle.setBounds(390, 270, 240, 51);
		panel.add(jPongTitle);
		
		JLabel arrowDown1 = new JLabel("");
		arrowDown1.setIcon(AD);
		arrowDown1.setBounds(500, 170, 25, 19);
		panel.add(arrowDown1);
		
		JLabel arrowDown2 = new JLabel("");
		arrowDown2.setIcon(AD);
		arrowDown2.setBounds(500, 250, 25, 19);
		panel.add(arrowDown2);
		
		JLabel crownIcon = new JLabel("CROWN");
		crownIcon.setIcon(CrownIcon);
		crownIcon.setBounds(280, 120, 40, 40);
		panel.add(crownIcon);
		
		JLabel jBackground = new JLabel("");
		jBackground.setIcon(BackgroundIcon);
		jBackground.setBounds(0, 0, 670, 670);
		panel.add(jBackground);
		
		panel.setVisible(false);
		panel.setOpaque(false);
	}
	
	/**
	 * Creates the player LB icon.
	 *
	 * @param icon the player icon
	 * @return the player label
	 */
	private JLabel createPlayerLBIcon(ImageIcon icon) {
		JLabel label = new JLabel(": ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Terminator Two", Font.BOLD, 40));
		label.setForeground(Color.BLACK);
		label.setBounds(0, 0, 170, 40);
		label.setVisible(true);
		label.setIcon(icon);
		return label;
	}
	
	/**
	 * Creates the player RC icon.
	 *
	 * @param icon the player
	 * @param x the x-pixel coordinate
	 * @param y the y-pixel coordinate
	 * @return the player label
	 */
	private JLabel createPlayerRCIcon(ImageIcon icon, int x, int y) {
		JLabel label = new JLabel("Ready");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Terminator Two", Font.PLAIN, 40));
		label.setForeground(Color.RED);
		label.setBounds(x, y, 275, 40);
		label.setVisible(true);
		label.setIcon(icon);
		return label;
	}
	
	/**
	 * Update leaderboard method.
	 */
	protected void updateLeaderboard() {
		int[] scores = PlayerSuper.getScores();
		boolean p1 = true, p2 = true, p3 = true, p4 = true;
		Arrays.sort(scores);
		for(int i = 0; i < scores.length; i++){
			if(PlayerSuper.getScores()[0] == scores[i] && p1) {
				player1IconLB.setLocation(60, (5-i)*60);
				player1IconLB.setText(": "+scores[i]);
				p1 = false;
			}
			else if(PlayerSuper.getScores()[1] == scores[i] && p2) {
				player2IconLB.setLocation(60, (5-i)*60);
				player2IconLB.setText(": "+scores[i]);
				p2 = false;
			}
			else if(PlayerSuper.getScores()[2] == scores[i] && p3) {
				player3IconLB.setLocation(60, (5-i)*60);
				player3IconLB.setText(": "+scores[i]);
				p3 = false;
			}
			else if(PlayerSuper.getScores()[3] == scores[i] && p4) {
				player4IconLB.setLocation(60, (5-i)*60);
				player4IconLB.setText(": "+scores[i]);
				p4 = false;
			}
		}
	}
	
	/**
	 * Method for play again button pressed.
	 */
	private void jPlayAgainButtonActionPerformed() {
		GamePanel.pickGameOrder();
		resetGameIcons();
		jPlayAgainButton.setEnabled(false);
		jPlayAgainButton.setVisible(false);
		jHTPButton.setEnabled(true);
		jHTPButton.setVisible(true);
		jNextButton.setEnabled(true);
		jNextButton.setVisible(true);
	}
	
	/**
	 * Reset game icons.
	 */
	private void resetGameIcons() {
		jFroggerTitle.setIcon(FrTitle);
		jPacmanTitle.setIcon(PaTitle);
		jPongTitle.setIcon(PoTitle);
	}
	
	/**
	 * Play again method.
	 */
	protected void playAgain() {
		jPlayAgainButton.setEnabled(true);
		jPlayAgainButton.setVisible(true);
		jHTPButton.setEnabled(false);
		jHTPButton.setVisible(false);
		jNextButton.setEnabled(false);
		jNextButton.setVisible(false);
	}
	
	/**
	 * Method for next button action pressed.
	 */
	//performs when the next button is pressed
	private void jNextButtonActionPerformed() {
		if(PhidgetHandler.allReady) {
			PhidgetHandler.onPreGamePanel = false;
			gamePanel.setVisible(true);
			panel.setVisible(false);
			jReadyMsg.setVisible(false);
			if(GameHandler.gameRunning)
				GameHandler.playNextGame();
			if(!GameHandler.gameRunning)
				CoreFrame.gamePanel.playGames();
		}
		else {
			jReadyMsg.setVisible(true);
		}
	}
	
	/**
	 * Method for how to play button button pressed.
	 */
	private void jHowToPlayButtonActionPerformed(){
		if(GameHandler.gameRunning) {
			HowToPlayPanel.changeTo(GamePanel.getGameOrder()[GameHandler.index+1]);
		}
		else {
			HowToPlayPanel.changeTo(GamePanel.getGameOrder()[0]);
		}
		panel.setVisible(false);
		hTPPanel.setVisible(true);
	}
	
	/**
	 * Game done method.
	 *
	 * @param gameName the game name
	 */
	protected static void gameDone(String gameName) {
		if(gameName.equals("Frogger"))
			jFroggerTitle.setIcon(FrTitleD);
		if(gameName.equals("Pacman"))
			jPacmanTitle.setIcon(PaTitleD);
		if(gameName.equals("Pong"))
			jPongTitle.setIcon(PoTitleD);
	}
	
	/**
	 * Method for back button pressed.
	 */
	//performs when the back button is pressed
	private void jBackButtonActionPerformed() {
		PhidgetHandler.onCharPanel = true;
		PhidgetHandler.onPreGamePanel = false;
		characterPanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Update game order method.
	 */
	protected static void updateGameOrder() {
		String[] gameList = GamePanel.getGameOrder();
		for(int i = 0; i < gameList.length; i++) {
			if(gameList[i].equals("Frogger"))
				jFroggerTitle.setLocation(390, 110 + (i*80));
			if(gameList[i].equals("Pacman"))
				jPacmanTitle.setLocation(390, 110 + (i*80));
			if(gameList[i].equals("Pong"))
				jPongTitle.setLocation(390, 110 + (i*80));
		}
	}
	
	/**
	 * Sets the panels.
	 *
	 * @param CharacterPanel the character panel
	 * @param GamePanel the game panel
	 * @param HTPPanel the How To Play panel
	 */
	//Set panel function that initializes neighbouring panels in the menu sequence
	protected void setPanels(JPanel CharacterPanel, JLayeredPane GamePanel, JPanel HTPPanel) {
		characterPanel = CharacterPanel;
		gamePanel = GamePanel;
		hTPPanel = HTPPanel;
	}
}
