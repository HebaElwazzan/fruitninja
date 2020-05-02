package model;

public class ArcadeGameState implements GameState {


	@Override
	public void updateTime(Time time, GameModel gameModel) {
		time.setMinutes(0);
		time.setSeconds(59);
		gameModel.notifyAllObservers(
				new GameScreenLabel(gameModel.getState().toString(), 
						gameModel.getTime().toString(), gameModel.getLives(), Integer.toString(gameModel.getScore())));

		time.startDecrementTime(gameModel);
		

	}

	@Override
	public double setVelocityOfObjects() {
		return 2;
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
	
	@Override
	public int setTimeBetweenFruits() {
		return 3;
	}

	@Override
	public String toString() {
		return "Arcade Mode";
	}

	@Override
	public void updateLives(int livesDecrement, int lives) {
		if (livesDecrement == 3)
			lives = 0;
	lives = 3;
	}


	


}
