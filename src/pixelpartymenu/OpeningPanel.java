package pixelpartymenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * The Class OpeningPanel.
 */
//OpeningPanel is the initial screen you see when prompted to play the game
public class OpeningPanel{
	
	//Declare variables, some are specifically protected as they are not
	/** The panel. */
	//mean't to be encapsulated.
	protected JPanel panel;
	
	/** The Image icons. */
	private ImageIcon PlayBIcon, PlayBHIcon, ExitBIcon, ExitBHIcon, BackgroundIcon;
	
	/** The info panel. */
	private JPanel infoPanel;
	
	/** The play button. */
	private JButton jPlayButton;

	/**
	 * Instantiates a new opening panel.
	 */
	//Constructor that builds the panel
	protected OpeningPanel() {
		//Reads and initializes all images used by the panel
		try {
			PlayBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PlayButton.png")));
			PlayBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/PlayButtonHighlighted.png")));
			ExitBIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/ExitButton.png")));
			ExitBHIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/ExitButtonHighlighted.png")));
			BackgroundIcon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Menu/OpeningFrameBackground.png")));
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		//INITIALIZES SWING COMPONENTS
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.GRAY);
		panel.setBorder(null);
		panel.setBounds(40, 26, 400, 200);
		panel.setLocation(335-(panel.getWidth()/2), 335-(panel.getHeight()/2));
		panel.setLayout(null);
		
		jPlayButton = new JButton("");
		jPlayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				jPlayButton.setIcon(PlayBHIcon);
			}
			public void mouseExited(MouseEvent arg0) {
				jPlayButton.setIcon(PlayBIcon);
			}
		});
		jPlayButton.setIcon(PlayBIcon);
		jPlayButton.setBorder(null);
		jPlayButton.setBorderPainted(false);
		jPlayButton.setContentAreaFilled(false);
		jPlayButton.setFocusable(false);
		jPlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPlayButtonActionPerformed();
			}
		});
		jPlayButton.setBounds(258, 111, 87, 51);
		panel.add(jPlayButton);
		
		JButton jExitButton = new JButton("");
		jExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jExitButton.setIcon(ExitBHIcon);
			}
			public void mouseExited(MouseEvent e) {
				jExitButton.setIcon(ExitBIcon);
			}
		});
		jExitButton.setIcon(ExitBIcon);
		jExitButton.setFocusable(false);
		jExitButton.setContentAreaFilled(false);
		jExitButton.setBorder(null);
		jExitButton.setBackground(new Color(0,0,0,0));
		jExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jExitButton.setBounds(47, 111, 87, 51);
		panel.add(jExitButton);
		
		JLabel background = new JLabel("");
		background.setIcon(BackgroundIcon);
		background.setBounds(0, 0, 400, 200);
		panel.add(background);
	}

	/**
	 * Method for play button pressed.
	 */
	//Code ran when the play button is clicked
	private void jPlayButtonActionPerformed() {
		infoPanel.setVisible(true);
		panel.setVisible(false);
	}
	
	/**
	 * Sets the Info panel.
	 *
	 * @param InfoPanel the new panels
	 */
	//Set panel function that initializes neighbouring panels in the menu sequence
	protected void setPanels(JPanel InfoPanel) {
		infoPanel = InfoPanel;
	}
}
