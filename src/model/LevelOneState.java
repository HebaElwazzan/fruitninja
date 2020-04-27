package model;

public class LevelOneState implements GameState{

	@Override
	public void updateTime(Time time) {
		time.startIncrementTime();
		
	}

}
