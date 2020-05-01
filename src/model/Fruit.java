package model;

import java.util.Random;

import javafx.animation.ParallelTransition;


public abstract class Fruit extends GameObjectImplementation {

	/*
	 * This method sets the score of the fruit sliced. It gets overrided if the fruit is a special one.
	 */
	public int getScoreOnSlicing() {
		return 10;
	}
	
	/*
	 * This method plays a sound on the fruit getting sliced.
	 */
	public void playSlicingSound() {
		
	}






}
