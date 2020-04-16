package frogger;

import javax.swing.JLabel;
import java.util.ArrayList;
	

/**
 * The Class MovementHandler.
 */
//THIS CLASS HANDLES ALL MOVEMENT INCLUDING: PLAYERS, LANES, BUSES
public class MovementHandler {
	
	/** The rate of descent. */
	//integer rate that the map and everything on it will move at
	private int slowDescent = 1;
	
	/** Start the Bus thread. */
	//create the bus movement thread
	private Thread BusThread = new Thread(new BusThread());
	
	
	/** The has stopped. */
	protected static boolean hasStopped = false;
	/** The Bus list 1. */
	//create the bus list
	private Obstacle BusList1[] = new Obstacle[91];
	
	/** The Player list 1. */
	//create the player list
	private Player PlayerList1[] = new Player[5];
	
	/** The Lane list 1. */
	//create the lane list
	private Lane LaneList1[] = new Lane[17];
	
	/** The background. */
	//create the background
	JLabel background;
	
	
	/**
	 * Instantiates a new movement handler.
	 *
	 * @param o the the background
	 * THESE HAVE NOT BEEN FULLY IMPLEMENTED YET
	 * @param p the player list
	 * @param l the l
	 * @param b the obstacle list
	 */
	//constructor that copies over player, bus and lane lists to be updated for movement
	public MovementHandler(Obstacle[] o, Player[] p, Lane[] l, JLabel b) {
		slowDescent = 1;
		hasStopped = false;
		BusList1 = o;
		PlayerList1 = p;
		LaneList1 = l;
		background = b;
		BusThread.start();
	}
	
	/**
	 * The Class BusThread.
	 */
	//thread that handles all movement
	public class BusThread implements Runnable{
		
		/**
		 * Run.
		 */
		@Override
		public void run(){
			while(CrossyRoadMainClass.active) {
				try {
					Thread.sleep(15);
				}
				catch(Exception ex) {};
				
				if(background.getY() >= -1) {
					slowDescent = 0;
					hasStopped = true;
				}
				
				//nested loop to check for player bus collisions
				for (Obstacle bus : BusList1) {								//for every bus 
					for (Player player : PlayerList1) {						// for every player
						if(Intersects.Intersect(player, bus)) {				// if they intersect
							for (int i = 0; i < LaneList1.length; i++) {					// for every lane								
								if (player.getY() <= LaneList1[i].getTop() && player.getY() >= LaneList1[i+1].getTop()) {		// check to see the most recent lane passed by the player					
									player.respawn(LaneList1[i].getTop());														//respawn the player at that lane
								}
							} 
						}		
					}
				}	
				
				
				//create an array list and add each player to it 
				//this array list keeps track when a player reaches the finish line
				ArrayList<Player> playerArray = new ArrayList<Player>();
                playerArray.add(PlayerList1[0]);
                playerArray.add(PlayerList1[1]);
                playerArray.add(PlayerList1[2]);
                playerArray.add(PlayerList1[3]);
                
                //loop each player in playerlist
                for(Player player: PlayerList1) {
                	
                	//if player is behind or same as the background movement + 500 and it says it isn't finished then the player has reached the final lane so player is finished
                    if(player.getY() <= background.getY()+500 && !player.isFinished) {
                        player.isFinished = true;

                        //if one player has finished before the others add 100 to the score
                        if(player.isFinished && !player.respawnFinish && playerArray.size() == 4) {
                            playerArray.remove(player);
                            player.addScore(100);

                        }

                        //second player to the finish line receives 70 points
                        else if(player.isFinished && !player.respawnFinish && playerArray.size() == 3) {
                            playerArray.remove(player);
                            player.addScore(70);
                        }

                        //3rd player to the finish like receives 40 points
                        else if(player.isFinished && !player.respawnFinish && playerArray.size() == 2) {
                            playerArray.remove(player);
                            player.addScore(40);
                        }

                        //4th player to the finish line receives 10 points
                        else {
                            player.addScore(10);
                        }
                    }
	
					//if players are behind the map, respawn them to the next safe lane 
					if(player.getY() > 600-50) {
						for (int i = 0; i < LaneList1.length-1; i++) {
							if (LaneList1[i].getTop() >= 600 && LaneList1[i+1].getTop()<600-50) {
								player.respawn(LaneList1[i+1].getTop());
								if(i+1 == LaneList1.length-1)
									player.respawnFinish = true;
							}
						} 
					}
				}
				
				//Move the background
				background.setLocation(background.getX(), background.getY() + slowDescent);
				
				
				//move the players
				for (int i = 0; i < PlayerList1.length; i++ ) {
					PlayerList1[i].setLocation(PlayerList1[i].getX(), PlayerList1[i].getY() + slowDescent);
				}
				
				
				//move the lanes
				for (int i = 0; i < LaneList1.length; i++) {
					LaneList1[i].setTop(LaneList1[i].getTop() + slowDescent);
				}	
				
				//move the buses
				for(Obstacle bus:BusList1) {
					bus.setLocation(bus.getX() + bus.getSpeed(), bus.getY() + slowDescent);
					bus.reset();
				}
			}
		}
	}
}


