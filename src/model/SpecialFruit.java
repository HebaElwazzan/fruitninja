package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javafx.scene.image.ImageView;


/*
 * Decorator design pattern implementation
 */
public abstract class SpecialFruit extends Fruit{
	
	Fruit fruit;
	
	public SpecialFruit(Fruit sentFruit) {

		super();
		this.fruit = sentFruit;
		setImageView();

	}

}
