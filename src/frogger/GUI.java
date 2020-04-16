package frogger;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


/**
 * The Class GUI.
 */
public class GUI extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ratio. */
	final int ratio = 50;
	
	/** The offset. */
	final int offset = 125;
	
	/** The player 1 show score 1. */
	//labels for score display
	JLabel player1ShowScore1 = new JLabel("");
	
	/** The player 2 show score 1. */
	JLabel player2ShowScore1 = new JLabel("");
	
	/** The player 3 show score 1. */
	JLabel player3ShowScore1 = new JLabel("");
	
	/** The player 4 show score 1. */
	JLabel player4ShowScore1 = new JLabel("");
	
	/** The Background. */
	//create the Jlabel background background
	private JLabel Background = new JLabel("");

	/** The Bus list. */
	//create the bus list					  18
	private Obstacle BusList[] = new Obstacle[91];

	/** The Player list. */
	//create the player list
	private Player PlayerList[] = new Player[4];
	
	/** The Score list. */
	//create the score list
	private int ScoreList[] = new int[4];
	
	/**  The x and y starting coordinates for the buses. */
								//1  2  3    4    5    6    7   8   9   10   11  12  13  14   15  16  17  18   19  20  21  22  23 24   25  26  27  28  29  30  31  32   33   34   35   36  37  38  39  40   41  42  43   44  45  46   47  48 49 50  51  52  53  54    55   56  57  58 59   60  61  62  63   64  65   66   67  68  69 70  71  72    73  74  75  76  77  78   79  80  81  82 83  84  85   86   87  88  89  90  91
	private final int xBus[] = {300, 0, 514, 0, 350, 532, 269, 55, 400, 100, 0, 100, 300, 0, 500, 250, 0, 500, 0, 300, 0, 300, 0, 100, 400, 0, 300, 0, 500, 0, 300, 0 , 500, 100, 400, 0, 400, 0, 400, 500, 250, 0, 500, 200, 0, 400, 0, 300, 0, 0, 300, 0, 100, 500, 400, 0, 300, 0, 400, 200, 0, 300, 200, 0, 300, 100, 500, 0, 0, 300, 0, 300, 500, 250, 0, 0, 300, 500, 250, 0, 0, 300, 0, 400, 0, 100, 350, 0, 100, 500, 0};														
								//																																							  					   																																			  	                   |
								/** The bus speeds. */
								//    1   2  3  4   5   6  7   8  9  10  11  12 13  14  15 16 17  18  19  20 21 22 23 24 25 26 27  28 29 30 31 32  33 34 35  36  37 38 39  40  41  42  43 44  45  46 47 48 49  50 51 52  53 54 55  56  57 58  59  60 61  62  63  64  65  66 67  68 69  70  71  72  73 74 75 76  77 78 79  80  81  82 83 84 85 86 87  88  89 90 91
	private final int busSpeeds[] = {-3, -3, 4, -4, -4, 3, 3, -2, 4, 4,  -3, 4, -4, -4, 4, 4, 4, -5, -4, -4, 4, 4, 5, 2, 2,  3, 3, 4, 2, 2, 3, -2, -2, 3, 3, -3, -3, 3, 3, -3, -3, -3,  3, 3, -3 ,-3, 2, 4, 4, 2, 2, -2, -3, -3, 3, 4, 4, -3, -3, 5, -4, -4, -6, -3, -3, 3, 3, -2, -4, -3, -3, -4, 2, 2, 2, -4, -4, 3, 3, 3, -2, -2, 2, 1, -3, 2, 4, -3, 2, 2, 4};
								//							 																																											 |					|
	
	/** The bus lanes. */
								//bus lanes					//  1  2  3  4  5  6  7  8  9  10 11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37  38  39  40  41  42  43  44  45  46  47  48  49  50 51   52  53  54  55  56  57  58  59  60  61  62  63  64  65  66  67  68  69  70  71  72  73  74  75  76  77  78  79  80  81  82  83  84  85  86  87  88  89  90  91
	private final int busLanes[] = {1, 1, 3, 4, 4, 6, 6, 7, 8, 8, 10, 11, 12, 12, 14, 14, 14, 16, 17, 17, 18, 18, 20, 21, 21, 22, 22, 24, 25, 25, 26, 27, 27, 28, 28, 29, 29, 31, 31, 32, 32, 32, 34, 34, 35, 35, 36, 37, 37, 39, 39, 40, 41, 41, 42, 43, 43, 45, 45, 46, 47, 47, 49, 51, 51, 52, 52, 53, 54, 55, 55, 54, 57, 57, 57, 58, 58, 60, 60, 60, 61, 61, 62, 62, 63, 64, 65, 66, 67, 67, 65};
								//													 										 	 		 																					 		 |
	/** The safe lanes. */
								//safe lanes					
	private final int safeLanes[] = {0, 2, 5, 9, 13, 15, 19, 23, 30, 33, 38, 44, 48, 50, 56, 59, 68};
	
	/** The Lane list. */
	private Lane LaneList[] = new Lane[safeLanes.length];
	
	/** The content pane. */
	public static JPanel contentPane;
	
	
	/** The j player 1,2,3,4 labels. */
	private JLabel jPlayer1Label = new JLabel("Player1");
	
	/** The j player 2 label. */
	private JLabel jPlayer2Label = new JLabel("Player2");
	
	/** The j player 3 label. */
	private JLabel jPlayer3Label = new JLabel("Player3");
	
	/** The j player 4 label. */
	private JLabel jPlayer4Label = new JLabel("Player 4");
	
	/**  create the players 1,2,3,4 and give them Jlabels. */
	private Player player1 = new Player(jPlayer1Label, 0, Player.getPlayer1Color());
	
	/** The player 2. */
	private Player player2 = new Player(jPlayer2Label, 0, Player.getPlayer2Color());
	
	/** The player 3. */
	private Player player3 = new Player(jPlayer3Label, 0, Player.getPlayer3Color());
	
	/** The player 4. */
	private Player player4 = new Player(jPlayer4Label, 0, Player.getPlayer4Color());
	
	
	/**
	 * Launch the application.
	 *
	 */
	
Thread RunThingy = new Thread(new runThingy()); 

/**
 * The Class runThingy.
 */
//thread that checks for intersections between players and buses
public class runThingy implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run(){
			while(CrossyRoadMainClass.active) {
				try {
					Thread.sleep(500);
					
					
					
				}
				catch(Exception ex) {};
				
				//set text of score to each player
				player1ShowScore1.setText("" + player1.getScore());
				player2ShowScore1.setText("" + player2.getScore());
				player3ShowScore1.setText("" + player3.getScore());
				player4ShowScore1.setText("" + player4.getScore());
				
				//add each score to the score list created so it keeps track of the entire score at the end of the game
				ScoreList[0] = player1.getScore();
				ScoreList[1] = player2.getScore();
				ScoreList[2] = player3.getScore();
				ScoreList[3] = player4.getScore();
				
				if(MovementHandler.hasStopped) {
					try {
						Thread.sleep(5000);
					}
					catch(Exception ex) {ex.printStackTrace();}
					CrossyRoadMainClass.active = false;
				}
			}
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	//create constructors where we store labels, movement handler, phidget handler
	public GUI() {
		
		//call initComponents
		initComponents();
		
		//fill the player list with players
		PlayerList[0] = player1; PlayerList[1] = player2; 
		PlayerList[2] = player3; PlayerList[3] = player4;
		
		//add the buses to the window and the buslist
		for (int i = 0; i<BusList.length; i++) {
			BusList[i] = createObstacle(xBus[i], (offset-ratio*busLanes[i]), busSpeeds[i]);
		}
		
		//fill the lane list with lanes
		for (int i = 0; i < LaneList.length; i++) {
			LaneList[i] = createLane(safeLanes[i]);
		}
		
		//add the player 1 to the window
		jPlayer1Label.setBounds(185, 120, 50, 47);
		contentPane.add(jPlayer1Label);
		
		//add the player 2 to the window
		jPlayer2Label.setBounds(245, 120, 50, 47);
		contentPane.add(jPlayer2Label);
		
		//add the player 3 to the window
		jPlayer3Label.setBounds(305, 120, 50, 47);
		contentPane.add(jPlayer3Label);
		
		//add the player 4 to the window
		jPlayer4Label.setBounds(365, 120, 50, 47);
		contentPane.add(jPlayer4Label);
		
		//add background to the panel
		contentPane.add(Background);
		
		//use the playerlist to call on every player to phidget handler
		new PhidgetHandler(PlayerList, contentPane);
		
		//use the playerlist to call on every player to animation handler
		new AnimationHandler(PlayerList);
		
		//call on every bus/player/lane and the background to the movement handler
		new MovementHandler(BusList, PlayerList, LaneList, Background);
		
		//start game
		RunThingy.start();
	}
		
	//adding the buses to the window
	/**
	 * Creates the obstacle.
	 *
	 * @param x the starting x-coordinate
	 * @param y starting x-coordinate
	 * @param speed the speed
	 * @return the obstacle
	 */	
	//create jLabels for every obstacle so this code is used for every label without repetition
	public Obstacle createObstacle(int x, int y, int speed) {
		JLabel label = new JLabel();							//create the bus Jlabel
		label.setHorizontalAlignment(SwingConstants.CENTER);	//set the bus horizontal alignment
		label.setBounds(x, y, 90, 40);							//set the pixel dimensions for the bus
		contentPane.add(label);									//add the Jlabel to the window
		return new Obstacle(label, speed);						//return the completed bus to the Jlabel list
	}
	
	/**
	 * Creates the lane.
	 *
	 * @param y the y
	 * @return the lane
	 */
	//creates lanes in a loop to avoid like 17 more instance variables
	public Lane createLane(int y) {
		y = (offset-5-ratio * y);
		return new Lane(y);
	}
	
	/**
	 * Inits the components.
	 */
	//create components for the panel
	private void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 600, 600);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,0,0));
				
				//add the background image
				Background.setHorizontalAlignment(SwingConstants.CENTER);
				Background.setFont(new Font("Tahoma", Font.BOLD, 66));
				try {
					Background.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/images/Frogger/Background.png"))));
				}
				catch(Exception ex) {ex.printStackTrace();}
				
				//set bounds for the background so it fits the screen we have for all other games
				Background.setBounds(0, -3780, 600, 4550);
				
				//add the player one score label
				JLabel player1ShowScore = new JLabel("PLAYER 1");
				player1ShowScore.setHorizontalAlignment(SwingConstants.CENTER);
				player1ShowScore.setForeground(Color.WHITE);
				player1ShowScore.setFont(new Font("Arial", Font.BOLD, 18));
				player1ShowScore.setBounds(55, 10, 100, 30);
				contentPane.add(player1ShowScore);
				
				//add the player one score display
				player1ShowScore1 = new JLabel("0");
				player1ShowScore1.setHorizontalAlignment(SwingConstants.CENTER);
				player1ShowScore1.setForeground(Color.WHITE);
				player1ShowScore1.setFont(new Font("Arial", Font.BOLD, 18));
				player1ShowScore1.setBounds(55, 40, 100, 30);
				contentPane.add(player1ShowScore1);
				
				//add the player two score label
				JLabel player2ShowScore = new JLabel("PLAYER 2");
				player2ShowScore.setHorizontalAlignment(SwingConstants.CENTER);
				player2ShowScore.setFont(new Font("Arial", Font.BOLD, 18));
				player2ShowScore.setForeground(Color.WHITE);
				player2ShowScore.setBounds(185, 10, 100, 30);
				contentPane.add(player2ShowScore);
				
				//add the player two score display
				player2ShowScore1 = new JLabel("0");
				player2ShowScore1.setHorizontalAlignment(SwingConstants.CENTER);
				player2ShowScore1.setFont(new Font("Arial", Font.BOLD, 18));
				player2ShowScore1.setForeground(Color.WHITE);
				player2ShowScore1.setBounds(185, 40, 100, 30);
				contentPane.add(player2ShowScore1);
				
				//add the player three score label
				JLabel player3ShowScore = new JLabel("PLAYER 3");
				player3ShowScore.setHorizontalAlignment(SwingConstants.CENTER);
				player3ShowScore.setFont(new Font("Arial", Font.BOLD, 18));
				player3ShowScore.setForeground(Color.WHITE);
				player3ShowScore.setBounds(315, 10, 100, 30);
				contentPane.add(player3ShowScore);
				
				//add the player three score display
				player3ShowScore1 = new JLabel("0");
				player3ShowScore1.setHorizontalAlignment(SwingConstants.CENTER);
				player3ShowScore1.setFont(new Font("Arial", Font.BOLD, 18));
				player3ShowScore1.setForeground(Color.WHITE);
				player3ShowScore1.setBounds(315, 40, 100, 30);
				contentPane.add(player3ShowScore1);
				
				//add the player four score label
				JLabel player4ShowScore = new JLabel("PLAYER 4");
				player4ShowScore.setHorizontalAlignment(SwingConstants.CENTER);
				player4ShowScore.setFont(new Font("Arial", Font.BOLD, 18));
				player4ShowScore.setForeground(Color.WHITE);
				player4ShowScore.setBounds(445, 10, 100, 30);
				contentPane.add(player4ShowScore);
				
				//add the player four score display
				player4ShowScore1 = new JLabel("0");
				player4ShowScore1.setHorizontalAlignment(SwingConstants.CENTER);
				player4ShowScore1.setFont(new Font("Arial", Font.BOLD, 18));
				player4ShowScore1.setForeground(Color.WHITE);
				player4ShowScore1.setBounds(445, 40, 100, 30);
				contentPane.add(player4ShowScore1);
				
				
				
	}
	
	/**
	 * Gets the background.
	 *
	 * @return the background
	 */
	public JLabel getbackground() {
		return Background;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int[] getScore() {
		return ScoreList;
	}
	
	
}
