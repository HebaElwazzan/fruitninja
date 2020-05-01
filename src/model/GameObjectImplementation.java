package model;

import javafx.animation.ParallelTransition;
import javafx.animation.Animation.Status;
import java.io.IOException;
import java.util.Random;
import javafx.animation.ParallelTransition;
import javafx.animation.Animation.Status;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.GameObject.ObjectType;

/*
 * Most of the methods' functionality from the GameObject interface were already implemented in ObjectAnimation
 * so some of the methods here simply call on the methods there or are simply useless
 */
public abstract class GameObjectImplementation implements GameObject{
	
	private boolean isSliced = false;
	
	@Override
	public ObjectType getObjectType() {
		if (this instanceof Apple) 
			return ObjectType.APPLE;
		else if (this instanceof Banana)
			return ObjectType.BANANA;
		else if (this instanceof Watermelon)
			return ObjectType.WATERMELON;
		else if (this instanceof DangerousBomb) 
			return ObjectType.DANGEROUS_BOMB;
		else if (this instanceof FatalBomb)
			return ObjectType.FATAL_BOMB;
		else return null;
	}
	

	@Override
	public int getXlocation() {
		return 0;
	}

	@Override
	public int getYlocation() {
		return 0;
	}

	@Override
	public int getMaxHeight() {
		return 700; //we set it by default to reach a height of 700
	}

	@Override
	public int getInitialVelocity() {
		return 0;
		//return (int) parallelTransition.getRate();
	}

	@Override
	public int getFallingVelocity() {
		return 0;
		//return (int) parallelTransition.getRate();
	}

	@Override
	public Boolean isSliced() {
		return isSliced;
	}
	
	@Override
	public void setSliced(boolean sliced) {
		this.isSliced = sliced;
	}

	@Override
	public Boolean hasMovedOffScreen() {
		//if(parallelTransition.getStatus() == Status.STOPPED) 
			return true;
		//return false;
	}

	@Override
	public void slice() {
		// this action is implemented inside the ObjectAnimat

	}

	@Override
	public void move(double time) { //the time elapsed here was not necessary
		//parallelTransition.play();
	}
	
	/*
	 * This method returns a node of the object that can be added to the screen's root.
	 */
}



