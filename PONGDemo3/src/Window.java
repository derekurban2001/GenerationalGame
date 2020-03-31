// method to create the window using JFrame
import javax.swing.JFrame;

/**
 * The Class Window.
 */
public class Window {

// Constructor - Creates the window for the game
// Parameters: 
// title: takes the String title for the name of the game.
/**
 * Instantiates a new window.
 *
 * @param title the title
 * @param game the game
 */
// game: Parameter of the class type "Game" to create the game
	public Window(String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game); 
		frame.pack();
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}

}
