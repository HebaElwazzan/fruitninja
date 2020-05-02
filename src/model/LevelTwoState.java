package model;

public class LevelTwoState extends ClassicGameState{

	@Override
	public double setVelocityOfObjects() {
		return 1.5;
	}

	@Override
	public int setMaxNumberOfSimultaneousFruits() {
		return 3;
	}

	@Override
	public int setMaxNumberOfSimultaneousBombs() {
		return 2;
	}

	@Override
	public int setTimeBetweenBombs() {
		return 15;
	}
	
	@Override
	public int setTimeBetweenFruits() {
		return 2;
	}

	@Override
	public String toString() {
		return "Level Two";
	}

	
}
