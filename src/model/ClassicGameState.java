package model;

public class ClassicGameState extends GameState{
	
	private int level = 1;
	
	public void updateLevel() {
		level++;
	}

	@Override
	public void updateTime() {
		getTime().startIncrementTime();
		
	}

}
