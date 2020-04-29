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

	@Override
	public String toString() {
		return "Arcade Mode";
	}


}
