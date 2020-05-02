package model;

public abstract class ClassicGameState implements GameState{
	@Override
	public void updateTime(Time time, GameModel gameModel) {

		time.startIncrementTime(gameModel);		    

	}
	@Override
	public void updateLives(int livesDecrement, int lives) {
		lives-= livesDecrement;

	}

}
