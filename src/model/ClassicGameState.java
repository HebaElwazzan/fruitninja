package model;

public abstract class ClassicGameState implements GameState{
	@Override
	public void updateTime(Time time) {
		time.startIncrementTime();
		
	}

}
