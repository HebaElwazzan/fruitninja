package model;

public class ArcadeGameState implements GameState {

	
	@Override
	public void updateTime(Time time) {
		time.setMinutes(1);
		time.setSeconds(0);
		time.startDecrementTime();
		
	}

	@Override
	public double setVelocityOfObjects() {
		return 100;
	}

	@Override
	public int setMaxNumberOfSimultaneousFruits() {
		return 3;
	}

	@Override
	public int setMaxNumberOfSimultaneousBombs() {
		return 1;
	}

	@Override
	public int setTimeBetweenBombs() {
		return 20;
	}

	

}
