package model;

public class LevelTwoState extends ClassicGameState{

	@Override
	public double setVelocityOfObjects() {
		return 3;
	}

	@Override
	public int setMaxNumberOfSimultaneousFruits() {
		return 4;
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
	public String toString() {
		return "Level Three";
	}

	
}
