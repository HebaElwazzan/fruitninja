package model;

public class LevelThreeState extends ClassicGameState{

	@Override
	public double setVelocityOfObjects() {
		return 2.5;
	}

	@Override
	public int setMaxNumberOfSimultaneousFruits() {
		return 4;
	}

	@Override
	public int setMaxNumberOfSimultaneousBombs() {
		return 3;
	}

	@Override
	public int setTimeBetweenBombs() {
		return 10;
	}

	@Override
	public int setTimeBetweenFruits() {
		return 3;
	}
	
	@Override
	public String toString() {
		return "Level Three";
	}
}
