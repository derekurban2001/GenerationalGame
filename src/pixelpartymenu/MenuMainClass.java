package pixelpartymenu;
import java.awt.EventQueue;


//MenuMainClass is the main entry point for the game, this prompts
/**
 * The Class MenuMainClass.
 */
//the main menu
public class MenuMainClass {
	
	/** The active. */
	public static boolean active = false;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	//Prompts CoreFrame which constructs the core frame of the game
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoreFrame frame = new CoreFrame();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
