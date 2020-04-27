package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Fruit implements GameObject {
	
	/*
	 * This method sets the score of the fruit sliced. It gets overrided if the fruit is a special one.
	 */
	public int getScoreOnSlicing() {
		return 10;
	}
	
	
	/*
	 * We could not understand what the proposed declaration meant by ENUM so for simplicity we changed it to GameObject
	 * It serves to generate a random object of type fruit. It can be called at intervals.
	 */
	@Override
	public GameObject getObjectType() {
		List<GameObject> listOfGameObjects = new ArrayList<>();
		listOfGameObjects.add(new Apple());
		listOfGameObjects.add(new Banana());
		listOfGameObjects.add(new Watermelon());
		listOfGameObjects.add(new SpecialFruit(new Apple()));
		listOfGameObjects.add(new SpecialFruit(new Banana()));
		listOfGameObjects.add(new SpecialFruit(new Banana()));
		
		Random random = new Random();
		
		return listOfGameObjects.get(random.nextInt(5));
		
		
	}

	@Override
	public int getXlocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYlocation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getInitialVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFallingVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isSliced() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean hasMovedOffScreen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void slice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(double time) {
		// TODO Auto-generated method stub
		
	}

}
