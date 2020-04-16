
package pixelpartymenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * The Class HowToPlayPanel.
 */
public class HowToPlayPanel{
	
	/** The Back BH icon. */
	
	private ImageIcon BackgroundIcon, BackBIcon, BackBHIcon;
	
	/** The Pong icon. */
	private static ImageIcon FroggerIcon, PacmanIcon, PongIcon;
	
	/** The panel. */
	protected JPanel panel;
	
	/** The pre game panel. */
	private JPanel preGamePanel;
	
	/** The info label. */
	private static JLabel infoLabel;
	
	/**
	 * Instantiates a new how to play panel.
	 */
	protected HowToPlayPanel() {
		try {
			BackBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButton.png")));
			BackBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/BackButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/DefaultPanelBackground.png")));
			FroggerIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/FroggerInfo.png")));
			PacmanIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PacmanInfo.png")));
			PongIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PongInfo.png")));
		}
		catch(Exception ex) {}
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(40, 26, 670, 670);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));
		panel.setLayout(null);
		
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
		jBackButton.setBounds(510, 587, 89, 51);
		panel.add(jBackButton);
		
		infoLabel = new JLabel();
		infoLabel.setBounds(0, 0, 670, 670);
		panel.add(infoLabel);
		
		JLabel jBackground = new JLabel("");
		jBackground.setIcon(BackgroundIcon);
		jBackground.setBounds(0, 0, 670, 670);
		panel.add(jBackground);
		
		panel.setOpaque(false);
		panel.setVisible(false);
	}
	
	/**
	 * Change to method for changing infoLabel based on the game name
	 *
	 * @param gameName the game name
	 */
	protected static void changeTo(String gameName) {
		if(gameName.equals("Frogger"))
			infoLabel.setIcon(FroggerIcon);
			
		if(gameName.equals("Pacman"))
			infoLabel.setIcon(PacmanIcon);
			
		if(gameName.equals("Pong"))
			infoLabel.setIcon(PongIcon);
	}
	
	/**
	 * Method for back button pressed.
	 */
	private void jBackButtonActionPerformed() {
		preGamePanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Sets the panels.
	 *
	 * @param iPreGamePanel the new panels
	 */
	protected void setPanels(JPanel iPreGamePanel) {
		preGamePanel = iPreGamePanel;
	}
}
