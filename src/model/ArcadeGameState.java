package model;

public class ArcadeGameState implements GameState {

	
	@Override
	public void updateTime(Time time) {
		time.setMinutes(1);
		time.setSeconds(0);
		time.startDecrementTime();
		
	}
	

}
