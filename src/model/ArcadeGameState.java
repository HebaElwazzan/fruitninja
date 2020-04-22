package model;

public class ArcadeGameState extends GameState {

	
	@Override
	public void updateTime() {
		Time time = new Time(1,0);
		setTime(time);
		this.getTime().startDecrementTime();
		
	}
	

}
