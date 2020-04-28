package model;

public class GameModel {
	private GameState gameState;

	private int score = 0;
	private Time time;
	private int lives = 3;

	public GameModel() {
		time = new Time();
	}

	public void updateScore(int incrementToScore) {
		score += incrementToScore;
	}
	public void updateTime() {
		gameState.updateTime(time);
	};
	
	public void updateLives() {
		lives--;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}


	public double setVelocityOfObjects() {
		return gameState.setVelocityOfObjects();
	}

	public int setMaxNumberOfSimultaneousFruits() {
		return gameState.setMaxNumberOfSimultaneousFruits();
	}

	public int setMaxNumberOfSimultaneousBombs() {
		return setMaxNumberOfSimultaneousBombs();
	}

	public int setTimeBetweenBombs() {
		return setTimeBetweenBombs();
	}
	
	public void setState() {
		if (score <= GameInfo.getInstance().getEndOfLevelOne())
			gameState = new LevelOneState();
		else if (score <= GameInfo.getInstance().getEndOfLevelTwo())
			gameState =  new LevelTwoState();
		else 
			gameState = new LevelThreeState();
	}


}
