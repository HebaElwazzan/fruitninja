package model;


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
