//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Movement /*extends KeyAdapter */ {
		
	//instance variables
	private Player player;
	private Obstacles obstacle;
	private boolean moving;
		
	//constructor
	public Movement () {
		player = new Player(1);
		obstacle = new Obstacles();
		moving = false;
	} 
		
		
	public void movePlayerForward() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Press Enter: ");
		String n = reader.next(); // Scans the next token of the input as an int.
			
		if(n.equals("s")) {
			player.updateYlocation(1.0);
			System.out.println(player.getYLocation());
		}
		else if(n.equals("n")) {
			System.exit(0);
		}
	}
		
		
	//move the player forward
/*	public void keyTyped(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_UP) {
				player.updateYlocation(1.0);
				System.out.println(player.getYLocation());
				moving = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
			
		if (key == KeyEvent.VK_UP) {
			moving = false;
	}
	}
	*/
	public void busLoop() {	
			
	}	
	public static void main(String[]args) {
	
}
}

