import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
	//instance objects
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private Obstacles obstacle;
	
	static KeyEvent VK_W;

	//create the objects
	public Main () {
		this.player1 = new Player(1);
		this.player2 = new Player(2);
		this.player3 = new Player(3);
		this.player4 = new Player(4);
		
		this.obstacle = new Obstacles();
	}
	
	public static void main(String[] args) {
		Movement movement = new Movement();
		while(true) {
			movement.movePlayerForward();
			try {
				Thread.sleep(50);
			}
			catch(Exception ex) {};
		}
	}
}