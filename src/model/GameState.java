package model;

public interface GameState {
	
	public abstract void updateTime(Time time, GameModel gameModel);
	public abstract double setVelocityOfObjects();
	public abstract int setMaxNumberOfSimultaneousFruits();
	public abstract int setMaxNumberOfSimultaneousBombs();
	public abstract int setTimeBetweenBombs();
	public abstract int setTimeBetweenFruits();

}
