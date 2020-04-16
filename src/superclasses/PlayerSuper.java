package superclasses;

import java.awt.Color;


//PlayerSuper is supposed to be a parent class for all player classes,
//this class allows access to the players color, and the players score
/**
 * The Class PlayerSuper.
 */
//on the main scope of the game.
public class PlayerSuper {
	
	/** The player 1 score. */
	//Declares player scores are used in the leaderboard
	private static int player1Score = 0;
	
	/** The player 2 score. */
	private static int player2Score = 0;
	
	/** The player 3 score. */
	private static int player3Score = 0;
	
	/** The player 4 score. */
	private static int player4Score = 0;
	
	/** The player 1 color. */
	//Declares and sets default colors for the players
	private static Color player1Color = new Color(255,255,0);
	
	/** The player 2 color. */
	private static Color player2Color = new Color(255,0,255);
	
	/** The player 3 color. */
	private static Color player3Color = new Color(0,255,255);
	
	/** The player 4 color. */
	private static Color player4Color = new Color(255,0,0);
	
	/**
	 * Update scores.
	 *
	 * @param scoreList the score list
	 */
	//Update scores based off an inputted ordered list
	public static void updateScores(int[] scoreList) {
		player1Score += scoreList[0];
		player2Score += scoreList[1];
		player3Score += scoreList[2];
		player4Score += scoreList[3];
	}
	
	/**
	 * Gets the scores.
	 *
	 * @return the scores
	 */
	//returns scores in the format of an ordered list
	public static int[] getScores() {
		int[] list = {player1Score, player2Score, player3Score, player4Score};
		return list;
	}
	
	/**
	 * Sets the player colors.
	 *
	 * @param playerColorList the new player colors
	 */
	//sets all the player colors based off the colorTable of the CharacterPanel
	public static void setPlayerColors(String[] playerColorList) {
		for(String playerInfo : playerColorList) {
			
			String name = playerInfo.split(";")[0];
			String[] RGB = playerInfo.split(";")[1].split(",");
			
			Color color = new Color(Integer.valueOf(RGB[0]), Integer.valueOf(RGB[1]), Integer.valueOf(RGB[2]));
			
			if(name.equals("PLAYER1"))
				player1Color = new Color(color.getRGB());
			if(name.equals("PLAYER2"))
				player2Color = new Color(color.getRGB());
			if(name.equals("PLAYER3"))
				player3Color = new Color(color.getRGB());
			if(name.equals("PLAYER4"))
				player4Color = new Color(color.getRGB());
		}
	}
	
	//GETTER METHODS FOR EACH PLAYERS COLOR
	
	/**
	 * Gets the player 1 color.
	 *
	 * @return the player 1 color
	 */
	public static Color getPlayer1Color() {
		return new Color(player1Color.getRGB());
	}
	
	/**
	 * Gets the player 2 color.
	 *
	 * @return the player 2 color
	 */
	public static Color getPlayer2Color() {
		return new Color(player2Color.getRGB());
	}
	
	/**
	 * Gets the player 3 color.
	 *
	 * @return the player 3 color
	 */
	public static Color getPlayer3Color() {
		return new Color(player3Color.getRGB());
	}
	
	/**
	 * Gets the player 4 color.
	 *
	 * @return the player 4 color
	 */
	public static Color getPlayer4Color() {
		return new Color(player4Color.getRGB());
	}
}
