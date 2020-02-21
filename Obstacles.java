package CrossyRoad;

public class Obstacles {
	double upperRightHitBox;
	double upperLeftHitBox;
	double lowerLeftHitBox;
	double lowerRightHitBox;
	int obstaclespeed;
	
	//input for obstacles
	Obstacles(){
		this.upperRightHitBox = 0.0;
		this.upperLeftHitBox = 0.0;
		this.lowerLeftHitBox = 0.0;
		this.lowerRightHitBox = 0.0;
		this.obstaclespeed = 0;
	}
	//make copy constructor so every obstacle has the same speed for every player 
	
	public void setUpperRightHitBox(double upRight) {
		upperRightHitBox = upRight;
	}
	
	public void setUpperLeftHitBox(double upLeft) { 
		upperLeftHitBox = upLeft;
	}
	
	public void setLowerRightHitBox(double lowerRight) {
		lowerRightHitBox = lowerRight;
	}
	
	public void setLowerLeftHitBox(double lowerLeft) {
		lowerLeftHitBox = lowerLeft;
	}
	
	public double getUpperRightHitBox() {
		return upperRightHitBox;
	}
	
	public double getUpperLeftHitBox() {
		return upperLeftHitBox;
	}
	
	public double getLowerLeftHitBox() {
		return lowerLeftHitBox;
	}
	
	public double getLowerRightHitBox() {
		return lowerRightHitBox;
	}

	public void updateSpeed(int newSpeed) {
		obstaclespeed = newSpeed;
	}
	
	public void overlapsWithPlayer() {
	
	}
	
	
	
	

}
