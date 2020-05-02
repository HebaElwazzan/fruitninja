package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface GameObject{
	

	/*
	 * this enumeration allows for random number generation which links to a random object generation
	 */
	enum ObjectType {
		APPLE, BANANA, WATERMELON, SPECIAL_APPLE, SPECIAL_BANANA, SPECIAL_WATERMELON, DANGEROUS_BOMB, FATAL_BOMB;
	}
	/**
	 *@return the type of game object
	 */
	public ObjectType getObjectType();
	/*
	 *@return X location of game object
	 */
	public int getXlocation();
	/*
	 *@return Y location of game object
	 */
	public int getYlocation();
	/*
	 *@return max Y location that the object can reach on the screen
	 */
	public int getMaxHeight();
	/*
	 *@return velocity at which game object is thrown
	 */
	public int getInitialVelocity();
	/*
	 *@return failing velocity of game object
	 */
	public int getFallingVelocity();
	/*
	 *@return whether the object is sliced or not
	 */
	public Boolean isSliced();
	/*
	 *@return whether the object is dropped off the screen or not
	 */
	public Boolean hasMovedOffScreen();
	/*
	 *it is used to slice the object
	 */
	public void slice();
	/*
	 *it is used to move the object on the screen
		@param deltaTime: time elapsed since the object is thrown
							it is used calculate the new position of
							fruit object.
	NOTE: We made alterations to this method as we used path transitions instead of keyframes as proposed
	 it gave us a chance to use the QuadCurveTo class and make a nicer looking animation
	 The time parameter was therefore unnecessary
	 We added a velocity parameter instead so that we can send it different velocities depending on the game model
	 as speed changes according to which level or mode the player is in
	 
	 */
	public void move(double velocity); 
	/*
	 *@return at least two images of the object, one when it is
sliced and one when it is not.
	 */
	public BufferedImage [] getBufferedImages() throws IOException;
	public void setSliced(boolean sliced);

}