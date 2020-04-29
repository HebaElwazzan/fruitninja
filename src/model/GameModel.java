package model;

public class GameModel extends Subject{
	private GameState gameState;

	private int score = 0;
	private Time time;
	private int lives = 3;

	public GameModel(GameState gameState) {
		this.gameState = gameState;
		time = new Time();
	}

	public void updateScore(int incrementToScore) {
		score += incrementToScore;
		notifyAllObservers(new GameScreenLabel(gameState.toString(), time.toString(), lives, Integer.toString(score)));
	}
	public void updateTime() {
		gameState.updateTime(time, this);

	};
	
	public void updateLives(int livesDecrement) {
		lives-= livesDecrement;
		notifyAllObservers(new GameScreenLabel(gameState.toString(), time.toString(), lives, Integer.toString(score)));
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
	
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
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
	
	
	public GameState getState() {
		return gameState;
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
