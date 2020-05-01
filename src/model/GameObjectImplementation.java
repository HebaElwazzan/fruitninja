package model;

import javafx.animation.ParallelTransition;
import javafx.animation.Animation.Status;

/*
 * Most of the methods' functionality from the GameObject interface were already implemented in ObjectAnimation
 * so some of the methods here simply call on the methods there or are simply useless
 */
public abstract class GameObjectImplementation implements GameObject{
	/*
	 * those fields relate to the objectAnimation class which will set the animation of the object
	 */
	ObjectAnimation objectAnimation =  new ObjectAnimation(this);
	ParallelTransition parallelTransition = objectAnimation.getParallelTransition();
	

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
		return 700; //we set it by default to reach a height of 700
	}

	@Override
	public int getInitialVelocity() {
		return (int) parallelTransition.getRate();
	}

	@Override
	public int getFallingVelocity() {
		return (int) parallelTransition.getRate();
	}

	@Override
	public Boolean isSliced() {
		return objectAnimation.isSliced();
	}

	@Override
	public Boolean hasMovedOffScreen() {
		if(parallelTransition.getStatus() == Status.STOPPED) 
			return true;
		return false;
	}

	@Override
	public void slice() {
		// this action is implemented inside the ObjectAnimat

	}

	@Override
	public void move(double time) { //the time elapsed here was not necessary
		parallelTransition.play();
	}

}



