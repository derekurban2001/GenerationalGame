package pixelpartymenu;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


//CoreFrame is the core frame of the game, this handles the
/**
 * The Class CoreFrame.
 */
//contentPane for all games and menus
public class CoreFrame extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	//Declare variables, some are specifically public as they are not
	/** The JPanel content pane. */
	//mean't to be encapsulated.
	public static JPanel contentPane;
	
	/** The How To Play Panel. */
	private static HowToPlayPanel htpp = new HowToPlayPanel();
	
	/** The opening panel. */
	private OpeningPanel openingPanel = new OpeningPanel();
	
	/** The info panel. */
	private InfoPanel infoPanel = new InfoPanel();
	
	/** The character panel. */
	private CharacterPanel characterPanel = new CharacterPanel();
	
	/** The pre game panel. */
	protected static PreGamePanel preGamePanel = new PreGamePanel();
	
	/** The game panel. */
	protected static GamePanel gamePanel = new GamePanel();
	
	/**
	 * Instantiates a the environment for the frame.
	 */
	//Sets up the environment for the frame
	public CoreFrame() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 670);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setBackground(new Color(0,0,0,0));
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		//creates a new PhidgetHandler to handle input for the Menu
		new PhidgetHandler(contentPane);
		initPanels();
	}
	
	/**
	 * Initializes the swing components.
	 */
	//Initialize swing components
	private void initPanels() {
		contentPane.add(openingPanel.panel);
		contentPane.add(infoPanel.panel);
		contentPane.add(characterPanel.panel);
		contentPane.add(GamePanel.panel);
		contentPane.add(preGamePanel.panel);
		contentPane.add(htpp.panel);
		openingPanel.setPanels(infoPanel.panel);
		infoPanel.setPanels(openingPanel.panel, characterPanel.panel);
		characterPanel.setPanels(infoPanel.panel, preGamePanel.panel);
		preGamePanel.setPanels(characterPanel.panel, GamePanel.panel, htpp.panel);
		gamePanel.setPanels(preGamePanel.panel);
		htpp.setPanels(preGamePanel.panel);
	}
}
