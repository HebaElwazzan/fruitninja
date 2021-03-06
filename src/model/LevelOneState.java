package model;

public class LevelOneState extends ClassicGameState{

	@Override
	public double setVelocityOfObjects() {
		return 1;
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
		return 4;
	}
	
	@Override
	public String toString() {
		return "Level One";
	}

}
