package model;

import java.util.Random;

import javafx.animation.ParallelTransition;


public abstract class Fruit extends GameObjectImplementation {

	/*
	 * those fields relate to the objectAnimation class which will set the animation of the object
	 */
	ObjectAnimation objectAnimation =  new ObjectAnimation(this);
	ParallelTransition parallelTransition = objectAnimation.getParallelTransition();
	
	/*
	 * This method sets the score of the fruit sliced. It gets overrided if the fruit is a special one.
	 */
	public int getScoreOnSlicing() {
		return 10;
	}


	/*
	 * this method will generate a random integer between 0 and 5 and will be used by GameObjectFactory to create one of the 
	 * objects from the enum ObjectType.
	 */
	@Override
	public ObjectType getObjectType() {
		Random random = new Random();
		return ObjectType.values()[random.nextInt(5)];
	}


}
