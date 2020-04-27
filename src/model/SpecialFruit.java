package model;

import java.awt.image.BufferedImage;
import java.io.IOException;


/*
 * Decorator design pattern implementation
 */
public class SpecialFruit extends Fruit{
	
	Fruit fruit;
	
	public SpecialFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	
	/*
	 * this method allows a bonus to be added to the fruit being sliced 
	 */
	@Override
	public int getScoreOnSlicing() {
		return super.getScoreOnSlicing() * 2;
	}

	/*
	 * this will allow the special fruit to still have the image of the normal fruit
	 * a label in-game will indicate the bonus
	 */
	@Override
	public BufferedImage[] getBufferedImages() throws IOException {
		return fruit.getBufferedImages();
	}

}
