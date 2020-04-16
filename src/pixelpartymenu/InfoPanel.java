package pixelpartymenu;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * The Class InfoPanel.
 */
//InfoPanel displays important information prior to character selection to the players
public class InfoPanel{
	
	//Declare variables, some are specifically protected as they are not
	/** The panel. */
	//mean't to be encapsulated.
	protected JPanel panel;
	
	/** The Image icons. */
	private ImageIcon NextBIcon, NextBHIcon, BackBIcon, BackBHIcon, BackgroundIcon, XBIcon, XBHIcon, infoIcon;
	
	/** The opening panel. */
	private JPanel openingPanel;
	
	/** The character panel. */
	private JPanel characterPanel;
	
	/**
	 * Instantiates a new info panel.
	 */
	//Constructor that build the panel
	protected InfoPanel() {
		//initializes images used by the panel
		try {
			NextBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/NextButton.png")));
			NextBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/NextButtonHighlighted.png")));
			BackBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButton.png")));
			BackBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButtonHighlighted.png")));
			XBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButton.png")));
			XBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/XButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
			infoIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/InfoPanel.png")));
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		//INITIALIZES SWING COMPONENTS
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setBounds(40, 26, 670, 670);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));
		panel.setLayout(null);
		
		JButton jNextButton = new JButton("");
		
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
		jBackButton.setBounds(41, 580, 89, 51);
		panel.add(jBackButton);
		
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
		
		JLabel infoMessage = new JLabel("");
		infoMessage.setIcon(infoIcon);
		infoMessage.setBounds(41, 41, 599, 532);
		panel.add(infoMessage);
		
		JLabel jBackground = new JLabel("");
		jBackground.setBounds(0, 0, 670, 670);
		panel.add(jBackground);
		
		panel.setVisible(false);
		panel.setOpaque(false);
		
		jNextButton.setIcon(NextBIcon);
		jBackButton.setIcon(BackBIcon);
		jExitButton.setIcon(XBIcon);
		jBackground.setIcon(BackgroundIcon);
	}
	
	/**
	 * Method for Next Button pressed.
	 */
	//perform when the next button is pressed
	private void jNextButtonActionPerformed() {
		//sets boolean to true to state that focus is on another panel
		PhidgetHandler.onCharPanel = true;
		characterPanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Method for Back Button pressed.
	 */
	//perform when the back button is pressed
	private void jBackButtonActionPerformed() {
		openingPanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Sets the opening and character panels.
	 *
	 * @param OpeningPanel the opening panel
	 * @param CharacterPanel the character panel
	 */
	//Set panel function that initializes neighbouring panels in the menu sequence
	protected void setPanels(JPanel OpeningPanel, JPanel CharacterPanel) {
		openingPanel = OpeningPanel;
		characterPanel = CharacterPanel;
	}
}
