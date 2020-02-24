
public class Player {
	
	//instance variables
	
	private double xlocation;
	private double ylocation;
	private int yspeed;
	private double score;
	
	
	//constructor
	//user does not input location and score values
	public Player(double a) {
		this.xlocation = a;
		this.ylocation = 0.0;
		this.yspeed = 0;
		this.score = 0.0;
	}
	
	//get score
	public double getScore() {
		return score;
	}
	
	//get location
	public double getXLocation() {
		return xlocation;
	}
	
	public double getYLocation() {
		return ylocation;
	}
	
	//update xlocation
	public void updateXlocation (double Uvalue) {
		this.xlocation = xlocation + Uvalue;
	}
	
	//update ylocation
	public void updateYlocation (double Uvalue) {
		this.ylocation = ylocation + Uvalue;
	}
	
	//update score
	public void updateScore(int Uvalue) {
		this.score = score + Uvalue;
		
	}
	
}
